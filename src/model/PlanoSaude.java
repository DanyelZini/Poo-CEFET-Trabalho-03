package model;

public class PlanoSaude {
    private Integer id;
    private String nomePlano;

    public PlanoSaude(int id, String nomePlano) {
        this.id = id;
        this.nomePlano = nomePlano;
    }
    public PlanoSaude(String nomePlano) {
        this.id = null;
        this.nomePlano = nomePlano;
    }
    public PlanoSaude(PlanoSaude planoSaude) {
        this.id = planoSaude.id;
        this.nomePlano = planoSaude.nomePlano;
    }
    public PlanoSaude() {
    }

    public Integer getId() {
        return id;
    }
    
    public String getNomePlano() {
        return nomePlano;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    @Override
    public String toString() {
        return String.format("PlanoSaude { id: %d, nomePlano: '%s' }", id, nomePlano);
    }

    
}
