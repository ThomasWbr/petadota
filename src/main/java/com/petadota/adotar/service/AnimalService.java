package com.petadota.adotar.service;

import com.petadota.adotar.model.Animal;
import com.petadota.adotar.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
    }
}
