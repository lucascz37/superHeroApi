package br.com.lucas.superHeroApi.repository;
/*
@author: Lucas Andrade
@Created_at: 12/04/2021, seg
*/

import br.com.lucas.superHeroApi.documents.Hero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends ReactiveMongoRepository<Hero, String> {
}
