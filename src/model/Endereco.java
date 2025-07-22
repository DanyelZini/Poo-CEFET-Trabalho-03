package model;

public class Endereco {
    private Integer id;
    private int numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(Integer id, int numero, String rua, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    public Endereco(int numero, String rua, String bairro, String cidade, String estado, String cep) {
        this.id = null;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    public Endereco(Endereco endereco) {
        this.id = endereco.id;
        this.numero = endereco.numero;
        this.rua = endereco.rua;
        this.bairro = endereco.bairro;
        this.cidade = endereco.cidade;
        this.estado = endereco.estado;
        this.cep = endereco.cep;
    }
    public Endereco() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return String.format("Endereco { id: %s, numero: %d, rua: '%s', bairro: '%s', cidade: '%s', estado: '%s', cep: '%s' }",
                id, numero, rua, bairro, cidade, estado, cep);
    }
}
