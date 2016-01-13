package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.CentroCusto;
import com.jpaproject.veiculos.util.JpaUtil;

public class PersistindoCentroCusto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		CentroCusto cc1 = new CentroCusto();
		cc1.setNome("Tecnologia");
		
		
		CentroCusto cc2 = new CentroCusto();
		cc2.setNome("Comercial");
		
		manager.persist(cc1);
		manager.persist(cc2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
