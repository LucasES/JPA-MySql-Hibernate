package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jpaproject.veiculos.util.JpaUtil;

public class ExclusaoUsuariosLote {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Query query = manager.createQuery("delete from Usuario where ativo = false");
		
		int linhasAfetadas = query.executeUpdate();
		
		System.out.println(linhasAfetadas + " registros removidos.");
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
