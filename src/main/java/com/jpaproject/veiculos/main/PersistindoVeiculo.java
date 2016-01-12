package com.jpaproject.veiculos.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Proprietario;
import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.dominio.Veiculo.TipoCombustivel;
import com.jpaproject.veiculos.util.JpaUtil;

public class PersistindoVeiculo {

	public static void main(String[] args) {
//		
//		Path path = FileSystems.getDefault().getPath("img/ix35.jpg");
//		byte[] foto = null;
//		
//		try {
//			foto = Files.readAllBytes(path);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		EntityManager manager = JpaUtil.getEntityManager();
//		EntityTransaction tx = manager.getTransaction();
//		tx.begin();
//		
//		StringBuilder especificacoes = new StringBuilder();
//		
//		especificacoes.append("Carro em excelente estado.\n");
//		especificacoes.append("Completo, menos ar.\n");
//		especificacoes.append("Primeiro dono, com manual de instru��o ");
//		especificacoes.append("e todas as revis�es feitas.\n");
//		especificacoes.append("IPVA pago, aceita financiamento.");
//		
//		Veiculo veiculo = new Veiculo();
//		//Utilizando chaves compostas
//		//veiculo.setId(new VeiculoId("ABC-1234", "Uberl�ndia"));
//		veiculo.setFabricante("Hyundai");
//		veiculo.setModelo("Ix35");
//		veiculo.setAnoFabricacao(2010);
//		veiculo.setAnoModelo(2010);
//		veiculo.setValor(new BigDecimal(77_200));
//		veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
//		veiculo.setDataDeCadastra(new Date());
//		veiculo.setEspecificacoes(especificacoes.toString());
//		veiculo.setFoto(foto);
		
		
		//Tipo de persist�ncia utilizando Embeddable, todas as propriedades est�o na mesma tabela
		
//		Path path2 = FileSystems.getDefault().getPath("img/golf-2015.jpg");
//		byte[] foto2 = null;
//		
//		try {
//			foto2 = Files.readAllBytes(path2);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Proprietario proprietario = new Proprietario();
//		proprietario.setNome("Lucas Ara�jo");
//		proprietario.setTelefone("997487584");
//		
//		Veiculo veiculo2 = new Veiculo();
//		//Utilizando chaves compostas
//		//veiculo.setId(new VeiculoId("ABC-1234", "Uberl�ndia"));
//		veiculo2.setFabricante("VW");
//		veiculo2.setModelo("Golf");
//		veiculo2.setAnoFabricacao(2015);
//		veiculo2.setAnoModelo(2015);
//		veiculo2.setValor(new BigDecimal(95_500));
//		veiculo2.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
//		veiculo2.setDataDeCadastra(new Date());
//		veiculo2.setFoto(foto2);
//		veiculo2.setProprietario(proprietario);
		
		
		//Persist�ncia de dados utilizando a rela��o de um para um de propriet�rio com veiculo.
		
		Path path = FileSystems.getDefault().getPath("img/ix35.jpg");
		byte[] foto = null;
		
		try {
			foto = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		StringBuilder especificacoes = new StringBuilder();
		
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instru��o ");
		especificacoes.append("e todas as revis�es feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Lucas Ara�jo");
		proprietario.setTelefone("997487584");
		
		manager.persist(proprietario);
		
		Veiculo veiculo = new Veiculo();
		//Utilizando chaves compostas
		//veiculo.setId(new VeiculoId("ABC-1234", "Uberl�ndia"));
		veiculo.setFabricante("Hyundai");
		veiculo.setModelo("Ix35");
		veiculo.setAnoFabricacao(2010);
		veiculo.setAnoModelo(2010);
		veiculo.setValor(new BigDecimal(77_200));
		veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo.setDataDeCadastra(new Date());
		veiculo.setEspecificacoes(especificacoes.toString());
		veiculo.setFoto(foto);
		veiculo.setProprietario(proprietario);
		
		
		manager.persist(veiculo);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}
}
