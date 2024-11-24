package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/listSongs")
public class SongListController {

    private final SongService songService;


    @Autowired
    public SongListController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public String listSongs(Model model) {

        List<Song> songs = songService.listSongs();


        model.addAttribute("songList", songs);


        return "listSongs";
    }
}