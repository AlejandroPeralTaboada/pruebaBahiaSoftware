package com.alexperal.pruebaBahiaSoftware.entities.pet.cat;

import com.alexperal.pruebaBahiaSoftware.entities.pet.Pet;
import com.alexperal.pruebaBahiaSoftware.entities.pet.SpeciesNaming;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@DiscriminatorValue("CAT")
public class Cat extends Pet {
	@Override
	public String getSpecies() {
		return SpeciesNaming.CAT;
	}
}
