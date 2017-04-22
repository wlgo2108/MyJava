package ou.gong.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import ou.gong.models.TestCase;

public class ExcelTools {
	
	/**
	 * 
	 * @param file_name
	 * @param sheet_name
	 * @return
	 */
	public List<TestCase> getTestCaseByExcel(String file_name ,String sheet_name) {
		
		List<TestCase> tcList = new ArrayList<TestCase>() ;
		try {
			File file = new File(file_name) ;
			Workbook wb = Workbook.getWorkbook(file);
			Sheet sheet = wb.getSheet(sheet_name) ;		
			int nrows = sheet.getRows() ; //行数
//			int ncols = sheet.getColumns() ; //列数 
			for(int i = 1 ; i < nrows ; i ++) {
				TestCase tc = new TestCase() ;
		
				tcList.add(tc) ;
			}
			
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //从文件流中取得excel工作区对象

		return tcList ;
	}

	
}
