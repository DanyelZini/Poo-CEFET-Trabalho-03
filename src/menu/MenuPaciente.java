package menu;

import java.time.LocalDate;
import java.util.Scanner;

import model.Paciente;
import repository.EnderecoRepository;
import repository.PacienteRepository;
import repository.PlanoSaudeRepository;

public class MenuPaciente {
    public static void exibir(Scanner scanner) {
        PacienteRepository pacienteRepository = PacienteRepository.getInstance();
        int opcao;
        do {
            System.out.println("==== CRUD PACIENTE ====");
            System.out.println("1. Criar paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Buscar paciente");
            System.out.println("4. Atualizar paciente");
            System.out.println("5. Remover paciente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Insira os dados do paciente:");
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
                    System.out.print("Id Plano de Saúde: \n> ");
                    Integer planoSaude = scanner.nextInt();
                    pacienteRepository.salvar(new Paciente(nome, cpf, dataNascimento,
                            EnderecoRepository.getInstance().buscarPorId(endereco),
                            PlanoSaudeRepository.getInstance().buscarPorId(planoSaude)));
                    break;
                case 2:
                    System.out.println("Lista de pacientes:");
                    pacienteRepository.buscarTodos().forEach(paciente -> {
                        System.out.println("ID: " + paciente.getId() +
                                ", Nome: " + paciente.getNome() +
                                ", CPF: " + paciente.getCpf() +
                                ", Data de Nascimento: " + paciente.getDataNascimento() +
                                ", Endereço: " + paciente.getEndereco().getId() +
                                ", Plano de Saúde: " + paciente.getPlanoSaude().getNomePlano());
                    });
                    break;
                case 3:
                    System.out.print("Digite o CPF do paciente a ser buscado: \n> ");
                    String cpfBusca = scanner.nextLine();
                    Paciente paciente = pacienteRepository.buscarPorCpf(cpfBusca);
                    if (paciente != null) {
                        System.out.println("Paciente encontrado: " + paciente);
                    } else {
                        System.out.println("Paciente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o CPF do paciente a ser atualizado: \n> ");
                    String cpfAtualizar = scanner.nextLine();
                    Paciente pacienteAtualizar = pacienteRepository.buscarPorCpf(cpfAtualizar);
                    if (pacienteAtualizar == null) {
                        System.out.println("Paciente não encontrado.");
                    } else {
                        System.out.println("Insira os novos dados do paciente:");
                        System.out.print("Nome: \n> ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Data de Nascimento (dd/MM/yyyy): \n> ");
                        String novaDataNascimentoStr = scanner.nextLine();
                        LocalDate novaDataNascimento = LocalDate.parse(novaDataNascimentoStr,
                                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.print("Id Endereco: \n> ");
                        Integer novoEndereco = scanner.nextInt();
                        System.out.print("Id Plano de Saúde: \n> ");
                        Integer novoPlanoSaude = scanner.nextInt();
                        scanner.nextLine();
                        pacienteAtualizar.setEndereco(EnderecoRepository.getInstance().buscarPorId(novoEndereco));
                        pacienteAtualizar.setPlanoSaude(PlanoSaudeRepository.getInstance().buscarPorId(novoPlanoSaude));
                        pacienteAtualizar.setNome(novoNome);
                        pacienteAtualizar.setDataNascimento(novaDataNascimento);
                        pacienteRepository.atualizar(pacienteAtualizar);
                        System.out.println("Paciente atualizado com sucesso.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o CPF do paciente a ser removido: \n> ");
                    String cpfRemover = scanner.nextLine();
                    Paciente pacienteRemover = pacienteRepository.buscarPorCpf(cpfRemover);
                    if (pacienteRemover != null) {
                        pacienteRepository.deletar(pacienteRemover);
                        System.out.println("Paciente removido com sucesso.");
                    } else {
                        System.out.println("Paciente não encontrado.");
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
