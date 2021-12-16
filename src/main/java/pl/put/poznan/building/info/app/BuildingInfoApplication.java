package pl.put.poznan.building.info.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.building.info.rest"})
@ComponentScan(basePackages = {"pl.put.poznan.building.info"})

public class BuildingInfoApplication {

    public static void main(String[] args) {

        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
