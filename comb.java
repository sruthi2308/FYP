
import java.sql.*;
import java.lang.*;

public class comb {
    public static void main(String[] args) {
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/antipatterndb","root","info123.");
            Statement st=conn.createStatement();  
            ResultSet rs=st.executeQuery("select * from splitnew");  
    
            while(rs.next())    
            {  
                System.out.println(rs.getString(1));  
                System.out.print("  "+rs.getString(2));
                System.out.print("  "+rs.getString(3));
                System.out.print("  "+rs.getString(4));
            }   
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
