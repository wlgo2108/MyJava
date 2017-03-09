package ou.gong.dao;

import java.util.Calendar;

import ou.gong.actions.SendTrancode;
import ou.gong.models.GameInfo;
import ou.gong.models.ServerInfo;
import ou.gong.models.StationInfo;
import ou.gong.models.TestCase;
import ou.gong.tools.TimeTools;

/**
 * Created by wlgo2108 on 2017/3/8.
 */
public class TestSend {

    public static void main(String[] args) {

        SendTrancode stc = new SendTrancode(62) ;
        TestCase ts = new TestCase() ;
        ts.setPro_id(62) ;
        ts.setTsn(10) ;
        ts.setWager_money(1000) ;
        GameInfo gf = new GameInfo() ;
        gf.setIssue(170308059) ;
        gf.setGame_id(6) ;
        StationInfo st = new StationInfo() ;
        st.setStation_cret(801589720) ;
        st.setStation_id(62015001) ;

        System.out.println(stc.tt602201(ts, gf, st)) ;
    	
    	Calendar calendar = Calendar.getInstance() ;
    	System.out.println(TimeTools.dateTimeChange(calendar.getTime()));

    }
}
