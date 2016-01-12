package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.Categoria;
import com.jpaproject.veiculos.dominio.Produto;
import com.jpaproject.veiculos.util.JpaUtil;

public class BuscandoCategorias {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Categoria categoria = manager.find(Categoria.class, 8L);
		
		System.out.println("Categoria: " + categoria.getNome());
		
		for (Produto produtos : categoria.getProdutos()) {
			System.out.println("Produto: "+ produtos.getNome());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
