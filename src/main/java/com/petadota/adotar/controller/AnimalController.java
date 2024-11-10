package com.petadota.adotar.controller;

import com.petadota.adotar.model.Animal;
import com.petadota.adotar.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.petadota.adotar.exception.InvalidDataException;  // Importação da exceção personalizada

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // Endpoint para criar um novo animal com validação do nome
    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        if (animal.getNome() == null || animal.getNome().isEmpty()) {
            throw new InvalidDataException("O nome do animal não pode ser vazio.");
        }
        Animal newAnimal = animalService.saveAnimal(animal);
        return new ResponseEntity<>(newAnimal, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os animais
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // Endpoint para buscar um animal pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        return animal.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para atualizar um animal
    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animalDetails) {
        Optional<Animal> existingAnimal = animalService.getAnimalById(id);
        if (existingAnimal.isPresent()) {
            Animal animal = existingAnimal.get();
            animal.setNome(animalDetails.getNome());
            animal.setTipo(animalDetails.getTipo());
            animal.setIdade(animalDetails.getIdade());
            animal.setRaca(animalDetails.getRaca());
            animal.setStatus(animalDetails.getStatus());
            animal.setDescricao(animalDetails.getDescricao());

            Animal updatedAnimal = animalService.updateAnimal(animal);
            return ResponseEntity.ok(updatedAnimal);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar um animal pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimalById(@PathVariable Long id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        if (animal.isPresent()) {
            animalService.deleteAnimalById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}