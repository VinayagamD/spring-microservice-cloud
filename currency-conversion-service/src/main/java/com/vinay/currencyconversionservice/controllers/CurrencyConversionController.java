package com.vinay.currencyconversionservice.controllers;

import com.vinay.currencyconversionservice.models.CurrencyConversionBean;
import com.vinay.currencyconversionservice.proxies.CurrencyExchangeServiceProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-converter")
public class CurrencyConversionController {

    private final CurrencyExchangeServiceProxy proxy;

    public CurrencyConversionController(CurrencyExchangeServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
       CurrencyConversionBean response = proxy.retrieveExchangeValue(from,to);
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple() , quantity,quantity.multiply(response.getConversionMultiple()) , response.getPort());
    }

}
