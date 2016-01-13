package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Usuario;
import com.jpaproject.veiculos.util.JpaUtil;

public class PersistindoUsuario {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Usuario u1 = new Usuario();
		u1.setEmail("joao@mail.com");
		u1.setAtivo(true);
		
		Usuario u2 = new Usuario();
		u2.setEmail("adail@gmail.com");
		u2.setAtivo(true);
		
		Usuario u3 = new Usuario();
		u3.setEmail("sebastiao123@gmail.com");
		u3.setAtivo(true);
		
		manager.persist(u1);
		manager.persist(u2);
		manager.persist(u3);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
