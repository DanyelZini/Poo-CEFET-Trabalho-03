package menu;

import java.time.LocalDate;
import java.util.Scanner;

import model.Medico;
import repository.DepartamentoRepository;
import repository.EnderecoRepository;
import repository.MedicoRepository;

public class MenuMedico {
    public static void exibir(Scanner scanner) {
        MedicoRepository medicoRepository = MedicoRepository.getInstance();
        int opcao;
        do {
            System.out.println("==== CRUD MÉDICO ====");
            System.out.println("1. Criar médico");
            System.out.println("2. Listar médicos");
            System.out.println("3. Buscar médico");
            System.out.println("4. Atualizar médico");
            System.out.println("5. Remover médico");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Insira os dados do médico:");
                    System.out.print("Nome: \n> ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: \n> ");
                    String cpf = scanner.nextLine();
                    System.out.print("Data de Nascimento (dd/MM/yyyy): \n> ");
                    String dataNascimentoStr = scanner.nextLine();
                    LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr,
                            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.print("Id Endereco: \n> ");
                    Integer endereco = scanner.nextInt();
                    System.out.println("Id Departamento: \n> ");
                    Integer departamento = scanner.nextInt();
                    scanner.nextLine();
                    medicoRepository.salvar(new Medico(nome, cpf, dataNascimento, 
                            EnderecoRepository.getInstance().buscarPorId(endereco),
                            DepartamentoRepository.getInstance().buscarPorId(departamento)));
                    break;
                case 2:
                    System.out.println("Lista de médicos:");
                    medicoRepository.buscarTodos().forEach(medico -> {
                        System.out.println("ID: " + medico.getId() +
                                ", Nome: " + medico.getNome() +
                                ", CPF: " + medico.getCpf() +
                                ", Data de Nascimento: " + medico.getDataNascimento() +
                                ", Endereço: " + medico.getEndereco().getId() +
                                ", Departamento: " + medico.getDepartamento().getNomeDepartamento());
                    });
                    break;
                case 3:
                    System.out.print("Digite o CPF do médico a ser buscado: \n> ");
                    String cpfBusca = scanner.nextLine();
                    Medico medico = medicoRepository.buscarPorCpf(cpfBusca);
                    if (medico != null) {
                        System.out.println("Médico encontrado: " + medico);
                    } else {
                        System.out.println("Médico não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o CPF do médico a ser atualizado: \n> ");
                    String cpfAtualizar = scanner.nextLine();
                    Medico medicoAtualizar = medicoRepository.buscarPorCpf(cpfAtualizar);
                    if (medicoAtualizar == null) {
                        System.out.println("Médico não encontrado.");
                    } else {
                        System.out.println("Insira os novos dados do médico:");
                        System.out.print("Nome: \n> ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Data de Nascimento (dd/MM/yyyy): \n> ");
                        String novaDataNascimentoStr = scanner.nextLine();
                        LocalDate novaDataNascimento = LocalDate.parse(novaDataNascimentoStr,
                                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.print("Id Endereco: \n> ");
                        Integer novoEndereco = scanner.nextInt();
                        System.out.print("Id Departamento: \n> ");
                        Integer novoDepartamento = scanner.nextInt();
                        scanner.nextLine();
                        medicoAtualizar.setEndereco(EnderecoRepository.getInstance().buscarPorId(novoEndereco));
                        medicoAtualizar.setDepartamento(DepartamentoRepository.getInstance().buscarPorId(novoDepartamento));
                        medicoAtualizar.setNome(novoNome);
                        medicoAtualizar.setDataNascimento(novaDataNascimento);
                        medicoRepository.atualizar(medicoAtualizar);
                        System.out.println("Médico atualizado com sucesso.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o CPF do médico a ser removido: \n> ");
                    String cpfRemover = scanner.nextLine();
                    Medico medicoRemover = medicoRepository.buscarPorCpf(cpfRemover);
                    if (medicoRemover != null) {
                        medicoRepository.deletar(medicoRemover);
                        System.out.println("Médico removido com sucesso.");
                    } else {
                        System.out.println("Médico não encontrado.");
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
