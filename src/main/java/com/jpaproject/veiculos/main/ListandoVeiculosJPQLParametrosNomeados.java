package com.jpaproject.veiculos.main;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ListandoVeiculosJPQLParametrosNomeados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();
		
		Query query = manager.createQuery(
				"from Veiculo where anoFabricacao >= :ano and valor <= :preco");
		
		query.setParameter("ano", 2014);
		query.setParameter("preco", new BigDecimal(100_500));
		
		List veiculos = query.getResultList();
		
		if (veiculos.size() > 0) {
			for (Object obj : veiculos) {
				Veiculo veiculo = (Veiculo) obj;
				
				System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante()
				+ ": " + veiculo.getAnoFabricacao());
			}
		} else 
			System.out.println("Não há veiculos");
		
		manager.close();
		JpaUtil.close();
	}

}
