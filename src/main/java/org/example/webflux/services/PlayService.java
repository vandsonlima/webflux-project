package org.example.webflux.services;

import org.example.webflux.document.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayService {

    Flux<Playlist> findAll();

    Mono<Playlist> findById(String id);

    Mono<Playlist> save(Playlist playlist);


}
