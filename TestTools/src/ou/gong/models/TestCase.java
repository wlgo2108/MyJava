package ou.gong.models;

public class TestCase {
	
	private int bs ; //倍数
	private int qs ;  //期数
	private int play_type ; //玩法编号
	private int wager_money ; //投注金额
	private String wager_num ; //投注号码
	private int tsn ; //流水号
	private String pre_win_num ; //预期中奖号码
	private String pre_win_result ; //预期中奖结果
	
	private String explain ; //说明
	private String serial_num ;//用例编号
	private String result ; //用例测试结果
	private String from_server_result ; //后台返回结果
	
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getFrom_server_result() {
		return from_server_result;
	}
	public void setFrom_server_result(String from_server_result) {
		this.from_server_result = from_server_result;
	}
	public int getBs() {
		return bs;
	}
	public void setBs(int bs) {
		this.bs = bs;
	}
	public int getQs() {
		return qs;
	}
	public void setQs(int qs) {
		this.qs = qs;
	}
	public int getPlay_type() {
		return play_type;
	}
	public void setPlay_type(int play_type) {
		this.play_type = play_type;
	}
	public int getWager_money() {
		return wager_money;
	}
	public void setWager_money(int wager_money) {
		this.wager_money = wager_money;
	}
	public String getWager_num() {
		return wager_num;
	}
	public void setWager_num(String wager_num) {
		this.wager_num = wager_num;
	}
	public int getTsn() {
		return tsn;
	}
	public void setTsn(int tsn) {
		this.tsn = tsn;
	}
	public String getPre_win_num() {
		return pre_win_num;
	}
	public void setPre_win_num(String pre_win_num) {
		this.pre_win_num = pre_win_num;
	}
	public String getPre_win_result() {
		return pre_win_result;
	}
	public void setPre_win_result(String pre_win_result) {
		this.pre_win_result = pre_win_result;
	}
	
	@Override
	public String toString() {
		return "TestCase [bs=" + bs + ", qs=" + qs + ", play_type=" + play_type + ", wager_money=" + wager_money
				+ ", wager_num=" + wager_num + ", tsn=" + tsn + ", pre_win_num=" + pre_win_num + ", pre_win_result="
				+ pre_win_result + ", explain=" + explain + ", serial_num=" + serial_num + ", result=" + result
				+ ", from_server_result=" + from_server_result + "]";
	}
	
	
	

}
