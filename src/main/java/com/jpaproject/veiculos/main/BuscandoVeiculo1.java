package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class BuscandoVeiculo1 {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		
		System.out.println("Ve�culo: "+ veiculo.getModelo());
		System.out.println("------");
		System.out.println(veiculo.getEspecificacoes());
		
		manager.close();
		JpaUtil.close();
	}

}
