package ou.gong.models;

public class StationInfo {
	
	private int station_id ; //站点编号
	private Long station_cert ; //站点认证码
	private float station_money ; //缴款金额
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public Long getStation_cert() {
		return station_cert;
	}
	public void setStation_cert(Long station_cert) {
		this.station_cert = station_cert;
	}
	public float getStation_money() {
		return station_money;
	}
	public void setStation_money(float station_money) {
		this.station_money = station_money;
	}
	
	
	
	

}
