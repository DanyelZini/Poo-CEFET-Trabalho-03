package util;

import java.time.LocalDate;

import model.Agenda;
import model.Departamento;
import model.Endereco;
import model.Medico;
import model.Paciente;
import model.PlanoSaude;
import model.Sala;
import repository.AgendaRepository;
import repository.DepartamentoRepository;
import repository.EnderecoRepository;
import repository.MedicoRepository;
import repository.PacienteRepository;
import repository.PlanoSaudeRepository;
import repository.SalaRepository;


public class RepositoryInitializer {
    public static void inicializar() {
        EnderecoRepository enderecoRepo = new EnderecoRepository();
        PacienteRepository pacienteRepo = new PacienteRepository();
        PlanoSaudeRepository planoRepo = new PlanoSaudeRepository();
        DepartamentoRepository departamentoRepo = new DepartamentoRepository();
        MedicoRepository medicoRepo = new MedicoRepository();
        SalaRepository salaRepo = new SalaRepository();
        AgendaRepository agendaRepo = new AgendaRepository();

        // Criando e salvando um endereço
        enderecoRepo.salvar(new Endereco( 100, "Av. Paulista", "Bela Vista", "Sao Paulo", "SP", "01311 -000"));
        enderecoRepo.salvar(new Endereco(200, "Rua XV de Novembro", "Centro", "Curitiba", "PR", "80020-310"));
        enderecoRepo.salvar(new Endereco(300, "Av. Atlantica", "Copacabana", "Rio de Janeiro", "RJ", "22021-001"));
        enderecoRepo.salvar(new Endereco(400, "Av. Afonso Pena", "Centro", "Belo Horizonte", "MG", "30130-003"));
        enderecoRepo.salvar(new Endereco(500, "Rua das Flores", "Centro", "Florianopolis", "SC", "88010-020"));
        enderecoRepo.salvar(new Endereco(600, "Rua 24 de Outubro", "Moinhos de Vento", "Porto Alegre", "RS", "90510-002"));
        enderecoRepo.salvar(new Endereco(700, "Av. Sete de Setembro", "Campo Grande", "Salvador", "BA", "40060-001"));
        enderecoRepo.salvar(new Endereco(800, "Av. Boa Viagem", "Boa Viagem", "Recife", "PE", "51011-000"));
        enderecoRepo.salvar(new Endereco(900, "Rua Barao de Aracati", "Meireles", "Fortaleza", "CE", "60115-080"));
        enderecoRepo.salvar(new Endereco(1000, "Av. Governador Jose Malcher", "Nazare", "Belem", "PA", "66035-100"));
        enderecoRepo.salvar(new Endereco(1100, "Rua Oscar Freire", "Jardins", "Sao Paulo", "SP", "01426-001"));
        enderecoRepo.salvar(new Endereco(1200, "Rua Augusta", "Consolacao", "Sao Paulo", "SP", "01305-100"));
        enderecoRepo.salvar(new Endereco(1300, "Av. Brasil", "Jardim America", "Sao Paulo", "SP", "01431-000"));
        enderecoRepo.salvar(new Endereco(1400, "Rua das Palmeiras", "Botafogo", "Rio de Janeiro", "RJ", "22270-070"));

        // Criando e salvando planos de saude
        planoRepo.salvar(new PlanoSaude("Unimed"));
        planoRepo.salvar(new PlanoSaude("Bradesco Saude"));
        planoRepo.salvar(new PlanoSaude("Amil"));
        planoRepo.salvar(new PlanoSaude("SulAmerica"));

        // Criando e salvando departamentos
        departamentoRepo.salvar(new Departamento("Clinico Geral"));
        departamentoRepo.salvar(new Departamento("Pediatria"));
        departamentoRepo.salvar(new Departamento("Cardiologia"));
        departamentoRepo.salvar(new Departamento("Ortopedia"));
    
        // Criando e salvando pacientes
        pacienteRepo.salvar(new Paciente("Ana Silva", "984.597.660-39", LocalDate.of(1990, 1, 1), enderecoRepo.buscarPorId(1), planoRepo.buscarPorId(1)));
        pacienteRepo.salvar(new Paciente("Carla Pereira", "057.181.455-71", LocalDate.of(1992, 3, 3), enderecoRepo.buscarPorId(3), planoRepo.buscarPorId(3)));
        pacienteRepo.salvar(new Paciente("Daniel Costa", "472.318.313-20", LocalDate.of(1988, 4, 4), enderecoRepo.buscarPorId(4), null));
        pacienteRepo.salvar(new Paciente("Eduarda Lima", "375.865.329-07", LocalDate.of(1995, 5, 5), enderecoRepo.buscarPorId(5), planoRepo.buscarPorId(2)));
        pacienteRepo.salvar(new Paciente("Fabio Alves", "562.727.851-00", LocalDate.of(1980, 6, 6), enderecoRepo.buscarPorId(6), planoRepo.buscarPorId(3)));
        pacienteRepo.salvar(new Paciente("Gabriela Rocha", "347.179.419-00", LocalDate.of(1993, 7, 7), enderecoRepo.buscarPorId(7), planoRepo.buscarPorId(4)));
        pacienteRepo.salvar(new Paciente("Henrique Dias", "648.142.622-72", LocalDate.of(1987, 8, 8), enderecoRepo.buscarPorId(8), null));
        pacienteRepo.salvar(new Paciente("Isabela Torres", "366.284.511-35", LocalDate.of(1991, 9, 9), enderecoRepo.buscarPorId(9), planoRepo.buscarPorId(1)));
        pacienteRepo.salvar(new Paciente("Joao Mendes", "955.388.674-47", LocalDate.of(1994, 10, 10), enderecoRepo.buscarPorId(10), null));

        // Criando e salvando medicos
        medicoRepo.salvar(new Medico("Dr. Lucas Ramos", "465.954.672-16", LocalDate.of(1975, 11, 11), enderecoRepo.buscarPorId(11), departamentoRepo.buscarPorId(1)));
        medicoRepo.salvar(new Medico("Dr. Marina Prado", "475.233.328-70", LocalDate.of(1978, 12, 12), enderecoRepo.buscarPorId(12), departamentoRepo.buscarPorId(2)));
        medicoRepo.salvar(new Medico("Dr. Pedro Nunes", "100.421.868-03", LocalDate.of(1982, 1, 13), enderecoRepo.buscarPorId(13), departamentoRepo.buscarPorId(3)));
        medicoRepo.salvar(new Medico("Dr. Sofia Castro", "574.727.253-58", LocalDate.of(1984, 2, 14), enderecoRepo.buscarPorId(14), departamentoRepo.buscarPorId(4)));

        // Criando e salvando salas
        salaRepo.salvar(new Sala(1, "Sala de Emergencia"));
        salaRepo.salvar(new Sala(2, "Sala de Cirurgia"));
        salaRepo.salvar(new Sala(3, "Sala de Consulta"));
    
        // Criando e salvando agendas
        agendaRepo.salvar(new Agenda(LocalDate.of(2025, 7, 1), 8, pacienteRepo.buscarPorId(1), medicoRepo.buscarPorId(1), salaRepo.buscarPorId(1)));
        agendaRepo.salvar(new Agenda(LocalDate.of(2025, 7, 1), 9, pacienteRepo.buscarPorId(2), medicoRepo.buscarPorId(2), salaRepo.buscarPorId(2)));
        agendaRepo.salvar(new Agenda(LocalDate.of(2025, 7, 1), 10, pacienteRepo.buscarPorId(3), medicoRepo.buscarPorId(3), salaRepo.buscarPorId(3)));
        agendaRepo.salvar(new Agenda(LocalDate.of(2025, 7, 1), 11, pacienteRepo.buscarPorId(4), medicoRepo.buscarPorId(4), salaRepo.buscarPorId(2)));
        agendaRepo.salvar(new Agenda(LocalDate.of(2025, 7, 2), 8, pacienteRepo.buscarPorId(5), medicoRepo.buscarPorId(1), salaRepo.buscarPorId(3)));
        agendaRepo.salvar(new Agenda(LocalDate.of(2025, 7, 2), 9, pacienteRepo.buscarPorId(6), medicoRepo.buscarPorId(2), salaRepo.buscarPorId(1)));
        agendaRepo.salvar(new Agenda(LocalDate.of(2025, 7, 2), 10, pacienteRepo.buscarPorId(7), medicoRepo.buscarPorId(3), salaRepo.buscarPorId(1)));
        agendaRepo.salvar(new Agenda(LocalDate.of(2025, 7, 2), 11, pacienteRepo.buscarPorId(8), medicoRepo.buscarPorId(4), salaRepo.buscarPorId(2)));
        agendaRepo.salvar(new Agenda(LocalDate.of(2025, 7, 3), 8, pacienteRepo.buscarPorId(9), medicoRepo.buscarPorId(1), salaRepo.buscarPorId(3)));
    }
}
