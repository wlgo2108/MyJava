package ou.gong.dao;



import ou.gong.models.ServerInfo;

import ou.gong.models.TestCase;
import ou.gong.models.TranCodeInfo;
import ou.gong.tools.ExcelToDB;
import ou.gong.tools.SendTranCode;
import ou.gong.tools.StringTools;

import java.util.List;
import java.util.ArrayList ;

/**
 * Created by wlgo2108 on 2017/3/8.
 */
public class TestCaseDao {


    
    public TestCaseDao() {
    	
    }

    public String tcT101200(TranCodeInfo tf ,ServerInfo sf,String sheet_name) {
    	ExcelToDB etb = new ExcelToDB() ;
    	SendTranCode tcd = new SendTranCode(sf) ;
		String filename = "C:\\个人资料\\代码\\中奖检索用例\\test.xls" ;
		List<TestCase> tcList = etb.toDb(sf.getPro_code(),tf.getGame_id(),tf.getTsn(),filename,sheet_name) ;
		for(TestCase tc :tcList) {
			String rec_msg = tcd.tt101200(tc, tf) ;
			System.out.println(rec_msg);
			if(StringTools.checkStr(rec_msg, "999999")) {
				
				return rec_msg ;
			} 
		}
		
		return "投注成功" ;
    }



    public List<TestCase> getTestCaseByExcel(int game_id) {
        List<TestCase> tList = new ArrayList<TestCase>() ;

        return tList ;
    }

  
    public List<TestCase> getTestCaseByDB() {
        List<TestCase> tList = new ArrayList<TestCase>() ;

        return tList ;
    }
    
    
    


}
