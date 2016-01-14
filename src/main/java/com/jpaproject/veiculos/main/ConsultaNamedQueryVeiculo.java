package com.jpaproject.veiculos.main;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConsultaNamedQueryVeiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();

		TypedQuery<Veiculo> query = manager.createNamedQuery(
				"Veiculo.comProprietarioPorValor", Veiculo.class);

		query.setParameter("valor", new BigDecimal(10_000));

		List<Veiculo> veiculos = query.getResultList();

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " - "
					+ veiculo.getProprietario().getNome());
		}

		//Utilizando a consulta do arquivo externo orm.xml
		TypedQuery<Veiculo> query2 = manager.createNamedQuery(
				"Veiculo.anoFabricacaoMenor", Veiculo.class);

		query2.setParameter("ano", 2016);
		List<Veiculo> veiculos2 = query.getResultList();

		for (Veiculo veiculo : veiculos2) {
			System.out.println(veiculo.getModelo() + " - "
					+ veiculo.getProprietario().getNome());
		}

		manager.close();
		JpaUtil.close();
	}

}
