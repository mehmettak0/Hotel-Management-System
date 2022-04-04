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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emin yasir corut
 */
public class Room extends javax.swing.JFrame {

    int idSelected;
    Database db = new Database();//I have included another class  to connect to the database.
    DefaultTableModel tbl_RoomModel;// I created DefaultTableModel to retrieve the data from the Room database.
    DefaultTableModel tbl_RoomType_id;// I created DefaultTableModel to retrieve the data from the RoomType database.

    /**
     * Creates new form Room
     */
    public Room() {
        initComponents();
        tbl_RoomModel = db.GetRoom();//I get Room data from the database class.
        tbl_RoomType_id = db.GetRoomType();//I get RoomType data from the database class.

        tbl_room.setModel(tbl_RoomModel);//I'm transferring the data to the Room table.

        //closing the appearance of labels to show errors arising from regex controls
        lbl_roomTypeId.setVisible(false);
        lbl_floor.setVisible(false);
        lbl_number.setVisible(false);
        lbl_phone.setVisible(false);

        // import room id, room name, adults count and finally kids count into combobox
        for (int i = 0; i < tbl_RoomType_id.getRowCount(); i++) {
            String name = (String) tbl_RoomType_id.getValueAt(i, 1);
            String id = (String) (tbl_RoomType_id.getValueAt(i, 0) + "");
            String adults_count = (String) (tbl_RoomType_id.getValueAt(i, 2) + "");
            String kids_count = (String) (tbl_RoomType_id.getValueAt(i, 3) + "");

            cmbox_room_typeID.addItem(id + "-" + name + "-" + adults_count + "-" + kids_count);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_floor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_number = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_room = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        btn_addRoom = new javax.swing.JButton();
        btn_updateRoom = new javax.swing.JButton();
        btn_deleteRoom = new javax.swing.JButton();
        txt_phone = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        lbl_roomTypeId = new javax.swing.JLabel();
        lbl_floor = new javax.swing.JLabel();
        lbl_number = new javax.swing.JLabel();
        lbl_phone = new javax.swing.JLabel();
        cmbox_room_typeID = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(330, 85));
        setMaximumSize(new java.awt.Dimension(970, 710));
        setMinimumSize(new java.awt.Dimension(970, 710));
        setPreferredSize(new java.awt.Dimension(970, 710));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel1.setText("Room Type ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));
        getContentPane().add(txt_floor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 200, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setText("Floor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Phone");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));
        getContentPane().add(txt_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 190, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setText("Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        tbl_room.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_room.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_roomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_room);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 930, 330));

        btn_back.setIcon(new javax.swing.ImageIcon("C:\\Users\\emin yasir corut\\Desktop\\HOTEL-Proje\\back.png")); // NOI18N
        btn_back.setText("BACK");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        getContentPane().add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 620, 90, 30));

        btn_addRoom.setIcon(new javax.swing.ImageIcon("C:\\Users\\emin yasir corut\\Desktop\\HOTEL-Proje\\follow.png")); // NOI18N
        btn_addRoom.setText("Add");
        btn_addRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addRoomActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 120, 40));

        btn_updateRoom.setIcon(new javax.swing.ImageIcon("C:\\Users\\emin yasir corut\\Desktop\\HOTEL-Proje\\sync-512.png")); // NOI18N
        btn_updateRoom.setText("Update");
        btn_updateRoom.setEnabled(false);
        btn_updateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateRoomActionPerformed(evt);
            }
        });
        getContentPane().add(btn_updateRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 120, 40));

        btn_deleteRoom.setIcon(new javax.swing.ImageIcon("C:\\Users\\emin yasir corut\\Desktop\\HOTEL-Proje\\x-button.png")); // NOI18N
        btn_deleteRoom.setText("Delete");
        btn_deleteRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteRoomActionPerformed(evt);
            }
        });
        getContentPane().add(btn_deleteRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, 100, 40));

        try {
            txt_phone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+##-###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 200, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setText("Search Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        getContentPane().add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 130, -1));
        getContentPane().add(lbl_roomTypeId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 200, -1));
        getContentPane().add(lbl_floor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 200, -1));
        getContentPane().add(lbl_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 190, -1));
        getContentPane().add(lbl_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 200, -1));

        getContentPane().add(cmbox_room_typeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 200, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\emin yasir corut\\Desktop\\HOTEL-Proje\\customer_background.jpg")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 970, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addRoomActionPerformed
        // TODO add your handling code here:

        //at first, I checked to see if they were all empty. and then I made it mandatory that those entered using Regex be under a certain condition.
        // if the data entered is not like the desired condition, errors are written in the labels.        
        if (txt_floor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Do Not Leave Any Free Space");
            return;
        } else {
            Matcher matcher;
            matcher = Pattern.compile("^[0-9]{1}$").matcher(txt_floor.getText());//
            if (!matcher.find()) {
                lbl_floor.setText("Room ID Must Be 1 Number");
                lbl_floor.setVisible(true);
                return;
            } else {
                lbl_floor.setVisible(false);
            }
        }
        if (txt_number.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Do Not Leave Any Free Space");
            return;
        } else {
            Matcher matcher;
            matcher = Pattern.compile("^[0-9]{1,3}$").matcher(txt_number.getText());//
            if (!matcher.find()) {
                lbl_number.setText("Room ID Must Be most 999 Number");
                lbl_number.setVisible(true);
                return;
            } else {
                lbl_number.setVisible(false);
            }
        }
        if (txt_phone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Do Not Leave Any Free Space");
            return;
        } else {
            Matcher matcher;
            matcher = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$").matcher(txt_phone.getText());//
            if (!matcher.find()) {
                lbl_phone.setText("Phone Must Be Like +06-539-555-2933");
                lbl_phone.setVisible(true);
                return;
            } else {
                lbl_phone.setVisible(false);
            }
        }

        // after checking the accuracy of the entered data, I pulled the data from the screen by Type.
        //here,I defined a string array and assigned it by separating the room id properties.
        String[] id = cmbox_room_typeID.getSelectedItem().toString().split("-");
        int room_type_ID = Integer.parseInt(id[0] + "");
        int number = Integer.parseInt(txt_number.getText());
        int floor = Integer.parseInt(txt_floor.getText());
        String phone = txt_phone.getText();

        //goes to the insert room function.
        InsertReservation(room_type_ID, number, floor, phone);

        //I pulled the data and projected it into the table.
        tbl_RoomModel = db.GetRoom();
        tbl_room.setModel(tbl_RoomModel);

        Clear();// goes to the cleaning function to delete the entered data after the end of the transaction
    }//GEN-LAST:event_btn_addRoomActionPerformed

    private void btn_updateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateRoomActionPerformed
        // TODO add your handling code here:
        Update();//goes to the function for update.
        btn_updateRoom.setEnabled(false);
        Clear();// goes to the cleaning function to delete the entered data after the end of the transaction
    }//GEN-LAST:event_btn_updateRoomActionPerformed

    private void btn_deleteRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteRoomActionPerformed
        // TODO add your handling code here:
        int row = tbl_room.getSelectedRow();//I GOT THE SELECTED LINE
        int id = (int) tbl_room.getValueAt(row, 0);//I get the ID of the room

        Delete(id);//going to the function for deletion

        //I pulled the data and projected it into the table.
        tbl_RoomModel = db.GetRoom();
        tbl_room.setModel(tbl_RoomModel);
    }//GEN-LAST:event_btn_deleteRoomActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        this.dispose();// closes Room page , opens Main page
        new Main().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void tbl_roomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_roomMouseClicked
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {// the process of selecting rows from a table with the mouse
            if (tbl_room.getSelectedRow() > -1) {
                // I get the ID of the room in the selected line
                int row = tbl_room.getSelectedRow();
                idSelected = (int) tbl_RoomModel.getValueAt(row, 0);

                GetDataWihtId(idSelected);// going to the GetDataWithId function to print information from the selected line to textboxes.
                btn_updateRoom.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tbl_roomMouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:

        //according to the input entered, the room matching the database is reflected in the table.
        if (!txt_search.getText().equals("")) {
            int text = Integer.parseInt(txt_search.getText());
            //goes to the database class for the match operation in the database.
            tbl_RoomModel = db.GetRoomBySearchText(text);
            tbl_room.setModel(tbl_RoomModel);// and projected it into the room table.
        } else {
            tbl_RoomModel = db.GetRoom();
            tbl_room.setModel(tbl_RoomModel);
            return;
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    public boolean InsertReservation(int room_type_ID, int number, int floor, String phone) {
        boolean rvalue = false;
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password.
            Statement stmt = conn.createStatement();//javasql.statment ı seçtik
            String query = "SELECT ROOM_ID FROM ROOM ORDER BY ROOM_ID DESC";///AUTOMATIC ID COUNT RETRIEVAL PROCESS
            ResultSet rs = stmt.executeQuery(query);//AUTOMATIC ID COUNT RETRIEVAL PROCESS
            rs.next();//First element in the table.
            int id = rs.getInt(1) + 1;
            //part of adding incoming information to the database
            query = "INSERT INTO ROOM VALUES(" + id + "," + room_type_ID + "," + number + "," + floor + ",'" + phone + "')";
            stmt.executeUpdate(query);
            conn.close();
            rvalue = true;
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {

                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;
    }

    public boolean Delete(int id) {
        //delete the room from the database according to the incoming id
        boolean rvalue = false;
        Connection conn = null;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM ROOM WHERE ROOM_ID=" + id;//room selection section according to id
            stmt.executeUpdate(query);
            conn.close();
            rvalue = true;
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    public void Clear() {
        //clears all data from the screen when finished processing
        txt_floor.setText("");
        txt_number.setText("");
        txt_phone.setText("");
        cmbox_room_typeID.setSelectedIndex(0);

    }

    public void GetDataWihtId(int id) {//I reflect the table according to the id of the selected row.

        tbl_RoomModel.setRowCount(0);//we reset the number of rows so that it does not add on top of the previous information
        try {

            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "sa", "as");//I enter the database location and add the username and password
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ROOM WHERE ROOM_ID=" + id;// according to the incoming id, I get the room from the database
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // after identifying the room, I pull their information according to their type. then I print their information on the screen
                int Room_Type_id = rs.getInt("ROOM_TYPE_ID");
                int number = rs.getInt("NUMBER");
                int Floor = rs.getInt("FLOOR");
                String phone = rs.getString("PHONE");

                txt_floor.setText(Floor + "");
                txt_number.setText(number + "");
                txt_phone.setText(phone);

                cmbox_room_typeID.setSelectedIndex((int) (tbl_RoomType_id.getValueAt(Room_Type_id - 1, 0)) - 1);
            }
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //updating the table
        tbl_RoomModel = db.GetRoom();
        tbl_room.setModel(tbl_RoomModel);
    }

    public void Update() {

        try {
            //I get the changed information. 
            String[] id = cmbox_room_typeID.getSelectedItem().toString().split("-");
            int Room_Type_id = Integer.parseInt(id + "");
            int number = Integer.parseInt(txt_number.getText());
            String phone = txt_phone.getText();
            int Floor = Integer.parseInt(txt_floor.getText());

            // I update the Room's database information on the selected row along with the changed information
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/USerDB", "sa", "as");//I enter the database location and add the username and password
            Statement stmt = conn.createStatement();
            String query = "UPDATE ROOM SET ROOM_TYPE_ID=" + Room_Type_id + ",NUMBER=" + number + ",FLOOR=" + Floor + ",PHONE='" + phone + "' WHERE ROOM_ID=" + idSelected;
            stmt.executeUpdate(query);
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //updating the table
        tbl_RoomModel = db.GetRoom();
        tbl_room.setModel(tbl_RoomModel);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addRoom;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_deleteRoom;
    private javax.swing.JButton btn_updateRoom;
    private javax.swing.JComboBox<String> cmbox_room_typeID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_floor;
    private javax.swing.JLabel lbl_number;
    private javax.swing.JLabel lbl_phone;
    private javax.swing.JLabel lbl_roomTypeId;
    private javax.swing.JTable tbl_room;
    private javax.swing.JTextField txt_floor;
    private javax.swing.JTextField txt_number;
    private javax.swing.JFormattedTextField txt_phone;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
