import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaMysqlSelectExample
{

  public static void main(String[] args)
  {
    try
    {
      // create our mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/csvdb";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "password");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM archivio";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        
        Date anno = rs.getDate("anno");
        String ruota = rs.getString("ruota");
        
        
        int primo = rs.getInt("primo");
        int secondo = rs.getInt("secondo");
        int terzo = rs.getInt("terzo");
        int quarto = rs.getInt("quarto");
        int quinto = rs.getInt("quinto");
        
        ArrayList<Integer> estrazione = new ArrayList<Integer>();

        estrazione.add(rs.getInt("primo"));
        estrazione.add(rs.getInt("secondo"));
        estrazione.add(rs.getInt("terzo"));
        estrazione.add(rs.getInt("quarto"));
        estrazione.add(rs.getInt("quinto"));
        
        int contausciti = 0;
        
        if(estrazione.contains(15)) {
        	contausciti++;
        }
        
        if(estrazione.contains(6)) {
        	contausciti++;
        }
        
        if(estrazione.contains(79)) {
        	contausciti++;
        }
        
        if(estrazione.contains(18)) {
        	contausciti++;
        }
        
        if(estrazione.contains(53)) {
        	contausciti++;
        }
        
        if(contausciti==4 || contausciti==3 || contausciti==5) {
        	System.out.println("USCITI");
         	System.out.format("%s, %s, %s, %s, %s, %s, %s\n", anno, ruota, primo, secondo, terzo, quarto, quinto);
        }
        
        
        
        
        
       
    	
        
        
        
        
        // print the results
        //System.out.format("%s, %s, %s, %s, %s, %s, %s\n", anno, ruota, primo, secondo, terzo, quarto, quinto);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}