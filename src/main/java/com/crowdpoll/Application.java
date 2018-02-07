package com.crowdpoll;

import com.crowdpoll.kiva.KivaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages={"com.crowdpoll.kiva"})
@EntityScan(basePackages = {"com.crowdpoll.kiva.entities"} )
@EnableJpaRepositories(basePackages = {"com.crowdpoll.kiva.repositories"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        KivaService ka = new KivaService();
        ka.pollForCampaigns();

    }

}