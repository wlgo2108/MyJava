package ou.gong.dao;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import ou.gong.models.Server;
import ou.gong.socket.BasicSocket;

public class TranCodeDao {
	
	private String server_name ;
	private String game_name ;
	private GameDao gameDao ;
	private ServerDao serverDao ;
	private BasicSocket socket ; 
	private Server server ;
	public TranCodeDao(String server_name ,String game_name) {
		this.server_name = server_name ;
		this.game_name = game_name ;
		gameDao = new GameDao() ;
		serverDao = new ServerDao() ;
		server = serverDao.getServer(server_name) ;
		try {
			socket = new BasicSocket(server.getServerHost(),server.getServerPort()) ;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("服务器连接失败！") ;
			e.printStackTrace();
		}

	}
	
	
	public List<String> t101300() {
		List<String> reList = new ArrayList<String>() ;
		
		
		
		
		return reList ;
	}
	
	
	
	

	
}
