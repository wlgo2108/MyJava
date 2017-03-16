package ou.gong.actions;

import ou.gong.models.ServerInfo;
import ou.gong.models.ZcFileDwn;
import ou.gong.tools.MakeZcFile;
import ou.gong.tools.MySuperAction;

public class MakeZcFileAction extends MySuperAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toMakeFile() {
		
		if(((String) request.getParameter("game_type")) == null || ((String) request.getParameter("game_type")).equals("1")) {
			request.setAttribute("msg", "请选择游戏！");
			return SUCCESS ;
		}
		
		String server_ip = (String) request.getParameter("serverIp");
		String server_port = (String) request.getParameter("serverPort");
		System.out.println(server_port);
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String filePath = (String) request.getParameter("filePath");
		System.out.println(server_ip);
		ServerInfo sinfo = new ServerInfo();
		sinfo.setHost_ip(server_ip);
		int sport = Integer.parseInt(server_port);
		sinfo.setPort(sport);
		sinfo.setServer_name(username);
		sinfo.setServer_pass(password);
		sinfo.setUpload_path(filePath) ;
		
		ZcFileDwn zfd = new ZcFileDwn();
		zfd.setAbandonIssue(Integer.parseInt((String) request.getParameter("abandonIssue")));
		zfd.setAbandonNum(Integer.parseInt((String) request.getParameter("abandonNum")));
		zfd.setIssue(Integer.parseInt((String) request.getParameter("issue")));
		zfd.setCash_days(Integer.parseInt((String) request.getParameter("cash_days")));
		zfd.setDays(Integer.parseInt((String) request.getParameter("days")));
		zfd.setEnd_cash_time((String) request.getParameter("end_cash_time"));
		zfd.setEnd_time((String) request.getParameter("end_time"));
		
		zfd.setGame_type(Integer.parseInt((String) request.getParameter("game_type")));
		zfd.setStart_time((String) request.getParameter("start_time"));

		String win_num = "";
		
		for (int i = 1; i < 8; i++) {
			if ((i < 7) && ( zfd.getGame_type() == 10001 )) {
				
				int num = Integer.parseInt((String) request.getParameter("num" + i));
				win_num += ((num < 10) ? ("0" + num) : ("" + num));
			} else if(zfd.getGame_type() == 10003 ) {
				int num = Integer.parseInt((String) request.getParameter("num" + i));
				win_num += ((num < 10) ? ("0" + num) : ("" + num));
			}
		}
		
		int num = Integer.parseInt((String) request.getParameter("num_ts"));
		win_num += ((num < 10) ? ("-0" + num) : ("-" + num));
		zfd.setWin_num(win_num);

		boolean  upCheck = false ;
		
		String sale = (String)request.getParameter("sale") ;
		String numb = (String)request.getParameter("numb") ;
		String bull = (String)request.getParameter("bull") ;
		MakeZcFile mzf = new MakeZcFile(sinfo, zfd);
		if(sale!=null && sale.equals("1")) {
			upCheck = mzf.makeSale();
			
		} 
		if(numb !=null &&  numb.equals("1")) {
			upCheck = mzf.makeNumb() ;
		}
		if(bull !=null &&  bull.equals("1")) {
			upCheck = mzf.makeBull() ;
		}
		System.out.println(upCheck);
		if(upCheck) {
			request.setAttribute("msg", ((zfd.getGame_type() == 10001)?"双色球":"七乐彩") +""+ zfd.getIssue()+"期中彩文件上传成功！");
		} else {
			request.setAttribute("msg", ((zfd.getGame_type() == 10001)?"双色球":"七乐彩") +""+ zfd.getIssue()+"期中彩文件上传失败！");
		}
		
		
		return SUCCESS ;
	}

}
