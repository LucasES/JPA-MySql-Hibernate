package com.jpaproject.veiculos.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConsultaVeiculoJPQLQueryNativa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();

		Query query = manager.createNativeQuery("select * from veiculo", Veiculo.class);
		
		List<Veiculo> veiculos = query.getResultList();
		
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " - "
					+ veiculo.getProprietario().getNome());
		}

		manager.close();
		JpaUtil.close();

	}

}
