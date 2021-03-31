package com.gadgetszan.mycattery;

import com.gadgetszan.mycattery.repository.CatInfoRepository;
import com.gadgetszan.mycattery.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class MyCatteryApplication {
	Logger LOGGER = LoggerFactory.getLogger(MyCatteryApplication.class);

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}


	public static void main(String[] args) {
		SpringApplication.run(MyCatteryApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(OwnerRepository ownerRepository,
										CatInfoRepository catInfoRepository) {
		return args -> {


		};
	};
}
