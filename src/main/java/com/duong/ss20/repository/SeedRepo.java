package com.duong.ss20.repository;

import com.duong.ss20.entity.Seed;

import java.util.List;
import java.util.Optional;

public interface SeedRepo {
    List<Seed> getAll (int page, int pageSize);
    int count ();
    boolean insert (Seed seed);
    boolean update (Seed seed);
    boolean delete (Seed seed);
    Optional<Seed> findByName (String name);
    Optional<Seed> findById (int id);
    List<Seed> findByNameLike (String name);
    List<Seed> searchByFilter(String name, double min, double max);
}
