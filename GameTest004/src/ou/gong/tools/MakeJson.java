package ou.gong.tools;




import ou.gong.models.TestCase;

import java.beans.IntrospectionException;  
import java.beans.Introspector;  
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;  
import java.util.Map;  
import java.util.Set;

import net.sf.json.JSONArray;  
  

public class MakeJson {
	


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
	            props = Introspector.getBeanInfo(bean.getClass(), Object.class)  
	                    .getPropertyDescriptors();  
	        } catch (IntrospectionException e) {  
	        }  
	        if (props != null) {  
	            for (int i = 0; i < props.length; i++) {  
	                try {  
	                    String name = objectToJson(props[i].getName());  
	                    String value = objectToJson(props[i].getReadMethod()  
	                            .invoke(bean));  
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
	  
	    public void writeToJson(String filePath,String jsonStr) throws IOException
		{
			File file = new File(filePath);
			char [] stack = new char[1024];
			int top=-1;
			
		
			
			StringBuffer sb = new StringBuffer();
			char [] charArray = jsonStr.toCharArray();
			for(int i=0;i<charArray.length;i++){
				char c= charArray[i];
				if ('{' == c || '[' == c) {  
	                stack[++top] = c; 
	                sb.append("\n"+charArray[i] + "\n");  
	                for (int j = 0; j <= top; j++) {  
	                    sb.append("\t");  
	                }  
	                continue;  
	            }
				 if ((i + 1) <= (charArray.length - 1)) {  
		                char d = charArray[i+1];  
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

	
	public static void  main(String[] args) {
		MakeJson mJson = new MakeJson() ;
		int pro_id = 62;
		int game_id = 2;
		int tsn = 0;
		String filename = "C:\\个人资料\\代码\\中奖检索用例\\test.xls";
		String sheetName = "GSB001";
		List<TestCase> tList = new ExcelToDB().toDb(pro_id, game_id, tsn, filename, sheetName);
		String jSonStr = mJson.listToJson(tList) ;
		try {
			mJson.writeToJson("c:\\logs\\"+sheetName+".json",jSonStr );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	
}
