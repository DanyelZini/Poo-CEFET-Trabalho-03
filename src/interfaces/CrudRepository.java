package interfaces;

import java.util.List;

public interface CrudRepository<T> extends Cloneable {

    void salvar(T obj);

    T buscarPorId(int id);
    List<T> buscarTodos();

    void atualizar(T obj);
    
    void deletar(T obj);
    void deletarTodos();

    T clone();
}