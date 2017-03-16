package ou.gong.models;

public class ZcFileDwn {
	
	private int game_type ; //游戏编号
	private int issue ;	//期号
	private String start_time ; //开始销售时间
	private String end_time ; //结束销售时间
	private int days ;	//销售天数
	private int cash_days ;	//兑奖天数
	private String end_cash_time ; //结束兑奖时间
	private int abandonNum ; //弃奖期数
	private int abandonIssue ; //弃奖期号
	private String win_num ; //开奖号码
	public int getGame_type() {
		return game_type;
	}
	public void setGame_type(int game_type) {
		this.game_type = game_type;
	}
	public int getIssue() {
		return issue;
	}
	public void setIssue(int issue) {
		this.issue = issue;
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
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
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
	public int getAbandonNum() {
		return abandonNum;
	}
	public void setAbandonNum(int abandonNum) {
		this.abandonNum = abandonNum;
	}
	public int getAbandonIssue() {
		return abandonIssue;
	}
	public void setAbandonIssue(int abandonIssue) {
		this.abandonIssue = abandonIssue;
	}
	public String getWin_num() {
		return win_num;
	}
	public void setWin_num(String win_num) {
		this.win_num = win_num;
	}
	
	
	

}
