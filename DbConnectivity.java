
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

//singleton implementation
public class DbConnectivity {
    
  private static  DbConnectivity db ;
   String username=null,currentusername=null,regnum=null,reservid=null;
    Connection con;
    private DbConnectivity(){
        
    }
    public static DbConnectivity getobject(){
        if(db==null){
            db=new DbConnectivity();
        }
        return db;
    }
    
    public Connection DbConnection(){
         try{  
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  

    try {
        System.out.println("connecting");
        
        con = DriverManager.getConnection("jdbc:sqlserver://ASUS\\SQLEXPRESS:1433;databaseName=bustricketreservation;integratedSecurity=true");
                
               System.out.println("connected to db"); 
         
    }catch(Exception e){
        System.out.println(e);
    }
} catch(Exception e){ System.out.println(e);
}
return con;
    }

public String retrievecurrentuser( )
    {
        Stack s=new Stack();
        DbConnectivity db1;
        db1=DbConnectivity.db;
       //Connection con=db.DatabaseConnection();
       //String username,currentusername;
       try
       {
           Statement sm=con.createStatement();
           ResultSet rs=sm.executeQuery("select username from loginDetail");
           
           while(rs.next()){
               
               username=rs.getString(1);
               s.push(username);
           }
           
           currentusername=s.pop();
           //System.out.println("currentuser="+currentusername);
       }
       catch(Exception e)
       {}
  
      return currentusername; 
    }   
    

public String currentreserid( )
    {
        Stack s=new Stack();
        DbConnectivity db1;
        db1=DbConnectivity.db;
        String id;
       //Connection con=db.DatabaseConnection();
       //String username,currentusername;
       try
       {
           Statement sm=con.createStatement();
           ResultSet rs=sm.executeQuery("select reser_id from Reservation1");
           
           while(rs.next()){
               
               id=rs.getString(1);
               s.push(id);
           }
           
           reservid=s.pop();
           System.out.println("reserv_id="+reservid);
       }
       catch(Exception e)
       {}
  
      return reservid; 
    }


    
      public String currentuserregnum()
    {
        
       DbConnectivity db;
       db=DbConnectivity.db;
       
       try
       {
           Statement sm=con.createStatement();
           ResultSet rs=sm.executeQuery("select regid from Registration where username='"+this.retrievecurrentuser()+"'");
           
           while(rs.next()){
               
               regnum=rs.getString(1);
               
           }
           System.out.println("regnum="+regnum);
       }
       catch(Exception e)
       {}
       return regnum;
    }
}
