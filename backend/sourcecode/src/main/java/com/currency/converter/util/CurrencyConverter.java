package com.currency.converter.util;

import java.util.Random;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Rinu
 *
 */
@Component
public class CurrencyConverter {
	
	/**
	 * 
	 * @param amount input from controller page 
	 * @return returns converted amount value
	 */
public double convert(double amount) {
	double convertedValue=0; // used to store calculated value
	double scale = Math.pow(10, 2);
	convertedValue=amount*2 +Math.round((0 + new Random().nextDouble() * (1 - 0))*scale)/scale;
		
		return convertedValue;
	
}
}
