package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class fishing {

	public static void main(String[] args) {
					// 인증키 (개인이 받아와야함)
					String key = "E4382798261957A5F3B708916542BA8E5AF936F427FC7D8C7826F22C11C7FDEC";
					// 검색어
					String keyWord = "타이틀";
					// 검색 결과
					String result = "";
					// 문자 인코딩
					String encodeKey;
					try {
						encodeKey = URLEncoder.encode(keyWord, "UTF-8");
							/*인기 100 url*/
						URL url = new URL("http://book.interpark.com/api/bestSeller.api?key="
								+ key + "&categoryId=100&output=json");
						/*도서 검색 url*/
						url = new URL(
								"https://book.interpark.com/api/search.api?key="
								+ key
								+ "&query="
								+ encodeKey
								+ "&output=json"
								);
						BufferedReader bf;
				
						bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				
						result = bf.readLine();
						System.err.println("json 응답="+result);
						
						JSONParser parser = new JSONParser();
						JSONObject bookData = (JSONObject)parser.parse(result);
					//System.err.println(bookData.toJSONString());

					JSONArray arr = (JSONArray)bookData.get("item");
					//System.err.println(arr.toJSONString());
					
					for(int i=0;i<arr.size();i++){
						JSONObject tmp = (JSONObject)arr.get(i);//인덱스 번호로 접근해서 가져온다.
						String title = (String)tmp.get("title");
						String author = (String)tmp.get("author");
						System.out.println("----- "+i+"번째 인덱스 값 -----");
						System.out.println("제목 : "+title);
						System.out.println("작가 : "+author);
					}
					
					}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	}