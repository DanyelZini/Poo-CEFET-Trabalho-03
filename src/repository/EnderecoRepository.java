package repository;

import java.util.ArrayList;
import java.util.List;

import interfaces.CrudRepository;
import model.Endereco;

public class EnderecoRepository implements CrudRepository<Endereco> {
    private static Integer nextid = 0;
    private static List<Endereco> instance = new ArrayList<>();

    public static EnderecoRepository getInstance() {
        return new EnderecoRepository();
    }

    @Override
    public void salvar(Endereco obj) {
        if (obj.getId() == null) {
            obj.setId(++nextid);
        }
        instance.add(new Endereco(obj));
    }

    @Override
    public Endereco buscarPorId(int id) {
        for (Endereco endereco : instance) {
            if (endereco.getId() == id) {
                return new Endereco(endereco);
            }
        }
        throw new UnsupportedOperationException("Endereco com id " + id + " nao encontrado.");
    }

    @Override
    public List<Endereco> buscarTodos() {
        if (instance.isEmpty()) {
            throw new UnsupportedOperationException("Nao existem enderecos cadastrados." +
                                                    " Utilize o metodo salvar para cadastrar um endereco.");
        }
        List<Endereco> enderecos = new ArrayList<>();
        for (Endereco endereco : instance) {
            enderecos.add((new Endereco(endereco)));
        }
        return enderecos;
    }

    @Override
    public void atualizar(Endereco obj) {
        for (Endereco endereco : instance) {
            if (endereco.getId() == obj.getId()) {
                endereco.setNumero(obj.getNumero());
                endereco.setRua(obj.getRua());
                endereco.setBairro(obj.getBairro());
                endereco.setCidade(obj.getCidade());
                endereco.setEstado(obj.getEstado());
                endereco.setCep(obj.getCep());
                return;
            }
        }
        throw new UnsupportedOperationException("Endereco com id " + obj.getId() + " nao encontrado.");
    }

    @Override
    public void deletar(Endereco obj) {
        for (Endereco endereco : instance) {
            if (endereco.getId() == obj.getId()) {
                instance.remove(endereco);
                return;
            }
        }
        throw new UnsupportedOperationException("Endereco com id " + obj.getId() + " nao encontrado.");
    }

    @Override
    public void deletarTodos() {
        instance.clear();
        nextid = 0;
        System.out.println("Todos os enderecos foram deletados.");
    }

    @Override
    public Endereco clone() {
        try {
            return (Endereco) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
