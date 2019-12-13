package fr.diginamic.locale;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class TestLocale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate date = LocalDate.now();
		
	
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		
		System.out.println(date.format(formatter));
		
		System.out.println(Locale.getDefault());
		
		double test = 10000.15;
		
		DecimalFormat nbFormatter = new DecimalFormat();
		
		System.out.println(nbFormatter.format(test));
		
		
		

	}

}
