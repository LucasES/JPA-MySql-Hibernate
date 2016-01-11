package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class TesteCachePrimeiroNivel {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo1 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou um veiculo pela primeira vez...");
		
		Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou um veiculo pela segunda vez...");
		
		System.out.println("Mesmo veiculo? " + (veiculo1 == veiculo2));

		manager.close();
		JpaUtil.close();
	}

}
