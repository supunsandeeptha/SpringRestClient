package com.example.restDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class RestDemoApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
			System.out.println("Hello");

			try {
				//new rest template
				RestTemplate restTemplate = new RestTemplate();
				//http headers
				HttpHeaders httpHeaders = new HttpHeaders();
				//setting the key ( can use the key according to your api)
				httpHeaders.set("APIKey", "5567GGH67225HYVGG");
				httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
				//api url
				String url = "https://jsonplaceholder.typicode.com/todos/1";
				HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
				//fetching the response
				ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
				if (response.getStatusCode() == HttpStatus.OK) {
					System.out.println(response);
				} else {
					System.out.println("error");
				}

			}catch (Exception ex){
				System.out.print("exception has occurred");
			}
	}
}
