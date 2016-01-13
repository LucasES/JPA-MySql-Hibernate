package com.jpaproject.veiculos.main;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Animal;
import com.jpaproject.veiculos.util.JpaUtil;

public class PersistindoAnimalPostPersist {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(2011, 5, 21);

		Animal animal = new Animal();
		animal.setNome("Big Funny");
		animal.setDataNascimento(dataNascimento.getTime());
		//A adição da anotação @EntityListener faz essa linha ser desnecessária.
		//animal.setDataUltimaAtualizacao(new Date());

		System.out.println("Idade antes de persistir: " + animal.getIdade());

		manager.persist(animal);

		System.out.println("Idade depois de persistir: " + animal.getIdade());

		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
