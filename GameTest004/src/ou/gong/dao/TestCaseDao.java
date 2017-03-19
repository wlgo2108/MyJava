package ou.gong.dao;



import ou.gong.models.ServerInfo;

import ou.gong.models.TestCase;
import ou.gong.models.TranCodeInfo;
import ou.gong.tools.ExcelToDB;
import ou.gong.tools.SendTranCode;
import ou.gong.tools.StringTools;
import ou.gong.tools.WriteLog;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;


import java.util.ArrayList ;

/**
 * Created by wlgo2108 on 2017/3/8.
 */
public class TestCaseDao {
	

	protected final Log log = LogFactory.getLog("mySearch.log") ;
	private  List<String> log_msg = new ArrayList<String>() ;
	private WriteLog wlog = new WriteLog() ;


    
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
    
    
    public String tc877805(TranCodeInfo tf ,ServerInfo sf,String sheet_name) {
    	ExcelToDB etb = new ExcelToDB() ;
    	SendTranCode tcd = new SendTranCode(sf) ;
		String filename = "C:\\个人资料\\代码\\中奖检索用例\\test.xls" ;
		List<TestCase> tcList = etb.toDb(sf.getPro_code(),tf.getGame_id(),tf.getTsn(),filename,sheet_name) ;
		int tsn = tf.getTsn() ;
		for(TestCase tc :tcList) {
			String rec_msg = tcd.tt101200(tc, tf) ;
			System.out.println(rec_msg);
			if(StringTools.checkStr(rec_msg, "999999")) {
				wlog.log(log_msg) ;
				wlog.checkResult() ;
				return rec_msg ;
			} 
			String result_msg = tcd.tt877805(tc, tf) ;
			System.out.println(result_msg) ;
			
			log.info("期号："+tf.getIssue()+ "用例编号:"+tc.getSerialNumber()+ "票流水号:"+tsn+"服务器返回结果："+result_msg);
			log_msg.add(("[期号："+tf.getIssue()+ "][用例编号:"+tc.getSerialNumber()+"][票流水号:"+tsn+" ][服务器返回结果："+result_msg+"]")) ;
			tsn ++ ;
			if(StringTools.checkStr(result_msg, "999999")) {
				wlog.log(log_msg) ;
				wlog.checkResult() ;
				return result_msg ;
			}
		}
		wlog.log(log_msg) ;
		wlog.checkResult() ;
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
