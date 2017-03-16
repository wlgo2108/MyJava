package ou.gong.models;
import ou.gong.dao.*;
import ou.gong.tools.MySuperAction;

public class TranCodeInfo extends MySuperAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//stat:  1 -- 投注/2--注销 /3---冲正/4--兑奖/5--多期兑奖/6--多期退票/7---缴款602201
	public int stat  ; //操作
	public String server_name ;//服务器名
	public int station_id ; //站点编号
	public long station_cert ; //站点认证码
	public String game_name ; //游戏名称
	public float money ; //缴款金额
	public int issue ;//期号---投注期号，兑奖期号，注销期号
	public int tsn ; //流水号 -- 投注初始流水号，兑奖期号，注销期号
	public int type ; //投注方式--- 0 : 数据库投注/ 1 ：excel方式投注
	
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getServer_name() {
		return server_name;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public long getStation_cert() {
		return station_cert;
	}
	public void setStation_cert(long station_cert) {
		this.station_cert = station_cert;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getIssue() {
		return issue;
	}
	public void setIssue(int issue) {
		this.issue = issue;
	}
	public int getTsn() {
		return tsn;
	}
	public void setTsn(int tsn) {
		this.tsn = tsn;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public int getGame_id() {
		int game_id = new GameInfoDao().getGameID(getServer_name(), getGame_name()) ;
		return game_id ;
	}

	
	

}
