package ou.gong.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



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
	
	

}
 