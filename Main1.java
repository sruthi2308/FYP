import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main1 {
    int val=0;
	private static BufferedWriter bufferedWriter;
	private static BufferedReader bufferedReader;

	/**
	 * @param args
	 * @throws Exception
	 * @description: this method will read the query command from input.txt and
	 *               parse it then output the resut to AST.xml file
	 *
	 */
	public static void main(String args[]) throws Exception {
            try{
              //  ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/antipatterndb?useUnicode=yes&characterEncoding=UTF-8","root","info123.");
            Statement stmt = conn.createStatement();
            //System.out.println("Created DB Connection....");
            ResultSet rs = stmt.executeQuery("select STATEMENT from dataset_refined");
            
           String st;BufferedWriter bw = null;
		
 //FileWriter fw=new FileWriter(new File("input.txt"));
		int i=0;
                System.out.println("Input.txt file generated");
            while(rs.next())
            { 
            
                st=rs.getString(1);
                
                //System.out.println("st is "+st);
                //bw = new BufferedWriter(fw);
	        //bw.append(st);
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("input.txt", true)));
    //out.println("the text");
    out.write(st);
    out.println();
   out.close();
   
                     
//bw.close();      
            }
            
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
            FileInputStream fstream = new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\ANTIPATTERN\\input.txt");
BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
FileWriter fw=new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\ANTIPATTERN\\output.txt",true);
BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw);
String strLine="";

//Read File Line By Line

Scanner sc=new Scanner(new File("input.txt"));

//while ((strLine = br.readLine()) != null)   {
while(sc.hasNextLine())  {  strLine=sc.nextLine();
            // Print the content on the console
//System.out.println("\nSTRLINE IS ---- "+strLine);
  String result;
            result = doComputation(strLine);
            if(result=="Parsed"){
                //System.out.println("\nloop begin");
               //out.println(strLine);
               fw.append(strLine+"\r\n");
               
               //System.out.println("\nloop end");
           //fw.append(strLine+"\r\n");    
           //fw.close();    
           }
}
            System.out.println("\n-----After Parsing-----");
System.out.println("\nOutput.txt file generated");
fw.close();

//Close the input stream
br.close();
            


new Antipattern().show();


        }
        
        public static String doComputation(String sql)
    {
        int len=sql.length();
        //String arr[];
        Pattern pattern = Pattern.compile(" "); 
  
        // splitting String str with a pattern 
        // (i.e )splitting the string whenever their 
        //  is whitespace and store in temp array. 
        String[] temp = pattern.split(sql); 
        String result = ""; 
        String[] store=new String[temp.length];
        // Iterate over the temp array and store 
        // the string in reverse order. 
        /*
        for (int i = 0; i < temp.length; i++) { 
            if (i == temp.length - 1) 
                result = temp[i] + result; 
            else
                result = " " + temp[i] + result; 
    }
        */
        String final1 = null;
        int set=-1;
        int k=-1,setv=-1;
        int length=-1;
        for(String alphabet : temp)
        {
            length++;
            //System.out.println(alphabet);
        }
        
        
        if(length>=3)
        {
        int basic=0,high=0;
        if(temp[0].equalsIgnoreCase("SELECT")&&temp[2].equalsIgnoreCase("FROM"))
        { 
            if(length==3)
                basic=1;
            if(length>3)
                if(temp[4].equalsIgnoreCase("WHERE"))
                    if(length==5)
                        high=1;
        }
        int gg=0;
        
        if(basic==1||high==1)
        {
            gg=1;
            final1="Parsed";
        }
        if(gg==0)
            final1="NotParsed";
        
      }
        else
            final1="NotParsed";
    return final1;
    } 
}  

