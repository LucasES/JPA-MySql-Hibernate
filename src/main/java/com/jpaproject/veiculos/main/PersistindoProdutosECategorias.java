package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Categoria;
import com.jpaproject.veiculos.dominio.Produto;
import com.jpaproject.veiculos.util.JpaUtil;

public class PersistindoProdutosECategorias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Categoria categoria = new Categoria();
		categoria.setNome("Bebidas");
		
		Produto produto1 = new Produto();
		produto1.setNome("Red Label");
		produto1.setCategoria(categoria);
		
		Produto produto2 = new Produto();
		produto2.setNome("Ballantines");
		produto2.setCategoria(categoria);
		
		Produto produto3 = new Produto();
		produto3.setNome("Old par");
		produto3.setCategoria(categoria);
		
		manager.persist(categoria);
		manager.persist(produto1);
		manager.persist(produto2);
		manager.persist(produto3);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
