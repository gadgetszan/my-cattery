package com.gadgetszan.mycattery;

import com.gadgetszan.mycattery.repository.CatInfoRepository;
import com.gadgetszan.mycattery.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyCatteryApplication {
	Logger LOGGER = LoggerFactory.getLogger(MyCatteryApplication.class);

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
