package org.example.webflux.repository;

import org.example.webflux.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
