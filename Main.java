import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
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
            ResultSet rs = stmt.executeQuery("select statement from dataset_refined");
            
           String st;BufferedWriter bw = null;
		
 //FileWriter fw=new FileWriter(new File("input.txt"));
		int i=0;
            while(rs.next())
            { if(i==0){i++;}
            else{
                st=rs.getString(1);
                System.out.println("st is "+st);
                //bw = new BufferedWriter(fw);
	        //bw.append(st);
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("input.txt", true)));
    //out.println("the text");
    out.write(st);
    out.println();
   out.close();
   
            }         
//bw.close();      
            }
            
              
		String inputPath = "input.txt";
		String outputPath = "output.txt";
		System.out.println("read Query from \n\"" + inputPath + "\"");
		String input = readCommand(inputPath);
		System.out.println("input Query: ");
		System.out.println("---------------------------------------");
		System.out.println(input);
		// CALL the parse method and parse the input query then assign the AST
		// to rst String.
		String rst = parse(input);
		System.out.println("\n---------------------------------------");
		System.out.println("Output.txt are output as following : ");
		System.out.println("---------------------------------------\n");
		// print out rst String(AST)
		System.out.println("\nRST IS "+rst);
		System.out.println("\n---------------------------------------");
		System.out.println("Start to write into file :\n\"" + outputPath + "\"");
		System.out.println("---------------------------------------");
		// output the rst into AST.xml file
		outputAST(rst, outputPath);
		System.out.println("---------------------------------------");
	}
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
	/**
	 * @param input
	 * @return AST
	 * @description: this method parse the input Query String
	 *
	 */
	private static String parse(String input) {
		String rst = "";
		try {
			rst = Parser.parse(input);
                        System.out.println("\nrst is ----------"+rst);
		} catch (Exception e) {
			System.out.println("Error during Parsing");
			e.printStackTrace();
		}
		return rst;
	}

	/**
	 * @param inputPath
	 * @return Query String
	 * @description: this method will read the query from the file of
	 *               "inputPath" and return the Query String
	 *
	 */
	private static String readCommand(String inputPath) {
		String input = "";
		try {
			String temp = "";
			FileReader reader = new FileReader(inputPath);
			bufferedReader = new BufferedReader(reader);
			temp = bufferedReader.readLine();
			while (temp != null) {
				input += "\n" + temp;
				temp = bufferedReader.readLine();
                                
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + inputPath + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + inputPath + "'");
		}
		return input;
	}

	/**
	 * @param rst
	 * @param outputPath
	 * @description: This method will output the AST into the file of
	 *               "outputPath"
	 *
	 */
	private static void outputAST(String rst, String outputPath) {
		FileWriter writer;
		try {
                    Scanner sc=new Scanner(new File("input.txt"));
                    FileWriter fw=new FileWriter(outputPath,true);    
                    while(sc.hasNextLine())
                    {
                        rst=sc.nextLine();
			/*writer = new FileWriter(outputPath);
                        bufferedWriter = new BufferedWriter(writer);
                        System.out.println("rst is "+rst);
			bufferedWriter.append(rst);
			bufferedWriter.close();*/
                        
                        fw.write(rst+"\r\n"); 
                          
                        
                           
                    }
                    //fw.write("\n");
                    fw.close(); 
                    sc.close();
		} catch (IOException e) {
			System.out.println("Error during writing result");
			e.printStackTrace();
		}
                
		System.out.println("output Successfully");
	}
}
