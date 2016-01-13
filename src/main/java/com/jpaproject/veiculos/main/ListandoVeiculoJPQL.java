package com.jpaproject.veiculos.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ListandoVeiculoJPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();

		// Essa consulta é a mesma que:
		// from Veiculo where anoFabricacao = 2015
		Query query = manager.createQuery(
				"select v from Veiculo v where anoFabricacao = 2015");
		
		List veiculos = query.getResultList();
		
		for (Object obj : veiculos) {
			Veiculo veiculo = (Veiculo) obj;
			System.out.println(veiculo.getModelo() + " - " + veiculo.getFabricante()
			+ ": " + veiculo.getAnoFabricacao());
		}

		manager.close();
		JpaUtil.close();
	}

}
