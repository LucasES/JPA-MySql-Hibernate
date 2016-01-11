package com.jpaproject.veiculos.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class PersistindoVeiculo {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("VW");
		veiculo.setModelo("Gol");
		veiculo.setAnoFabricacao(2009);
		veiculo.setAnoModelo(2009);
		veiculo.setValor(new BigDecimal(21000));
		
		manager.persist(veiculo);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}
}
