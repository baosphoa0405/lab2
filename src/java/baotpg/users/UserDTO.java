/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baotpg.users;

import baotpg.roles.RoleDTO;
import baotpg.status.StatusDTO;

/**
 *
 * @author Admin
 */
public class UserDTO {

    private String userID, username, password, email, phone, photo;
    private RoleDTO roleDTO;
    private StatusDTO statusDTO;

    public StatusDTO getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(StatusDTO statusDTO) {
        this.statusDTO = statusDTO;
    }

    public UserDTO(String userID, String username, String password, String email, String phone, String photo, RoleDTO roleDTO, StatusDTO statusDTO) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.roleDTO = roleDTO;
        this.statusDTO = statusDTO;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone + ", photo=" + photo + ", roleDTO=" + roleDTO + ", statusDTO=" + statusDTO + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

}
