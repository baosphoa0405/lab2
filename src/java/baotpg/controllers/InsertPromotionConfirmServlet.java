/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baotpg.controllers;

import bao.tpg.promotions.PromotionDAO;
import bao.tpg.promotions.PromotionDTO;
import bao.tpg.ranks.RankDAO;
import bao.tpg.ranks.RankDTO;
import baotpg.histories.HistoryDAO;
import baotpg.histories.HistoryDTO;
import baotpg.status.StatusDAO;
import baotpg.status.StatusDTO;
import baotpg.utils.MyConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "InsertPromotionConfirmServlet", urlPatterns = {"/InsertPromotionConfirmServlet"})
public class InsertPromotionConfirmServlet extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            String namePromotion = request.getParameter("namePromotion");
            String userID = request.getParameter("userID");
            HistoryDAO historyDao = new HistoryDAO();
            // tim2 kiem61
            boolean flag = historyDao.checkHistory(userID);
            if (!flag) {
                PromotionDAO promotionDAO = new PromotionDAO();
                StatusDAO statusDAO = new StatusDAO();
                RankDAO rankDAO = new RankDAO();
                ArrayList<PromotionDTO> listPromotion = promotionDAO.getListPromotion();
                Date assignDate = Date.valueOf(java.time.LocalDate.now());
                ArrayList<StatusDTO> listStatus = statusDAO.getListStatus();
                ArrayList<RankDTO> listRank = rankDAO.getListRank();

                PromotionDTO promotionAdd = null;
                for (PromotionDTO promotionDTO : listPromotion) {
                    if (promotionDTO.getPromotionName().equals(namePromotion)) {
                        promotionAdd = new PromotionDTO(promotionDTO.getPromotionID(), promotionDTO.getPromotionName());
                        break;
                    }
                }
                StatusDTO statusAdd = null;
                for (StatusDTO status : listStatus) {
                    if (status.getStatusID() == MyConstants.STATUS_ID_ACTIVE) {
                        statusAdd = new StatusDTO(status.getStatusID(), status.getStatusName());
                        break;
                    }
                }
                RankDTO rankDTO = null;
                for (RankDTO rank : listRank) {
                    if (rank.getRankID() == MyConstants.RANK_ID_DEFAULT) {
                        rankDTO = new RankDTO(rank.getRankID(), rank.getRankValue());
                        break;
                    }
                }
                boolean isAdd = historyDao.insertHistory(new HistoryDTO(userID, assignDate, promotionAdd, statusAdd, rankDTO));
                request.setAttribute("addSuccess", "add success full");
                request.setAttribute("userID", userID);
            } else {
                request.setAttribute("addFail", "add fail ");
            }
            request.setAttribute("namePromotion", namePromotion);
        } catch (NamingException ex) {
            log(ex.getMessage());
        } catch (SQLException ex) {
            log(ex.getMessage());
        } finally {
            request.getRequestDispatcher("InsertPromotionServlet").forward(request, response);
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
