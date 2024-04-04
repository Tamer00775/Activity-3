package kz.sdu.sadp.Activity3.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Slf4j
public class DatabaseConfig {
    @Value("${spring.db.url}")
    private String HOSTNAME;

    @Value("${spring.db.username}")
    private String USERNAME;

    @Value("${spring.db.password}")
    private String PASSWORD;

    @Value("${spring.db.driver-classname}")
    private String DRIVER_CLASS_NAME;

    private static volatile DatabaseConfig instanse;

    public DatabaseConfig() {

    }

    public static DatabaseConfig getInstance() {
        if (instanse == null) {
            synchronized (DatabaseConfig.class) {
                if (instanse == null) {
                    instanse = new DatabaseConfig();
                }
            }
        }

        return instanse;
    }

    @Bean
    private DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(HOSTNAME);
        dataSourceBuilder.username(USERNAME);
        dataSourceBuilder.password(PASSWORD);
        dataSourceBuilder.driverClassName(DRIVER_CLASS_NAME);

        log.info("DRIVER {}, HOSTNAME {}", DRIVER_CLASS_NAME, HOSTNAME);
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(DRIVER_CLASS_NAME);
        driverManagerDataSource.setPassword(PASSWORD);
        driverManagerDataSource.setUrl(HOSTNAME);
        driverManagerDataSource.setUsername(USERNAME);
        log.info("DATABASE CONNECTION SUCCESSFULLY");

        return driverManagerDataSource;
    }
}
