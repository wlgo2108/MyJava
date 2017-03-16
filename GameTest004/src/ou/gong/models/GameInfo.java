package ou.gong.models;

public class GameInfo {
	
	private String game_name ; //游戏名称
	private int game_id ; //游戏编号
	private int wager_issue ; //销售期
	private int issue ; //兑奖期
	private int abandon_issue ;//弃奖起始期
	private int abandon_num ;//弃奖期数
	private String win_num ; //开奖号码
	private String start_time ;//开始销售时间
	private String end_time ; //结束销售时间
	private int sale_days ; //销售天数
	private int cash_days ;//兑奖天数
	private String end_cash_time ; //结束兑奖时间
	
	private String game_file ;  //游戏操作文件名，用于excel文件使用测试用例
	private String game_sheet ; //游戏操作文件表，用于excel文件使用测试用例
	
	private int tsn ;//初始流水号
	
	public int getTsn() {
		return tsn;
	}
	public void setTsn(int tsn) {
		this.tsn = tsn;
	}
	public String getGame_file() {
		return game_file;
	}
	public void setGame_file(String game_file) {
		this.game_file = game_file;
	}
	public String getGame_sheet() {
		return game_sheet;
	}
	public void setGame_sheet(String game_sheet) {
		this.game_sheet = game_sheet;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public int getWager_issue() {
		return wager_issue;
	}
	public void setWager_issue(int wager_issue) {
		this.wager_issue = wager_issue;
	}
	public int getIssue() {
		return issue;
	}
	public void setIssue(int issue) {
		this.issue = issue;
	}
	public int getAbandon_issue() {
		return abandon_issue;
	}
	public void setAbandon_issue(int abandon_issue) {
		this.abandon_issue = abandon_issue;
	}
	public int getAbandon_num() {
		return abandon_num;
	}
	public void setAbandon_num(int abandon_num) {
		this.abandon_num = abandon_num;
	}
	public String getWin_num() {
		return win_num;
	}
	public void setWin_num(String win_num) {
		this.win_num = win_num;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getSale_days() {
		return sale_days;
	}
	public void setSale_days(int sale_days) {
		this.sale_days = sale_days;
	}
	public int getCash_days() {
		return cash_days;
	}
	public void setCash_days(int cash_days) {
		this.cash_days = cash_days;
	}
	public String getEnd_cash_time() {
		return end_cash_time;
	}
	public void setEnd_cash_time(String end_cash_time) {
		this.end_cash_time = end_cash_time;
	}
	
	
	
	

}
