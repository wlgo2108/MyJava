package ou.gong.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTools {
	
	public static String dateTimeChange(Date source){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String changeTime=format.format(source);		
		return changeTime;
	}

}
