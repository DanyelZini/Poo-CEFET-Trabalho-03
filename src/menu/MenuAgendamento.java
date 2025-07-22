package menu;

import java.time.LocalDate;
import java.util.Scanner;

import model.Agenda;
import repository.AgendaRepository;
import repository.MedicoRepository;
import repository.PacienteRepository;
import repository.SalaRepository;

public class MenuAgendamento {
    public static void exibir(Scanner scanner) {
        AgendaRepository agendaRepository = new AgendaRepository();
        int opcao;
        do {
            System.out.println("==== CRUD AGENDAMENTO ====");
            System.out.println("1. Criar agendamento");
            System.out.println("2. Listar agendamentos");
            System.out.println("3. Buscar agendamento");
            System.out.println("4. Atualizar agendamento");
            System.out.println("5. Remover agendamento");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Insira os dados para o agendamento:");
                    System.out.print("Cpf do paciente: \n> ");
                    String cpf = scanner.nextLine();
                    System.out.print("Id do médico: \n> ");
                    int idMedico = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Data da consulta (dd/MM/yyyy): \n> ");
                    String dataConsulta = scanner.nextLine();
                    LocalDate dtConsulta = LocalDate.parse(dataConsulta, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.print("Hora da consulta (HH): \n> ");
                    Integer horaConsulta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Id da sala: \n> ");
                    int idSala = scanner.nextInt();
                    scanner.nextLine();
                    agendaRepository.salvar(new Agenda(dtConsulta, horaConsulta, PacienteRepository.getInstance().buscarPorCpf(cpf), MedicoRepository.getInstance().buscarPorId(idMedico), SalaRepository.getInstance().buscarPorId(idSala)));
                    break;
                case 2:
                    System.out.println("Lista de agendamentos:");
                    agendaRepository.buscarTodos().forEach(agenda -> {
                        System.out.println("Id: " + agenda.getId() + ", Data: " + agenda.getDtConsulta() +
                                ", Hora: " + agenda.getHoraConsulta() +
                                ", Paciente: " + agenda.getPaciente().getNome() +
                                ", Médico: " + agenda.getMedico().getNome() +
                                ", Sala: " + agenda.getSala().getTipoSala());
                    });
                    break;
                case 3:
                    System.out.print("Digite o ID do agendamento a ser buscado: \n> ");
                    int idAgendamento = scanner.nextInt();
                    scanner.nextLine();
                    Agenda agendamento = agendaRepository.buscarPorId(idAgendamento);
                    if (agendamento != null) {
                        System.out.println("Agendamento encontrado: " + agendamento);
                    } else {
                        System.out.println("Agendamento não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do agendamento a ser atualizado: \n> ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    Agenda agendamentoAtualizar = agendaRepository.buscarPorId(idAtualizar);
                    if (agendamentoAtualizar == null) {
                        System.out.println("Agendamento não encontrado."); 
                    } else {
                        System.out.println("Insira os novos dados para o agendamento:");
                        System.out.print("Cpf do paciente: \n> ");
                        String novoCpf = scanner.nextLine();
                        System.out.print("Id do médico: \n> ");
                        int novoIdMedico = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Data da consulta (dd/MM/yyyy): \n> ");
                        String novaDataConsulta = scanner.nextLine();
                        LocalDate novaDtConsulta = LocalDate.parse(novaDataConsulta, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.print("Hora da consulta (HH): \n> ");
                        Integer novaHoraConsulta = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Id da sala: \n> ");
                        int novaIdSala = scanner.nextInt();
                        scanner.nextLine();
                        agendamentoAtualizar.setDtConsulta(novaDtConsulta);
                        agendamentoAtualizar.setHoraConsulta(novaHoraConsulta);
                        agendamentoAtualizar.setPaciente(PacienteRepository.getInstance().buscarPorCpf(novoCpf));
                        agendamentoAtualizar.setMedico(MedicoRepository.getInstance().buscarPorId(novoIdMedico));
                        agendamentoAtualizar.setSala(SalaRepository.getInstance().buscarPorId(novaIdSala));
                        agendaRepository.atualizar(agendamentoAtualizar);
                        System.out.println("Agendamento atualizado com sucesso.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o ID do agendamento a ser removido: \n> ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    Agenda agendamentoRemover = agendaRepository.buscarPorId(idRemover);
                    if (agendamentoRemover != null) {
                        agendaRepository.deletar(agendamentoRemover);
                        System.out.println("Agendamento removido com sucesso.");
                    } else {
                        System.out.println("Agendamento não encontrado.");
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
