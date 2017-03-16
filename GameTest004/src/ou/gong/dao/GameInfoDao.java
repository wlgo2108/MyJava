package ou.gong.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import ou.gong.db.DBConnection;

public class GameInfoDao {
	
	private DBConnection db ;
	
	public GameInfoDao() {
		db = new DBConnection() ;
	}
	
	public int getGameID(String server_name,String game_name ) {
		int game_id = 0 ;
		String sql = "select game_id from tb_proinfo ,tb_game where "
				+ "tb_game.pro_id = tb_proinfo.pro_id and tb_proinfo.server_name = ? "
				+ "and tb_game.game_name = ?" ;
		
		db.doPstm(sql, new String[]{server_name,game_name}) ;
		ResultSet rs = null ;
		try {
			rs = db.getRs() ;
			if(rs.next()) {
				game_id = rs.getInt("game_id") ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null ) {
				try {
					rs.close() ;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			db.closed() ; 
		}
		
		return game_id ;
		
	}
	
	public String getSheetTable(String server_name,String game_name) {
		String sheet_name = "" ;
		System.out.println(server_name + game_name);
		String sql = "select sheet_name from tb_game,tb_proinfo where tb_game.pro_id = tb_proinfo.pro_id "
				+ " and tb_proinfo.server_name = ? and tb_game.game_name = ? " ;
		db.doPstm(sql, new String[]{server_name,game_name}) ;
		ResultSet rs = null ;
		try {
			rs = db.getRs() ;
			if(rs.next()) {
				System.out.println(1);
				sheet_name = rs.getString("sheet_name") ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null ) {
				try {
					rs.close() ;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			db.closed() ; 
		}
		
		
		return sheet_name ;
	}
	

}
