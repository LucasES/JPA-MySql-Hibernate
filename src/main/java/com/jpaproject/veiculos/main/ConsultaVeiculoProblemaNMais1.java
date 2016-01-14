package com.jpaproject.veiculos.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConsultaVeiculoProblemaNMais1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();

		//Várias consultas são realizadas para buscar o mesmo proprietário de um veiculo.
		TypedQuery<Veiculo> query = manager.createQuery("from Veiculo v", Veiculo.class);

		List<Veiculo> veiculos = query.getResultList();

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " - "
					+ veiculo.getProprietario().getNome());
		}

		//utilizando inner join fetch para retornar os valores da consulta

		TypedQuery<Veiculo> query2 = manager.createQuery(
				"from Veiculo v inner join fetch v.proprietario", Veiculo.class);

		List<Veiculo> veiculos2 = query2.getResultList();
		
		for (Veiculo veiculo : veiculos2) {
			System.out.println(veiculo.getModelo() + " - "
					+ veiculo.getProprietario().getNome());
		}

		manager.close();
		JpaUtil.close();
	}

}
