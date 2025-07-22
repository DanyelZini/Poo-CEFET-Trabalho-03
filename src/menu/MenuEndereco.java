package menu;

import java.util.Scanner;

import model.Endereco;
import repository.EnderecoRepository;

public class MenuEndereco {
    public static void exibir(Scanner scanner) {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        int opcao;
        do {
            System.out.println("==== CRUD ENDEREÇO ====");
            System.out.println("1. Criar endereço");
            System.out.println("2. Listar endereços");
            System.out.println("3. Buscar endereços");
            System.out.println("4. Atualizar endereço");
            System.out.println("5. Remover endereço");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Insira os dados para o endereço:");
                    System.out.println("Numero: \n> ");
                    Integer numero = scanner.nextInt();
                    System.out.println("Rua: \n> ");
                    String rua = scanner.nextLine();
                    System.out.println("Bairro: \n> ");
                    String bairro = scanner.nextLine();
                    System.out.println("Cidade: \n> ");
                    String cidade = scanner.nextLine();
                    System.out.println("Estado: \n> ");
                    String estado = scanner.nextLine();
                    System.out.println("Cep: \n> ");
                    String cep = scanner.nextLine();
                    enderecoRepository.salvar(new Endereco(numero, rua, bairro, cidade, estado, cep));
                    break;
                case 2:
                    System.out.println("Lista de endereços:");
                    enderecoRepository.buscarTodos().forEach(endereco -> {
                        System.out.println("Id: " + endereco.getId() + ", Rua: " + endereco.getRua() +
                                ", Bairro: " + endereco.getBairro() +
                                ", Cidade: " + endereco.getCidade() +
                                ", Estado: " + endereco.getEstado() +
                                ", CEP: " + endereco.getCep() +
                                ", Número: " + endereco.getNumero());
                    });
                    break;
                case 3:
                    System.out.print("Digite o ID do endereço a ser buscado: \n> ");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();
                    Endereco enderecoBuscado = enderecoRepository.buscarPorId(idBusca);
                    if (enderecoBuscado != null) {
                        System.out.println("Endereço encontrado: ID: " + enderecoBuscado.getId() +
                                ", Rua: " + enderecoBuscado.getRua() +
                                ", Bairro: " + enderecoBuscado.getBairro() +
                                ", Cidade: " + enderecoBuscado.getCidade() +
                                ", Estado: " + enderecoBuscado.getEstado() +
                                ", CEP: " + enderecoBuscado.getCep() +
                                ", Número: " + enderecoBuscado.getNumero());
                    } else {
                        System.out.println("Endereço não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do endereço a ser atualizado: \n> ");
                    int idEndereco = scanner.nextInt();
                    scanner.nextLine();
                    Endereco endereco = enderecoRepository.buscarPorId(idEndereco);
                    if (endereco == null) {
                        System.out.println("Endereço não encontrado!");
                    } else {
                        System.out.println("Atualizando endereço:");
                        System.out.print("Novo número: \n> ");
                        endereco.setNumero(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Nova rua: \n> ");
                        endereco.setRua(scanner.nextLine());
                        System.out.print("Novo bairro: \n> ");
                        endereco.setBairro(scanner.nextLine());
                        System.out.print("Nova cidade: \n> ");
                        endereco.setCidade(scanner.nextLine());
                        System.out.print("Novo estado: \n> ");
                        endereco.setEstado(scanner.nextLine());
                        System.out.print("Novo CEP: \n> ");
                        endereco.setCep(scanner.nextLine());
                        enderecoRepository.atualizar(endereco);
                        System.out.println("Endereço atualizado com sucesso!");
                    }
                    break;
                case 5:
                    System.out.print("Digite o ID do endereço a ser removido: \n> ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    Endereco enderecoRemover = enderecoRepository.buscarPorId(idRemover);
                    if (enderecoRemover != null) {
                        enderecoRepository.deletar(enderecoRemover);
                        System.out.println("Endereço removido com sucesso!");
                    } else {
                        System.out.println("Endereço não encontrado!");
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
