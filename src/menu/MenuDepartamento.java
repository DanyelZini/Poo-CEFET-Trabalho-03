package menu;
import java.util.Scanner;
import java.util.List;

import model.Departamento;
import repository.DepartamentoRepository;

public class MenuDepartamento {
    public static void exibir(Scanner scanner) {
            DepartamentoRepository departamentoRepository = DepartamentoRepository.getInstance();
            int opcao;
            do {
                System.out.println("==== CRUD DEPARTAMENTO ====");
                System.out.println("1. Criar departamento");
                System.out.println("2. Listar departamentos");
                System.out.println("3. Buscar departamento");
                System.out.println("4. Atualizar departamento");
                System.out.println("5. Remover departamento");
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do departamento:\n> ");
                        String nomeDepartamento = scanner.nextLine();
                        Departamento departamento = new Departamento(nomeDepartamento);
                        departamentoRepository.salvar(departamento);
                        System.out.println("Departamento criado com sucesso.");
                        break;
                    case 2:
                        try {
                            List<Departamento> departamentos = departamentoRepository.buscarTodos();
                            System.out.println("Lista de departamentos:");
                            departamentos.forEach(dep ->
                                System.out.println("ID: " + dep.getId() +
                                        ", Nome: " + dep.getNomeDepartamento()));
                        } catch (UnsupportedOperationException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Digite o ID do departamento:\n> ");
                        int idBusca = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            Departamento depEncontrado = departamentoRepository.buscarPorId(idBusca);
                            System.out.println("Departamento encontrado: ID: " + depEncontrado.getId() +
                                    ", Nome: " + depEncontrado.getNomeDepartamento());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Digite o ID do departamento a ser atualizado:\n> ");
                        int idAtualizar = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            Departamento depAtualizar = departamentoRepository.buscarPorId(idAtualizar);
                            System.out.print("Digite o novo nome do departamento:\n> ");
                            String novoNome = scanner.nextLine();
                            depAtualizar.setNomeDepartamento(novoNome);
                            departamentoRepository.atualizar(depAtualizar);
                            System.out.println("Departamento atualizado com sucesso.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.print("Digite o ID do departamento a ser removido:\n> ");
                        int idRemover = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            Departamento depRemover = departamentoRepository.buscarPorId(idRemover);
                            departamentoRepository.deletar(depRemover);
                            System.out.println("Departamento removido com sucesso.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        }
}
