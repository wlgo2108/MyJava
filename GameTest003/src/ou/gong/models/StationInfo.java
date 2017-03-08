package ou.gong.models;

public class StationInfo {
	
	private int station_id ; //站点编号
	private long station_cret ;//站点认证码
	private String station_address ;//站地址
	
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public long getStation_cret() {
		return station_cret;
	}
	public void setStation_cret(long station_cret) {
		this.station_cret = station_cret;
	}
	public String getStation_address() {
		return station_address;
	}
	
	public void setStation_address(String station_address) {
		this.station_address = station_address;
	}
	
	

}
