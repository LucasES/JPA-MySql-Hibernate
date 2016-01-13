package com.jpaproject.veiculos.main;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConsultaPaginacaoVeiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		EntityManager manager = JpaUtil.getEntityManager();

		//Consulta estática
//		TypedQuery<Veiculo> query = manager.createQuery("from Veiculo", Veiculo.class);
//		query.setFirstResult(0);
//		query.setMaxResults(10);
//
//		List<Veiculo> veiculos = query.getResultList();
//
//		for (Veiculo veiculo : veiculos) {
//			System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante()
//			+ ": " + veiculo.getAnoFabricacao());
//		}

		//Consulta dinâmica. Usuário deseja quantos resultos quer ver.

		Scanner scanner = new Scanner(System.in);

		System.out.println("Registros por página: ");
		int registrosPorPagina = scanner.nextInt();
		int numeroDaPagina = 0;

		TypedQuery<Veiculo> queryPaginacao = manager.createQuery("from Veiculo", Veiculo.class);

		do {
			System.out.println("Numero da página: ");
			numeroDaPagina = scanner.nextInt();

			if(numeroDaPagina != 0) {
				int primeiroRegistro = (numeroDaPagina - 1) * registrosPorPagina;

				queryPaginacao.setFirstResult(primeiroRegistro);
				queryPaginacao.setMaxResults(registrosPorPagina);
				List<Veiculo> veiculosPaginacao = queryPaginacao.getResultList();

				for (Veiculo veiculo : veiculosPaginacao) {
					System.out.println(veiculo.getModelo() + " "
							+ veiculo.getFabricante()
							+ ": " + veiculo.getAnoFabricacao());
				}

			}

		} while (numeroDaPagina != 0);

		manager.close();
		JpaUtil.close();
	}
}
