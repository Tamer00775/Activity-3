package kz.sdu.sadp.Activity3;

import kz.sdu.sadp.Activity3.config.DatabaseConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class Activity3Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(Activity3Application.class, args);
		DatabaseConfig databaseConfig = DatabaseConfig.getInstance();
		DatabaseConfig databaseConfig2 = DatabaseConfig.getInstance();
		if (databaseConfig == databaseConfig2) {
			log.info("TWO OBJECTS ARE THE SAME HASHCODE");
		}
	}

}
