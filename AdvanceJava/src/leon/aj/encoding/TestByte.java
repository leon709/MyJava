package leon.aj.encoding;

import java.nio.charset.Charset;
import java.util.Set;

public class TestByte {
	public static void main(String str[]){
		String s = "苏水链";
		System.out.println(s.hashCode());
		
		System.out.println("农行网银".hashCode());
		
		byte[] b = s.getBytes();
		for(byte i : b){
			System.out.print(i+" ");
		}
		
		System.out.println("\u4E25");
		Set<String> charsetNames = Charset.availableCharsets().keySet();
		for(String s1 : charsetNames){
			System.out.println(s1);
		}
		System.out.println(Charset.defaultCharset().displayName());;
	}
	
	public static String bytes2HexString(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		return ret;
	}
}
