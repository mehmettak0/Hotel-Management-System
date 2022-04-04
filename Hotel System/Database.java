/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emin yasir corut
 */
public class Database {

    DefaultTableModel tbl_usersModel;// I created DefaultTableModel to connect User database.
    DefaultTableModel tbl_RolesModel;// I created DefaultTableModel to connect Roles database.
    DefaultTableModel tbl_customerModel;// I created DefaultTableModel to connect Customer database.
    DefaultTableModel tbl_reservationModel;// I created DefaultTableModel to connect Reservation database.
    DefaultTableModel tbl_roomModel;// I created DefaultTableModel to connect Room database.
    DefaultTableModel tbl_roomTypeModel;// I created DefaultTableModel to connect RoomType database.

    public Database() {
        //identify User's database columns
        tbl_usersModel = new DefaultTableModel();
        tbl_usersModel.setColumnIdentifiers(new Object[]{"USERID", "ROLEID", "USERNAME", "NAME", "SURNAME", "EMAIL", "PHONE", "PASSWORD"});

        //identify Role's database columns
        tbl_RolesModel = new DefaultTableModel();
        tbl_RolesModel.setColumnIdentifiers(new Object[]{"ROLEID", "ROLENAME"});

        //identify Customer's database columns
        tbl_customerModel = new DefaultTableModel();
        tbl_customerModel.setColumnIdentifiers(new Object[]{"CUSTOMERID", "TC_NO", "NAME", "SURNAME", "EMAIL", "PHONE", "COUNTRY", "GENDER", "IS_MARRIED", "BIRTHDAY"});

        //identify Reservation's database columns
        tbl_reservationModel = new DefaultTableModel();
        tbl_reservationModel.setColumnIdentifiers(new Object[]{"RESERVATION_ID", "ROOM_ID", "CUSTOMER_ID", "ARRIVAL_DATE", "DEPARTURE_DATE", "PRICE"});

        //identify Room's database columns
        tbl_roomModel = new DefaultTableModel();
        tbl_roomModel.setColumnIdentifiers(new Object[]{"ROOM_ID", "ROOM_TYPE_ID", "NUMBER", "FLOOR", "PHONE"});

        //identify RoomType's database columns
        tbl_roomTypeModel = new DefaultTableModel();
        tbl_roomTypeModel.setColumnIdentifiers(new Object[]{"ROOM_TYPE_ID", "ROOM_NAME", "ADULTS_COUNT", "KIDS_COUNT"});
    }

    public DefaultTableModel GetUser() {
        tbl_usersModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM USER1 ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int id = rs.getInt("USERID");
                int Roleid = rs.getInt("ROLEID");
                String Username = rs.getString("USERNAME");
                String name = rs.getString("NAME");
                String surname = rs.getString("SURNAME");
                String email = rs.getString("EMAIL");
                String phone = rs.getString("PHONE");
                String password = rs.getString("PASSWORD");
                tbl_usersModel.addRow(new Object[]{id, Roleid, Username, name, surname, email, phone, password});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tbl_usersModel;
    }

    public DefaultTableModel GetCustomers() {
        tbl_customerModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM CUSTOMER ";//POİNT SIRALAAMASI İÇİN ORDER BY KULLANIDIK
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int id = rs.getInt("CUSTOMER_ID");
                String tcNo = rs.getString("TC_NO");
                String name = rs.getString("NAME");
                String surname = rs.getString("SURNAME");
                String birthday = rs.getString("BIRTHDAY");
                String email = rs.getString("EMAİL");
                String phone = rs.getString("PHONE");
                String country = rs.getString("COUNTRY");
                String gender = rs.getString("GENDER");
                String isMarried = rs.getString("IS_MARRIED");
                tbl_customerModel.addRow(new Object[]{id, tcNo, name, surname, email, phone, country, gender, isMarried, birthday});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbl_customerModel;
    }

    public DefaultTableModel GetReservation() {
        tbl_reservationModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM RESERVATION ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int reservationId = rs.getInt("RESERVATION_ID");
                int RoomId = rs.getInt("ROOM_ID");
                int CustomerId = rs.getInt("CUSTOMER_ID");
                String ArrivalDate = rs.getString("ARRIVAL_DATE");
                String DepartureDate = rs.getString("DEPARTURE_DATE");
                int Price = rs.getInt("PRICE");
                tbl_reservationModel.addRow(new Object[]{reservationId, RoomId, CustomerId, ArrivalDate, DepartureDate, Price});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbl_reservationModel;
    }

    public DefaultTableModel GetRoom() {
        tbl_roomModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ROOM ";//POİNT SIRALAAMASI İÇİN ORDER BY KULLANIDIK
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int Room_id = rs.getInt("ROOM_ID");
                int Room_Type_id = rs.getInt("ROOM_TYPE_ID");
                int number = rs.getInt("NUMBER");
                int Floor = rs.getInt("FLOOR");
                String phone = rs.getString("PHONE");
                tbl_roomModel.addRow(new Object[]{Room_id, Room_Type_id, number, Floor, phone});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbl_roomModel;
    }

    public DefaultTableModel GetRoomType() {
        tbl_roomTypeModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ROOM_TYPE ";//POİNT SIRALAAMASI İÇİN ORDER BY KULLANIDIK
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int Room_type_id = rs.getInt("ROOM_TYPE_ID");
                String Roomname = rs.getString("ROOM_NAME");
                int AdultsCount = rs.getInt("ADULTS_COUNT");
                int KidsCount = rs.getInt("KIDS_COUNT");
                tbl_roomTypeModel.addRow(new Object[]{Room_type_id, Roomname, AdultsCount, KidsCount});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbl_roomTypeModel;
    }

    public DefaultTableModel GetUserBySearchText(String text) {
        tbl_usersModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM USER1 WHERE NAME LIKE '" + text + "%'";//search the database according to the desired value
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int id = rs.getInt("USERID");
                int Roleid = rs.getInt("ROLEID");
                String Username = rs.getString("USERNAME");
                String name = rs.getString("NAME");
                String surname = rs.getString("SURNAME");
                String email = rs.getString("EMAIL");
                String phone = rs.getString("PHONE");
                String password = rs.getString("PASSWORD");
                tbl_usersModel.addRow(new Object[]{id, Roleid, Username, name, surname, email, phone, password});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbl_usersModel;
    }

    public DefaultTableModel GetCustomerBySearchText(String text) {
        tbl_customerModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM CUSTOMER WHERE NAME LIKE '" + text + "%'";//search the database according to the desired value
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int id = rs.getInt("CUSTOMER_ID");
                String tcNo = rs.getString("TC_NO");
                String name = rs.getString("NAME");
                String surname = rs.getString("SURNAME");
                String birthday = rs.getString("BIRTHDAY");
                String email = rs.getString("EMAİL");
                String phone = rs.getString("PHONE");
                String country = rs.getString("COUNTRY");
                String gender = rs.getString("GENDER");
                String isMarried = rs.getString("IS_MARRIED");
                tbl_customerModel.addRow(new Object[]{id, tcNo, name, surname, email, phone, country, gender, isMarried, birthday});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbl_customerModel;
    }

    public DefaultTableModel GetReservationBySearchText(int text) {
        tbl_reservationModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM RESERVATION WHERE ROOM_ID=" + text;//search the database according to the desired value
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int reservationId = rs.getInt("RESERVATION_ID");
                int RoomId = rs.getInt("ROOM_ID");
                int CustomerId = rs.getInt("CUSTOMER_ID");
                String ArrivalDate = rs.getString("ARRIVAL_DATE");
                String DepartureDate = rs.getString("DEPARTURE_DATE");
                int Price = rs.getInt("PRICE");
                tbl_reservationModel.addRow(new Object[]{reservationId, RoomId, CustomerId, ArrivalDate, DepartureDate, Price});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbl_reservationModel;
    }

    public DefaultTableModel GetRoomBySearchText(int text) {
        tbl_roomModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ROOM WHERE NUMBER=" + text;////search the database according to the desired value
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int Room_id = rs.getInt("ROOM_ID");
                int Room_Type_id = rs.getInt("ROOM_TYPE_ID");
                int number = rs.getInt("NUMBER");
                int Floor = rs.getInt("FLOOR");
                String phone = rs.getString("PHONE");
                tbl_roomModel.addRow(new Object[]{Room_id, Room_Type_id, number, Floor, phone});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbl_roomModel;
    }

    public DefaultTableModel GetRoles() {
        tbl_RolesModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ROLE ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //taking data from the database
                int Roleid = rs.getInt("ROLEID");
                String Rolename = rs.getString("ROLENAME");
                tbl_RolesModel.addRow(new Object[]{Roleid, Rolename});
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbl_RolesModel;
    }

}
