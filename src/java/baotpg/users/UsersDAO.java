/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baotpg.users;

import baotpg.roles.RoleDTO;
import baotpg.status.StatusDTO;
import baotpg.utils.DBHelper;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class UsersDAO {

    private PreparedStatement pstm = null;
    private Connection cn = null;
    private ResultSet rs = null;

    public void close() throws SQLException {
        if (pstm != null) {
            pstm.close();
        }
        if (cn != null) {
            cn.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public boolean checkUserID(String userID) throws NamingException, SQLException {
        boolean flag = false;
        try {
            cn = DBHelper.makeConnection();
            if (cn != null) {
                String sql = "select userID from Users where userID = ? ";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, userID);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    flag = !rs.getString("userID").isEmpty() ? true : false;
                }
            }
        } finally {
            close();
        }
        return flag;
    }

    public UserDTO login(String userID, String password) throws NamingException, SQLException {
        UserDTO user = null;
        StatusDTO status = null;
        RoleDTO role = null;
        try {
            cn = DBHelper.makeConnection();
            if (cn != null) {
                String sql = "select userID, password, userName, email, phone, u.photo, r.roleID, r.roleName, s.statusID, s.statusName from Users u, Roles r, Status s "
                        + "where u.roleID = r.roleID "
                        + "and u.statusID = s.statusID "
                        + "and userID = ? and u.password = ? ";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, userID);
                pstm.setString(2, password);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    status = new StatusDTO(rs.getInt("statusID"), rs.getString("statusName"));
                    role = new RoleDTO(rs.getInt("roleID"), rs.getString("roleName"));
                    user = new UserDTO(rs.getString("userID"), rs.getString("userName"), rs.getString("password"), rs.getString("email"), rs.getString("phone"), rs.getString("photo"), role, status);
                }
            }
        } finally {
            close();
        }
        return user;
    }

    public ArrayList<UserDTO> getAllUserFilter(String nameSearch, String roleName) throws SQLException, NamingException {
        ArrayList<UserDTO> listUser = new ArrayList<>();
        UserDTO user = null;
        StatusDTO status = null;
        RoleDTO role = null;
        String sqlCondition = "";
        if (!roleName.trim().isEmpty()) {
            sqlCondition = "and roleName = ? ";
        }
        try {
            cn = DBHelper.makeConnection();
            if (cn != null) {
                String sql = "select userID, password, userName, email, phone, u.photo, r.roleID, r.roleName, s.statusID, s.statusName from Users u, Roles r, Status s \n"
                        + "where u.roleID = r.roleID \n"
                        + "and u.statusID = s.statusID \n"
                        + "and userName like ? " + sqlCondition;
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, "%" + nameSearch + "%");
                if (!roleName.trim().isEmpty()) {
                    pstm.setString(2, roleName);
                }
                rs = pstm.executeQuery();
                while (rs.next()) {
                    status = new StatusDTO(rs.getInt("statusID"), rs.getString("statusName"));
                    role = new RoleDTO(rs.getInt("roleID"), rs.getString("roleName"));
                    user = new UserDTO(rs.getString("userID"), rs.getString("userName"), rs.getString("password"), rs.getString("email"), rs.getString("phone"), rs.getString("photo"), role, status);
                    listUser.add(user);
                }
            }
        } finally {
            close();
        }
        return listUser;
    }

    public boolean updateStatusUserID(String idUser, int statusID) throws SQLException, NamingException {
        boolean flag = false;
        try {
            cn = DBHelper.makeConnection();
            if (cn != null) {
                String sql = "update Users SET statusID = ? where userID = ? ";
                pstm = cn.prepareStatement(sql);
                pstm.setInt(1, statusID);
                pstm.setString(2, idUser);
                flag = pstm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            close();
        }
        return flag;
    }

    public UserDTO getDetailUser(String idUser) throws SQLException, NamingException {
        UserDTO user = null;
        StatusDTO status = null;
        RoleDTO role = null;
        try {
            cn = DBHelper.makeConnection();
            if (cn != null) {
                String sql = "select userID, password, userName, email, phone, u.photo, r.roleID, r.roleName, s.statusID, s.statusName from Users u, Roles r, Status s \n"
                        + "where u.roleID = r.roleID \n"
                        + "and u.statusID = s.statusID \n "
                        + "and userID = ? ";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, idUser);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    status = new StatusDTO(rs.getInt("statusID"), rs.getString("statusName"));
                    role = new RoleDTO(rs.getInt("roleID"), rs.getString("roleName"));
                    user = new UserDTO(rs.getString("userID"), rs.getString("userName"), rs.getString("password"), rs.getString("email"), rs.getString("phone"), rs.getString("photo"), role, status);
                }
            }
        } finally {
            close();
        }
        return user;
    }

    public boolean addUser(UserDTO newUser) throws SQLException, NamingException {
        boolean flag = false;
        try {
            cn = DBHelper.makeConnection();
            if (cn != null) {
                String sql = "Insert into Users Values(?,?,?,?,?,?,?,?)";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, newUser.getUserID());
                pstm.setString(2, newUser.getUsername());
                pstm.setString(3, newUser.getPassword());
                pstm.setString(4, newUser.getEmail());
                pstm.setString(5, newUser.getPhone());
                pstm.setInt(6, newUser.getRoleDTO().getRoleID());
                pstm.setString(7, newUser.getPhoto());
                pstm.setInt(8, newUser.getStatusDTO().getStatusID());
                flag = pstm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            close();
        }
        return flag;
    }

    public boolean updateUser(UserDTO newUser) throws SQLException, NamingException {
        boolean flag = false;
        try {
            cn = DBHelper.makeConnection();
            if (cn != null) {
                String sql = "Update Users set userName = ? , password = ? , email = ? , phone = ?, roleID = ?, photo = ? where userID = ?";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, newUser.getUsername());
                pstm.setString(2, newUser.getPassword());
                pstm.setString(3, newUser.getEmail());
                pstm.setString(4, newUser.getPhone());
                pstm.setInt(5, newUser.getRoleDTO().getRoleID());
                pstm.setString(6, newUser.getPhoto());
                pstm.setString(7, newUser.getUserID());
                flag = pstm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            close();
        }
        return flag;
    }

    public static void main(String[] args) throws NamingException, SQLException {
        Connection cn = DBHelper.makeConnection();
        if (cn != null) {
            System.out.println("ket noi");
        }

    }
}
