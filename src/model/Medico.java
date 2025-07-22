package model;

import java.time.LocalDate;

public class Medico extends Pessoa {
    private Departamento departamento;

    public Medico(Pessoa pessoa, Departamento departamento) {
        super(pessoa);
        this.departamento = departamento;
    }

    public Medico(Integer id, String nome, String cpf, LocalDate nascimento, Endereco endereco, Departamento departamento) {
        super(id, nome, cpf, nascimento, endereco);
        this.departamento = departamento;
    }

    public Medico(String nome, String cpf, LocalDate nascimento, Endereco endereco, Departamento departamento) {
        super(nome, cpf, nascimento, endereco);
        this.departamento = departamento;
    }

    public Medico(Integer id, Pessoa pessoa, Departamento departamento) {
        super(id, pessoa);
        this.departamento = departamento;
    }

    public Medico() {
        super();
    }

    // Getters and Setters
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer getId() {
        return super.getId();
    }

    public void setId(Integer id) {
        super.setId(id);
    }

    public String getNome() {
        return super.getNome();
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }

    public String getCpf() {
        return super.getCpf();
    }

    public void setCpf(String cpf) {
        super.setCpf(cpf);
    }

    public LocalDate getDataNascimento() {
        return super.getNascimento();
    }

    public void setDataNascimento(LocalDate nascimento) {
        super.setNascimento(nascimento);
    }

    @Override
    public String toString() {
        return String.format(
                "Medico { id: %d, nome: '%s', cpf: '%s', nascimento: '%s', \n\tendereco: %s, \n\tdepartamento: %s }",
                getId(), getNome(), getCpf(), getDataNascimento(), getEndereco(), departamento);
    }
    

}
