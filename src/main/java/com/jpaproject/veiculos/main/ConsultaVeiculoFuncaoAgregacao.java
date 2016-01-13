package com.jpaproject.veiculos.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jpaproject.veiculos.dominio.TotalCarroPorAno;
import com.jpaproject.veiculos.util.JpaUtil;

public class ConsultaVeiculoFuncaoAgregacao {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<TotalCarroPorAno> query = manager.createQuery(
				"select new com.jpaproject.veiculos.dominio.TotalCarroPorAno(v.anoFabricacao, "
				+ "avg(v.valor), count(v))"
				+ "from Veiculo v group by v.anoFabricacao", TotalCarroPorAno.class);
		
		List<TotalCarroPorAno> resultado = query.getResultList();
		
		for (TotalCarroPorAno valores : resultado) {
			System.out.println("Ano: " + valores.getAnoFabricacao()
			+ " - Preço Médio: " + valores.getMediaPreco()
			+ " - Quantidade: " + valores.getQuantidadeCarros());
		}
		
		manager.close();
		JpaUtil.close();
	}

}
