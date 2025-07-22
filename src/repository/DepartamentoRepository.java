package repository;

import java.util.ArrayList;
import java.util.List;

import interfaces.CrudRepository;
import model.Departamento;

public class DepartamentoRepository implements CrudRepository<Departamento> {
    private static Integer nextid = 0;
    private static List<Departamento> instance = new ArrayList<>();
    
    @Override
    public void salvar(Departamento obj) {
        if (obj.getId() == null) {
            obj.setId(++nextid);
        }
        instance.add(new Departamento(obj));
    }
    @Override
    public Departamento buscarPorId(int id) {
        for (Departamento departamento : instance) {
            if (departamento.getId() == id) {
                return new Departamento(departamento);
            }
        }
        throw new UnsupportedOperationException("Departamento com id " + id + " nao encontrado.");
    }
    @Override
    public List<Departamento> buscarTodos() {
        if (instance.isEmpty()) {
            throw new UnsupportedOperationException("Nao existem departamentos cadastrados." +
                                                    " Utilize o metodo salvar para cadastrar um departamento.");
        }
        List<Departamento> departamentos = new ArrayList<>();
        for (Departamento departamento : instance) {
            departamentos.add(new Departamento(departamento));
        }
        return departamentos;
    }
    @Override
    public void atualizar(Departamento obj) {
        for (Departamento departamento : instance) {
            if (departamento.getId() == obj.getId()) {
                departamento.setNomeDepartamento(obj.getNomeDepartamento());
                return;
            }
        }
        throw new UnsupportedOperationException("Departamento com id " + obj.getId() + " nao encontrado.");
    }
    @Override
    public void deletar(Departamento obj) {
        for (Departamento departamento : instance) {
            if (departamento.getId() == obj.getId()) {
                instance.remove(departamento);
                return;
            }
        }
        throw new UnsupportedOperationException("Departamento com id " + obj.getId() + " nao encontrado.");
    }
    @Override
    public void deletarTodos() {
        instance.clear();
        nextid = 0;
        System.out.println("Todos os departamentos foram deletados.");
    }

    @Override
    public Departamento clone() {
        try {
            return (Departamento) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    
}
