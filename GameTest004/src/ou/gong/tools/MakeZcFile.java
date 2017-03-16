package ou.gong.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import ou.gong.models.ServerInfo;
import ou.gong.models.ZcFileDwn;

public class MakeZcFile {
	private FtpUploadFile ftpFile ;
	private ZcFileDwn zfd ;
	
	public MakeZcFile() {
		
	}
	
	public MakeZcFile(ServerInfo sInfo,ZcFileDwn zfd) {
		this.ftpFile = new FtpUploadFile(sInfo) ;
		this.zfd = zfd ;
	}
	
	/**
	 * 生成中彩文件SALE.DWN
	 * 修改时间：2017-02-28 11:21
	 * @return
	 */
	public boolean makeSale() {
		boolean mk = true ;
		String fileName = "00_" + this.zfd.getGame_type() + "_" + this.zfd.getIssue() + "_SALE.DWN";
		//创建文件fileName
		File file = new File(fileName);
		
		try {
			file.createNewFile();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			System.out.println("文件创建失败！");
			mk = false ;
		}
		
		
		//sale.dwn文件文件内容
		String fileContent = this.zfd.getGame_type() + "," + this.zfd.getIssue() + "     ,00,00," + this.zfd.getStart_time() + "," + this.zfd.getEnd_time() + ","+this.zfd.getCash_days()+","
				+ this.zfd.getEnd_cash_time() + ",000" + this.zfd.getAbandonNum() + "" + this.zfd.getAbandonIssue() + "     ,";
		if (this.zfd.getAbandonNum() == 0) {
			fileContent = this.zfd.getGame_type() + "," + this.zfd.getIssue() + "     ,00,00," + this.zfd.getStart_time() + "," + this.zfd.getEnd_time() + ","+this.zfd.getCash_days()+","
					+ this.zfd.getEnd_cash_time() + ",000" + this.zfd.getAbandonNum() + "            ,";
		}
		
		//文件内容写入本地sale.dwn文件中
		byte[] bytes = new byte[1024];
		bytes = fileContent.getBytes();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes, 0, bytes.length);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mk = false ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mk = false ;
		}
		
		//文件上传到中彩服务器中
		this.ftpFile.uploadFile(fileName);
		this.ftpFile.closeServer();
		

		return mk ;
	}
	
	/**
	 * 生成中彩文件numb.dwn 
	 * 修改时间：2017-02-28 11:26
	 * @return
	 */
	public boolean makeNumb() {
		boolean mk = true ;
		//文件名
		String fileName = "00_" + this.zfd.getGame_type() + "_" + this.zfd.getIssue() + "_NUMB.DWN";
		
		//按游戏处理各游戏的开奖号码
		String[] win_num = this.zfd.getWin_num().split("-");
		String win_num_file = win_num[0].replace("|", "");
		
		if (this.zfd.getGame_type() == 10001) {
			if (win_num[0].replace("|", "").length() != 12) {
				System.out.println("双色球开奖号码输入有误，请重新输入！");
				mk = false ;
			} else {
				win_num_file = win_num_file + "+" + win_num[1].replace("|", "");
				win_num_file += "                                                                                     ,";
			}

		} else if (this.zfd.getGame_type() == 10003) {
			if (win_num[0].replace("|", "").length() != 14) {
				System.out.println("七乐彩开奖号码输入有误，请重新输入！");
				mk = false ;

			} else {
				win_num_file = win_num_file + "@" + win_num[1].replace("|", "");
				win_num_file += "                                                                                   ,";
			}

		}

		//创建文件
		File file = new File(fileName);

		try {
			file.createNewFile();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			System.out.println("文件创建失败！");
			mk = false ;

		}

		//写文件内容
		String fileContent = this.zfd.getGame_type() + "," + this.zfd.getIssue() + "      ,00,01," + win_num_file;
		byte[] bytes = new byte[1024];
		bytes = fileContent.getBytes();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes, 0, bytes.length);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mk = false ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mk = false ;
		}


		//文件上传到中彩服务器
		this.ftpFile.uploadFile(fileName);
		this.ftpFile.closeServer();

		System.out.println(win_num_file);
		return mk ;

	}
	
	/**
	 * 生成中彩文件BULL.DWN
	 * 修改时间：2017-02-28 11:31
	 * @return
	 */
	public boolean makeBull() {
		boolean mk = true ;
		//文件名
		String fileName = "00_" + this.zfd.getGame_type() + "_" + this.zfd.getIssue() +"_BULL.DWN";
		//按游戏处理各游戏开奖号码格式
		String[] win_num = this.zfd.getWin_num().split("-");
		String win_num_file = win_num[0].replace("|", "");

		if (this.zfd.getGame_type() == 10001) {
			if (win_num[0].replace("|", "").length() != 12) {
				System.out.println("双色球开奖号码输入有误，请重新输入！");
				mk = false ;
			} else {
				win_num_file = win_num_file + "+" + win_num[1].replace("|", "");
				win_num_file += "                                                                                   ,257165686.00 ,110698090.00 ,10,50      ,7223074.00   ,73      ,228398.00    ,976     ,3000.00      ,45978   ,200.00       ,856975  ,10.00        ,9948196 ,5.00         ,0       ,0.00         ,";
			}

		} else if (this.zfd.getGame_type() == 10003) {
			if (win_num[0].replace("|", "").length() != 14) {
				System.out.println("七乐彩开奖号码输入有误，请重新输入！");
				mk = false ;

			} else {
				win_num_file = win_num_file + "@" + win_num[1].replace("|", "");
				win_num_file += "                                                                                ,4311313294.00,50000000.00+2000000.00                                                                              ,10,37      ,7052347.00   ,66      ,125129.00    ,1074    ,40210.00     ,666     ,200.00       ,5767    ,50.00         ,735     ,10.00         ,1225    ,5.00         ,50      ,400000.00    ,0       ,0.00         ,0       ,0.00         ," ;
			}

		}

		//创建文件
		File file = new File(fileName);

		try {
			file.createNewFile();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			System.out.println("文件创建失败！");
			mk = false ;

		}

		//文件内容并写入文件
		String fileContent = this.zfd.getGame_type() + "," + this.zfd.getIssue() + "      ,00,01," + win_num_file;
		byte[] bytes = new byte[1024];
		bytes = fileContent.getBytes();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes, 0, bytes.length);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mk = false ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mk = false ;
		}


		//文件上传到服务器
		this.ftpFile.uploadFile(fileName);
		this.ftpFile.closeServer();

		System.out.println(win_num_file);
		return mk ;

	}
	
	
	

}
