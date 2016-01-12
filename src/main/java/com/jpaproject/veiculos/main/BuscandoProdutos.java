package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.Produto;
import com.jpaproject.veiculos.util.JpaUtil;

public class BuscandoProdutos {

	public static void main(String[] args) {

		//Utilizando busca com fetch LAZY, logo não a inner join entre as tabelas e assim os dados da categoria não ficam expostos.
		EntityManager manager = JpaUtil.getEntityManager();
		
		Produto produto = manager.find(Produto.class, 11L);
		
		System.out.println("Nome: " + produto.getNome());
		
		//O JPA só realiza a consulta a partir dessa linha, pois ele ver a necessidade de acessar dados da categoria.
		System.out.println("Categoria: " + produto.getCategoria().getNome());
		
		manager.close();
		JpaUtil.close();
	}
}
