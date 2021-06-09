/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bao.tpg.promotions;

import baotpg.utils.DBHelper;
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
public class PromotionDAO {

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

    public ArrayList<PromotionDTO> getListPromotion() throws NamingException, SQLException {
        ArrayList<PromotionDTO> list = new ArrayList<PromotionDTO>();
        try {
            String sql = "select promotionID, promotionName from Promotions";
            cn = DBHelper.makeConnection();
            if (cn != null) {
                pstm = cn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    list.add((new PromotionDTO(rs.getInt("promotionID"), rs.getString("promotionName"))));
                }
            }
        } finally {
            close();
        }
        return list;
    }
}
