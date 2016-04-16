package com.afn;

import java.util.ArrayList;
// You need to query by id, and id's need to be unique...don't want to repeat myself and introduce a potential bug by having both subclasses of 
//organism generate their own id's. Instead the superclass constructor generated unique identifiers so that there would never be
//any collision. Made design decision based on the similarity of both objects. Now we can use ANY idea for ANYTHING in an ecosystem. 



public class Ecosystem {
	
	private ArrayList<Organism> organisms;
	private static int numEcosystems;
	private int id;
	
	
	public Ecosystem() {
		super();
		organisms = new ArrayList<>();
		id = ++numEcosystems;
	}
	
	public int getId() {
		return id;
	}

	public void addOrganism(Organism org) {
		organisms.add(org);
	}

	public ArrayList<Organism> getOrganisms() {
		return organisms;
	}

	public void setOrganisms(ArrayList<Organism> organisms) {
		this.organisms = organisms;
	}
	
	
}
