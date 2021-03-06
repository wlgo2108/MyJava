package ou.gong.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import ou.gong.actions.SendTrancode;

import ou.gong.models.GameInfo;

import ou.gong.models.StationInfo;
import ou.gong.models.TestCase;

public class ExcelToDB {
	
	/**
	 * 将excel表中的测试用例导入数据库中
	 */
	
	public List<TestCase> toDb(int pro_id,int game_id,int tsn,String filename,String sheetName)
	{
		List<TestCase> tcList = new ArrayList<TestCase>() ;
		
		try {
			File file = new File(filename) ;//根据文件名创建一个文件对象
			Workbook wb = Workbook.getWorkbook(file) ; //从文件流中取得excel工作区对象
			Sheet sheet = wb.getSheet(sheetName) ;
			
			int nrows = sheet.getRows() ; //行数
//			int ncols = sheet.getColumns() ; //列数 

			
			for(int i = 1 ; i < nrows ; i ++)
			{

				TestCase tc = new TestCase() ;
				tc.setPro_id(pro_id);
				tc.setGame_id(game_id) ;
				if(sheet.getCell(0, i).getContents().equals("")|| sheet.getCell(0, i).getContents() == null){
					tc.setTitle(sheet.getCell(0, 1).getContents()) ;
				} else {
					tc.setTitle(sheet.getCell(0, i).getContents());
				}
				tc.setComment(sheet.getCell(1, i).getContents());
				tc.setSerialNumber(sheet.getCell(2, i).getContents());
				tc.setTsn(tsn) ;
				tc.setBs(Integer.parseInt(sheet.getCell(3, i).getContents())) ;
				tc.setQs(Integer.parseInt(sheet.getCell(4, i).getContents())) ;
				tc.setWager_money(Integer.parseInt(sheet.getCell(6, i).getContents()));
				tc.setWager_num(sheet.getCell(8, i).getContents());
				tc.setPlay_type(Integer.parseInt(sheet.getCell(7, i).getContents()));
				tc.setPre_win_nun(sheet.getCell(9, i).getContents());
				tc.setPre_win_result(sheet.getCell(10, i).getContents());
//				tc.setReturnFormServer(sheet.getCell(11, i).getContents());
//				tc.setResult(sheet.getCell(12, i).getContents()) ;
				
				tcList.add(tc) ;
				tsn ++ ;

			}
			
			
		} catch(IOException e){
			e.printStackTrace() ; 
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tcList ;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ExcelToDB etb = new ExcelToDB() ;
		String filename = "C:\\个人资料\\代码\\中奖检索用例\\test.xls" ;
		//excel文件名限制为.xls文件
		//toDb省码，游戏ID，流水号，文件名，sheet名
		
		GameInfo gf = new GameInfo() ;
		gf.setGame_id(4) ;
		gf.setIssue(2017065) ;
		StationInfo st = new StationInfo() ;
		st.setStation_id(62011005) ;
		
		TestCase ts = new TestCase() ;
		 //主要用于注销冲正兑奖
		

		
		SendTrancode tcd = new SendTrancode(62) ;
//		
		ts.setTsn(110) ;
		int stat = 2 ;
		// stat : 1 --- 投注，  2 --- 注销  3 --- 冲正
		// 4 --- 兑奖   5 --- 多期票兑奖  6 --- 多期票退票   7 缴款金额
		
		if (stat == 1) {
			
			List<TestCase> tcList = etb.toDb(62,4,906,filename, "GS3D") ;
			for(TestCase tc :tcList) {
				String rec_msg = tcd.tt101200(tc, gf, st) ;
				System.out.println(rec_msg);
				if(StringTools.checkStr(rec_msg, "999999")) {
					System.exit(0) ;
				} 
				
			}
		} else if (stat == 2 ) {
			System.out.println(tcd.tt101300(ts, gf, st)); //注销,需要使用TestCase 设置注销票的流水号
		} else if (stat == 3 ) {
			System.out.println(tcd.tt101999(ts, gf, st)) ;  //冲正 ,需要使用TestCase 设置流水号 
		} else if (stat == 4 ) {
			System.out.println(tcd.tt101009(ts, gf, st)) ; //兑奖
		} else if (stat == 5 ) {
			System.out.println(tcd.tt101056(ts, gf, st)) ;  // 多期兑奖
		} else if (stat == 6 ) {
			System.out.println(tcd.tt101058(ts, gf, st)) ;   //多期退票
		} else if (stat == 7 ) {
			ts.setWager_money(1000) ;//设置缴款金额为1000 
			System.out.println(tcd.tt602201(ts, gf, st)) ; // 缴款金额
		}
		
		
		

		
	}

}
 