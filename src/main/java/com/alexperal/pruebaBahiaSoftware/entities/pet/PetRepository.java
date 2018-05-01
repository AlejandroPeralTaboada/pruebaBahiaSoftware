package com.alexperal.pruebaBahiaSoftware.entities.pet;

import com.alexperal.pruebaBahiaSoftware.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	List<Pet> findByState(State state);
}
