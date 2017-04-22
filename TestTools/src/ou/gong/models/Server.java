package ou.gong.models;

public class Server {
	
	private String server_name ; //服务器别名
	private int pro_id ;  //服务器省码
	private int game_num ; //服务器游戏个数
	private int dbPort ;  //数据库端口
	private String dbHost ; //数据库ip
	private String dbUser ; //数据库用户名
	private String dbPass ; //数据库密码
	private String dbName ; //数据库名
	private int serverPort ; //服务器名
	private String serverHost ; //服务器端口
	private String serverUser ; //服务器用户名
	private String serverPass ; //服务器密码
	private String update_file_path ; //上传文件路径
	private String download_file_path ; //下载文件路径
	private String dbType ; //数据库类型 --- postgresql,mysql,lottery
	private String proName ; //服务器省份简码
	public String getServer_name() {
		return server_name;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getGame_num() {
		return game_num;
	}
	public void setGame_num(int game_num) {
		this.game_num = game_num;
	}
	public int getDbPort() {
		return dbPort;
	}
	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}
	public String getDbHost() {
		return dbHost;
	}
	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPass() {
		return dbPass;
	}
	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	public String getServerHost() {
		return serverHost;
	}
	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
	public String getServerUser() {
		return serverUser;
	}
	public void setServerUser(String serverUser) {
		this.serverUser = serverUser;
	}
	public String getServerPass() {
		return serverPass;
	}
	public void setServerPass(String serverPass) {
		this.serverPass = serverPass;
	}
	public String getUpdate_file_path() {
		return update_file_path;
	}
	public void setUpdate_file_path(String update_file_path) {
		this.update_file_path = update_file_path;
	}
	public String getDownload_file_path() {
		return download_file_path;
	}
	public void setDownload_file_path(String download_file_path) {
		this.download_file_path = download_file_path;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	
	
	@Override
	public String toString() {
		return "Server [server_name=" + server_name + ", pro_id=" + pro_id + ", game_num=" + game_num + ", dbPort="
				+ dbPort + ", dbHost=" + dbHost + ", dbUser=" + dbUser + ", dbPass=" + dbPass + ", dbName=" + dbName
				+ ", serverPort=" + serverPort + ", serverHost=" + serverHost + ", serverUser=" + serverUser
				+ ", serverPass=" + serverPass + ", update_file_path=" + update_file_path + ", download_file_path="
				+ download_file_path + ", dbType=" + dbType + ", proName=" + proName + "]";
	}
	
	
	
	
	
	
	
	
	

}
