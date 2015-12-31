// The Client sessions package
import com.thetransactioncompany.jsonrpc2.client.*;

// The Base package for representing JSON-RPC 2.0 messages
import com.thetransactioncompany.jsonrpc2.*;

// The JSON Smart package for JSON encoding/decoding (optional)


// For creating URLs
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
public class ClientExample {

	private static String method;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("main .....");
		 URL serverURL = null;
		try {
			serverURL = new URL("http://localhost:8080/jsonPrcProjectApi/jsonrpc");
			
		} catch (MalformedURLException e) {
			e.printStackTrace(); 
		}
		
		// Create new JSON-RPC 2.0 client session
		 JSONRPC2Session mySession = new JSONRPC2Session(serverURL);
		  // Construct new request
		  // String method = "getFestivalCategory"; //成功
		 // String method = "getCategoryList";  //成功
		 
	     // String method = "getQueryMenberList";
        // String method = "uploadShortMessageStatics";
		// String method = "getShortMessage";
		//String method = "findAllVersion";
		 //String method = "getHore";
		// String method="hostManagementState";//成功
		//String method="hostManagementStateY";//成功
		// String method="paymentStateOpen";
		// String method="paymentStateOff";
		// String method="findByPayList";
		 //String method="findByHouseList";
		 String method = "findByHouseList";
		 //String method="findByPayManList";
		// String method="findByPayManNow";
		 Map map = new HashMap();
		// map.put("p_no", "123");
		// map.put("p_no", "111");
		 map.put("h_username", "tk");
		 
		// map.put("pay_no", "80");
		//  map.put("maxMsgid","4");
		 // map.put("totalsend", "5");
		   //map.put("categoryid","3");
		 //map.put("88", "2");
		 
		  //map.put("festivagid", "4");
		 
				 
		// map.put("p_no", "111");
		 // map.put("L_Type","4");
		 
		// map.put("id", "111");
		// map.put("state","1");
		 
		 
//		  try {
//			map.put("keyword", "万地方".getBytes("unicode"));
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
		
		 //JSONRPC2Request request = new JSONRPC2Request(method, requestID);
		 //map.put(arg0, arg1);
		 String requestID = "1";
		 JSONRPC2Request request = new JSONRPC2Request(method, map,requestID);

		 // Send request
		 JSONRPC2Response response = null;
          System.out.println(request);
		 try {
		         response = mySession.send(request);		    

		 } catch (JSONRPC2SessionException e) {
			 e.printStackTrace();
		         System.err.println(e.getMessage());
		         // handle exception...
		 }

		 // Print response result / error
		 if (response.indicatesSuccess())
		 {
			System.out.println("************");
			 System.out.println(response.getResult());			
		 }			
		else
		{
			System.out.println(response.getError().getMessage());

		}
	
	}
	
}

