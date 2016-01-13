package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Usuario;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConcorrenciaELockingUsuario {

	
//	Como você pode imaginar, quando fizemos commit no primeiro EntityManager,
//	a alteração foi sincronizada com o banco de dados. O outro commit, do segundo
//	EntityManager, também sincronizou a alteração feita no usúario associado a este
//	contexto de persistência, substituindo a modificação anterior.
	
	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		EntityManager manager2 = JpaUtil.getEntityManager();
		EntityTransaction tx2 = manager2.getTransaction();
		tx2.begin();
		
		Usuario u1 = manager.find(Usuario.class, 17L);
		u1.setEmail("joao@algaworks.com");
		
		Usuario u2 = manager2.find(Usuario.class, 20L);
		u2.setEmail("lucas@algaworks.com");
		
		// faz commit na primeira transação
		tx.commit();
		manager.close();
		
		// faz commit na segunda transação
		tx2.commit();
		manager2.close();
		
		JpaUtil.close();
		
	}
}
