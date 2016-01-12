package com.jpaproject.veiculos.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpaproject.veiculos.dominio.Proprietario;
import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ListandoVeiculos {

	public static void main(String[] args) {

//		EntityManager manager = JpaUtil.getEntityManager();

		//Query utilizada quando a entidade veículo não possuia a relação com proprietário.
		
//		Query query = manager.createQuery("from Veiculo");
//		List<Veiculo> veiculos = query.getResultList();
//		
//		for (Veiculo veiculo : veiculos) {
//			System.out.println(veiculo.getCodigo() + " - "
//					+ veiculo.getFabricante() + " "
//					+ veiculo.getModelo() + ", ano "
//					+ veiculo.getAnoFabricacao() + "/"
//					+ veiculo.getAnoModelo() + " por "
//					+ "R$" + veiculo.getValor());
//		}
//		
		
		//Esta consulta realiza uma consulta em proprietário para cada veiculo encontrado
//		EntityManager manager = JpaUtil.getEntityManager();
//		List<Veiculo> veiculos = manager.createQuery("from Veiculo", Veiculo.class)
//				.getResultList();
//
//		for (Veiculo veiculo : veiculos) {
//			System.out.println(veiculo.getModelo() + " - "
//					+ veiculo.getProprietario().getNome());
//		}
//		manager.close();
//		JpaUtil.close();	
		
		
		//Esta consulta realiza um inner join ou left join, realizando somente um select. CONSULTA REALIZADA PARA LISTAR EM MAPEAMENTO UM PARA UM.
		
//		EntityManager manager = JpaUtil.getEntityManager();
//		
//		Veiculo veiculo = manager.find(Veiculo.class, 1L);
//		
//		
//		System.out.println(veiculo.getModelo() + " - "
//				+ veiculo.getProprietario().getNome());
//
//		Proprietario proprietario = manager.find(Proprietario.class, 1L);
//		System.out.println(proprietario.getVeiculo().getModelo() + " - "
//				+ proprietario.getNome());
//		
//		manager.close();
//		JpaUtil.close();
		
		
		//Consultando um proprietario e listando todos os seus carros. CONSULTA REALIZADA NA RELAÇÃO UM PARA MUITOS ENTRE VEÍCULO E PROPRIETÁRIO.
		EntityManager manager = JpaUtil.getEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		
		System.out.println("Proprietario: " + proprietario.getNome());
		
		for (Veiculo veiculo : proprietario.getVeiculos()) {
			System.out.println("Veículo: " + veiculo.getModelo());
		}
		
		manager.close();
		JpaUtil.close();
	}

}
