/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.six_fifty_8;


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
public class Six_fifty_8 {

    public static class to_6_58 {

        public final int id;
        public final String result_date;
        public final String result;
        public  String interval_x;
        public String interval_y;
        public to_6_58(int id, String result_date, String result,String interval_x,String interval_y) {
            this.id = id;
            this.result_date = result_date;
            this.result = result;
            this.interval_x=interval_x;
            this.interval_y=interval_y;
        }

        public String getInterval_y() {
            return interval_y;
        }

        public void setInterval_y(String interval_y) {
            this.interval_y = interval_y;
        }

        public String getInterval_x() {
            return interval_x;
        }

        public void setInterval_x(String interval_x) {
            this.interval_x = interval_x;
        }
        
    }

    public static void add_data(to_6_58 to_6_58) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into 6_58("
                    + "result_date"
                    + ",result"
                    + ")values("
                    + ":result_date"
                    + ",:result"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("result_date", to_6_58.result_date)
                    .setString("result", to_6_58.result)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Six_fifty_8.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_6_58 to_6_58) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update 6_58 set "
                    + "result_date= :result_date "
                    + ",result= :result "
                    + " where id='" + to_6_58.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("result_date", to_6_58.result_date)
                    .setString("result", to_6_58.result)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Six_fifty_8.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_6_58 to_6_58) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from 6_58  "
                    + " where id='" + to_6_58.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Six_fifty_8.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_6_58> ret_data(String where) {
        List<to_6_58> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",result_date"
                    + ",result"
                    + " from 6_58"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String result_date = rs.getString(2);
                String result = rs.getString(3);

                to_6_58 to = new to_6_58(id, result_date, result,"","");
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
