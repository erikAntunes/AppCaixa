package br.com.digitalhouse.postapp.model;

public class Produto {

    private String nome;
    private int preco;

    public Produto(){}

    public Produto(String titulo, int preco) {

        this.nome = titulo;
        this.preco = preco;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
