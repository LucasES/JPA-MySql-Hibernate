package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.Acessorio;
import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ListandoAcessoriosVeiculo {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		
		System.out.println("Veiculo: " + veiculo.getModelo());
		
		for (Acessorio acessorio : veiculo.getAcessorios()) {
			System.out.println("Acessorio: " + acessorio.getDescricao());
		}
	}
}
