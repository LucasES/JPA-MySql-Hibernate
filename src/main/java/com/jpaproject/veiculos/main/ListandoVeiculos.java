package com.jpaproject.veiculos.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ListandoVeiculos {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();

		Query query = manager.createQuery("from Veiculo");
		List<Veiculo> veiculos = query.getResultList();
		
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getCodigo() + " - "
					+ veiculo.getFabricante() + " "
					+ veiculo.getModelo() + ", ano "
					+ veiculo.getAnoFabricacao() + "/"
					+ veiculo.getAnoModelo() + " por "
					+ "R$" + veiculo.getValor());
		}
		
		manager.close();
		JpaUtil.close();
	}

}
