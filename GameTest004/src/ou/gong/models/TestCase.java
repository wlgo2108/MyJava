package ou.gong.models;

public class TestCase {

    private int game_id ; //��Ϸ���
    private int pro_id ; // ʡ��
    private int tsn ; //��ˮ��
    private String title ;//�淨����
	private String comment ;  //˵��
 
	private String serialNumber ;
    private String returnFormServer ;//��̨����
    private int play_type ; //��Ϸ�淨���
    private int bs ;//Ͷע����
    private int qs ; //Ͷע�ں�
    private int wager_money ;//Ͷע���
    private String wager_num ; //Ͷע����
    private String pre_win_nun ; //�������뢝
    private String pre_win_result ;//�н����
    private String result ; //���Խ��
    private float money ;
    


    public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getComment() {
 		return comment;
 	}

 	public void setComment(String comment) {
 		this.comment = comment;
 	}

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getReturnFormServer() {
		return returnFormServer;
	}

	public void setReturnFormServer(String returnFormServer) {
		this.returnFormServer = returnFormServer;
	}

	public void setQs(int qs) {
		this.qs =qs;
	}

	public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getTsn() {
        return tsn;
    }

    public void setTsn(int tsn) {
        this.tsn = tsn;
    }

    public int getPlay_type() {
        return play_type;
    }

    public void setPlay_type(int play_type) {
        this.play_type = play_type;
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

    public void setPs(int ps) {
        this.qs = ps;
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

    public String getPre_win_nun() {
        return pre_win_nun;
    }

    public void setPre_win_nun(String pre_win_nun) {
        this.pre_win_nun = pre_win_nun;
    }

    public String getPre_win_result() {
        return pre_win_result;
    }

    public void setPre_win_result(String pre_win_result) {
        this.pre_win_result=pre_win_result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

	@Override
	public String toString() {
		return "TestCase [game_id=" + game_id + ", pro_id=" + pro_id + ", tsn=" + tsn + ", title=" + title
				+ ", comment=" + comment + ", serialNumber=" + serialNumber + ", returnFormServer=" + returnFormServer
				+ ", play_type=" + play_type + ", bs=" + bs + ", qs=" + qs + ", wager_money=" + wager_money
				+ ", wager_num=" + wager_num + ", pre_win_nun=" + pre_win_nun + ", pre_win_result=" + pre_win_result
				+ ", result=" + result + ", money=" + money + "]";
	}


    
    
}
