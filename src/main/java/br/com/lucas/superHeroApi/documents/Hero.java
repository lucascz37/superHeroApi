package br.com.lucas.superHeroApi.documents;
/*
@author: Lucas Andrade
@Created_at: 12/04/2021, seg
*/

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document
public class Hero {

    @Id
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String universe;
    @NotEmpty
    private String movies;

    public Hero(String id, String name, String universe, String movies) {
        this.id = id;
        this.name = name;
        this.universe = universe;
        this.movies = movies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }
}
