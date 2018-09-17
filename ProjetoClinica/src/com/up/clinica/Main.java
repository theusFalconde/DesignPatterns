package com.up.clinica;

import com.up.clinica.dal.AnimalDAO;
import com.up.clinica.dal.EspecieDAO;
import com.up.clinica.model.Animal;
import com.up.clinica.model.Especie;

public class Main {
	public static void main(String[] args) {
		System.out.println("Olá Mundo");
		try {
			EspecieDAO especieDAO = new EspecieDAO();
			for(Especie e : especieDAO.listar()) {
				System.out.println(e.getNome());
			}
			AnimalDAO animalDAO = new AnimalDAO();
			for (Animal a : animalDAO.listar()) {
				System.out.println(a.getNome());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fim!");	
	}
}