package com.jpaproject.veiculos.main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jpaproject.veiculos.dominio.Veiculo;
import com.jpaproject.veiculos.util.JpaUtil;

public class ExibindoImagem {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		
//		if(veiculo.getFoto() != null) {
//			BufferedImage img = null; 
//			try {
//				img = ImageIO.read(new ByteArrayInputStream(veiculo.getFoto()));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
//		} else {
//			System.out.println("Veiculo não possui foto.");
//		}
		
		manager.close();
		JpaUtil.close();
	}
}
