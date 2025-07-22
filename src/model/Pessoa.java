package model;

import java.time.LocalDate;

public abstract class Pessoa {
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private Endereco endereco;
    
    protected Pessoa(Pessoa pessoa) {
        this.id = pessoa.id;
        this.nome = pessoa.nome;
        this.cpf = pessoa.cpf;
        this.nascimento = pessoa.nascimento;
        this.endereco = pessoa.endereco;
    }
    protected Pessoa(Integer id, Pessoa pessoa) {
        this.id = id;
        this.nome = pessoa.nome;
        this.cpf = pessoa.cpf;
        this.nascimento = pessoa.nascimento;
        this.endereco = pessoa.endereco;
    }
    protected Pessoa(int id, String nome, String cpf, LocalDate nascimento, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }
    protected Pessoa(String nome, String cpf, LocalDate nascimento, Endereco endereco) {
        this.id = null;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }
    protected Pessoa() {
    }
    
    // Getters and Setters
    protected Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCpf() {
        return cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected LocalDate getNascimento() {
        return nascimento;
    }

    protected void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
