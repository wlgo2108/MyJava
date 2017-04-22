package ou.gong.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import ou.gong.db.DBConnection;

public class GameDao {
	private DBConnection db ;
	
	public GameDao() {
		db = new DBConnection() ;
	}
	
	public int getGame_id(String server_name ,String game_name) {
		int game_id = 0 ; 
		String sql = "select game_id from tb_proinfo a ,tb_game b where a.pro_id = b.pro_id "
				+ " and a.server_name = ? and b.game_name = ?" ;
		String[] params = new String[]{server_name,game_name} ;
		db.doPstm(sql, params);
		try {
			ResultSet rs = db.getRs() ;
			if(rs.next()) {
				game_id = rs.getInt(1) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		} 
		
		return game_id ;
	}

}
