package repository;

import java.util.ArrayList;
import java.util.List;

import interfaces.CrudRepository;
import model.Departamento;
import model.Endereco;
import model.Medico;
import util.CpfUtils;

public class MedicoRepository implements CrudRepository<Medico>{
    private static Integer nextid = 0;
    private static List<Medico> instance = new ArrayList<>();

    public static MedicoRepository getInstance() {
        return new MedicoRepository();
    }

    @Override
    public void salvar(Medico obj) {
        if (obj.getId() == null) {
            obj.setId(++nextid);
        }
        if (!CpfUtils.isCpfValido(obj.getCpf())) {
            throw new IllegalArgumentException("CPF invalido: " + obj.getCpf());
        }
        obj.setCpf(CpfUtils.formatarCpf(obj.getCpf()));
        if (this.buscarPorCpf(obj.getCpf()) != null) {
            throw new IllegalArgumentException("CPF ja cadastrado: " + obj.getCpf());
        }
        instance.add(new Medico(obj.getId(), obj.getNome(), obj.getCpf(), obj.getDataNascimento(), new Endereco(obj.getEndereco()), new Departamento(obj.getDepartamento())));
    }

    public Medico buscarPorCpf(String cpf) {
        cpf = CpfUtils.formatarCpf(cpf);
        for (Medico medico : instance) {
            if (medico.getCpf().equals(cpf)) {
                return medico;
            }
        }
        return null; 
    }

    @Override
    public Medico buscarPorId(int id) {
        for (Medico medico : instance) {
            if (medico.getId() == id) {
                return new Medico(medico.getId(), medico.getNome(), medico.getCpf(), medico.getDataNascimento(), new Endereco(medico.getEndereco()), new Departamento(medico.getDepartamento()));
            }
        }
        throw new UnsupportedOperationException("Medico com id " + id + " nao encontrado.");
    }
    @Override
    public List<Medico> buscarTodos() {
        if (instance.isEmpty()) {
            throw new UnsupportedOperationException("Nenhum medico encontrado.");
        }
        List<Medico> medicos = new ArrayList<>();
        for (Medico medico : instance) {
            medicos.add(new Medico(medico.getId(), medico.getNome(), medico.getCpf(), medico.getDataNascimento(), new Endereco(medico.getEndereco()), new Departamento(medico.getDepartamento())));
        }
        return medicos;
    }
    @Override
    public void atualizar(Medico obj) {
        for (Medico medico : instance) {
            if (medico.getId() == obj.getId()) {
                medico.setNome(obj.getNome());
                medico.setDataNascimento(obj.getDataNascimento());
                medico.setEndereco(new Endereco(obj.getEndereco()));
                medico.setDepartamento(new Departamento(obj.getDepartamento()));
                return;
            }
        }
        throw new UnsupportedOperationException("Medico com id " + obj.getId() + " nao encontrado.");
    }
    @Override
    public void deletar(Medico obj) {
        for (Medico medico : instance) {
            if (medico.getId() == obj.getId()) {
                instance.remove(medico);
                return;
            }
        }
        throw new UnsupportedOperationException("Medico com id " + obj.getId() + " nao encontrado.");
    }
    @Override
    public void deletarTodos() {
        instance.clear();
        nextid = 0;
        System.out.println("Todos os medicos foram deletados.");
    }

    @Override
    public Medico clone() {
        try {
            return (Medico) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
