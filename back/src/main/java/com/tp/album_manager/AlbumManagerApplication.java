package com.tp.album_manager;

import com.tp.album_manager.dao.AlbumRepository;
import com.tp.album_manager.model.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class AlbumManagerApplication {

    private static final Logger log = LoggerFactory.getLogger(AlbumManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AlbumManagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AlbumRepository albumRepository) {
        return (args) -> {
            albumRepository.deleteAll();

            albumRepository.save(new Album(
                    "An Awesome Wave",
                    "Iguana Studio",
                    "Alt J",
                    19.99f,
                    40
            ));
            albumRepository.save(new Album(
                    "The Golden Age",
                    "Green United Music",
                    "Woodkid",
                    24.99f,
                    200
            ));
            albumRepository.save(new Album(
                    "Myopia",
                    "Strange Harvest Limited",
                    "Agnes Obel",
                    1999.99f,
                    2
            ));

            for(Album a : albumRepository.findAll()){
                log.info(a.toString());
            }
        };
    }
}
