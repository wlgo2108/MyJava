package ou.gong.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WriteLog {

	public void log(List<String> log_msg) {

		String fileName = "C:\\logs\\mySearch.log";
		// 创建文件fileName
		File file = new File(fileName);

		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			System.out.println("文件创建失败！");

		}

		FileWriter fw = null;
		BufferedWriter bw = null;
		Iterator<String> iter = log_msg.iterator();
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			while (iter.hasNext()) {
				bw.write(iter.next());
				bw.newLine();
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public List<String> readLog() {
		List<String> strList = new ArrayList<String>();
		String fileName = "C:\\logs\\mySearch.log";
		// 创建文件fileName
		File file = new File(fileName);

		BufferedReader br = null;// 构造一个BufferedReader类来读取文件
		String s = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				strList.add(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return strList;
	}

	public void checkResult() {
		List<String> log_msg = new WriteLog().readLog();
		int passCount = 0;
		int failCount = 0;
		List<String> errList = new ArrayList<String>();

		for (String s : log_msg) {
			// System.out.println(s) ;
			String[] res = s.split("]");
			// System.out.println(res[3].replace("[", "")) ;
			String returnfromServer = res[3].replace("[", "");
			if (StringTools.checkStr(returnfromServer, "检索不通过")) {
				failCount++;
				// System.out.println(s);
				errList.add(s);
			} else {

				if (StringTools.checkStr(returnfromServer, "检索通过")) {
					passCount++;
					// System.out.println(s);
				} else {

					String[] checkStr = returnfromServer.split("，");
					if(checkStr.length > 1) {
						String yqResult = checkStr[0].split("预期结果为:")[1];
						if (StringTools.checkStr(checkStr[1], checkStr[0].split("预期结果为:")[1])) {
							passCount++;
						} else {
							failCount++;
							errList.add(s);
						}
					}

				}

			}

		}
		System.out.println("-----------本轮测试结果----------");
		System.out.println("用例通过数：" + passCount);
		System.out.println("用例不通过数：" + failCount);
		if (errList.size() != 0) {
			System.out.println("不通过的用例为：");
			for (String errStr : errList) {
				System.out.println(errStr);
			}

		}
	}

}
