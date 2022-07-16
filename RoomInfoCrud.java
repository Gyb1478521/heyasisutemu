/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaingamen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yb
 */
public class RoomInfoCrud {
    
    String url = "jdbc:postgresql://localhost:5432/GYBYB";
    String user = "postgres";
    String password = "postgres";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
        public void conn( String room_num, String room_money, String room_area, String room_service) {
           
        LocalDateTime date = LocalDateTime.now();

        try {

            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();

            String sql = "insert into room_info( room_id , room_num , room_money , room_area , room_service , create_date , modify_date) "
                    + "values(" + "(select xnum from roomid)" + ",'" + room_num + "','" + room_money + "','" + room_area + "','" + room_service + " ','" + date + "','" + date + "'" + ")";

            query.execute(sql);
            System.out.println(sql+"++++in");
        } catch (SQLException ex) {
             String sql = "insert into room_info( room_id , room_num , room_money , room_area , room_service , create_date , modify_date) "
                    + "values('" + "(select xnum from roomid)" + "','" + room_num + "','" + room_money + "','" + room_area + "','" + room_service + " ','" + date + "','" + date + "'" + ")";
            System.out.println(sql);
        }

    }
     public void RoomDelete(Room rm) {

        
        try {

            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            StringBuffer sb = new StringBuffer();
            sb.append("delete from room_info ");
            sb.append(" where ");
            sb.append(" id = '" + rm.getId()+ "'");
            sb.append(";");
            System.out.println(sb.toString());
            query.execute(sb.toString());

            
           
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }

    }
     
         public void RoomUpdate(Room rm){
          
        try {
            conn = DriverManager.getConnection(url, user, password);
            
            Statement query = conn.createStatement();
            
            StringBuffer sb = new StringBuffer();
            sb.append("Update room_info set ");
             sb.append("room_id = ' "+rm.getRoom_id()+"',");
            sb.append("room_num = ' "+rm.getRoom_num()+"',");
            sb.append("room_money= '"+rm.getRoom_money()+"',");
            sb.append("room_area = '"+rm.getRoom_area()+ "',");
            sb.append("room_service = '"+rm.getRoom_service()+"'");
            sb.append(" where ");
            sb.append("id = " +rm.getId());
            sb.append(";");
            System.out.println(sb.toString());
            query.executeUpdate(sb.toString());
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BukenInfoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    
    }
    
}
