package org.rodion.solution;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
	public static LocalDateTime strToDateTime(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		if(!dateStr.contains(":")) {
			dateStr = dateStr +" 00:00";
		}
		return LocalDateTime.parse(dateStr, formatter);
		
	}
	public static void main(String[] args) {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime now = LocalDateTime.now();
		String format = now.format(formatter1);
		System.out.println(format);
		//now.fo
	

	}

}
