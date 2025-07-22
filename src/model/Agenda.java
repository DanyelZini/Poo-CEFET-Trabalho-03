package model;

import java.time.LocalDate;

public class Agenda {
    private Integer id;
    private LocalDate dtConsulta;
    private int horaConsulta;
    private Paciente paciente;
    private Medico medico;
    private Sala sala;

    public Agenda(Integer id, LocalDate dtConsulta, int horaConsulta, Paciente paciente, Medico medico, Sala sala) {
        this.id = id;
        this.dtConsulta = dtConsulta;
        this.horaConsulta = horaConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.sala = sala;
    }

    public Agenda(LocalDate dtConsulta, int horaConsulta, Paciente paciente, Medico medico, Sala sala) {
        this.id = null;
        this.dtConsulta = dtConsulta;
        this.horaConsulta = horaConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.sala = sala;
    }

    public Agenda() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(LocalDate dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public int getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(int horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return String.format("Agenda{id=%d, dtConsulta=%s, horaConsulta=%d, paciente=%s, medico=%s, sala=%s}",
                id, dtConsulta, horaConsulta, paciente.getNome(), medico.getNome(), sala.getTipoSala());
    }
}
