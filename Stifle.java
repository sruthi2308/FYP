/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class Stifle extends javax.swing.JFrame {

    /**
     * Creates new form Stifle
     */
    public Stifle() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jButton1.setText("DW-Stifle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("DS-Stifle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DF-Stifle");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addGap(73, 73, 73)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            
            ArrayList<String> sarr=new ArrayList<>();
            ArrayList<String> farr=new ArrayList<>();
            ArrayList<String> warr=new ArrayList<>();
            ArrayList<Integer> sn=new ArrayList<>();
            ArrayList<Integer> fn=new ArrayList<>();
            ArrayList<Integer> wn=new ArrayList<>();
            
            Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/antipatterndb?useUnicode=yes&characterEncoding=UTF-8","root","info123.");
            Statement stmt = conn.createStatement();
            
            PreparedStatement ps1=null,ps2=null,pst2=null;
            
            String sql="SELECT * FROM SPLITNEW";
        Statement stmt1 = null;
        stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(sql);
      String ss,ff,ww;
      
     
      while(rs.next()){
                 //nn=rs.getInt("n");
                 ss=rs.getString("select11");
                 ff=rs.getString("from11");
                 ww=rs.getString("where11");
                 sarr.add(ss);
                 farr.add(ff);
                 warr.add(ww);
                 sn.add(sarr.indexOf(ss));
                 fn.add(farr.indexOf(ff));
                 wn.add(warr.indexOf(ww));
                 
     /*           
    for (int i = 0; i < sn.size(); i++) {
  for (int j = i+1; j < sn.size(); j++) {
    // compare list.get(i) and list.get(j)
      if(sn.get(i)== sn.get(j))
      {
          System.out.println("Equal");
      }
      else
      {
          System.out.println("Not Equal");
      }
  
    for (int ii = 0; ii < fn.size(); ii++) {
  for (int jj = ii+1; jj < fn.size(); jj++) {
    // compare list.get(i) and list.get(j)
      if(fn.get(ii)== fn.get(jj))
      {
          System.out.println("Second Equal");
      }
      else
      {
          System.out.println("Second Not Equal");
      }
  
  for (int iii = 0; iii < wn.size(); iii++) {
  for (int jjj = iii+1; jjj < wn.size(); jjj++) {
    // compare list.get(i) and list.get(j)
      if(wn.get(iii)== wn.get(jjj))
      {
          System.out.println("Tird Equal");
      }
      else
      {
          System.out.println("Tird Not Equal");
      }
  
    
    
    if((sn.get(i)== sn.get(j))&& (fn.get(ii)== fn.get(jj)) && (wn.get(iii)== wn.get(jjj)))
            {
                System.out.println("Same\n\n");
            }
    else
    {
        System.out.println("Not Same\n\n");
    }
  }
    }
  }
   }
  }
                 }
    */
                 
      }
            
            for(int i=0;i<sarr.size();i++)
            {
                int sn1=sn.get(i)+1;
                int fn1=fn.get(i)+1;
                int wn1=wn.get(i)+1;
                System.out.println(sn1+"  "+fn1+"  "+wn1);
                
            }
            
            
            
      /*      
            
        Scanner sc=new Scanner(new File("output.txt"));
        while(sc.hasNext())
        {
            
            
            if(sc.nextLine().contains("WHERE specObjID"))
            {
                String test =  sc.nextLine();
                String lastWord = test.substring(test.lastIndexOf("=")+1);
                //System.out.println(lastWord);
                System.out.println(sc.nextLine().replaceAll("=", " IN "));
                
            }
                
        }
        */
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
static String between(String value, String a, String b) {
        // Return a substring between the two strings.
        int posA = value.indexOf(a);
        if (posA == -1) {
            return "";
        }
        int posB = value.lastIndexOf(b);
        if (posB == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= posB) {
            return "";
        }
        return value.substring(adjustedPosA, posB);
    }

    static String before(String value, String a) {
        // Return substring containing all characters before a string.
        int posA = value.indexOf(a);
        if (posA == -1) {
            return "";
        }
        return value.substring(0, posA);
    }

    static String after(String value, String a) {
        // Returns a substring containing all characters after a string.
        int posA = value.lastIndexOf(a);
        if (posA == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= value.length()) {
            return "";
        }
        return value.substring(adjustedPosA);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
        Scanner sc=new Scanner(new File("output.txt"));
        while(sc.hasNext())
        {
            
            
            /*if(sc.next().contains("from"))
            {
                System.out.println("Result "+sc.nextLine());
            }*/
          //  System.out.println(sc.next().indexOf("FROM"));
            
            //System.out.println(between(sc.next()
        //System.out.println(between(sc.next(), ":", "="));
String test;
test=sc.nextLine();
        //System.out.println(before(sc.next(), "FROM"));
        //System.out.println(before(sc.next(), "=")); 
if(test.contains("FROM emp WHERE id=8"))
       // System.out.println(after(sc.nextLine(), "FROM"));
        System.out.println(test);
       // System.out.println(after(test, "="));
String[] sp = test.split(" ");
    System.out.println(sp[1]);
    
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Stifle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stifle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stifle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stifle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stifle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
