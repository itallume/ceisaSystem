package ceisaSystem;

import java.util.Scanner;

public class program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Item calcinha = new Item("calcinha", 10, 5.00);
		System.out.println("valor total do estoque com "+ calcinha.getEstoque() + " unidades: "+ calcinha.valorEmEstoque());
		calcinha.adicionarAoEstoque(10);
		System.out.println("valor total do estoque com "+ calcinha.getEstoque() + " unidades: "+calcinha.valorEmEstoque());
		calcinha.removerDoEstoque(5);
		System.out.println("valor total do estoque com "+ calcinha.getEstoque() + " unidades: "+calcinha.valorEmEstoque());
		sc.close();
		
		
		System.out.println(Double.parseDouble("2"));

	}

}
