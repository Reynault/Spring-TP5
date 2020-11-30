package com.tp.album_manager.dao;

import com.tp.album_manager.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    Album findAlbumById(Long id);
    void deleteById(Long aLong);
}
