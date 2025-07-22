package model;

public class Departamento {
    private Integer id;
    private String NomeDepartamento;

    public Departamento(Integer id, String nomeDepartamento) {
        this.id = id;
        this.NomeDepartamento = nomeDepartamento;
    }

    public Departamento(String nomeDepartamento) {
        this.id = null;
        this.NomeDepartamento = nomeDepartamento;
    }

    public Departamento(Departamento departamento) {
        this.id = departamento.id;
        this.NomeDepartamento = departamento.NomeDepartamento;
    }

    public Departamento() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDepartamento() {
        return NomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        NomeDepartamento = nomeDepartamento;
    }

    @Override
    public String toString() {
        return String.format("Departamento { id: %d, nomeDepartamento: '%s' }", id, NomeDepartamento);
    }

}
