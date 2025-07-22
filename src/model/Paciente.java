package model;

import java.time.LocalDate;

public class Paciente extends Pessoa {
    private PlanoSaude planoSaude;

    public Paciente(Pessoa pessoa, PlanoSaude planoSaude) {
        super(pessoa);
        this.planoSaude = planoSaude;
    }

    public Paciente(Integer id, String nome, String cpf, LocalDate nascimento, Endereco endereco, PlanoSaude planoSaude) {
        super(id, nome, cpf, nascimento, endereco);
        this.planoSaude = planoSaude;
    }

    public Paciente(String nome, String cpf, LocalDate nascimento, Endereco endereco, PlanoSaude planoSaude) {
        super(nome, cpf, nascimento, endereco);
        this.planoSaude = planoSaude;
    }

    public Paciente(Integer id, Pessoa pessoa, PlanoSaude planoSaude) {
        super(id, pessoa);
        this.planoSaude = planoSaude;
    }

    public Paciente() {
        super();
    }

    // Getters and Setters

    public PlanoSaude getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(PlanoSaude planoSaude) {
        this.planoSaude = planoSaude;
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

    public Endereco getEndereco() {
        return super.getEndereco();
    }

    public void setEndereco(Endereco endereco) {
        super.setEndereco(endereco);
    }

    @Override
    public String toString() {
        return String.format(
                "Paciente { id: %d, nome: '%s', cpf: '%s', nascimento: '%s', \n\tendereco: %s, \n\tplanoSaude: %s }",
                getId(), getNome(), getCpf(), getDataNascimento(), getEndereco(), planoSaude);
    }

}
