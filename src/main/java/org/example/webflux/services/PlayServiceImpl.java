package org.example.webflux.services;

import org.example.webflux.document.Playlist;
import org.example.webflux.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayServiceImpl implements PlayService{
    private final PlaylistRepository playlistRepository;

    public PlayServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public Flux<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
