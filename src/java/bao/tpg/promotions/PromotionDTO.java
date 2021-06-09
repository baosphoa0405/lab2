/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bao.tpg.promotions;

/**
 *
 * @author Admin
 */
public class PromotionDTO {

    private int promotionID;
    private String promotionName;

    @Override
    public String toString() {
        return "PromotionDTO{" + "promotionID=" + promotionID + ", promotionName=" + promotionName + '}';
    }

    public PromotionDTO(int promotionID, String promotionName) {
        this.promotionID = promotionID;
        this.promotionName = promotionName;
    }

    public int getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(int promotionID) {
        this.promotionID = promotionID;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

}
