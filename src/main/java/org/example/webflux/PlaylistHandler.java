package org.example.webflux;

import org.example.webflux.document.Playlist;
import org.example.webflux.services.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PlaylistHandler {

    @Autowired
    PlayService playService;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(APPLICATION_JSON)
                .body(playService.findAll(), Playlist.class);
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ok()
                .contentType(APPLICATION_JSON)
                .body(playService.findById(id), Playlist.class);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest){
        final Mono<Playlist> playlist = serverRequest.bodyToMono(Playlist.class);
        return ok()
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(playlist1 -> playService.save(playlist1)), Playlist.class));

    }
}
