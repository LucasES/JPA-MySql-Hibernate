package com.jpaproject.veiculos.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.dominio.Veiculo.TipoCombustivel;
import com.jpaproject.veiculos.util.JpaUtil;

public class PersistindoVeiculo {

	public static void main(String[] args) {
		
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
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");
		
		Veiculo veiculo = new Veiculo();
		//Utilizando chaves compostas
		//veiculo.setId(new VeiculoId("ABC-1234", "Uberlândia"));
		veiculo.setFabricante("Hyundai");
		veiculo.setModelo("Ix35");
		veiculo.setAnoFabricacao(2010);
		veiculo.setAnoModelo(2010);
		veiculo.setValor(new BigDecimal(77_200));
		veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo.setDataDeCadastra(new Date());
		veiculo.setEspecificacoes(especificacoes.toString());
		veiculo.setFoto(foto);
		
		manager.persist(veiculo);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}
}
