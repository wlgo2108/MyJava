package ou.gong.socket;

import java.io.IOException;
import java.net.UnknownHostException;

public class SocketTest {
	
	public static void main(String[] args) {
		String hostIp = "10.13.0.8" ;
		int port = 51370 ;
		BasicSocket bSock  ;
		try {
			bSock = new BasicSocket(hostIp,port) ;
			String msg = "602201;1;12345678;51990001;1;12345678;51990001;51990001;1000;2017-03-07 14:33:01;5;" ;
			System.out.println(msg) ;
			bSock.send(msg);
			System.out.println(bSock.receive());
			bSock.close() ;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
