package com.jpaproject.veiculos.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConsultaTipadaVeiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();

		TypedQuery<Veiculo> query = manager.createQuery("from Veiculo", Veiculo.class);

		List<Veiculo> veiculos = query.getResultList();

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante()
			+ ": " + veiculo.getAnoFabricacao());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
