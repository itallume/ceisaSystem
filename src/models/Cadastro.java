package models;

import Exceptions.NomeInvalido;
import Exceptions.PrecoAtacadoInvalido;
import Exceptions.PrecoUnitarioInvalido;
import Exceptions.PrecoVarejoInvalido;
import Exceptions.QuantidadeInvalida;

public class Cadastro {
	private String nome;
	private int quantidade;
	private double precoUnitario;
	private double precoAtacado;
	private double precoVarejo;
	
	public Cadastro(String nome, String quantidade, String precoUnitario, String precoAtacado, String precoVarejo) 
			throws NomeInvalido, QuantidadeInvalida, PrecoUnitarioInvalido, PrecoAtacadoInvalido, PrecoVarejoInvalido{
		validarNome(nome);
		validarQuantidade(quantidade);
		validarPrecoUnitario(precoUnitario);
		validarPrecoAtacado(precoAtacado);
		validarPrecoVarejo(precoVarejo);
	}
	
	
	private void validarNome(String nome) throws NomeInvalido {
		if (nome.isEmpty()) {
			 throw new NomeInvalido("Nome não pode ser nulo");
		}
		
		if (nome.length() < 3) {
			throw new NomeInvalido("Nome deve ter no mínimo 3 caracteres");
		}
		
		if (nome.length() > 50) {
			throw new NomeInvalido("Nome deve ter no mínimo 3 caracteres");
		}
		
		this.nome = nome;
		
	}
	
	private void validarQuantidade(String quantidade) throws QuantidadeInvalida {
		if (quantidade.isEmpty()) {
			 throw new QuantidadeInvalida("Quantidade não pode ser nula.");
		}
		
		if (!quantidade.matches("[0-9]+")){
	            throw new QuantidadeInvalida("Quantidade deve ser um número inteiro positivo.");
	    }
		this.quantidade = Integer.parseInt(quantidade);
	}
	
	private void validarPrecoUnitario(String precoUnitario) throws PrecoUnitarioInvalido {
        if (precoUnitario.isEmpty()){
            throw new PrecoUnitarioInvalido("Preço unitário não pode ser nulo.");
        }

        if (!precoUnitario.matches("^[0-9]*\\.?[0-9]+$")){
            throw new PrecoUnitarioInvalido("Preço unitário deve ser um número positivo.");
        }
        
        this.precoUnitario = Double.parseDouble(precoUnitario);
    }
	
	private void validarPrecoAtacado(String precoAtacado) throws PrecoAtacadoInvalido {
        if (precoAtacado.isEmpty()){
            throw new PrecoAtacadoInvalido("Preço atacado não pode ser nulo.");
        }

        if (!precoAtacado.matches("^[0-9]*\\.?[0-9]+$")){
            throw new PrecoAtacadoInvalido("Preço atacado deve ser um número positivo.");
        }
        
        this.precoAtacado = Double.parseDouble(precoAtacado);
    }
	
	private void validarPrecoVarejo(String precoVarejo) throws PrecoVarejoInvalido {
        if (precoVarejo.isEmpty()){
            throw new PrecoVarejoInvalido("Preço varejo não pode ser nulo.");
        }

        if (!precoVarejo.matches("^[0-9]*\\.?[0-9]+$")){
            throw new PrecoVarejoInvalido("Preço varejo deve ser um número positivo.");
        }
        
        this.precoVarejo = Double.parseDouble(precoVarejo);
    }
	
	public String getNome() {
		return nome;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public double getPrecoUnitario() {
		return precoUnitario;
	}


	public double getPrecoAtacado() {
		return precoAtacado;
	}


	public double getPrecoVarejo() {
		return precoVarejo;
	}
	
}





















