package ou.gong.models;

public class GameInfo {
	
	private String game_name ; //��Ϸ����
	private int game_id ; //��Ϸ���
	private int wager_issue ; //������
	private int issue ; //�ҽ���
	private int abandon_issue ;//������ʼ��
	private int abandon_num ;//��������
	private String win_num ; //��������
	private String start_time ;//��ʼ����ʱ��
	private String end_time ; //��������ʱ��
	private int sale_days ; //��������
	private int cash_days ;//�ҽ�����
	private String end_cash_time ; //�����ҽ�ʱ��
	
	private String game_file ;  //��Ϸ�����ļ���������excel�ļ�ʹ�ò�������
	private String game_sheet ; //��Ϸ�����ļ�������excel�ļ�ʹ�ò�������
	
	private int tsn ;//��ʼ��ˮ��
	
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
