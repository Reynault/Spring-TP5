package com.tp.album_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AlbumManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbumManagerApplication.class, args);
    }

}
