package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class BuscandoVeiculo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
		
		System.out.println("Veiculo de código " + veiculo.getCodigo() + " é um " + veiculo.getModelo());
		
		manager.close();
		JpaUtil.close();		
	}

}
