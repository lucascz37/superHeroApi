package br.com.lucas.superHeroApi.controller;
/*
@author: Lucas Andrade
@Created_at: 12/04/2021, seg
*/

import br.com.lucas.superHeroApi.documents.Hero;
import br.com.lucas.superHeroApi.service.HeroService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
public class HeroController {

    private final HeroService service;


    public HeroController(HeroService service) {
        this.service = service;
    }

    @GetMapping("/hero")
    public ResponseEntity<Flux<Hero>> getAll(){
        return new ResponseEntity<>(service.getHeroes(), HttpStatus.OK);
    }

    // find by example
    @GetMapping("/hero/query")
    public ResponseEntity<Flux<Hero>> getWhere(@RequestBody Hero hero){
        return new ResponseEntity<>(service.findWhere(
                new Hero(null, hero.getName(), hero.getUniverse(), hero.getMovies()))
                , HttpStatus.OK);
    }

    @GetMapping("/hero/{id}")
    public ResponseEntity<Mono<Hero>> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/hero")
    public ResponseEntity<Mono<Hero>> createOrUpdateHero(@Valid @RequestBody Hero hero){
        return new ResponseEntity<>(service.createAndUpdateDocument(hero), HttpStatus.CREATED);
    }

    @DeleteMapping("/hero/{id}")
    public Mono<ResponseEntity<Hero>> deleteHero(@PathVariable("id") String id){
        return service.findById(id)
                .flatMap(hero -> service.deleteById(hero).then(Mono.just(new ResponseEntity<>(hero,HttpStatus.OK)))
                )
                .switchIfEmpty(Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
