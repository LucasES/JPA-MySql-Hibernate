package com.jpaproject.veiculos.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Acessorio;
import com.jpaproject.veiculos.dominio.Proprietario;
import com.jpaproject.veiculos.dominio.Telefone;
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
//		especificacoes.append("Primeiro dono, com manual de instrução ");
//		especificacoes.append("e todas as revisões feitas.\n");
//		especificacoes.append("IPVA pago, aceita financiamento.");
//		
//		Veiculo veiculo = new Veiculo();
//		//Utilizando chaves compostas
//		//veiculo.setId(new VeiculoId("ABC-1234", "Uberlândia"));
//		veiculo.setFabricante("Hyundai");
//		veiculo.setModelo("Ix35");
//		veiculo.setAnoFabricacao(2010);
//		veiculo.setAnoModelo(2010);
//		veiculo.setValor(new BigDecimal(77_200));
//		veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
//		veiculo.setDataDeCadastra(new Date());
//		veiculo.setEspecificacoes(especificacoes.toString());
//		veiculo.setFoto(foto);
		
		
		//Tipo de persistência utilizando Embeddable, todas as propriedades estão na mesma tabela
		
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
//		proprietario.setNome("Lucas Araújo");
//		proprietario.setTelefone("997487584");
//		
//		Veiculo veiculo2 = new Veiculo();
//		//Utilizando chaves compostas
//		//veiculo.setId(new VeiculoId("ABC-1234", "Uberlândia"));
//		veiculo2.setFabricante("VW");
//		veiculo2.setModelo("Golf");
//		veiculo2.setAnoFabricacao(2015);
//		veiculo2.setAnoModelo(2015);
//		veiculo2.setValor(new BigDecimal(95_500));
//		veiculo2.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
//		veiculo2.setDataDeCadastra(new Date());
//		veiculo2.setFoto(foto2);
//		veiculo2.setProprietario(proprietario);
		
		
		//Persistência de dados utilizando a relação de um para um de proprietário com veiculo.
		
//		Path path = FileSystems.getDefault().getPath("img/golf-2015.jpg");
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
//		especificacoes.append("Carro Novo.\n");
//		especificacoes.append("Completo.\n");
//		especificacoes.append("Primeiro dono, com manual de instrução ");
//		especificacoes.append("e todas as revisões feitas.\n");
//		especificacoes.append("IPVA pago, aceita financiamento.");
//		
//		Proprietario proprietario = new Proprietario();
//		proprietario.setNome("Lucas Araújo");
//		proprietario.setTelefone("997487584");
//		
//		manager.persist(proprietario);
//		
//		Veiculo veiculo = new Veiculo();
//		//Utilizando chaves compostas
//		//veiculo.setId(new VeiculoId("ABC-1234", "Uberlândia"));
//		veiculo.setFabricante("VW");
//		veiculo.setModelo("Golf");
//		veiculo.setAnoFabricacao(2015);
//		veiculo.setAnoModelo(2015);
//		veiculo.setValor(new BigDecimal(99_200));
//		veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
//		veiculo.setDataDeCadastra(new Date());
//		veiculo.setEspecificacoes(especificacoes.toString());
//		veiculo.setFoto(foto);
//		veiculo.setProprietario(proprietario);
//		
//		
//		manager.persist(veiculo);
//		
//		tx.commit();
//		manager.close();
//		JpaUtil.close();
		
		
		//Persistência de dados utilizando o relacionamento de muitos para um entre Veículo e Proprietário.
		
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
//		EntityManager manager = JpaUtil.getEntityManager();
//		EntityTransaction tx = manager.getTransaction();
//		tx.begin();
//		
//		StringBuilder especificacoes = new StringBuilder();
//		
//		especificacoes.append("Carro Novo.\n");
//		especificacoes.append("Completo.\n");
//		especificacoes.append("Primeiro dono, com manual de instrução ");
//		especificacoes.append("e todas as revisões feitas.\n");
//		especificacoes.append("IPVA pago, aceita financiamento.");
//		
//		Proprietario proprietario = new Proprietario();
//		proprietario.setNome("Lucas Araújo");
//		proprietario.setTelefone("997487584");
//		
//		manager.persist(proprietario);
//		
//		Veiculo veiculo = new Veiculo();
//		//Utilizando chaves compostas
//		//veiculo.setId(new VeiculoId("ABC-1234", "Uberlândia"));
//		veiculo.setFabricante("Hyundai");
//		veiculo.setModelo("ix35");
//		veiculo.setAnoFabricacao(2015);
//		veiculo.setAnoModelo(2015);
//		veiculo.setValor(new BigDecimal(99_200));
//		veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
//		veiculo.setDataDeCadastra(new Date());
//		veiculo.setEspecificacoes(especificacoes.toString());
//		veiculo.setFoto(foto);
//		veiculo.setProprietario(proprietario);
//		
//		
//		manager.persist(veiculo);
//		
//		
//		Veiculo veiculo2 = new Veiculo();
//		//Utilizando chaves compostas
//		//veiculo.setId(new VeiculoId("ABC-1234", "Uberlândia"));
//		veiculo2.setFabricante("VW");
//		veiculo2.setModelo("Golf GTI");
//		veiculo2.setAnoFabricacao(2015);
//		veiculo2.setAnoModelo(2015);
//		veiculo2.setValor(new BigDecimal(99_200));
//		veiculo2.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
//		veiculo2.setDataDeCadastra(new Date());
//		veiculo2.setFoto(foto2);
//		veiculo2.setProprietario(proprietario);
//		
//		
//		manager.persist(veiculo2);
//		
//		tx.commit();
//		manager.close();
//		JpaUtil.close();
		
		
		//Persistindo dados 
		Path path = FileSystems.getDefault().getPath("img/ix35.jpg");
		byte[] foto = null;
		
		try {
			foto = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Path path2 = FileSystems.getDefault().getPath("img/golf-2015.jpg");
		byte[] foto2 = null;
		
		try {
			foto2 = Files.readAllBytes(path2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		StringBuilder especificacoes = new StringBuilder();
		
		especificacoes.append("Carro Novo.\n");
		especificacoes.append("Completo.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Lucas Araújo");
		proprietario.getTelefones().add(new Telefone("85", "9 9433-3888", null));
		proprietario.getTelefones().add(new Telefone("85", "9 9422-3434", "104"));
		
		manager.persist(proprietario);
		
		Acessorio alarme = new Acessorio();
		alarme.setDescricao("Alarme");
		
		Acessorio arCondicionado = new Acessorio();
		arCondicionado.setDescricao("Ar condicionado");
		
		Acessorio bancosDeCouro = new Acessorio();
		bancosDeCouro.setDescricao("Bancos de couro");
		
		Acessorio direcaoHidraulica = new Acessorio();
		direcaoHidraulica.setDescricao("Direção hidráulica");
		// persiste acessórios
		
		manager.persist(alarme);
		manager.persist(arCondicionado);
		manager.persist(bancosDeCouro);
		manager.persist(direcaoHidraulica);
		
		Veiculo veiculo = new Veiculo();
		//Utilizando chaves compostas
		//veiculo.setId(new VeiculoId("ABC-1234", "Uberlândia"));
		veiculo.setFabricante("Hyundai");
		veiculo.setModelo("ix35");
		veiculo.setAnoFabricacao(2015);
		veiculo.setAnoModelo(2015);
		veiculo.setValor(new BigDecimal(99_200));
		veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo.setDataDeCadastra(new Date());
		veiculo.setEspecificacoes(especificacoes.toString());
		veiculo.setFoto(foto);
		veiculo.setProprietario(proprietario);
		veiculo.getAcessorios().add(alarme);
		veiculo.getAcessorios().add(arCondicionado);
		
		manager.persist(veiculo);
		
		Veiculo veiculo2 = new Veiculo();
		//Utilizando chaves compostas
		//veiculo.setId(new VeiculoId("ABC-1234", "Uberlândia"));
		veiculo2.setFabricante("VW");
		veiculo2.setModelo("Golf GTI");
		veiculo2.setAnoFabricacao(2015);
		veiculo2.setAnoModelo(2015);
		veiculo2.setValor(new BigDecimal(99_200));
		veiculo2.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo2.setDataDeCadastra(new Date());
		veiculo2.setFoto(foto2);
		veiculo2.setProprietario(proprietario);
		veiculo2.getAcessorios().add(alarme);
		veiculo2.getAcessorios().add(arCondicionado);
		veiculo2.getAcessorios().add(bancosDeCouro);
		veiculo2.getAcessorios().add(direcaoHidraulica);
		
		
		manager.persist(veiculo2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}
}
