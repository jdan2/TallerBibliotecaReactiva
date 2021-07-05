package com.sofka.biblioteca.repository;

import com.sofka.biblioteca.collections.AreaTematica;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositorioAreaTematica  extends ReactiveMongoRepository<AreaTematica, String> {
}
