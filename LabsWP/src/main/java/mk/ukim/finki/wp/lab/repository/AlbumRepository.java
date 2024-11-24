package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {
    public List<Album> findAll() {
        return DataHolder.albumList;
    }

    public Optional<Album> findById(Long id) {
        return DataHolder.albumList.stream()
                .filter(album -> album.getId().equals(id))
                .findFirst(); // Find album by ID
    }

    public Album save(Album album) {
        DataHolder.albumList.add(album); // Add a new album
        return album;
    }

    public void delete(Long id) {
        DataHolder.albumList.removeIf(album -> album.getId().equals(id));
    }
}
