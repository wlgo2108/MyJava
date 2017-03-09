package ou.gong.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ou.gong.db.DBConnection;
import ou.gong.models.ServerInfo;

public class ServerInfoDao {
	private DBConnection db ;
	
	public ServerInfoDao() {
		db = new DBConnection() ;
	}
	
	
	public List<ServerInfo> getServer() {
		List<ServerInfo> sList = new ArrayList<ServerInfo> () ;
		String sql = "select * from tb_proinfo" ;
		db.doPstm(sql, null) ;
		try {
			ResultSet rs = db.getRs() ;
			while(rs.next()) {
				ServerInfo sinfo = new ServerInfo() ;
				sinfo.setDb_ip(rs.getString("db_ip")) ;
				sinfo.setDb_port(rs.getInt("db_port")) ;
				sinfo.setDbName(rs.getString("db_name")) ;
				sinfo.setDownload_path(rs.getString("download_path")) ;
				sinfo.setGame_num(rs.getInt("game_num")) ;
				sinfo.setHost_ip(rs.getString("server_ip")) ;
				sinfo.setPort(rs.getInt("server_port")) ;
				sinfo.setPro_code(rs.getInt("pro_id")) ;
				sinfo.setServer_name(rs.getString("server_name")) ;
				sinfo.setServer_pass(rs.getString("server_pass")) ;
				sinfo.setServer_user(rs.getString("server_username")) ;
				sinfo.setUpload_path(rs.getString("upload_path")) ;
				sList.add(sinfo) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sList ;
	}


	
	
	public List<ServerInfo> getServerInfoByProId(int pro_id) {
		List<ServerInfo> sList = new ArrayList<ServerInfo> () ;
		String sql = "select * from tb_proinfo where pro_id = ?" ;
		db.doPstm(sql, new String[]{pro_id + ""}) ;
		try {
			ResultSet rs = db.getRs() ;
			while(rs.next()) {
				ServerInfo sinfo = new ServerInfo() ;
				sinfo.setDb_ip(rs.getString("db_ip")) ;
				sinfo.setDb_port(rs.getInt("db_port")) ;
				sinfo.setDbName(rs.getString("db_name")) ;
				sinfo.setDownload_path(rs.getString("download_path")) ;
				sinfo.setGame_num(rs.getInt("game_num")) ;
				sinfo.setHost_ip(rs.getString("server_ip")) ;
				sinfo.setPort(rs.getInt("server_port")) ;
				sinfo.setPro_code(rs.getInt("pro_id")) ;
				sinfo.setServer_name(rs.getString("server_name")) ;
				sinfo.setServer_pass(rs.getString("server_pass")) ;
				sinfo.setServer_user(rs.getString("server_username")) ;
				sinfo.setUpload_path(rs.getString("upload_path")) ;
				sList.add(sinfo) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sList ;
	}
	
	public List<ServerInfo> getZcServer() {
		List<ServerInfo> sList = new ArrayList<ServerInfo> () ;
		String sql = "select * from tb_proinfo where server_name like ?" ;
		db.doPstm(sql, new String[]{"%中彩服务器%"}) ;
		try {
			ResultSet rs = db.getRs() ;
			while(rs.next()) {
				
					ServerInfo sinfo = new ServerInfo() ;
					sinfo.setDb_ip(rs.getString("db_ip")) ;
					sinfo.setDb_port(rs.getInt("db_port")) ;
					sinfo.setDbName(rs.getString("db_name")) ;
					sinfo.setDownload_path(rs.getString("download_path")) ;
					sinfo.setGame_num(rs.getInt("game_num")) ;
					sinfo.setHost_ip(rs.getString("server_ip")) ;
					sinfo.setPort(rs.getInt("server_port")) ;
					sinfo.setPro_code(rs.getInt("pro_id")) ;
					sinfo.setServer_name(rs.getString("server_name")) ;
					sinfo.setServer_pass(rs.getString("server_pass")) ;
					sinfo.setServer_user(rs.getString("server_username")) ;
					sinfo.setUpload_path(rs.getString("upload_path")) ;
					sList.add(sinfo) ;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sList ;
	}
	
	//保证服务器用户名的单一性
	public boolean checkServerName(String server_name) {
		boolean chk = false  ;
		String sql = "select * from tb_proinfo where server_name = ?" ;
		db.doPstm(sql, new String[]{server_name});
		try {
			ResultSet rs = db.getRs() ;
			if(rs.next()) {
				chk = true ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return chk ;
	}
	
	
	public static  void main(String[] args) {
		ServerInfoDao sDao = new ServerInfoDao() ;
		List<ServerInfo> serverList = sDao.getZcServer() ;
		for(ServerInfo s : serverList) {
			System.out.println(s.getServer_name()) ;
		}
		System.out.println(sDao.checkServerName("四川后台"));
		System.out.println(sDao.getServerInfoByProId(62).size() ) ;
		
	}
	

}
