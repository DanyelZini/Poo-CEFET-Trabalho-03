package model;

public class Sala {
    private Integer id;
    private String tipoSala;

    public Sala(Integer id, String tipoSala) {
        this.id = id;
        this.tipoSala = tipoSala;
    }

    public Sala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    @Override
    public String toString() {
        return String.format("Sala { id: %d, tipoSala: '%s' }", id, tipoSala);
    }
        
}
