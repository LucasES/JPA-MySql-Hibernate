package com.jpaproject.veiculos.main;

import javax.persistence.Persistence;
public class CriaTabelas {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("AlgaWorksPU");
	}
}