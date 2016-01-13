package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Usuario;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConcorrenciaELockingUsuario {

	
//	Como voc� pode imaginar, quando fizemos commit no primeiro EntityManager,
//	a altera��o foi sincronizada com o banco de dados. O outro commit, do segundo
//	EntityManager, tamb�m sincronizou a altera��o feita no us�ario associado a este
//	contexto de persist�ncia, substituindo a modifica��o anterior.
	
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
		
		// faz commit na primeira transa��o
		tx.commit();
		manager.close();
		
		// faz commit na segunda transa��o
		tx2.commit();
		manager2.close();
		
		JpaUtil.close();
		
	}
}
