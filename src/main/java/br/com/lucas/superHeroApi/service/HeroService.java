package br.com.lucas.superHeroApi.service;

import br.com.lucas.superHeroApi.documents.Hero;
import br.com.lucas.superHeroApi.repository.HeroRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
@author: Lucas Andrade
@Created_at: 12/04/2021, seg
*/
@Service
public class HeroService {

    private final HeroRepository repository;


    public HeroService(HeroRepository repository) {
        this.repository = repository;
    }

    public Mono<Hero> createAndUpdateDocument(Hero hero){
        return repository.save(hero);
    }

    public Mono<Hero> findById(String id){
        return repository.findById(id);
    }

    public Mono<Void> deleteById(Hero hero){
        return repository.delete(hero);
    }

    public Flux<Hero> findWhere(Hero hero){
        return repository.findAll(Example.of(new Hero(null, hero.getName(), hero.getUniverse(), hero.getMovies())));
    }

    public Flux<Hero> getHeroes(){
        return repository.findAll();
    }
}
