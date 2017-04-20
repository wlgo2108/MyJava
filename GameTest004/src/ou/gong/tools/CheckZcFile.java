package ou.gong.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ou.gong.dao.CheckZcFileDao;
import ou.gong.dao.GameInfoDao;

public class CheckZcFile {
	private int[] sale_rpt_len = { 5, 12, 2, 13, 13 };
	private String[] sale_rpt_info = { "��Ϸ���", "�����ں�", "ʡ��", "�����ܶ�", "ע���ܶ�" };
	private int[] win_rpt_len = { 5, 12, 2, 100, 13, 2, 8, 13 };
	private String[] win_rpt_info = { "��Ϸ���", "�����ں�", "ʡ��", "�н�����", "�����н�����ϼ�", "��������", "�н�����", "�н����" };
	private int win_b001_level = 10;
	private int win_ql730_level = 10;
	private int win_d3_level = 34;
	
	
	private CheckZcFileDao chkZcFileDao ;
	public CheckZcFile(String server_name) {
		chkZcFileDao = new CheckZcFileDao(server_name) ;
	}

	public static List<String> ReadFile(String Path) {

		BufferedReader reader = null;
		List<String> laststr = new ArrayList<String>();
		try {
			FileInputStream fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return laststr;
	}

	public boolean checkSaleRpt(String file, int pro_id, int game_type, int issue) {
		boolean chk = true;
		List<String> saleList = this.ReadFile(file);
		for (String sale : saleList) {
			String[] sale_info = sale.split(",");
			int game_id = new GameInfoDao().getGameID(Integer.valueOf(sale_info[2]), Integer.valueOf(sale_info[0]));
//			float sale_money = chkZcFileDao.getSaleMoney(game_id,
//					Integer.valueOf(sale_info[1].trim()));
////			float cancel_money = new CheckZcFileDao(server_name).getCancelMoney(game_id,
//					Integer.valueOf(sale_info[1].trim()));
			if (Integer.valueOf(sale_info[2]) == pro_id) {
				System.out.println(sale_rpt_info[2] + "��ȷ,Ϊ " + sale_info[2]);
			} else {
				System.out.println(sale_rpt_info[2] + "����ȷ,�ļ���Ϊ " + sale_info[2] + "ʵ��Ϊ" + pro_id);
			}
			if (Integer.valueOf(sale_info[0]) == game_type) {
				System.out.println(sale_rpt_info[0] + "��ȷ,Ϊ " + sale_info[0]);
			} else {
				System.out.println(sale_rpt_info[0] + "����ȷ,�ļ���Ϊ " + sale_info[0] + "ʵ��Ϊ" + game_type);
			}
			if (Integer.valueOf(sale_info[1].trim()) == issue) {
				System.out.println(sale_rpt_info[1] + "��ȷ,Ϊ " + sale_info[1]);
			} else {
				System.out.println(sale_rpt_info[1] + "����ȷ,�ļ���Ϊ " + sale_info[1] + "ʵ��Ϊ" + issue);
			}
			chkZcFileDao.checkSaleMoney(game_id, issue, Float.valueOf(sale_info[3])) ;
			chkZcFileDao.checkCancelMoney(game_id, issue, Float.valueOf(sale_info[4])) ;
			for (int i = 0; i < sale_info.length; i++) {
				if (sale_info[i].length() == sale_rpt_len[i]) {
					System.out.println(sale_rpt_info[i] + "�ĳ�����ͬ������" + sale_info[i].length());
				} else {
					System.out.println(
							sale_rpt_info[i] + "�ĳ��Ȳ���ͬ��ʵ�ʳ���Ϊ" + sale_rpt_len[i] + "�ļ��еĳ���Ϊ" + sale_info[i].length());
				}
			}
		}

		return chk;
	}

	public boolean checkWinnRpt(String file, int pro_id, int game_type, int issue) {
		boolean chk = true;
		List<String> saleList = this.ReadFile(file);
		for (String sale : saleList) {
			String[] sale_info = sale.split(",");
			
			if (Integer.valueOf(sale_info[0]) == game_type) {
				System.out.println(win_rpt_info[0] + "��ȷ,Ϊ " + sale_info[0]);
			} else {
				System.out.println(win_rpt_info[0] + "����ȷ,�ļ���Ϊ " + sale_info[0] + "ʵ��Ϊ" + game_type);
			}
			if (Integer.valueOf(sale_info[1].trim()) == issue) {
				System.out.println(win_rpt_info[1] + "��ȷ,Ϊ " + sale_info[1]);
			} else {
				System.out.println(win_rpt_info[1] + "����ȷ,�ļ���Ϊ " + sale_info[1] + "ʵ��Ϊ" + issue);
			}
			if (Integer.valueOf(sale_info[2].trim()) == pro_id) {
				System.out.println(win_rpt_info[2] + "��ȷ,Ϊ " + sale_info[2]);
			} else {
				System.out.println(win_rpt_info[2] + "����ȷ,�ļ���Ϊ " + sale_info[2] + "ʵ��Ϊ" + pro_id);
			}	
			
			int game_id = new GameInfoDao().getGameID(pro_id, game_type) ;

			chkZcFileDao.checkAll_Prize_Money(game_id, issue, Float.valueOf(sale_info[4].trim())) ;
			if(game_type == 10002) {
				
				String[] win_num = sale_info[3].trim().split("\\+") ;
				for(int i = 0 ; i < win_num.length ; i ++) {
					chkZcFileDao.checkWinNum(game_id, issue, i + 1, Integer.valueOf(win_num[i])) ;
				}
				if(Integer.valueOf(sale_info[5].trim())==34) {
					System.out.println(win_rpt_info[5] + "��ȷ,Ϊ " + sale_info[5]);
				} else {
					System.out.println(win_rpt_info[5] + "����ȷ,�ļ���Ϊ " + sale_info[5] + "ʵ��Ϊ" + 34);
				}
				
			} else {
				
				 String regex = "(.{2})";
				 String[] win_num =(game_type == 10001) ?sale_info[3].trim().split("\\+") : sale_info[3].trim().split("\\@");
				 String[] wnum = win_num[0].replaceAll (regex, "$1 ").split(" ") ;
				 for(int i = 0 ; i <wnum.length ;i++) {
					 chkZcFileDao.checkWinNum(game_id, issue, i + 1, Integer.valueOf(wnum[i])) ;
				 }
				 int n = (game_type == 10001) ? 7 : 8 ;
				 chkZcFileDao.checkWinNum(game_id, issue,n, Integer.valueOf(win_num[1])) ;

				 
				if(Integer.valueOf(sale_info[5].trim())==10) {
					System.out.println(win_rpt_info[5] + "��ȷ,Ϊ " + sale_info[5]);
				} else {
					System.out.println(win_rpt_info[5] + "����ȷ,�ļ���Ϊ " + sale_info[5] + "ʵ��Ϊ" + 10);
				}

			}
			
			int m = 6 ;

			for(int k = m ; k <= sale_info.length - m ; k ++) {
//				System.out.println((k / 2) - 2 );
				if(k % 2 == 0) {
					
					chkZcFileDao.checkWin_bet(game_id, issue, ((int)(k /2 ))-2 , Integer.valueOf(sale_info[k].trim())) ;
					
				} else if(k % 2!= 0){
					chkZcFileDao.checkWin_bet_prize(game_id, issue, ((int)(k /2 ))-2 , Float.valueOf(sale_info[k].trim())) ;
				}
				
				
				
			}
			
			
			
			
			
			for (int i = 0; i < sale_info.length; i++) {
				if (i < 6) {
					if (sale_info[i].length() == win_rpt_len[i]) {
						System.out.println(win_rpt_info[i] + "�ĳ�����ͬ������" + sale_info[i].length());
					} else {
						System.out.println(
								win_rpt_info[i] + "�ĳ��Ȳ���ͬ��ʵ�ʳ���Ϊ" + win_rpt_len[i] + "�ļ��еĳ���Ϊ" + sale_info[i].length());
					}
				} else if ((i >= 6) && (i % 2 == 0)) {
					if (sale_info[i].length() == win_rpt_len[6]) {
						System.out.println(win_rpt_info[6] + "�ĳ�����ͬ������" + sale_info[i].length());
					} else {
						System.out.println(
								win_rpt_info[6] + "�ĳ��Ȳ���ͬ��ʵ�ʳ���Ϊ" + win_rpt_len[i] + "�ļ��еĳ���Ϊ" + sale_info[i].length());
					}
				} else if ((i >= 6) && (i % 2 != 0)) {
					if (sale_info[i].length() == win_rpt_len[7]) {
						System.out.println(win_rpt_info[7] + "�ĳ�����ͬ������" + sale_info[i].length());
					} else {
						System.out.println(
								win_rpt_info[7] + "�ĳ��Ȳ���ͬ��ʵ�ʳ���Ϊ" + win_rpt_len[i] + "�ļ��еĳ���Ϊ" + sale_info[i].length());
					}
				}
			}
		}

		return chk;
	}
	
	
	

	public static void main(String[] args) {
		String file = "C:\\��������\\�����ļ�\\�����в��ļ�\\62_10002_2017095_WINN.RPT";
		new CheckZcFile("�����ֳ����Ժ�̨").checkWinnRpt(file, 62, 10002, 2017095);
	}

}
