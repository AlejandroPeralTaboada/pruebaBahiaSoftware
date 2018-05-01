package com.alexperal.pruebaBahiaSoftware.entities;

public enum State {

	ILL(1),ALTA(2);

	private final Integer value;
	State(Integer value){
		this.value = value;
	}

	public static State fromInt(Integer value){
		return (value!=null && value == 1) ? ILL : ALTA;
	}

	public Integer getValue() {
		return value;
	}
}
