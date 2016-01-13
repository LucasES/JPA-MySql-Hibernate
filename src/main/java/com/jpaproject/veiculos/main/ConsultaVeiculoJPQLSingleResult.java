package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jpaproject.veiculos.util.JpaUtil;

public class ConsultaVeiculoJPQLSingleResult {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<Long> query = manager.createQuery(
				"select count(v) from Veiculo v ", Long.class);
		
		Long quantidadeVeiculos = query.getSingleResult();
		System.out.println("Quantidade de veículos: " + quantidadeVeiculos);
		
		manager.close();
		JpaUtil.close();
	}
}
