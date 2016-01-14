package com.jpaproject.veiculos.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jpaproject.veiculos.dominio.Proprietario;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConsultaAssociacoesEJoinVeiculo {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();

		//Inner join utilizado para encontrar os proprietarios dos veiculos
		TypedQuery<Proprietario> query = manager.createQuery(
				"select p from Proprietario p inner join p.veiculos v", Proprietario.class);

		List<Proprietario> resultado = query.getResultList();

		for (Proprietario proprietario : resultado) {
			System.out.println(proprietario.getNome());
		}
		
		//Quantidade de veiculos que cada funcionário tem
		TypedQuery<Object[]> query2 = manager.createQuery(
				"select p.nome, count(v) from Proprietario p "
				+ "inner join p.veiculos v group by p.nome", Object[].class);
		
		List<Object[]> qtd = query2.getResultList();
		
		for (Object[] valores : qtd) {
			System.out.println(valores[0] + " - " + valores[1] + " veiculo(s)");
			}

		
		//Consulta para funcionários que não possuem veiculos
		
		TypedQuery<Object[]> query3 = manager.createQuery(
				"select p.nome, count(v) from Proprietario p "
				+ "left join p.veiculos v group by p.nome", Object[].class);
		
		List<Object[]> qtd2 = query3.getResultList();
		
		for (Object[] valores : qtd2) {
			System.out.println(valores[0] + " - " + valores[1] + " veiculo(s)");
			}
		
		manager.close();
		JpaUtil.close();
	}

}
