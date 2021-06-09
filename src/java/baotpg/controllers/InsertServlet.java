/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baotpg.controllers;

import baotpg.roles.RoleDAO;
import baotpg.roles.RoleDTO;
import baotpg.status.StatusDAO;
import baotpg.status.StatusDTO;
import baotpg.users.UserDTO;
import baotpg.users.UsersDAO;
import baotpg.users.UsersError;
import baotpg.utils.MyToys;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@WebServlet(name = "InsertServlet", urlPatterns = {"/InsertServlet"})
@MultipartConfig
public class InsertServlet extends HttpServlet {

    private String FAIL = "insert.jsp";
    private String SUCCESS = "insert.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = SUCCESS;
        try {
            response.setContentType("text/html;charset=UTF-8");
            String userName = request.getParameter("userName");
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("rePassword");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            Part filePart = request.getPart("photo");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String roleName = request.getParameter("role");

            boolean flag = false;
            UsersDAO usersDAO = new UsersDAO();
            boolean checkUserID = usersDAO.checkUserID(userID);
            UsersError usersError = new UsersError("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            RoleDAO roleDAO = new RoleDAO();
            ArrayList<RoleDTO> listRole = roleDAO.getListRole();
            request.setAttribute("listRole", listRole);
            StatusDAO statusDAO = new StatusDAO();
            ArrayList<StatusDTO> listStatus = statusDAO.getListStatus();

            if (userID.trim().isEmpty()) {
                flag = true;
                usersError.setErrorID("userID is empty");
            }
            if (!userID.trim().isEmpty() && userID.length() < 1 || userID.length() > 25) {
                flag = true;
                usersError.setErrorIDlength("userID must length 1->25");
            }
            if (!userID.trim().isEmpty() && !userID.matches("[uU][0-9]{3}")) {
                flag = true;
                usersError.setErrorIDformat("user ID must Format U{3} | u{3} ");
            }
            if (!userID.trim().isEmpty() && checkUserID) {
                flag = true;
                usersError.setErrorIDduplicate("user ID duplicate");
            }
            if (userName.trim().isEmpty()) {
                flag = true;
                usersError.setErrorName("user name is empty");
            }
            if (!userName.trim().isEmpty() && !userName.matches("[a-z A-Z]+")) {
                flag = true;
                usersError.setErrorNameFormat("user name must only letter");
            }
            if (!userName.trim().isEmpty() && userName.length() < 1 || userName.length() > 50) {
                flag = true;
                usersError.setErrorNameLength("user name length 1-> 50");
            }

            if (password.trim().isEmpty()) {
                flag = true;
                usersError.setErrorPassword("password is empty");
            }
            if (!password.trim().isEmpty() && password.length() < 9 || password.length() > 50) {
                flag = true;
                usersError.setErrorPasswordLength("password must only length 9 -> 50");
            }
            if (rePassword.trim().isEmpty()) {
                flag = true;
                usersError.setErrorRePassword("repassword is empty");
            }
            if (!rePassword.trim().isEmpty() && !rePassword.equals(password)) {
                flag = true;
                usersError.setErrorConfirm("re-password vs password not match");
            }
            if (email.trim().isEmpty()) {
                flag = true;
                usersError.setErrorEmail("email is empty");
            }
            if (!email.trim().isEmpty() && !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                flag = true;
                usersError.setErrorEmailFormat("email is invalid Format abc@gmail.com");
            }
            if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") && email.length() > 50) {
                flag = true;
                usersError.setErrorEmailLength("email must length less than 50 letter");
            }
            if (phone.trim().isEmpty()) {
                flag = true;
                usersError.setErrorPhone("phone is empty");
            }
            if (!phone.trim().isEmpty() && !phone.matches("[0-9]{10}")) {
                flag = true;
                usersError.setErrorPhoneFormat("phone must number and 10 number");
            }
            if (fileName.isEmpty()) {
                flag = true;
                usersError.setErrorPhoto("Photo Is Empty");
            }
            UserDTO userNew = new UserDTO(userID, userName, password, email, phone, "", null, null);
            for (RoleDTO roleDTO : listRole) {
                if (roleDTO.getRoleName().equals(roleName)) {
                    userNew.setRoleDTO(roleDTO);
                    break;
                }
            }
            for (StatusDTO status : listStatus) {
                if (status.getStatusName().equals("Active")) {
                    userNew.setStatusDTO(status);
                    break;
                }
            }
            String imgUrl = null;
            String hashPassword = null;
            if (flag) {
                url = FAIL;
                request.setAttribute("usersError", usersError);
                request.setAttribute("userNew", userNew);
                request.setAttribute("repassword", rePassword);
            } else {
                if (fileName.contains(".jpg")) {
                    imgUrl = MyToys.writeImage(request, userID, filePart, ".jpg");
                    userNew.setPhoto(imgUrl);
                    try {
                        hashPassword = MyToys.bytesToHex(password);
                    } catch (NoSuchAlgorithmException ex) {
                        log(ex.getMessage());
                    }
                    userNew.setPassword(hashPassword);
                    boolean addUser = usersDAO.addUser(userNew);
                    if (addUser) {
                        request.setAttribute("success", "insert successfull");
                    }
                } else if (fileName.contains(".jpeg")) {
                    imgUrl = MyToys.writeImage(request, userID, filePart, ".jpeg");
                    userNew.setPhoto(imgUrl);
                    try {
                        hashPassword = MyToys.bytesToHex(password);
                    } catch (NoSuchAlgorithmException ex) {
                        log(ex.getMessage());
                    }
                    userNew.setPassword(hashPassword);
                    boolean addUser = usersDAO.addUser(userNew);
                    if (addUser) {
                        request.setAttribute("success", "insert successfull");
                    }
                } else {
                    request.setAttribute("repassword", rePassword);
                    request.setAttribute("userNew", userNew);
                    request.setAttribute("errorFile", "Error Format File Must JPG && JPEG");
                    url = FAIL;
                }
            }
        } catch (NamingException ex) {
            log(ex.getMessage());
        } catch (SQLException ex) {
            log(ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
