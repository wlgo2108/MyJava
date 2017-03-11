package ou.gong.tools;

import java.io.*;
import java.util.Calendar;

public class MakeZcFile {

	private FtpUploadFile ftpFile;
	private String filePath ;

	public MakeZcFile(String server_ip, int serverPort, String username, String password,String filePath) {
		this.ftpFile = new FtpUploadFile(server_ip, serverPort, username, password);
		this.filePath = filePath ;
	}

	
	//生成SALE.DWN文件
	public void makeSale(int game_type, int issue, int abandonNum, int abandonIssue) {

		String fileName = "00_" + game_type + "_" + issue + "_SALE.DWN";
		File file = new File(fileName);

		try {
			file.createNewFile();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			System.out.println("文件创建失败！");

		}

		Calendar calendar = Calendar.getInstance();
		String start_time = TimeTools.dateTimeChange(calendar.getTime());
		calendar.set(Calendar.DATE, 2);
		String end_time = TimeTools.dateTimeChange(calendar.getTime());
		calendar.set(Calendar.DATE, 60);
		String end_cash_time = TimeTools.dateTimeChange(calendar.getTime());
		String fileContent = game_type + "," + issue + "     ,00,00," + start_time + "," + end_time + ",61"
				+ end_cash_time + ",000" + abandonNum + "" + abandonIssue + "     ,";
		if (abandonNum == 0) {
			fileContent = game_type + "," + issue + "     ,00,00," + start_time + "," + end_time + ",61" + end_cash_time
					+ ",000" + abandonNum + "            ,";
		}

		byte[] bytes = new byte[1024];
		bytes = fileContent.getBytes();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes, 0, bytes.length);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String remoteFile = this.filePath + fileName;
		this.ftpFile.uploadFile(fileName, remoteFile);
		this.ftpFile.closeServer();

	}

	//生成NUMB.DWN文件
	public String makeNumb(int game_type, int issue, String num) {
		String fileName = "00_" + game_type + "_" + issue + "_NUMB.DWN";
		String[] win_num = num.split("-");
		String win_num_file = win_num[0].replace("|", "");

		if (game_type == 10001) {
			if (win_num[0].replace("|", "").length() != 12) {
				System.out.println("双色球开奖号码输入有误，请重新输入！");
				return "双色球开奖号码输入有误，请重新输入！";
			} else {
				win_num_file = win_num_file + "+" + win_num[1].replace("|", "");
				win_num_file += "                                                                                     ,";
			}

		} else if (game_type == 10003) {
			if (win_num[0].replace("|", "").length() != 14) {
				System.out.println("七乐彩开奖号码输入有误，请重新输入！");
				return "七乐彩开奖号码输入有误，请重新输入！";

			} else {
				win_num_file = win_num_file + "@" + win_num[1].replace("|", "");
				win_num_file += "                                                                                   ,";
			}

		}

		File file = new File(fileName);

		try {
			file.createNewFile();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			System.out.println("文件创建失败！");

		}

		String fileContent = game_type + "," + issue + "      ,00,01," + win_num_file;
		byte[] bytes = new byte[1024];
		bytes = fileContent.getBytes();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes, 0, bytes.length);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String remoteFile = this.filePath + fileName;
		this.ftpFile.uploadFile(fileName, remoteFile);
		this.ftpFile.closeServer();

		System.out.println(win_num_file);
		return "文件生成并上传服务器成功，请查看！";

	}
	
	//BULL.DWN文件
	public String makeBull(int game_type, int issue, String num) {
		String fileName = "00_" + game_type + "_" + issue + "_BULL.DWN";
		String[] win_num = num.split("-");
		String win_num_file = win_num[0].replace("|", "");

		if (game_type == 10001) {
			if (win_num[0].replace("|", "").length() != 12) {
				System.out.println("双色球开奖号码输入有误，请重新输入！");
				return "双色球开奖号码输入有误，请重新输入！";
			} else {
				win_num_file = win_num_file + "+" + win_num[1].replace("|", "");
				win_num_file += "                                                                                   ,257165686.00 ,110698090.00 ,10,50      ,7223074.00   ,73      ,228398.00    ,976     ,3000.00      ,45978   ,200.00       ,856975  ,10.00        ,9948196 ,5.00         ,0       ,0.00         ,";
			}

		} else if (game_type == 10003) {
			if (win_num[0].replace("|", "").length() != 14) {
				System.out.println("七乐彩开奖号码输入有误，请重新输入！");
				return "七乐彩开奖号码输入有误，请重新输入！";

			} else {
				win_num_file = win_num_file + "@" + win_num[1].replace("|", "");
				win_num_file += "                                                                                ,4311313294.00,50000000.00+2000000.00                                                                              ,10,37      ,7052347.00   ,66      ,125129.00    ,1074    ,40210.00     ,666     ,200.00       ,5767    ,50.00         ,735     ,10.00         ,1225    ,5.00         ,50      ,400000.00    ,0       ,0.00         ,0       ,0.00         ," ;
			}

		}

		File file = new File(fileName);

		try {
			file.createNewFile();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			System.out.println("文件创建失败！");

		}

		String fileContent = game_type + "," + issue + "      ,00,01," + win_num_file;
		byte[] bytes = new byte[1024];
		bytes = fileContent.getBytes();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes, 0, bytes.length);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String remoteFile = this.filePath + fileName;
		this.ftpFile.uploadFile(fileName, remoteFile);
		this.ftpFile.closeServer();

		System.out.println(win_num_file);
		return "文件生成并上传服务器成功，请查看！";

	}
	
	

	public static void main(String[] args) {
		MakeZcFile mzf = new MakeZcFile("10.13.0.210", 21, "zcserver", "1qaz-pl,","/home/zcserver/zcfiles/");
		int game_type = 10003 ;
		int issue = 2013019 ;
		int abandonNum = 0 ;
		int abandonIssue = 0 ;
		String win_num = "01|04|06|08|09|18|28|-05|" ;
		
		mzf.makeSale(game_type, issue, abandonNum, abandonIssue);
		mzf.makeNumb(game_type, issue, win_num);
		mzf.makeBull(game_type, issue, win_num);

	}

}
