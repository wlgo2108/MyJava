package ou.gong.models;
import ou.gong.dao.*;
import ou.gong.tools.MySuperAction;

public class TranCodeInfo extends MySuperAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//stat:  1 -- Ͷע/2--ע�� /3---����/4--�ҽ�/5--���ڶҽ�/6--������Ʊ/7---�ɿ�602201
	public int stat  ; //����
	public String server_name ;//��������
	public int station_id ; //վ����
	public long station_cert ; //վ����֤��
	public String game_name ; //��Ϸ����
	public float money ; //�ɿ���
	public int issue ;//�ں�---Ͷע�ںţ��ҽ��ںţ�ע���ں�
	public int tsn ; //��ˮ�� -- Ͷע��ʼ��ˮ�ţ��ҽ��ںţ�ע���ں�
	public int type ; //Ͷע��ʽ--- 0 : ���ݿ�Ͷע/ 1 ��excel��ʽͶע
	
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
