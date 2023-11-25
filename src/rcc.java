import com.intersystems.jdbc.IRIS;
import com.intersystems.jdbc.IRISConnection;
import java.sql.DriverManager;
import java.util.Scanner;

public class rcc {
   
	public static void main(String[] args) {
		System.out.println("\n\tWelcome to IRIS NativeAPI CommandLine Extension\n") ;
	// init connection
		String ip   = args[0];
		String port = args[1];
		String nspc = args[2];
		String user = args[3];
		String pwd  = args[4];
    String className = args[5];
    String methodName = args[6];
    String initstr = args[7];
	// get connected
	 try {
		IRISConnection conn = (IRISConnection) DriverManager.getConnection("jdbc:IRIS://"+ip+":"+port+"/"+nspc,user,pwd);
    IRIS iris = IRIS.createIRIS(conn) ;

      try {
		    String ans=iris.functionString("run","%ZAPM",className,methodName,initstr) ;	
		  //return ans ;
        System.out.println(ans);

      } catch (RuntimeException e) {
        System.out.println("Err " + e.getMessage());
      }
	
    iris.close();
    conn.close();
		}
  catch (Exception ex) {
          System.out.println("Exception -- "+ex.getMessage());
    }
    return ;
	}
}
