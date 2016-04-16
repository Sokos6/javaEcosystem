package com.afn;

public class Organism {

	private String name;
	private int id;
	private int ecosystemId;
	private static int numOrganisms;
	
	public Organism() {
		id = ++numOrganisms;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEcosystemId() {
		return ecosystemId;
	}
	public void setEcosystemId(int ecosystemId) {
		this.ecosystemId = ecosystemId;
	}
}
