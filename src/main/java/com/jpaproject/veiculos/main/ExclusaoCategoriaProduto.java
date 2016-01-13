package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Categoria;
import com.jpaproject.veiculos.dominio.Produto;
import com.jpaproject.veiculos.util.JpaUtil;

//Exclusão de produtos órfãos, para isso acontecer foi adicionado a opção orphanRemoval = true na
// anotação @Column da propriedade getProdutos da entidade Categoria.

public class ExclusaoCategoriaProduto {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Categoria categoria = manager.find(Categoria.class, 12L);
		Produto produto = manager.find(Produto.class, 13L);
		
		categoria.getProdutos().remove(produto);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}
}
