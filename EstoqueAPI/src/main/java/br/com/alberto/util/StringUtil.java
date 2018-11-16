package br.com.alberto.util;

public class StringUtil {

	private StringUtil() {}
	
	public static String concat(String... args) {
		StringBuilder builder = new StringBuilder();
		if(args != null && args.length > 0) {
			for(String s: args) {
				builder.append(s);
			}
		}
		return builder.toString();
	}
}
