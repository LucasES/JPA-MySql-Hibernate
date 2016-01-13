package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.CentroCusto;
import com.jpaproject.veiculos.util.JpaUtil;

public class BuscandoCentroCustoCacheSegundoNivel {

	public static void main(String[] args) {

		EntityManager manager1 = JpaUtil.getEntityManager();
		CentroCusto cc1 = manager1.find(CentroCusto.class, 25L);
		
		System.out.println("Centro de custo: "+ cc1.getNome());
		
		manager1.close();
		
		System.out.println("--------");
		
		EntityManager manager2 = JpaUtil.getEntityManager();
		CentroCusto cc2 = manager2.find(CentroCusto.class, 25L);
		
		System.out.println("Centro de custo: " + cc2.getNome());
		
		manager2.close();
		JpaUtil.close();
		
	}
}
