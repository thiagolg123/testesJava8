package br.com.thiago.testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {

	public static void main(String[] args) {
		List<String> listaPalavras = new ArrayList<>();

		listaPalavras.add("alguma");
		listaPalavras.add("coisa");
		listaPalavras.add("abc");
		listaPalavras.add("a");

		Optional<String> opcString = 
				listaPalavras.stream()
					.filter(l -> l.length() <= 1)
					.findAny();

		opcString.ifPresent(s -> System.out.println(s.toString())); //evita problemas com nullPointer sem precisar de 300 ifs, :D
																	// menos de um comando, nao precisa das  {}

		List<ContatoVO> contatos = new ArrayList<>();

		ContatoVO contato = new ContatoVO();
		contato.setNome("thiago");
		contato.setIdade(27);
		contato.setAlgumDouble(2.1);

		contatos.add(contato);

		ContatoVO c2 = new ContatoVO();
		c2.setNome("carol");
		c2.setIdade(22);
		c2.setAlgumDouble(2.5);

		contatos.add(c2);

		int somaDasIdades = 
				contatos.stream()
					.mapToInt(c -> c.getIdade())
					.sum(); // pegando todas as idades da lista e somando, GREAT 
		 
		OptionalDouble opcDouble = 
				contatos.stream()
					.mapToInt(ContatoVO::getIdade)  //invocacao bonita sem o lambda
					.average();
		
		opcDouble.ifPresent(System.out::println); //putz HEHE
		
		System.out.println(somaDasIdades);
		
		contatos.forEach(c -> {
			DaoContao.add(c); 
			System.out.println(c.getNome() +" "+ c.getIdade());
		});

	}
}
