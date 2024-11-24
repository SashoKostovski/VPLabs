# VPLabs


/*package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.services.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/artist/artist-list")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public String showArtistList(@RequestParam(required = false) String songRadio, Model model) {
        List<Artist> artistList = artistService.listArtists();
        model.addAttribute("artistList", artistList);
        model.addAttribute("trackId", songRadio != null ? songRadio : "-");
        return "listArtists";
    }


    @PostMapping
    public String processArtistSelection(@RequestParam(required = false) String songRadio, Model model) {
        List<Artist> artistList = artistService.listArtists();
        model.addAttribute("artistList", artistList);
        model.addAttribute("trackId", songRadio != null ? songRadio : "-");
        return "listArtists";
    }
}
