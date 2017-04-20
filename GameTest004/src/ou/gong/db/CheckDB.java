package ou.gong.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ou.gong.dao.ServerInfoDao;
import ou.gong.models.ServerInfo;

public class CheckDB {

	private ServerInfo sinfo;
	private PreparedStatement pstm;
	private String db_url ;
	private String username ;
	private String password  ;
	
	private Connection con ;
	public CheckDB(String server_name) {
		sinfo = new ServerInfoDao().getServerInfo(server_name);
		String db_type = sinfo.getDb_type();
		String db_ip = sinfo.getDb_ip();
		int db_port = sinfo.getDb_port();
		String db_name = sinfo.getDbName() ;
		this.password = sinfo.getDb_pass() ;
		this.username = sinfo.getDb_username();
		String className = "";
		
		if (db_type.equals("postgre")) {
			className = "org.postgresql.Driver" ;
			this.db_url = "jdbc:postgresql://"+db_ip+":"+db_port+"/"+db_name;
			System.out.println(this.db_url) ;
			System.out.println(username) ;
			System.out.println(password);
		} else if (db_type.equals("sybase")) {
			className = "com.sybase.jdbc.SybDriver" ;
			db_url = "jdbc:sybase:Tds:"+db_ip+":"+db_port+"/"+db_name ;
		}
		
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库驱动失败！");
			e.printStackTrace();
		}

	}
	
	

	/**创建数据库连接*/
	public Connection getCon(){
		
		try {
			con=DriverManager.getConnection(this.db_url,this.username,this.password);
		} catch (SQLException e) {
			System.out.println("创建数据库连接失败！");
			con=null;
			e.printStackTrace();
		}
		return con;
	}
	
	
	public void doPstm(String sql,Object[] params){
		if(sql!=null&&!sql.equals("")){
			if(params==null)
				params=new Object[0];
			
			getCon();
			if(con!=null){
				try{		

					pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					for(int i=0;i<params.length;i++){
						pstm.setObject(i+1,params[i]);
					}
					pstm.execute();
				}catch(SQLException e){
					System.out.println("doPstm()方法出错！");
					e.printStackTrace();
				}				
			}			
		}
	}
	
	public ResultSet getRs() throws SQLException{
		return pstm.getResultSet();		
	}
	public int getCount() throws SQLException{
		return pstm.getUpdateCount();		
	}
	public void closed(){
		try{
			if(pstm!=null)
				pstm.close();			
		}catch(SQLException e){
			System.out.println("关闭pstm对象失败！");
			e.printStackTrace();
		}
		try{
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			System.out.println("关闭con对象失败！");
			e.printStackTrace();
		}
	}
	

	
	public static void main(String[] args) {
		CheckDB db = new CheckDB("甘肃现场测试后台") ;
		String sql = "select * from win_num where game_id = ? and wager_issue = ?" ;
		db.doPstm(sql, new Integer[]{5,2017083});
		ResultSet rs = null ;
		try {
			rs = db.getRs() ;
			while(rs.next()) {
				System.out.println(rs.getInt("num")) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
