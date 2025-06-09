package com.duong.ss20.service;

import com.duong.ss20.dto.CreateSeedDTO;
import com.duong.ss20.dto.SearchSeedDTO;
import com.duong.ss20.dto.UpdateSeedDTO;
import com.duong.ss20.entity.Seed;

import java.util.List;
import java.util.Optional;

public interface SeedService {
    List<Seed> getAll (int page, int pageSize);
    int count();
    boolean insert (CreateSeedDTO createSeedDTO);
    boolean update (UpdateSeedDTO updateSeedDTO);
    boolean delete (Seed seed);
    Optional<Seed> findByName (String name);
    Optional<Seed> findById (int id);
    List<Seed> searchByFilter (String name,double min, double max);
}
