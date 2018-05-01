package com.alexperal.pruebaBahiaSoftware.entities.pet;

import com.alexperal.pruebaBahiaSoftware.entities.State;
import com.alexperal.pruebaBahiaSoftware.entities.owner.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance
@DiscriminatorColumn(name = "SPECIES")
public abstract class Pet {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private State state;
	private Instant birthDate;
	private Integer numberOfVisits;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_owner")
	private Owner owner;

	public abstract String getSpecies();
}

