package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class BuscandoVeiculo3 {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
		
		System.out.println("Buscou veiculo. Será que já executou o SQL???");
		
		System.out.println("Veiculo de código " + veiculo.getCodigo() + " é um " + veiculo.getModelo());

		manager.close();
		JpaUtil.close();
	}

}
