package tool;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
/*
 * ZkURLParser类
 * 对url路径实现参数分离
 */
public class URLParser {
	public static HashMap<String, String> params(String query,String charest) throws UnsupportedEncodingException
	{
		if(query==null||query.equals(""))
		{
			return null;
		}
		String str=query;
		HashMap<String, String> params=null;
//		int index=query.indexOf("?");
//		if(index>=0)
//		{
//			str=query.substring(index+1);
//		}
//		else
//		{
//			return params;
//		}
		
		if(str!=null&&!str.equals(""))
		{
			if(str.indexOf("%")>=0)
			{
				str=URLDecoder.decode(str, charest);
			}
			String[] arr=str.split("&");
			params=new HashMap<String, String>();
			for(int i=0;i<arr.length;i++)
			{
				String[] subarr=arr[i].split("=");
				if(subarr.length==2)
				{
					params.put(subarr[0],subarr[1]);
				}
				else if(subarr.length==1)
				{
					params.put(subarr[0], null);
				}
			}
		}
		return params;
	}
	public static HashMap<String, String> params(String query) throws UnsupportedEncodingException
	{
		return params(query,"utf-8");
	}
}
