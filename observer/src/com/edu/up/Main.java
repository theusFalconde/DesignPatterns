package com.edu.up;

import java.util.Date;

import com.edu.up.observe.ObservadorPostagemEmail;
import com.edu.up.observe.ObservadorPostagemSMS;
import com.edu.up.postagem.PostagemConvencional;
import com.edu.up.postagem.PostagemSedex;

public class Main {
	public static void main(String[] args) {
		ObservadorPostagemSMS sms1 = new ObservadorPostagemSMS(12345);
		ObservadorPostagemEmail email1 = new ObservadorPostagemEmail("gustavo@monteiro.com.br");
		
		ObservadorPostagemSMS sms2 = new ObservadorPostagemSMS(67890);
		ObservadorPostagemEmail email2 = new ObservadorPostagemEmail("monteiro@gustavo.com.br");
		
		PostagemConvencional convencional = new PostagemConvencional("Curitiba", "Florianópolis", false);
		convencional.adicionarObservador(sms1);
		convencional.adicionarObservador(email1);
		
		convencional.setDestino("São Paulo");
		convencional.setDataHoraPostagem(new Date());
		convencional.setItemEntregue(true);		
		
		PostagemSedex sedex = new PostagemSedex("Curitiba", "São Paulo", true);
		sedex.adicionarObservador(sms2);
		sedex.adicionarObservador(email2);
		
		sedex.setDataHoraPostagem(new Date());
		sedex.setUltimaLocalidade("Londrina");
		sedex.setUltimaLocalidade("Rio de Janeiro");
		sedex.setUltimaLocalidade("São Paulo");
		sedex.setItemEntregue(true);
		
		System.out.println("Todas as Localidades");
		for(String loc : sedex.getLocalidades()) {
			System.out.println("Localidade: " + loc);
		}
	}
}
