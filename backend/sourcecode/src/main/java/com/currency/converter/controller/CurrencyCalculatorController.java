package com.currency.converter.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.currency.converter.model.Currency;
import com.currency.converter.util.CurrencyConverter;


/**
 * 
 * @author Rinu
 * Accepts request body from post call ending with value currency is mapped to currency object
 * returns response with calculated new value amount
 */
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class CurrencyCalculatorController {
	
	@Autowired
	private CurrencyConverter currencyConverter;
	
	@RequestMapping(method=RequestMethod.POST,value="currency")
	public ResponseEntity<?> calculate(@RequestBody Currency currency) {
	
		currency.setAmount(currencyConverter.convert(currency.getAmount()));
		return ResponseEntity.ok().body(currency);

	}

}
