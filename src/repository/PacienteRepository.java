package repository;

import interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Paciente;
import model.PlanoSaude;

public class PacienteRepository implements CrudRepository<Paciente> {
    private static Integer nextid = 0;
    private static List<Paciente> instance = new ArrayList<>();

    @Override
    public void salvar(Paciente obj) {
        if (obj.getId() == null) {
            obj.setId(++nextid);
        }
        if (obj.getPlanoSaude() == null) {
            obj.setPlanoSaude(new PlanoSaude());
        }
        if (obj.getEndereco() == null) {
            obj.setEndereco(new Endereco());
        }
        instance.add(new Paciente(obj.getId(), obj.getNome(), obj.getCpf(), obj.getDataNascimento(), new Endereco(obj.getEndereco()), new PlanoSaude(obj.getPlanoSaude())));
    }

    @Override
    public Paciente buscarPorId(int id) {
        for (Paciente paciente : instance) {
            if (paciente.getId() == id) {
                return new Paciente(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getDataNascimento(), new Endereco(paciente.getEndereco()), new PlanoSaude(paciente.getPlanoSaude()));
            }
        }
        throw new UnsupportedOperationException("Paciente com id " + id + " nao encontrado.");
    }

    @Override
    public List<Paciente> buscarTodos() {
        if (instance.isEmpty()) {
            throw new UnsupportedOperationException("Nenhum paciente encontrado.");
        }
        List<Paciente> pacientes = new ArrayList<>();
        for (Paciente paciente : instance) {
            pacientes.add(new Paciente(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getDataNascimento(), new Endereco(paciente.getEndereco()), new PlanoSaude(paciente.getPlanoSaude())));
        }
        return pacientes;
    }

    @Override
    public void atualizar(Paciente obj) {
        for (Paciente paciente : instance) {
            if (paciente.getId() == obj.getId()) {
                paciente.setNome(obj.getNome());
                paciente.setDataNascimento(obj.getDataNascimento());
                paciente.setEndereco(new Endereco(obj.getEndereco()));
                paciente.setPlanoSaude(new PlanoSaude(obj.getPlanoSaude()));
                return;
            }
        }
        throw new UnsupportedOperationException("Paciente com id " + obj.getId() + " nao encontrado.");
    }

    @Override
    public void deletar(Paciente obj) {
        for (Paciente paciente : instance) {
            if (paciente.getId() == obj.getId()) {
                instance.remove(paciente);
                return;
            }
        }
        throw new UnsupportedOperationException("Paciente com id " + obj.getId() + " nao encontrado.");
    }

    @Override
    public void deletarTodos() {
        instance.clear();
        nextid = 0;
        System.out.println("Todos os pacientes foram deletados.");
    }

    @Override
    public Paciente clone() {
        try {
            return (Paciente) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
}
