package pl.put.poznan.building.info.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.building.info.rest"})
public class BuildingInfoApplication {

    public static void main(String[] args) {

        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
