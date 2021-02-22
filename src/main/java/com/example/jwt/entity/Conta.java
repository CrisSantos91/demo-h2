package com.example.jwt.entity;

public class Conta {

    private String nome;
    private String sobreNome;
    private int idade;

    public Conta(String nome, String sobreNome, int idade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return nome + " "+ sobreNome + ", " + idade;
    }
}
