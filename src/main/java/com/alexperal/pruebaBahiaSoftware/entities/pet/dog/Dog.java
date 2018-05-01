package com.alexperal.pruebaBahiaSoftware.entities.pet.dog;

import com.alexperal.pruebaBahiaSoftware.entities.pet.Pet;
import com.alexperal.pruebaBahiaSoftware.entities.pet.SpeciesNaming;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@DiscriminatorValue("DOG")
public class Dog extends Pet {
	@Override
	public String getSpecies() {
		return SpeciesNaming.DOG;
	}
}