package repository;

import java.util.ArrayList;
import java.util.List;

import interfaces.CrudRepository;
import model.PlanoSaude;

public class PlanoSaudeRepository implements CrudRepository<PlanoSaude> {
    private static Integer nextid = 0;
    private static List<PlanoSaude> instance = new ArrayList<>();
    
    public static PlanoSaudeRepository getInstance() {
        return new PlanoSaudeRepository();
    }

    @Override
    public void salvar(PlanoSaude obj) {
        if (obj.getId() == null) {
            obj.setId(++nextid);
        }
        instance.add(new PlanoSaude(obj));
    }

    @Override
    public PlanoSaude buscarPorId(int id) {
        for (PlanoSaude plano : instance) {
            if (plano.getId() == id) {
                return plano;
            }
        }
        throw new UnsupportedOperationException("Plano de saude com id " + id + " nao encontrado.");    
    }

    @Override
    public List<PlanoSaude> buscarTodos() {
        if(instance.isEmpty()) {
            throw new UnsupportedOperationException("Nao existem planos de saude cadastrados." +
                                                    " Utilize o metodo salvar para cadastrar um plano de saude.");
        }
        List<PlanoSaude> planos = new ArrayList<>();
        for (PlanoSaude plano : instance) {
            planos.add(new PlanoSaude(plano));
        }
        return planos;
    }

    @Override
    public void atualizar(PlanoSaude obj) {
        for (PlanoSaude plano : instance) {
            if (plano.getId() == obj.getId()) {
                plano.setNomePlano(obj.getNomePlano());
                return;
            }
        }
        throw new UnsupportedOperationException("Plano de saude com id " + obj.getId() + " nao encontrado.");
    }

    @Override
    public void deletar(PlanoSaude obj) {
        for (PlanoSaude plano : instance) {
            if (plano.getId() == obj.getId()) {
                instance.remove(plano);
                return;
            }
        }
        throw new UnsupportedOperationException("Plano de saude com id " + obj.getId() + " nao encontrado.");
    }

    @Override
    public void deletarTodos() {
        instance.clear();
        nextid = 0;
        System.out.println("Todos os planos de saude foram deletados.");
    }

    @Override
    public PlanoSaude clone() {
        try {
            return (PlanoSaude) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
}
