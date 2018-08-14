/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.swertres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lotto.util.MyConnection;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Swertres {

    public static class to_swertres {

        public final int id;
        public final String draw_time;
        public final String result;
        public final String draw_date;
        public final int winners;

        public to_swertres(int id, String draw_time, String result, String draw_date, int winners) {
            this.id = id;
            this.draw_time = draw_time;
            this.result = result;
            this.draw_date = draw_date;
            this.winners = winners;
        }
    }

    public static void add_data(to_swertres to_swertres) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into swertres("
                    + "draw_time"
                    + ",result"
                    + ",draw_date"
                    + ",winners"
                    + ")values("
                    + ":draw_time"
                    + ",:result"
                    + ",:draw_date"
                    + ",:winners"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("draw_time", to_swertres.draw_time)
                    .setString("result", to_swertres.result)
                    .setString("draw_date", to_swertres.draw_date)
                    .setNumber("winners", to_swertres.winners)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Swertres.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_swertres to_swertres) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update swertres set "
                    + "draw_time= :draw_time "
                    + ",result= :result "
                    + ",draw_date= :draw_date "
                    + ",winners= :winners "
                    + " where id='" + to_swertres.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("draw_time", to_swertres.draw_time)
                    .setString("result", to_swertres.result)
                    .setString("draw_date", to_swertres.draw_date)
                    .setNumber("winners", to_swertres.winners)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Swertres.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_swertres to_swertres) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from swertres  "
                    + " where id='" + to_swertres.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Swertres.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_swertres> ret_data(String where) {
        List<to_swertres> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",draw_time"
                    + ",result"
                    + ",draw_date"
                    + ",winners"
                    + " from swertres"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String draw_time = rs.getString(2);
                String result = rs.getString(3);
                String draw_date = rs.getString(4);
                int winners = rs.getInt(5);

                to_swertres to = new to_swertres(id, draw_time, result, draw_date, winners);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_swertres> ret_data2(String where) {
        List<to_swertres> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",draw_time"
                    + ", GROUP_CONCAT(DISTINCT result ORDER BY result ASC SEPARATOR ' , ') "
                    + ",draw_date"
                    + ",winners"
                    + " from swertres"
                    + " " + where;
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String draw_time = rs.getString(2);
                String result = rs.getString(3);
                String draw_date = rs.getString(4);
                int winners = rs.getInt(5);

                to_swertres to = new to_swertres(id, draw_time, result, draw_date, winners);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
