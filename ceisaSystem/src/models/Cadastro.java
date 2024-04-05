package models;

import Exceptions.NomeInvalido;
import Exceptions.Quantidadeinvalida;
import Exceptions.ValorUnitarioInvalido;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {

    private String nome;


    private int quantidade;
    private double precoUnitario;

    public Cadastro(String nome, String quantidade, String precoUnitario) throws NomeInvalido, ValorUnitarioInvalido, Quantidadeinvalida {
        validarNome(nome);
        validarQuantidade(quantidade);
        validarPrecoUnitario(precoUnitario);

        ArrayList<String> lista = new ArrayList<>(List.of(nome, quantidade, precoUnitario));
        conversor(lista);
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

    private void conversor(ArrayList<String> lista){
        this.nome = lista.get(0);
        this.quantidade = Integer.parseInt(lista.get(1));
        this.precoUnitario = Double.parseDouble(lista.get(2));
    }

    private void validarNome(String nome) throws NomeInvalido {
        if (nome.isEmpty()){
            throw new NomeInvalido("Nome não pode ser nulo.");
        }

        if(nome.length() < 3){
            throw new NomeInvalido("Nome deve ter no mínimo 3 caracteres.");
        }

        if (nome.length() > 50){
            throw new NomeInvalido("Nome deve ter no máximo 50 caracteres.");
        }
    }

    private void validarQuantidade(String quantidade) throws Quantidadeinvalida {
        if (quantidade.isEmpty()){
            throw new Quantidadeinvalida("Quantidade não pode ser nula.");
        }

        if (!quantidade.matches("[0-9]+")){
            throw new Quantidadeinvalida("Quantidade deve ser um número inteiro positivo.");
        }
    }

    private void validarPrecoUnitario(String precoUnitario) throws ValorUnitarioInvalido {
        if (precoUnitario.isEmpty()){
            throw new ValorUnitarioInvalido("Preço unitário não pode ser nulo.");
        }

        if (!precoUnitario.matches("^[0-9]*\\.?[0-9]+$")){
            throw new ValorUnitarioInvalido("Preço unitário deve ser um número positivo.");
        }
    }

}
