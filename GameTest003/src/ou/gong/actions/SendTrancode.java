package ou.gong.actions;

import ou.gong.dao.ServerInfoDao;
import ou.gong.models.GameInfo;
import ou.gong.models.ServerInfo;
import ou.gong.models.StationInfo;
import ou.gong.models.TestCase;
import ou.gong.socket.BasicSocket;

import ou.gong.tools.TimeTools;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by wlgo2108 on 2017/3/8.
 */
public class SendTrancode {
    private BasicSocket bSock  ;
    private ServerInfoDao sfDao ;
    private ServerInfo sf ;


    public SendTrancode() {


    }

    public SendTrancode(int pro_id) {
        sfDao = new ServerInfoDao() ;
        if(sfDao.getServerInfoByProId(pro_id).size() > 0 ) {

            sf = (ServerInfo)sfDao.getServerInfoByProId(pro_id).get(0) ;
        }

        try {
            bSock = new BasicSocket(sf.getHost_ip(),sf.getPort()) ;
        } catch (IOException e) {
            e.printStackTrace() ;
        }

    }


    /**
     * 鎶曟敞
     * @return
     */
    public String tt101200(TestCase ts, GameInfo gf , StationInfo stationInfo) {
        String trancode = "101200" ;
        if(sf.getPro_code() == 62) {
            trancode = "103200" ;
        }

        int game_type = ts.getPlay_type() ;
        int wager_money = ts.getWager_money() ;
        String wager_num = ts.getWager_num() ;
        int bs = ts.getBs() ;
//        String result_num = ts.getPre_win_nun() ;
//        String result_check = ts.getPre_win_result() ;
        int qs = ts.getQs() ;
        String[] new_num = wager_num.split(";") ;
        String lottery_num = String.valueOf(new_num.length) ;
//        System.out.println(lottery_num) ;
        for(int i = 0 ; i < new_num.length ; i ++) {
            lottery_num = lottery_num + ";" + String.valueOf(i + 1) + ";3;" + String.valueOf(game_type) + ";" + String.valueOf(bs) + ";" + new_num[i] ;
        }
        
        int station_id = stationInfo.getStation_id() ;
        int issue = gf.getIssue() ;
        int game_id = gf.getGame_id() ;
        int tsn = ts.getTsn() ;


        String msg = trancode + ";0;1;"+station_id+";1;"+game_id+";"+issue+";"+tsn+";"+
                wager_money + ";"+(tsn -1) + ";"+qs + ";;;;"+lottery_num + ";;" ;
        System.out.println(msg) ;
        bSock.send(msg) ;
        String rece_msg = bSock.receive() ;

    
         return rece_msg ;

    }

    /**
     * 注销
     * @return
     */
    public String tt101300(TestCase ts, GameInfo gf , StationInfo stationInfo) {


        String trancode = "101300" ;
        if(this.sf.getPro_code() == 62) {
            trancode = "103300" ;

        }

        String msg = trancode + ";0;103;"+stationInfo.getStation_id() + ";1;;"+gf.getGame_id()
                + ";" + gf.getIssue() + ";"+stationInfo.getStation_id()+";"+ts.getTsn() +";;" + stationInfo.getStation_cret()  + ";" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;
    }

    /**
     * 冲正
     * @return
     */

    public String tt101999(TestCase ts, GameInfo gf , StationInfo stationInfo) {
    	String trancode = "101999" ;
        if(this.sf.getPro_code() == 62) {
            trancode = "103999" ;

        }

        String msg = trancode + ";0;103;"+stationInfo.getStation_id() + ";1;;"+gf.getGame_id()
                + ";" + gf.getIssue() + ";"+stationInfo.getStation_id()+";"+ts.getTsn() +";;0;" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;
        
    }

    /***
     * 单期兑奖
     * @return
     */

    public String tt101009(TestCase ts, GameInfo gf , StationInfo stationInfo) {
    	
    	String trancode = "101009" ;
        if(this.sf.getPro_code() == 62) {
            trancode = "103009" ;

        }

        String msg = trancode + ";0;103;"+stationInfo.getStation_id() + ";1;;"
        		+stationInfo.getStation_id()+";"+gf.getIssue()
                + ";" + gf.getGame_id()+ ";"+ts.getTsn() +";;"+stationInfo.getStation_cret()+";" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;

    }

    /***
     * 多期兑奖
     * @return
     */

    public String tt101056(TestCase ts, GameInfo gf , StationInfo stationInfo) {
    	
    	String trancode = "101056" ;
        if(this.sf.getPro_code() == 62) {
            trancode = "103056" ;
        }
        String msg = trancode + ";0;103;"+stationInfo.getStation_id()+";1;;"+stationInfo.getStation_id()+";"
        		+ gf.getIssue()+";"+gf.getGame_id()+";"+ts.getTsn()+";;"+stationInfo.getStation_cret()+";" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;
 
    }

    /**
     *多期退票
     * @return
     */

    public String tt101058(TestCase ts, GameInfo gf , StationInfo stationInfo) {
    	
    	String trancode = "101058" ;
        if(this.sf.getPro_code() == 62) {
            trancode = "103058" ;
        }

        String msg = trancode + ";0;103;"+stationInfo.getStation_id()+";1;;"+stationInfo.getStation_id()+";"
        		+ gf.getIssue()+";"+gf.getGame_id()+";"+ts.getTsn()+";;"+stationInfo.getStation_cret()+";" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;
        
    }
    /**
     * 银行缴款602201
     * @return
     */

    public String tt602201(TestCase ts, GameInfo gf , StationInfo stationInfo) {
    	String trancode = "602201" ;
    	Calendar calendar = Calendar.getInstance() ;
    	String dDate_time = TimeTools.dateTimeChange(calendar.getTime()) ;
    	int money = ts.getWager_money() ;
    	String msg = trancode+";1;12345678;"+stationInfo.getStation_id()+";1;12345678;"+stationInfo.getStation_id()+";"+stationInfo.getStation_id()+";"+money+";"+dDate_time+";5;" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;
    }


}
