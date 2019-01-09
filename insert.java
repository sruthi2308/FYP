
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class insert {
    public static void main(String[] args) throws SQLException {
    try {
        Connection conn = null;
ResultSet rs = null;
Statement st = null;
        
            Class.forName("com.mysql.jdbc.Driver");
        
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","info123.");
//PreparedStatement ps=conn.prepareStatement("insert into table1 values('uthra','103');");
Statement ps=conn.createStatement();
int y=ps.executeUpdate("insert into table1 values('uthra','102')");
//int x=ps.executeUpdate();
if(y==1)
{
    System.out.println("inserted");
}
else {
    System.out.println("not inserted");
}
    }
    catch (ClassNotFoundException ex) {
            Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}