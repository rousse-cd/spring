package com.example.demo2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo2.models.Personaje;

@Repository
public interface IPersonaje extends CrudRepository<Personaje, Integer>{

}
