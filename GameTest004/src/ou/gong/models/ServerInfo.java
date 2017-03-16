package ou.gong.models;

public class ServerInfo {
	private String host_ip ;//后台ip 
	private int port ;//后台端口号
	private String server_user ;//后台用户名
	private String server_pass ;//后台密码
	private String dbName ;//数据库名
	private String db_ip ;//后台数据库ip 
	private int db_port ;//后台数据库端口号
	
	private int pro_code ; //省码
	private int game_num ;  //游戏个数
	private String upload_path ; //上传文件路径
	private String download_path ; //下载文件路径
	
	private String server_name ;//服务器名称
	
	
	public String getServer_name() {
		return server_name;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	public String getUpload_path() {
		return upload_path;
	}
	public void setUpload_path(String upload_path) {
		this.upload_path = upload_path;
	}
	public String getDownload_path() {
		return download_path;
	}
	public void setDownload_path(String download_path) {
		this.download_path = download_path;
	}
	public String getHost_ip() {
		return host_ip;
	}
	public void setHost_ip(String host_ip) {
		this.host_ip = host_ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getServer_user() {
		return server_user;
	}
	public void setServer_user(String server_user) {
		this.server_user = server_user;
	}
	public String getServer_pass() {
		return server_pass;
	}
	public void setServer_pass(String server_pass) {
		this.server_pass = server_pass;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDb_ip() {
		return db_ip;
	}
	public void setDb_ip(String db_ip) {
		this.db_ip = db_ip;
	}
	public int getDb_port() {
		return db_port;
	}
	public void setDb_port(int db_port) {
		this.db_port = db_port;
	}
	public int getPro_code() {
		return pro_code;
	}
	public void setPro_code(int pro_code) {
		this.pro_code = pro_code;
	}
	public int getGame_num() {
		return game_num;
	}
	public void setGame_num(int game_num) {
		this.game_num = game_num;
	}
	
	
}
