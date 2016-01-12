package com.jpaproject.veiculos.main;

import java.util.List;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.Cliente;
import com.jpaproject.veiculos.dominio.Pessoa;
import com.jpaproject.veiculos.util.JpaUtil;

public class ListandoClientes {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		List<Cliente> clientes = manager.createQuery("from Cliente", Cliente.class).getResultList();
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome() + " - R$ " + cliente.getRendaMensal());
		}
		
		System.out.println("Consulta polimorfica: ");
		
		List<Pessoa> pessoas = manager.createQuery("from Pessoa", Pessoa.class).getResultList();
		
		for (Pessoa pessoa : pessoas) {
			System.out.print(pessoa.getNome());
			
			if(pessoa instanceof Cliente) {
				System.out.println(" - é um cliente.");
			} else {
				System.out.println(" - é um funcionário.");
			}
		}
		
	}

}
