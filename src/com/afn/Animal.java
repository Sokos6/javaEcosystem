package com.afn;

import java.util.ArrayList;

public class Animal extends Organism {

	
	private ArrayList<Plant> ediblePlants;

	public Animal() {
		super();
		ediblePlants = new ArrayList<>();
	}
	
	
	public ArrayList<Plant> getEdiblePlants() {
		return ediblePlants;
	}

	public void setEdiblePlants(ArrayList<Plant> ediblePlants) {
		this.ediblePlants = ediblePlants;
	}
}
