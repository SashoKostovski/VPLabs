package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import mk.ukim.finki.wp.lab.web.controller.SongListController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// In-memory data holder
@Component
public class DataHolder {
    public static List<Artist> artistList = new ArrayList<>();
    public static List<Song> songList = new ArrayList<>();
    private final SongListController songListController;
    public static List<Album> albumList = new ArrayList<>();
    private static long idCounter = 1;
    public DataHolder(SongListController songListController) {
        this.songListController = songListController;
    }

    @PostConstruct
    public void init() {
        artistList.add(new Artist(1L, "Johnny", "Cash", "Bio of Johnny Cash"));
        artistList.add(new Artist(2L, "Marshall", "Mathers", "Bio of Marshall Mathers"));
        artistList.add(new Artist(3L, "Seba", "Jun", "Bio of Seba Jun"));
        artistList.add(new Artist(4L, "Micheal", "Jackson", "Bio of Micheal Jackson"));
        artistList.add(new Artist(5L, "Frank", "Sinatra", "Bio of Frank Sinatra"));


        songList.add(new Song("T1", "Hurt", "Alternative rock", 2002, artistList.get(0)));
        songList.add(new Song("T2", "Ring of Fire", "Country", 1963, artistList.get(0)));
        songList.add(new Song("T3", "Luv(sic)", "Hip-Hop", 2001, artistList.get(2)));
        songList.add(new Song("T4", "Thriller", "Pop", 1982, artistList.get(3)));
        songList.add(new Song("T5", "My Way", "Jazz", 1969, artistList.get(4)));

        // Initialize albums
        albumList.add(new Album(idCounter++, "Greatest Hits", "Rock", "1995"));
        albumList.add(new Album(idCounter++, "Pop Classics", "Pop", "2001"));
        albumList.add(new Album(idCounter++, "Jazz Essentials", "Jazz", "1980"));
        albumList.add(new Album(idCounter++, "Electronic Vibes", "Electronic", "2010"));
        albumList.add(new Album(idCounter++, "Acoustic Sessions", "Acoustic", "2015"));


        songList.get(0).setAlbum(albumList.get(0)); // "Greatest Hits"
        songList.get(1).setAlbum(albumList.get(0)); // "Greatest Hits"
        songList.get(2).setAlbum(albumList.get(1)); // "Pop Classics"
        songList.get(3).setAlbum(albumList.get(2)); // "Jazz Essentials"
        songList.get(4).setAlbum(albumList.get(3)); // "Electronic Vibes"

        // Assign songs to albums
        albumList.get(0).setSongs(List.of(songList.get(0), songList.get(1))); // Add songs to "Greatest Hits"
        albumList.get(1).setSongs(List.of(songList.get(2))); // Add song to "Pop Classics"
        albumList.get(2).setSongs(List.of(songList.get(3))); // Add song to "Jazz Essentials"
        albumList.get(3).setSongs(List.of(songList.get(4)));
    }
}
