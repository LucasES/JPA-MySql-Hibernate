package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Categoria;
import com.jpaproject.veiculos.util.JpaUtil;

public class ExclusaoCategoriaCascade {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Categoria categoria = manager.find(Categoria.class, 7L);
		
		manager.remove(categoria);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
