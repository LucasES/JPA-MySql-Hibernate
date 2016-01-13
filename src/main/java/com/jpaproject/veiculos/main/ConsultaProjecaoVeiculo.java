package com.jpaproject.veiculos.main;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jpaproject.veiculos.dominio.PrecoVeiculo;
import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConsultaProjecaoVeiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();

		//Essa consulta retorna todos os dados da tabela veiculo.
		//Mas só queremos os modelos.
		TypedQuery<Veiculo> query = manager.createQuery("from Veiculo",
				Veiculo.class);

		List<Veiculo> veiculos = query.getResultList();

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo());
		}

		//Agora estamos consultando somente os modelos da tabela Veiculo.
		TypedQuery<String> queryProjecao = manager.createQuery(
				"select modelo from Veiculo", String.class);

		List<String> modelos = queryProjecao.getResultList();

		for (String modelo : modelos) {
			System.out.println(modelo);
		}

		TypedQuery<Object[]> queryComplexa = manager.createQuery(
				"select modelo, valor from Veiculo", Object[].class);

		List<Object[]> resultado = queryComplexa.getResultList();

		for (Object[] valores : resultado) {
			String modelo = (String) valores[0];
			BigDecimal valor = (BigDecimal) valores[1];
			System.out.println(modelo + " - " + valor);
		}

		//Consulta utilizando um objeto para instancia-lo
		//Má prática!!!
		TypedQuery<PrecoVeiculo> queryUtilizandoNew = manager.createQuery(
				"select new com.jpaproject.veiculos.dominio.PrecoVeiculo(modelo, valor) from Veiculo",
				PrecoVeiculo.class);
		List<PrecoVeiculo> precos = queryUtilizandoNew.getResultList();
		for (PrecoVeiculo preco : precos) {
			System.out.println(preco.getModelo() + " - " + preco.getValor());
		}


		manager.close();
		JpaUtil.close();
	}
}
