package com.jpaproject.veiculos.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class SalvandoObjetosDesanexados {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		
		tx.commit();
		manager.close();
		
		veiculo.setValor(new BigDecimal(5000));
		
		manager = JpaUtil.getEntityManager();
		tx = manager.getTransaction();
		tx.begin();
		
		veiculo = manager.merge(veiculo);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
