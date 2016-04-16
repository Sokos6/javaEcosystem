import java.util.ArrayList;

import com.afn.Animal;
import com.afn.Ecosystem;
import com.afn.Evolution;
import com.afn.Organism;
import com.afn.Plant;

public class TestMain {
	public static void main(String[] args) {

		Plant p = new Plant();
		Plant p2 = new Plant();
		Animal a = new Animal();

		// Testing Objects

		p.setName("red pepper");
		p2.setName("onion");

		a.setName("Tiger");
		ArrayList<Plant> plants = a.getEdiblePlants();
		plants.add(p);
		a.setEdiblePlants(plants);

		plants.add(p2);

		System.out.println(a.getEdiblePlants().get(0).getName());

		Ecosystem e = new Ecosystem(); // creating ecosystem ID 1
		System.out.println(e.getId());
		ArrayList<Organism> organisms = e.getOrganisms();
		organisms.add(p);
		organisms.add(a);

		// polymorphism, because plants and animals are both organisms, we can
		// iterate over them and have an
		// expectation of behavior, they both inherit from the same thing

		for (Organism o : organisms) {
			System.out.println(o.getName());

			// Test auto incrementing unique identifiers
			System.out.println(o.getId());
		}

		// Create a new instance of evolution and assign a new plant to an
		// ecosystem
		Evolution ev = new Evolution();
		ev.assignOrganismToEcosystem(p); // id2 being created from evolution
		System.out.println(ev.getEcosystems().get(0).getOrganisms().get(0).getName());

		// give all organisms in first ecosystem, making sure we can get the
		// plant out of it
		System.out.println(ev.getOrganismEcosystem(p).get(0).getName());

		// getOrganismEcosystem fulfilling query with id to find all plants and
		// animals in ecosystem

		// did enter if
		ev.assignOrganismToEcosystem(new Plant());

		ev.assignOrganismToEcosystem(a);

		Animal a2 = new Animal();
		a2.setName("Platypus");
		a2.setEdiblePlants(plants);
		ev.assignOrganismToEcosystem(p2);
		ev.assignOrganismToEcosystem(a2);
		Animal a3 = new Animal();
		a3.setName("Dog");
		a3.setEdiblePlants(plants);
		ev.assignOrganismToEcosystem(a3);
		
		System.out.println(ev.getEcosystems().size());
		
//		System.out.println(ev.getOrganismById(1).getName());
//		System.out.println(ev.getOrganismById(2).getName());
//		System.out.println(ev.getOrganismById(3).getName());
//		System.out.println(ev.getOrganismById(4).getName());
//		System.out.println(ev.getOrganismById(5).getName());
		
		
		for (Organism organism : ev.getOrganismsInEcosystemByOrganismId(6)) {
			System.out.println(organism.getName());
		}

	}

}
