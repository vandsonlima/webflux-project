package org.example.webflux.controller;

import org.example.webflux.document.Playlist;
import org.example.webflux.repository.PlaylistRepository;
import org.example.webflux.services.PlayService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlaylistController {

    private final PlayService playService;

    public PlaylistController(PlayService playService) {
        this.playService = playService;
    }

    @GetMapping("/playlist")
    Flux<Playlist> getAll(){
        return playService.findAll();
    }

    @GetMapping("/playlist/{id}")
    Mono<Playlist> getById(@PathVariable String id){
        return playService.findById(id);
    }

    @PostMapping("/playlist")
    Mono<Playlist> save(@RequestBody Playlist playlist){
        return playService.save(playlist);
    }


}
