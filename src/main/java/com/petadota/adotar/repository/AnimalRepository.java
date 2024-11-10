package com.petadota.adotar.repository;

import com.petadota.adotar.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // Métodos específicos de consulta podem ser adicionados aqui, se necessário
}
