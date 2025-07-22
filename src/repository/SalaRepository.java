package repository;

import java.util.ArrayList;
import java.util.List;

import interfaces.CrudRepository;
import model.Sala;

public class SalaRepository implements CrudRepository<Sala> {
    public static final String Sala = null;
    private static Integer nextid = 0;
    private static List<Sala> instance = new ArrayList<>();

    public static SalaRepository getInstance() {
        return new SalaRepository();
    }

    @Override
    public void salvar(Sala obj) {
        if (obj.getId() == null) {
            obj.setId(++nextid);
        }
        instance.add(new Sala(obj.getId(), obj.getTipoSala()));
    }

    @Override
    public Sala buscarPorId(int id) {
        for (Sala sala : instance) {
            if (sala.getId() == id) {
                return new Sala(sala.getId(), sala.getTipoSala());
            }
        }
        throw new UnsupportedOperationException("Sala com id " + id + " nao encontrada.");
    }

    @Override
    public List<Sala> buscarTodos() {
        if (instance.isEmpty()) {
            throw new UnsupportedOperationException("Nao existem salas cadastradas." +
                                                    " Utilize o metodo salvar para cadastrar uma sala.");
        }
        List<Sala> salas = new ArrayList<>();
        for (Sala sala : instance) {
            salas.add(new Sala(sala.getId(), sala.getTipoSala()));
        }
        return salas;
    }

    @Override
    public void atualizar(Sala obj) {
        for (Sala sala : instance) {
            if (sala.getId() == obj.getId()) {
                sala.setTipoSala(obj.getTipoSala());
                return;
            }
        }
        throw new UnsupportedOperationException("Sala com id " + obj.getId() + " nao encontrada.");
    }

    @Override
    public void deletar(Sala obj) {
        for (Sala sala : instance) {
            if (sala.getId() == obj.getId()) {
                instance.remove(sala);
                return;
            }
        }
        throw new UnsupportedOperationException("Sala com id " + obj.getId() + " nao encontrada.");
    }

    @Override
    public void deletarTodos() {
        instance.clear();
        nextid = 0;
        System.out.println("Todas as salas foram deletadas.");
    }

    @Override
    public Sala clone() {
        try {
            return (Sala) super.clone();        
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
}
