package com.example.priceBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;

@SpringBootApplication
@RestController
public class PriceBackApplication {

	private static final Logger log = LoggerFactory.getLogger(PriceBackApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PriceBackApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/*@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			BinanceResp binRespBTC = restTemplate.getForObject(
					"https://api.binance.us/api/v3/ticker/bookTicker?symbol=BTCUSD", BinanceResp.class);
			log.info(binRespBTC.toString());

			BinanceResp binRespETH = restTemplate.getForObject(
					"https://api.binance.us/api/v3/ticker/bookTicker?symbol=ETHUSD", BinanceResp.class);
			log.info(binRespETH.toString());

			GeminiResp gemRespBTC = restTemplate.getForObject(
					"https://api.gemini.com/v1/pubticker/BTCUSD", GeminiResp.class);
			log.info(gemRespBTC.toString());

			GeminiResp gemRespETH = restTemplate.getForObject(
					"https://api.gemini.com/v1/pubticker/ETHUSD", GeminiResp.class);
			log.info(gemRespETH.toString());
			
			
		};
	}*/

	@Autowired
	private RestTemplate restTemplate;

	@CrossOrigin(origins = "*")
	@GetMapping("/Binance")
	public BinanceResp Binance(@RequestParam(value = "symbol", defaultValue = "BTCUSD") String symbol){
		BinanceResp resp = restTemplate.getForObject(
					"https://api.binance.us/api/v3/ticker/bookTicker?symbol=" + symbol, BinanceResp.class);

		return resp;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Gemini")
	public GeminiResp Gemini(@RequestParam(value = "symbol", defaultValue = "BTCUSD") String symbol){
		GeminiResp resp = restTemplate.getForObject(
					"https://api.gemini.com/v1/pubticker/" + symbol, GeminiResp.class);

		return resp;
	}

}
