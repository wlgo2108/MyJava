package ou.gong.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import ou.gong.db.CheckDB;

public class CheckZcFileDao {

	private CheckDB db;

	public CheckZcFileDao(String server_name) {
		db = new CheckDB(server_name);
	}

	public String checkSaleMoney(int game_id, int issue, float sale_money) {
		String result = "";
		String sql = "select (sum(wager_money)-sum(cancel_money) - sum(center_cancel_money)) from sum_issue_sales where game_id = ? and wager_issue = ?";
		db.doPstm(sql, new Integer[] { game_id, issue });
		ResultSet rs = null;
		try {
			rs = db.getRs();

			if (rs.next()) {
				if (sale_money == rs.getFloat(1)) {
					result = "��Ϸ"+game_id + "��" + issue + "�����۽��Ϊ" + sale_money + "�����ݿ������";
					System.out.println(result);
				} else {
					result ="��Ϸ"+game_id + "��" + issue + "���ļ������۽��Ϊ" + sale_money + "���ݿ��е�ע�����Ϊ" + rs.getFloat(1) + "���߲���";
					System.out.println(result);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.next();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			db.closed();
		}

		return result;
	}

	public String checkCancelMoney(int game_id, int issue, float cancel_money) {
		String result = "";
		String sql = "select (sum(cancel_money) + sum(center_cancel_money)) from sum_issue_sales where game_id = ? and wager_issue = ?";
		db.doPstm(sql, new Integer[] { game_id, issue });
		ResultSet rs = null;
		try {
			rs = db.getRs();
			if (rs.next()) {
				if (cancel_money == rs.getFloat(1)) {
					result = "��Ϸ"+game_id + "��" + issue + "��ע�����Ϊ" + cancel_money + "�����ݿ������";
					System.out.println(result);
				} else {
					result = "��Ϸ"+game_id + "��" + issue + "���ļ���ע�����Ϊ" + cancel_money + "���ݿ��е�ע�����Ϊ" + rs.getFloat(1)
							+ "���߲���";
					System.out.println(result);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.next();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			db.closed();
		}

		return result;
	}

	public boolean checkWinNum(int game_id, int issue, int num_sn, int num) {
		boolean chk = true;

		String sql = "select * from win_num where game_id = ? and wager_issue = ? and num_sn = ? and num = ?";
		db.doPstm(sql, new Integer[] { game_id, issue, num_sn, num });
		ResultSet rs = null;
		try {
			rs = db.getRs();
			if (rs.next()) {
				System.out.println("��Ϸ"+game_id + "��" + issue + "�ڵ�" + num_sn + "����������Ϊ" + num + "��ȷ��");
			} else {
				System.out.println("��Ϸ"+game_id + "��" + issue + "�ڵ�" + num_sn + "����������Ϊ" + num + "�����ݿⲻ������鿴���ݿ�ȷ�ϡ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.next();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			db.closed();
		}

		return chk;

	}

	public String checkAll_Prize_Money(int game_id ,int issue ,float all_prize_money) {
		String result  = "" ;
		String sql = "select sum(win_bet * prize_per_bet) from win_result where game_id = ? and wager_issue = ?";
		db.doPstm(sql, new Integer[] { game_id, issue });
		ResultSet rs = null;
		try {
			rs = db.getRs();
			if (rs.next()) {
				if (all_prize_money == rs.getFloat(1)) {
					result = "��Ϸ"+game_id + "��" + issue + "���н��ܽ��Ϊ" + all_prize_money + "�����ݿ������";
					System.out.println(result);
				} else {
					result = "��Ϸ"+game_id + "��" + issue + "���ļ����н��ܽ��Ϊ" + all_prize_money + "���ݿ��е��н��ܽ��Ϊ" + rs.getFloat(1)
							+ "���߲���";
					System.out.println(result);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.next();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			db.closed();
		}

		return result ;
	}
	
	public String checkWin_bet(int game_id ,int issue , int win_level ,int win_bet) {
		String result  = "" ;
		String sql = "select win_bet from win_result where game_id = ? and wager_issue = ? and win_level = ?";
		db.doPstm(sql, new Integer[] { game_id, issue,win_level });
		ResultSet rs = null;
		try {
			rs = db.getRs();
			if (rs.next()) {
				if (win_bet == rs.getInt(1)) {
					result = "��Ϸ"+game_id + "��" + issue + "�ڵ�"+win_level+"�����н���Ϊ" + win_bet + "�����ݿ������";
					System.out.println(result);
				} else {
					result = "��Ϸ"+game_id + "��" + issue + "�ڵ�"+win_level+"�����н���Ϊ" + win_bet +"���ݿ��еĽ����н���Ϊ" + rs.getInt(1) 
							+ "���߲���";
					System.out.println(result);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.next();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			db.closed();
		}

		return result ;
	}
	
	public String checkWin_bet_prize(int game_id ,int issue , int win_level ,float win_bet_prize) {
		String result  = "" ;
		String sql = "select prize_per_bet from win_result where game_id = ? and wager_issue = ? and win_level = ?";
		db.doPstm(sql, new Integer[] { game_id, issue,win_level });
		ResultSet rs = null;
		try {
			rs = db.getRs();
			if (rs.next()) {
				if (win_bet_prize == rs.getFloat(1)) {
					result = "��Ϸ"+game_id + "��" + issue + "�ڵ�"+win_level+"�����н����Ϊ" + win_bet_prize + "�����ݿ������";
					System.out.println(result);
				} else {
					result = "��Ϸ"+game_id + "��" + issue + "�ڵ�"+win_level+"�����н����Ϊ" + win_bet_prize +"���ݿ��е��н����Ϊ" + rs.getFloat(1)
							+ "���߲���";
					System.out.println(result);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.next();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			db.closed();
		}

		return result ;
	}
}
