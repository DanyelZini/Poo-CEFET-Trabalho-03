package menu;

import java.util.Scanner;

import model.PlanoSaude;
import repository.PlanoSaudeRepository;

public class MenuPlanoSaude {
    public static void exibir(Scanner scanner) {
        PlanoSaudeRepository planoSaudeRepository = new PlanoSaudeRepository();
        int opcao;
        do {
            System.out.println("==== CRUD PLANO DE SAÚDE ====");
            System.out.println("1. Criar plano de saúde");
            System.out.println("2. Listar planos de saúde");
            System.out.println("3. Buscar planos de saúde");
            System.out.println("4. Atualizar plano de saúde");
            System.out.println("5. Remover plano de saúde");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Insira os dados para o plano de saúde:");
                    System.out.print("Nome do plano: \n> ");
                    String nomePlano = scanner.nextLine();
                    planoSaudeRepository.salvar(new PlanoSaude(nomePlano));
                    System.out.println("Plano de saúde criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Lista de planos de saúde:");
                    planoSaudeRepository.buscarTodos().forEach(plano -> {
                        System.out.println("Id: " + plano.getId() + ", Nome: " + plano.getNomePlano());
                    });
                    break;
                case 3:
                    System.out.print("Digite o ID do plano de saúde a ser buscado: \n> ");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();
                    PlanoSaude planoBuscado = planoSaudeRepository.buscarPorId(idBusca);
                    if (planoBuscado != null) {
                        System.out.println("Plano de saúde encontrado: ID: " + planoBuscado.getId() +
                                ", Nome: " + planoBuscado.getNomePlano());
                    } else {
                        System.out.println("Plano de saúde não encontrado!");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do plano de saúde a ser atualizado: \n> ");
                    int idPlano = scanner.nextInt();
                    scanner.nextLine();
                    PlanoSaude plano = planoSaudeRepository.buscarPorId(idPlano);
                    if (plano == null) {
                        System.out.println("Plano de saúde não encontrado!");
                    } else {
                        System.out.println("Atualizando plano de saúde:");
                        System.out.print("Novo nome: \n> ");
                        plano.setNomePlano(scanner.nextLine());
                        planoSaudeRepository.atualizar(plano);
                        System.out.println("Plano de saúde atualizado com sucesso!");
                    }
                    break;
                case 5:
                    System.out.print("Digite o ID do plano de saúde a ser removido: \n> ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    PlanoSaude planoRemover = planoSaudeRepository.buscarPorId(idRemover);
                    if (planoRemover != null) {
                        planoSaudeRepository.deletar(planoRemover);
                        System.out.println("Plano de saúde removido com sucesso!");
                    } else {
                        System.out.println("Plano de saúde não encontrado!");
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
