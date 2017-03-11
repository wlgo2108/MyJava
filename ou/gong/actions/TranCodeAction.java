package ou.gong.actions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import ou.gong.dao.GameInfoDao;
import ou.gong.dao.ServerInfoDao;
import ou.gong.dao.TestCaseDao;
import ou.gong.models.ServerInfo;
import ou.gong.models.TranCodeInfo;
import ou.gong.tools.SendTranCode;

public class TranCodeAction extends TranCodeInfo {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String tcAction() throws UnsupportedEncodingException {
			
//	       server_name = new String(request.getParameter("server_name").getBytes("iso-8859-1"), "utf-8"); 
			server_name = new String(request.getParameter("server_name"));
			if(server_name.equals("0") || server_name == null) {
				request.setAttribute("msg", "请选择服务器") ;
		        return SUCCESS ;
			}
	       System.out.println(server_name);
	       game_name = (String)request.getParameter("game") ;
	       System.out.println(game_name);
	       issue = Integer.parseInt((String)request.getParameter("issue")) ;
	       station_id = Integer.parseInt((String)request.getParameter("station_id")) ;
	       station_cert = Integer.parseInt((String)request.getParameter("station_cert")) ;
	       type = Integer.parseInt((String)request.getParameter("type")) ;
	       stat = Integer.parseInt((String)request.getParameter("stat")) ;
	       tsn = Integer.parseInt((String)request.getParameter("tsn")) ;
	       money = Float.parseFloat((String)request.getParameter("money")) ;
	       
	       
	       TranCodeInfo tf = new TranCodeInfo() ;
	       tf.setGame_name(game_name) ;
	       tf.setIssue(issue);
	       tf.setMoney(money);
	       tf.setServer_name(server_name);
	       tf.setStat(stat); 
	       tf.setType(type);
	       tf.setTsn(tsn);
	       tf.setStation_id(station_id);
	       tf.setStation_cert(station_cert);
	     
	       ServerInfo sf = new ServerInfoDao().getServerInfo(server_name) ;
	       SendTranCode tcd = new SendTranCode(sf) ;
	       String sheet_name = new GameInfoDao().getSheetTable(server_name, game_name) ;
	       String msg = "" ;
			if (stat == 1) {
				//GS3D QL730 
				msg = new TestCaseDao().tcT101200(tf, sf, sheet_name)  ;
			

			} else if (stat == 2 ) {
				msg = tcd.tt101300(tf); //注销,需要使用TestCase 设置注销票的流水号
			} else if (stat == 3 ) {
				msg =tcd.tt101999(tf) ;  //冲正 ,需要使用TestCase 设置流水号 
			} else if (stat == 4 ) {
				msg =tcd.tt101009(tf) ; //兑奖
			} else if (stat == 5 ) {
				msg =tcd.tt101056(tf) ;  // 多期兑奖
			} else if (stat == 6 ) {
				msg =tcd.tt101058(tf) ;   //多期退票
			} else if (stat == 7 ) {
//				ts.setWager_money(money) ;//设置缴款金额为10000 
				msg =tcd.tt602201(tf) ; // 缴款金额
			}
			request.setAttribute("msg", msg) ;
			
	        return SUCCESS ;
	    }
	

}
