package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class AtualizandoVeiculo {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		
		System.out.println("Ano atual: " + veiculo.getAnoModelo());
		veiculo.setAnoModelo(2012);
		System.out.println("Novo ano: " + veiculo.getAnoModelo());
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
