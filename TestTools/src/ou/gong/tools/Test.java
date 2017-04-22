package ou.gong.tools;

import java.io.File;
import java.io.IOException;

import ou.gong.dao.GameDao;

public class Test {
	
	public static void main(String[] args) {
		
		System.out.println(new GameDao().getGame_id("ËÄ´¨ºóÌ¨8","B001"));
		
		try {
			File directory = new File("");
			String file_path = directory.getCanonicalPath();
			System.out.println(file_path) ;
			System.out.println(System.getProperty("user.dir")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
