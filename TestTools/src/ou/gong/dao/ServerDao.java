package ou.gong.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ou.gong.db.DBConnection;
import ou.gong.models.Server;

public class ServerDao {
	
	private DBConnection db ;
	
	public ServerDao() {
		db  = new DBConnection() ;
	}
	
	public List<Server> getServer() {
		List<Server> serverList = new ArrayList<Server>() ;
		String sql = "select * from tb_proinfo where server_name like ?" ;
		String[] params = new String[]{"%ºóÌ¨%"} ;
		db.doPstm(sql, params) ;
		try {
			ResultSet rs = db.getRs() ;
			while(rs.next()){
				   Server server = new Server() ;
		
				   server.setDbHost(rs.getString("db_ip"));
				   server.setDbName("db_name");
				   server.setDbPass("db_pwd");
				   server.setDbPort(rs.getInt("db_port"));
				   server.setDbType(rs.getString("db_type"));
				   server.setDbUser(rs.getString("db_username")) ;
				   server.setDownload_file_path(rs.getString("download_path")) ;
				   server.setGame_num(rs.getInt("game_num")) ;
				   server.setPro_id(rs.getInt("pro_id"));
				   server.setProName(rs.getString("pro_name"));
				   server.setServer_name(rs.getString("server_name"));
				   server.setServerHost(rs.getString("server_ip"));
				   server.setServerPass(rs.getString("server_pass"));
				   server.setServerPort(rs.getInt("server_port"));
				   server.setServerUser(rs.getString("server_username"));
				   server.setUpdate_file_path(rs.getString("update_path")) ;
				   serverList.add(server) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closed() ;
		}
		return serverList ;
	}
	
	public Server getServer(String server_name) {
		Server server = null;
		String sql = "select * from tb_proinfo where server_name = ?";
		String[] params = new String[] { server_name };
		db.doPstm(sql, params);
		try {
			ResultSet rs = db.getRs();
			if (rs.next()) {
				server = new Server();
				server.setDbHost(rs.getString("db_ip"));
				server.setDbName("db_name");
				server.setDbPass("db_pwd");
				server.setDbPort(rs.getInt("db_port"));
				server.setDbType(rs.getString("db_type"));
				server.setDbUser(rs.getString("db_username"));
				server.setDownload_file_path(rs.getString("download_path"));
				server.setGame_num(rs.getInt("game_num"));
				server.setPro_id(rs.getInt("pro_id"));
				server.setProName(rs.getString("pro_name"));
				server.setServer_name(rs.getString("server_name"));
				server.setServerHost(rs.getString("server_ip"));
				server.setServerPass(rs.getString("server_pass"));
				server.setServerPort(rs.getInt("server_port"));
				server.setServerUser(rs.getString("server_username"));
				server.setUpdate_file_path(rs.getString("update_path"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closed();
		}

		return server;
	}
	
	

}
