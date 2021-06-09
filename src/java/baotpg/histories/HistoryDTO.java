/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baotpg.histories;

import bao.tpg.promotions.PromotionDTO;
import bao.tpg.ranks.RankDTO;
import baotpg.status.StatusDTO;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class HistoryDTO {

    private String userID;
    private Date assignDate;
    private PromotionDTO promotionDTO;
    private StatusDTO statusDTO;
    private RankDTO rankDTO;

    public HistoryDTO(String userID, Date assignDate, PromotionDTO promotionDTO, StatusDTO statusDTO, RankDTO rankDTO) {
        this.userID = userID;
        this.assignDate = assignDate;
        this.promotionDTO = promotionDTO;
        this.statusDTO = statusDTO;
        this.rankDTO = rankDTO;
    }

    @Override
    public String toString() {
        return "HistoryDTO{" + "userID=" + userID + ", assignDate=" + assignDate + ", promotionDTO=" + promotionDTO + ", statusDTO=" + statusDTO + ", rankDTO=" + rankDTO + '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public PromotionDTO getPromotionDTO() {
        return promotionDTO;
    }

    public void setPromotionDTO(PromotionDTO promotionDTO) {
        this.promotionDTO = promotionDTO;
    }

    public StatusDTO getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(StatusDTO statusDTO) {
        this.statusDTO = statusDTO;
    }

    public RankDTO getRankDTO() {
        return rankDTO;
    }

    public void setRankDTO(RankDTO rankDTO) {
        this.rankDTO = rankDTO;
    }

}
