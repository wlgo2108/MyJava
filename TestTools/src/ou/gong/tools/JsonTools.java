package ou.gong.tools;

/**
 * 这个代码来源于网上，其中针对系统功能做了调整
 * 其中增加了jsonToTestCase()这个方法，遇到类似的json转换对象的问题可以作为参考
 * 时间：2017-03-19 22:49
 * 修改人：wlgo2108
 */

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


import net.sf.json.JSONObject;
import ou.gong.models.TestCase;

public class JsonTools {

	public static String stringToJson(String s) {
		if (s == null) {
			return nullToJson();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
				if (ch >= '\u0000' && ch <= '\u001F') {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}

	public static String nullToJson() {
		return "";
	}

	public static String objectToJson(Object obj) {
		StringBuilder json = new StringBuilder();
		if (obj == null) {
			json.append("\"\"");
		} else if (obj instanceof Number) {
			json.append(numberToJson((Number) obj));
		} else if (obj instanceof Boolean) {
			json.append(booleanToJson((Boolean) obj));
		} else if (obj instanceof String) {
			json.append("\"").append(stringToJson(obj.toString())).append("\"");
		} else if (obj instanceof Object[]) {
			json.append(arrayToJson((Object[]) obj));
		} else if (obj instanceof List) {
			json.append(listToJson((List<?>) obj));
		} else if (obj instanceof Map) {
			json.append(mapToJson((Map<?, ?>) obj));
		} else if (obj instanceof Set) {
			json.append(setToJson((Set<?>) obj));
		} else {
			json.append(beanToJson(obj));
		}
		return json.toString();
	}

	public static String numberToJson(Number number) {
		return number.toString();
	}

	public static String booleanToJson(Boolean bool) {
		return bool.toString();
	}

	/**
	 * @param bean
	 *            bean对象
	 * @return String
	 */
	public static String beanToJson(Object bean) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
		} catch (IntrospectionException e) {
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = objectToJson(props[i].getName());
					String value = objectToJson(props[i].getReadMethod().invoke(bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception e) {
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	/**
	 * @param list
	 *            list对象
	 * @return String
	 */
	public static String listToJson(List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	/**
	 * @param array
	 *            对象数组
	 * @return String
	 */
	public static String arrayToJson(Object[] array) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (array != null && array.length > 0) {
			for (Object obj : array) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	/**
	 * @param map
	 *            map对象
	 * @return String
	 */
	public static String mapToJson(Map<?, ?> map) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		if (map != null && map.size() > 0) {
			for (Object key : map.keySet()) {
				json.append(objectToJson(key));
				json.append(":");
				json.append(objectToJson(map.get(key)));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	/**
	 * @param set
	 *            集合对象
	 * @return String
	 */
	public static String setToJson(Set<?> set) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (set != null && set.size() > 0) {
			for (Object obj : set) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public void writeToJson(String filePath, String jsonStr) throws IOException {
		File file = new File(filePath);
		char[] stack = new char[1024];
		int top = -1;

		StringBuffer sb = new StringBuffer();
		char[] charArray = jsonStr.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if ('{' == c || '[' == c) {
				stack[++top] = c;
				sb.append("\n" + charArray[i] + "\n");
				for (int j = 0; j <= top; j++) {
					sb.append("\t");
				}
				continue;
			}
			if ((i + 1) <= (charArray.length - 1)) {
				char d = charArray[i + 1];
				if ('}' == d || ']' == d) {
					top--;
					sb.append(charArray[i] + "\n");
					for (int j = 0; j <= top; j++) {
						sb.append("\t");
					}
					continue;
				}
			}
			if (',' == c) {
				sb.append(charArray[i] + "");
				for (int j = 0; j <= top; j++) {
					sb.append("");
				}
				continue;
			}
			sb.append(c);
		}

		Writer write = new FileWriter(file);
		write.write(sb.toString());
		write.flush();
		write.close();
	}

	public static List<String> jsonToExcel(String path) {
		List<String> tList = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				tList.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return tList;

	}

	/**
	 * 将json文件转换成对象
	 * 
	 * @param file
	 * @return
	 */
	public static List<TestCase> jsonToTestCase(String file) {
		List<TestCase> obj = new ArrayList<TestCase>();
		List<String> list = JsonTools.jsonToExcel(file);
		for (String str : list) {
			if (StringTools.checkStr(str, ":")) {
				JSONObject jsonObj = new JSONObject();
				String[] arrStr = str.split(",");
				for (String arr : arrStr) {
					String[] tcStr = arr.split(":");
					String key = "" ;
					String value = "" ;
					if(StringTools.checkStr(tcStr[0].trim(), "\"")){
						key = tcStr[0].trim().replace("\"", "")  ;
					}
					if(StringTools.checkStr(tcStr[1].trim(), "\"")){
						value = tcStr[1].trim().replace("\"", "")  ;
					}
					jsonObj.put(key, value);
				}
				TestCase tc = (TestCase) JSONObject.toBean(jsonObj, TestCase.class);
				obj.add(tc) ;
			}
		}

		return obj;
	}

	public String ReadFile(String Path) {

		BufferedReader reader = null;
		String laststr = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return laststr;
	}

	
}
