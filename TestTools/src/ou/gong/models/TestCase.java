package ou.gong.models;

public class TestCase {
	
	private int bs ; //����
	private int qs ;  //����
	private int play_type ; //�淨���
	private int wager_money ; //Ͷע���
	private String wager_num ; //Ͷע����
	private int tsn ; //��ˮ��
	private String pre_win_num ; //Ԥ���н�����
	private String pre_win_result ; //Ԥ���н����
	
	private String explain ; //˵��
	private String serial_num ;//�������
	private String result ; //�������Խ��
	private String from_server_result ; //��̨���ؽ��
	
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
