package com.alexperal.pruebaBahiaSoftware.loader;

import com.alexperal.pruebaBahiaSoftware.entities.State;
import com.alexperal.pruebaBahiaSoftware.entities.owner.Owner;
import com.alexperal.pruebaBahiaSoftware.entities.owner.OwnerRepository;
import com.alexperal.pruebaBahiaSoftware.entities.pet.Pet;
import com.alexperal.pruebaBahiaSoftware.entities.pet.PetRepository;
import com.alexperal.pruebaBahiaSoftware.entities.pet.cat.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DataLoader implements ApplicationRunner {

	private final PetRepository petRepository;

	private final OwnerRepository ownerRepository;

	@Autowired
	public DataLoader(PetRepository petRepository, OwnerRepository ownerRepository) {
		this.petRepository = petRepository;
		this.ownerRepository = ownerRepository;
	}


	public void run(ApplicationArguments args) {
		Owner owner1 = ownerRepository.save(new Owner(null, "Michael", "Scott"));
		petRepository.save(newCat("Michu", State.ALTA,owner1));
		petRepository.save(newCat("Sasy", State.ILL,owner1));
		petRepository.save(newCat("milou", State.ILL,owner1));
		petRepository.save(newCat("Dorita", State.ALTA,owner1));

	}
	
	private Pet newCat(String name,State state, Owner owner){
		Pet cat = new Cat();
		cat.setName(name);
		cat.setState(state);
		cat.setOwner(owner);
		cat.setBirthDate(Instant.now());
		cat.setNumberOfVisits(1);
		return cat;
	}
}
