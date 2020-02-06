package swiggyhotel;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendSMS {

	public static void main(String[] args) {
        try {
        	String recipient="+919159951925";
        	String message="Greetings from My Swiggy Hotel!Have a nice day!";
        	String username="admin";
        	String password="123456";
        	String originator="+919787341714";
        	String requestUrl="http://127.0.0.1:9501/api?action=sendmessage&"+
        	"username=" + URLEncoder.encode(username,"UTF-8")+
        	"&password="+ URLEncoder.encode(password,"UTF-8")+
        	"&recipient=" + URLEncoder.encode(recipient,"UTF-8")+
        	"&messagetype=SMS:TEXT"+
        	"&messagedata=" + URLEncoder.encode(message,"UTF-8")+
        	"&originator=" + URLEncoder.encode(originator,"UTF-8")+
        	"&serviceprovider=GSMModem1"+
        	"&responseformat=html";
        	URL url=new URL(requestUrl);
        	HttpURLConnection uc=(HttpURLConnection)url.openConnection();
        	System.out.println(uc.getResponseMessage());
        	uc.disconnect();
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        	
        }
	}

}
