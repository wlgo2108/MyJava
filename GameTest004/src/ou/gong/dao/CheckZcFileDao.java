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
					result = "游戏"+game_id + "第" + issue + "期销售金额为" + sale_money + "与数据库相符。";
					System.out.println(result);
				} else {
					result ="游戏"+game_id + "第" + issue + "期文件中销售金额为" + sale_money + "数据库中的注销金额为" + rs.getFloat(1) + "两者不符";
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
					result = "游戏"+game_id + "第" + issue + "期注销金额为" + cancel_money + "与数据库相符。";
					System.out.println(result);
				} else {
					result = "游戏"+game_id + "第" + issue + "期文件中注销金额为" + cancel_money + "数据库中的注销金额为" + rs.getFloat(1)
							+ "两者不符";
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
				System.out.println("游戏"+game_id + "第" + issue + "期第" + num_sn + "个开奖号码为" + num + "正确。");
			} else {
				System.out.println("游戏"+game_id + "第" + issue + "期第" + num_sn + "个开奖号码为" + num + "与数据库不符，请查看数据库确认。");
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
					result = "游戏"+game_id + "第" + issue + "期中奖总金额为" + all_prize_money + "与数据库相符。";
					System.out.println(result);
				} else {
					result = "游戏"+game_id + "第" + issue + "期文件中中奖总金额为" + all_prize_money + "数据库中的中奖总金额为" + rs.getFloat(1)
							+ "两者不符";
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
					result = "游戏"+game_id + "第" + issue + "期第"+win_level+"奖等中奖数为" + win_bet + "与数据库相符。";
					System.out.println(result);
				} else {
					result = "游戏"+game_id + "第" + issue + "期第"+win_level+"奖等中奖数为" + win_bet +"数据库中的奖等中奖数为" + rs.getInt(1) 
							+ "两者不符";
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
					result = "游戏"+game_id + "第" + issue + "期第"+win_level+"奖等中奖金额为" + win_bet_prize + "与数据库相符。";
					System.out.println(result);
				} else {
					result = "游戏"+game_id + "第" + issue + "期第"+win_level+"奖等中奖金额为" + win_bet_prize +"数据库中的中奖金额为" + rs.getFloat(1)
							+ "两者不符";
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
