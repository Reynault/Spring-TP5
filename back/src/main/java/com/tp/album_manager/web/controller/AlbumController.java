package com.tp.album_manager.web.controller;

import com.tp.album_manager.dao.AlbumRepository;
import com.tp.album_manager.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AlbumController {

    @Value("${me}")
    private String me;

    private final AlbumRepository dao;

    @Autowired
    public AlbumController(AlbumRepository dao) {
        this.dao = dao;
    }

    @GetMapping(value = "/albums")
    public Collection<Album> getAlbums(HttpServletResponse response) {
        Iterable<Album> iterable = dao.findAll();
        Collection<Album> albums = new ArrayList<>();
        iterable.forEach(albums::add);
        if (albums.isEmpty())
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        return albums;
    }

    @GetMapping(value = "/albums/{id}")
    public Album getAlbum(@PathVariable long id, HttpServletResponse response) {
        Album album = dao.findAlbumById(id);
        if (album == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return album;
    }

    @DeleteMapping(value = "/albums/{id}")
    public void deleteAlbum(@PathVariable long id, HttpServletResponse response) {
        if(dao.existsById(id)) {
            dao.deleteById(id);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @PostMapping(value = "/albums")
    public Album postAlbum(@RequestBody Album album) {
        return dao.save(album);
    }

    @PutMapping(value = "/albums/{id}")
    public Album putAlbum(@PathVariable long id, @RequestBody Album album, HttpServletResponse response) {
        if (!dao.existsById(id)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        } else {
            album.setId(id);
            return dao.save(album);
        }
    }

    @GetMapping(value = "/cestqui")
    public String getName(){
        System.out.println("HELLO THERE !");
        return me;
    }
}
