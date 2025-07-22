package menu;

import java.util.Scanner;

import model.Sala;
import repository.SalaRepository;

public class MenuSala {
    public static void exibir(Scanner scanner) {
        SalaRepository salaRepository = new SalaRepository();
        int opcao;
        do {
            System.out.println("==== CRUD SALA ====");
            System.out.println("1. Criar sala");
            System.out.println("2. Listar salas");
            System.out.println("3. Buscar salas");
            System.out.println("4. Atualizar sala");
            System.out.println("5. Remover sala");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Insira os dados para a sala:");
                    System.out.print("Tipo da sala: \n> ");
                    String tipoSala = scanner.nextLine();
                    salaRepository.salvar(new Sala(tipoSala));
                    System.out.println("Sala criada com sucesso!");
                    break;
                case 2:
                    System.out.println("Lista de salas:");
                    salaRepository.buscarTodos().forEach(sala -> {
                        System.out.println("Id: " + sala.getId() + ", Tipo: " + sala.getTipoSala());
                    });
                    break;
                case 3:
                    System.out.print("Digite o ID da sala a ser buscada: \n> ");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();
                    Sala salaBuscada = salaRepository.buscarPorId(idBusca);
                    if (salaBuscada != null) {
                        System.out.println("Sala encontrada: ID: " + salaBuscada.getId() +
                                ", Tipo: " + salaBuscada.getTipoSala());
                    } else {
                        System.out.println("Sala não encontrada!");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID da sala a ser atualizada: \n> ");
                    int idSala = scanner.nextInt();
                    scanner.nextLine();
                    Sala sala = salaRepository.buscarPorId(idSala);
                    if (sala == null) {
                        System.out.println("Sala não encontrada!");
                    } else {
                        System.out.println("Atualizando sala:");
                        System.out.print("Novo tipo: \n> ");
                        sala.setTipoSala(scanner.nextLine());
                        salaRepository.atualizar(sala);
                        System.out.println("Sala atualizada com sucesso!");
                    }
                    break;
                case 5:
                    System.out.print("Digite o ID da sala a ser removida: \n> ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    Sala salaRemover = salaRepository.buscarPorId(idRemover);
                    if (salaRemover != null) {
                        salaRepository.deletar(salaRemover);
                        System.out.println("Sala removida com sucesso!");
                    } else {
                        System.out.println("Sala não encontrada!");
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
