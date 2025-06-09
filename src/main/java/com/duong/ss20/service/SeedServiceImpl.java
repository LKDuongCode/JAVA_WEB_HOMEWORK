package com.duong.ss20.service;

import com.duong.ss20.dto.CreateSeedDTO;
import com.duong.ss20.dto.SearchSeedDTO;
import com.duong.ss20.dto.UpdateSeedDTO;
import com.duong.ss20.entity.Seed;
import com.duong.ss20.repository.SeedRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeedServiceImpl implements SeedService{
    private final SeedRepo seedRepo;

    public SeedServiceImpl(SeedRepo seedRepo) {
        this.seedRepo = seedRepo;
    }

    @Override
    public List<Seed> getAll(int page, int pageSize) {
        return seedRepo.getAll(page,pageSize);
    }

    @Override
    public int count() {
        return seedRepo.count();
    }

    @Override
    public boolean insert(CreateSeedDTO createSeedDTO) {
        return seedRepo.insert(parseToSeed(createSeedDTO));
    }

    @Override
    public boolean update(UpdateSeedDTO dto) {
        Optional<Seed> seedOptional = seedRepo.findById(dto.getId());
        if (seedOptional.isEmpty()) {
            return false;
        }

        Seed seed = seedOptional.get();


        boolean changed = false;

        if (dto.getName() != null && !dto.getName().isBlank() && !dto.getName().equals(seed.getName())) {
            seed.setName(dto.getName());
            changed = true;
        }

        if (dto.getDescription() != null && !dto.getDescription().equals(seed.getDescription())) {
            seed.setDescription(dto.getDescription());
            changed = true;
        }

        if (Math.abs(dto.getPrice() - seed.getPrice()) > 0.00001) {
            seed.setPrice(dto.getPrice());
            changed = true;
        }

        if (dto.getStock() != seed.getStock()) {
            seed.setStock(dto.getStock());
            changed = true;
        }

        if (dto.getImage() != null && !dto.getImage().isBlank() && !dto.getImage().equals(seed.getImage())) {
            seed.setImage(dto.getImage());
            changed = true;
        }

        // Nếu không thay đổi gì → không cần gọi update
        if (!changed) {
            return false;
        }

        return seedRepo.update(seed);
    }


    @Override
    public boolean delete(Seed seed) {
        return seedRepo.delete(seed);
    }

    @Override
    public Optional<Seed> findByName(String name) {
        return seedRepo.findByName(name);
    }

    @Override
    public Optional<Seed> findById(int id) {
        return seedRepo.findById(id);
    }

    @Override
    public List<Seed> searchByFilter(String name, double min, double max) {
        return seedRepo.searchByFilter(name, min, max);
    }

    private Seed parseToSeed (CreateSeedDTO dto){
        Seed s = new Seed();
        s.setName(dto.getName());
        s.setDescription(dto.getDescription());
        s.setPrice(dto.getPrice());
        s.setStock(dto.getStock());
        s.setImage(dto.getImage());
        return s;
    }


}
