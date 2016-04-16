package com.afn;

import java.util.ArrayList;

public class Evolution {

	private ArrayList<Ecosystem> ecosystems;

	public Evolution() {
		super();
		ecosystems = new ArrayList();
	}

	// Assign and organism to an ecosystem
	public void assignOrganismToEcosystem(Organism org) {
		// if the org is a plant
		if (org instanceof Plant) {
			assignPlantToExistingEcosystem(org);
		} else if (org instanceof Animal) {
			assignAnimalToExistingEcosystem(org);
		}

	}

	private void assignPlantToExistingEcosystem(Organism org) {
		// iterate through each of the ecosystems in ecosystem
		for (Ecosystem ecosystem : ecosystems) {
			// going to iterate over all of the organisms in that ecosystem
			for (Organism o : ecosystem.getOrganisms()) {
				// if the org is an animal
				if (o instanceof Animal) {
					// iterate over all the things it eats
					for (Plant p : ((Animal) o).getEdiblePlants()) {
						// if plant is eaten by the animal
						if (p.getName().equals(org.getName())) {
							org.setEcosystemId(ecosystem.getId());
							// add the plant to the ecosystem
							ecosystem.addOrganism(org);
							System.out.println("Added plant to ecosystem");
							return;
						}

					}
				}
			}
		}
		createNewEcosystem(org);
	}

	private void assignAnimalToExistingEcosystem(Organism org) {
		for (Ecosystem ecosystem : ecosystems) {
			// going to iterate over all of the organisms in that ecosystem
			for (Organism o : ecosystem.getOrganisms()) {
				// if the org is a plant and animal eats that plant
				if (o instanceof Plant && ((Animal) org).getEdiblePlants().contains((Plant) o)) {
					// set org id to the ecosystem we're in
					org.setEcosystemId(ecosystem.getId());
					// add the plant to the ecosystem
					ecosystem.addOrganism(org);
					System.out.println("Added animal to ecosystem");
					return;
				}
			}
		}
		createNewEcosystem(org);
	}

	private void createNewEcosystem(Organism org) {
		System.out.println("created ecosystem");
		Ecosystem es = new Ecosystem();
		// Set the ecosystem id of the organism to the ecosystem
		// just created
		org.setEcosystemId(es.getId());
		es.addOrganism(org);
		ecosystems.add(es);
	}

	// Error handling if not found, will return null (whatever calls this might
	// be passed a null value)
	public ArrayList<Organism> getOrganismEcosystem(Organism org) {
		for (Ecosystem ecosystem : ecosystems) {
			if (ecosystem.getId() == org.getEcosystemId()) {
				return ecosystem.getOrganisms();
			}
		}
		return null;
	}
	
	public Organism getOrganismById(int id) {
		for (Ecosystem ecosystem : ecosystems) {
			for(Organism org : ecosystem.getOrganisms()) {
				if(org.getId() == id) {
					return org;
				}
			}
		}
		return null;
	}
	
	public ArrayList<Organism> getOrganismsInEcosystemByOrganismId(int id) {
		return getOrganismEcosystem(getOrganismById(id));
	}

	public ArrayList<Ecosystem> getEcosystems() {
		return ecosystems;
	}

	public void setEcosystems(ArrayList<Ecosystem> ecosystems) {
		this.ecosystems = ecosystems;
	}

}
