package com.crowdpoll;

import com.crowdpoll.kiva.KivaAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        KivaAPI ka = new KivaAPI();
        ka.search();

    }

}