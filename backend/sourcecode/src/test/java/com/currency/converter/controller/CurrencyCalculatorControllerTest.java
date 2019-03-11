package com.currency.converter.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.currency.converter.model.Currency;
import com.currency.converter.util.CurrencyConverter;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CurrencyCalculatorController.class, secure = false)
public class CurrencyCalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CurrencyConverter currencyConverter;

	@Test
	public void testCalculate() throws Exception {
		Currency currency = new Currency();
		currency.setAmount(2.50);
		String json = new Gson().toJson(currency);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/currency")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

}
