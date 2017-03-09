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
	 * ��excel���еĲ��������������ݿ���
	 */
	
	public List<TestCase> toDb(int pro_id,int game_id,int tsn,String filename,String sheetName)
	{
		List<TestCase> tcList = new ArrayList<TestCase>() ;
		
		try {
			File file = new File(filename) ;//�����ļ�������һ���ļ�����
			Workbook wb = Workbook.getWorkbook(file) ; //���ļ�����ȡ��excel����������
			Sheet sheet = wb.getSheet(sheetName) ;
			
			int nrows = sheet.getRows() ; //����
//			int ncols = sheet.getColumns() ; //���� 

			
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
		String filename = "C:\\��������\\����\\�н���������\\test.xls" ;
		//excel�ļ�������Ϊ.xls�ļ�
		//toDbʡ�룬��ϷID����ˮ�ţ��ļ�����sheet��
		
		GameInfo gf = new GameInfo() ;
		gf.setGame_id(4) ;
		gf.setIssue(2017065) ;
		StationInfo st = new StationInfo() ;
		st.setStation_id(62011005) ;
		
		TestCase ts = new TestCase() ;
		 //��Ҫ����ע�������ҽ�
		

		
		SendTrancode tcd = new SendTrancode(62) ;
//		
		ts.setTsn(110) ;
		int stat = 2 ;
		// stat : 1 --- Ͷע��  2 --- ע��  3 --- ����
		// 4 --- �ҽ�   5 --- ����Ʊ�ҽ�  6 --- ����Ʊ��Ʊ   7 �ɿ���
		
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
			System.out.println(tcd.tt101300(ts, gf, st)); //ע��,��Ҫʹ��TestCase ����ע��Ʊ����ˮ��
		} else if (stat == 3 ) {
			System.out.println(tcd.tt101999(ts, gf, st)) ;  //���� ,��Ҫʹ��TestCase ������ˮ�� 
		} else if (stat == 4 ) {
			System.out.println(tcd.tt101009(ts, gf, st)) ; //�ҽ�
		} else if (stat == 5 ) {
			System.out.println(tcd.tt101056(ts, gf, st)) ;  // ���ڶҽ�
		} else if (stat == 6 ) {
			System.out.println(tcd.tt101058(ts, gf, st)) ;   //������Ʊ
		} else if (stat == 7 ) {
			ts.setWager_money(1000) ;//���ýɿ���Ϊ1000 
			System.out.println(tcd.tt602201(ts, gf, st)) ; // �ɿ���
		}
		
		
		

		
	}

}
 