package ou.gong.tools;

public class StringTools {
	
	public static boolean checkStr(String pStr,String sStr) {
		boolean chk = false ;
		if(pStr.indexOf(sStr) > -1 ){
			chk = true ;
		}

		return chk ;
	}

}
