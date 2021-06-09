/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baotpg.controllers;

import baotpg.users.UserDTO;
import baotpg.users.UsersDAO;
import baotpg.users.UsersError;
import baotpg.utils.MyConstants;
import baotpg.utils.MyToys;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private String SUCCESS = "SearchServlet";
    private String FAIL = "login.jsp";
    private String URL_USER = "LoadHistoryPromotionUser";

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
            System.out.println("hello login servlet");
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            UsersError error = new UsersError("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            boolean flag = false;
            UserDTO userDTO = null;
            UsersDAO userDAO = new UsersDAO();
            HttpSession session = request.getSession();
            String mess = "";
            if (userID != null && password != null) {
                if (userID.trim().isEmpty()) {
                    error.setErrorID("userID is empty");
                    flag = true;
                }
                if (password.trim().isEmpty()) {
                    error.setErrorPassword("password is empty");
                    flag = true;
                }
                if (!userID.trim().isEmpty() && !password.trim().isEmpty()) {
                    String hashPassword = null;
                    try {
                        hashPassword = MyToys.bytesToHex(password);
                    } catch (NoSuchAlgorithmException ex) {
                        log(ex.getMessage());
                    }
                    userDTO = userDAO.login(userID, hashPassword);
                    if (userDTO == null) {
                        error.setErrorLogin("Password or Email wrong");
                        flag = true;
                    } else {
                        if (userDTO.getStatusDTO().getStatusID() == MyConstants.STATUS_ID_IN_ACTIVE) {
                            flag = true;
                            mess = "account of you status inactive";
                        }
                    }

                }
            }
            if (flag) {
                request.setAttribute("mess", mess);
                request.setAttribute("userID", userID);
                request.setAttribute("password", password);
                request.setAttribute("errors", error);
                url = FAIL;
            } else {
                if (userDTO.getRoleDTO().getRoleName().equals("User")) {
                    url = URL_USER;
                }
                session.setAttribute("user", userDTO);
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
