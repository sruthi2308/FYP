import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class split {
    public static void main(String[] args) {
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/antipatterndb?useUnicode=yes&characterEncoding=UTF-8","root","info123.");
            Statement stmt = conn.createStatement();
            
            PreparedStatement ps1=null,ps2=null,pst2=null;
            
            String s1="delete from split";
            ps1=conn.prepareStatement(s1);
            ps1.executeUpdate();
            ps1.close();
            String select1=null,from1=null,where1=null;
            int no=0;
            PreparedStatement pst=null,pst1=null;
            
            
             String ss=null,ff=null,ww=null;
      int nn=0;
            
            
            Scanner sc;
            try {
                sc = new Scanner(new File("output.txt"));
            
        while(sc.hasNext())
        {   
                System.out.println(++no);
                String store=sc.nextLine();
                
                String[] sp = store.split(" ");
                select1=sp[1];
                from1=sp[3];
                where1=sp[5];
                System.out.println("select1 = "+select1);
                System.out.println("from1 = "+from1);
                System.out.println("where1 = "+where1);
                System.out.println("store : "+store);
                String str="insert into split values(?,?,?,?)";
                    pst= conn.prepareStatement(str);
                    pst.setInt(1,no );
                    pst.setString(2,select1 );
                    pst.setString(3,from1);
                    pst.setString(4,where1);
                pst.execute();
                
                String s2="delete from splitnew";
                ps2=conn.prepareStatement(s2);
            ps2.executeUpdate();
            ps2.close();
                
            String str1="insert into splitnew(select11,from11,where11) select distinct select1,from1,where1 from split";
                    pst1= conn.prepareStatement(str1);
                    pst1.execute();
               
            

     // String sql = "SELECT @n := @n  + 1 n, select11,from11,where11 FROM splitnew, (SELECT @n := 0) m ORDER BY select11,from11,where11";
      
                
        }
        
        String s2="delete from splitno";
                ps2=conn.prepareStatement(s2);
            ps2.executeUpdate();
            ps2.close();
        
        String sql="SELECT * FROM SPLITNEW";
        Statement stmt1 = null;
        stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(sql);
      //STEP 5: Extract data from result set
      
     
      while(rs.next()){
                 //nn=rs.getInt("n");
                 ss=rs.getString("select11");
                 ff=rs.getString("from11");
                 ww=rs.getString("where11");
                 
                 
                 
      
      String str2="insert into splitno values(?,?,?,?)";
                    pst2= conn.prepareStatement(str2);
                    pst2.setInt(1,++nn );
                    pst2.setString(2,ss );
                    pst2.setString(3,ff);
                    pst2.setString(4,ww);
                pst2.execute();
            //System.out.println("\n\nLAST VALUE : "+nn+" "+ss+" "+ff+" "+ww);
      }
        } catch (FileNotFoundException ex) {
                Logger.getLogger(split.class.getName()).log(Level.SEVERE, null, ex);
            }
                pst.close();
                conn.close();
            }
        catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
