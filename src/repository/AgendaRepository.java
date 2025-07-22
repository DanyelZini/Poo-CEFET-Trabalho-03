package repository;

import java.util.ArrayList;
import java.util.List;

import interfaces.CrudRepository;
import model.Agenda;

public class AgendaRepository implements CrudRepository<Agenda> {
    private static Integer nextid = 0;
    private static List<Agenda> instance = new ArrayList<>();

    @Override
    public void salvar(Agenda obj) {
        if (obj.getId() == null) {
            obj.setId(++nextid);
        }
        instance.add(new Agenda(obj.getId(), obj.getDtConsulta(), obj.getHoraConsulta(),
                obj.getPaciente(), obj.getMedico(), obj.getSala()));
    }

    @Override
    public Agenda buscarPorId(int id) {
        for (Agenda agenda : instance) {
            if (agenda.getId() == id) {
                return new Agenda(agenda.getId(), agenda.getDtConsulta(), agenda.getHoraConsulta(),
                        agenda.getPaciente(), agenda.getMedico(), agenda.getSala());
            }
        }
        throw new UnsupportedOperationException("Agenda com id " + id + " nao encontrada.");
    }

    @Override
    public List<Agenda> buscarTodos() {
        if (instance.isEmpty()) {
            throw new UnsupportedOperationException("Nenhuma agenda encontrada.");
        }
        List<Agenda> agendas = new ArrayList<>();
        for (Agenda agenda : instance) {
            agendas.add(new Agenda(agenda.getId(), agenda.getDtConsulta(), agenda.getHoraConsulta(),
                    agenda.getPaciente(), agenda.getMedico(), agenda.getSala()));
        }
        return agendas;
    }

    @Override
    public void atualizar(Agenda obj) {
        for (Agenda agenda : instance) {
            if (agenda.getId() == obj.getId()) {
                agenda.setDtConsulta(obj.getDtConsulta());
                agenda.setHoraConsulta(obj.getHoraConsulta());
                agenda.setPaciente(obj.getPaciente());
                agenda.setMedico(obj.getMedico());
                agenda.setSala(obj.getSala());
                return;
            }
        }
        throw new UnsupportedOperationException("Agenda com id " + obj.getId() + " nao encontrada.");
    }

    @Override
    public void deletar(Agenda obj) {
        for (Agenda agenda : instance) {
            if (agenda.getId() == obj.getId()) {
                instance.remove(agenda);
                return;
            }
        }
        throw new UnsupportedOperationException("Agenda com id " + obj.getId() + " nao encontrada.");
    }

    @Override
    public void deletarTodos() {
        instance.clear();
        nextid = 0;
        System.out.println("Toda a agenda foi deletada.");
    }

    @Override
    public Agenda clone() {
        try {
            return (Agenda) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
