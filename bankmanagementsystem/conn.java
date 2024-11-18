package bankmanagementsystem  ;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;
   public conn(){
    try{
        //Class.forName(com.mysql.cj.jdbc.Driver);//Step 1 Register Driver and this driver is inside a library that we need to import
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem" , "root","Sumit_0001" ); //make connection
        System.out.println("Schema Name:"+c.getSchema()+"\n");
        s = c.createStatement();
    }catch(Exception e){
        System.out.println(e);
    }
   }
}

