package ou.gong.tools;

import java.util.List;

import ou.gong.models.TestCase;

public class TestJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int pro_id = 62;
		int game_id = 2;
		int tsn = 0;
		String filename = "C:\\��������\\����\\�н���������\\test.xls";
		String sheetName = "GSB001";
		List<TestCase> tList = new ExcelToDB().toDb(pro_id, game_id, tsn, filename, sheetName);

		System.out.println() ;

	}

}
