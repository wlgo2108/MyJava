package ou.gong.models;

public class TestCase {

    private int game_id ; //游戏编号
    private int pro_id ; // 省码
    private int tsn ; //流水号
    private String title ;//玩法名称
	private String comment ;  //说明
 
	private String serialNumber ;
    private String returnFormServer ;//后台返回
    private int play_type ; //游戏玩法编号
    private int bs ;//投注倍数
    private int qs ; //投注期号
    private int wager_money ;//投注金额
    private String wager_num ; //投注号码
    private String pre_win_nun ; //开奖号码
    private String pre_win_result ;//中奖结果
    private String result ; //测试结果
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
