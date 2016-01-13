package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import com.jpaproject.veiculos.dominio.Usuario;
import com.jpaproject.veiculos.util.JpaUtil;

public class BuscandoUsuarioLockingPessimista {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Usuario usuario = manager.find(Usuario.class, 20L,
				LockModeType.PESSIMISTIC_WRITE);
		
		System.out.println("Email: " + usuario.getEmail());
		
		manager.close();
		JpaUtil.close();
	}

}
