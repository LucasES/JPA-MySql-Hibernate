package com.jpaproject.veiculos.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class AtualizandoVeiculo {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		
		System.out.println("Valor atual: R$ " + veiculo.getValor());
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(500)));
		System.out.println("Novo valor: R$ " + veiculo.getValor());
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
