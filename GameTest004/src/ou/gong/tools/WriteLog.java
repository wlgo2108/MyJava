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
		// �����ļ�fileName
		File file = new File(fileName);

		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			System.out.println("�ļ������ɹ���");
		} catch (IOException e) {
			System.out.println("�ļ�����ʧ�ܣ�");

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
		// �����ļ�fileName
		File file = new File(fileName);

		BufferedReader br = null;// ����һ��BufferedReader������ȡ�ļ�
		String s = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while ((s = br.readLine()) != null) {// ʹ��readLine������һ�ζ�һ��
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
			if (StringTools.checkStr(returnfromServer, "������ͨ��")) {
				failCount++;
				// System.out.println(s);
				errList.add(s);
			} else {

				if (StringTools.checkStr(returnfromServer, "����ͨ��")) {
					passCount++;
					// System.out.println(s);
				} else {

					String[] checkStr = returnfromServer.split("��");
					if(checkStr.length > 1) {
						String yqResult = checkStr[0].split("Ԥ�ڽ��Ϊ:")[1];
						if (StringTools.checkStr(checkStr[1], checkStr[0].split("Ԥ�ڽ��Ϊ:")[1])) {
							passCount++;
						} else {
							failCount++;
							errList.add(s);
						}
					}

				}

			}

		}
		System.out.println("-----------���ֲ��Խ��----------");
		System.out.println("����ͨ������" + passCount);
		System.out.println("������ͨ������" + failCount);
		if (errList.size() != 0) {
			System.out.println("��ͨ��������Ϊ��");
			for (String errStr : errList) {
				System.out.println(errStr);
			}

		}
	}

}
