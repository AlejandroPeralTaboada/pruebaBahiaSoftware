package com.alexperal.pruebaBahiaSoftware.controller;


import com.alexperal.pruebaBahiaSoftware.entities.State;
import com.alexperal.pruebaBahiaSoftware.entities.pet.Pet;
import com.alexperal.pruebaBahiaSoftware.entities.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PetController {

	private static final List<Option> options;

	static {
		options = new ArrayList<>(3);
		options.add(new Option(0,"Todos"));
		options.add(new Option(1,"Enfermos"));
		options.add(new Option(2,"Alta"));
	}

	private final PetRepository petRepository;

	@Autowired
	public PetController(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@GetMapping("")
	public String getPets(@RequestParam(required = false) Integer filter, Model model) {

		model.addAttribute("pets", findPets(filter));
		model.addAttribute("options",options);
		return "pets";
	}

	private List<Pet> findPets(Integer filter) {
		if (filter==null || filter == 0) {
			return petRepository.findAll();
		}
		return petRepository.findByState(State.fromInt(filter));
	}

	@GetMapping("pet/{id}")
	public String getPet(@PathVariable("id")  Long id, Model model) {
		model.addAttribute("pet", petRepository.findById(id));
		return "pet";
	}

}
