package com.jpaproject.veiculos.main;

import javax.persistence.EntityManager;

import com.jpaproject.veiculos.dominio.Proprietario;
import com.jpaproject.veiculos.dominio.Telefone;
import com.jpaproject.veiculos.util.JpaUtil;

public class ListarTelefonesProprietario {
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		
		System.out.println("Proprietario: " + proprietario.getNome());
		
//		Utilizado quando n�o se utiliza a classe Telefone utilizando a anota��o @Embeddable
//		for (String telefones : proprietario.getTelefone()) {
//			System.out.println("Telefone: " + telefones);
//		}
		
		//Listando os telefones que est�o na classe embutida
		
//		for (Telefone telefone : proprietario.getTelefones()) {
//			System.out.println("Telefone: (" + telefone.getPrefixo() + ") "
//					+ telefone.getNumero()
//					+ (telefone.getRamal() != null ? " x" + telefone.getRamal() : ""));
//		}
	}
}
