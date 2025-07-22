package util;

import java.time.LocalDate;

import model.Departamento;
import model.Endereco;
import model.Medico;
import model.Paciente;
import model.PlanoSaude;
import repository.DepartamentoRepository;
import repository.EnderecoRepository;
import repository.MedicoRepository;
import repository.PacienteRepository;
import repository.PlanoSaudeRepository;


public class RepositoryInitializer {
    public static void inicializar() {
        EnderecoRepository enderecoRepo = new EnderecoRepository();
        PacienteRepository pacienteRepo = new PacienteRepository();
        PlanoSaudeRepository planoRepo = new PlanoSaudeRepository();
        DepartamentoRepository departamentoRepo = new DepartamentoRepository();
        MedicoRepository medicoRepo = new MedicoRepository();

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
        enderecoRepo.buscarTodos().forEach(System.out::println);

        // Criando e salvando planos de saude
        planoRepo.salvar(new PlanoSaude("Unimed"));
        planoRepo.salvar(new PlanoSaude("Bradesco Saude"));
        planoRepo.salvar(new PlanoSaude("Amil"));
        planoRepo.salvar(new PlanoSaude("SulAmerica"));
        planoRepo.buscarTodos().forEach(System.out::println);

        // Criando e salvando departamentos
        departamentoRepo.salvar(new Departamento("Clinico Geral"));
        departamentoRepo.salvar(new Departamento("Pediatria"));
        departamentoRepo.salvar(new Departamento("Cardiologia"));
        departamentoRepo.salvar(new Departamento("Ortopedia"));
        departamentoRepo.buscarTodos().forEach(System.out::println);
    
        // Criando e salvando pacientes
        pacienteRepo.salvar(new Paciente("Ana Silva", "12345678901", LocalDate.of(1990, 1, 1), enderecoRepo.buscarPorId(1), planoRepo.buscarPorId(1)));
        pacienteRepo.salvar(new Paciente("Carla Pereira", "34567890123", LocalDate.of(1992, 3, 3), enderecoRepo.buscarPorId(3), planoRepo.buscarPorId(3)));
        pacienteRepo.salvar(new Paciente("Daniel Costa", "45678901234", LocalDate.of(1988, 4, 4), enderecoRepo.buscarPorId(4), null));
        pacienteRepo.salvar(new Paciente("Eduarda Lima", "56789012345", LocalDate.of(1995, 5, 5), enderecoRepo.buscarPorId(5), planoRepo.buscarPorId(2)));
        pacienteRepo.salvar(new Paciente("Fabio Alves", "67890123456", LocalDate.of(1980, 6, 6), enderecoRepo.buscarPorId(6), planoRepo.buscarPorId(3)));
        pacienteRepo.salvar(new Paciente("Gabriela Rocha", "78901234567", LocalDate.of(1993, 7, 7), enderecoRepo.buscarPorId(7), planoRepo.buscarPorId(4)));
        pacienteRepo.salvar(new Paciente("Henrique Dias", "89012345678", LocalDate.of(1987, 8, 8), enderecoRepo.buscarPorId(8), null));
        pacienteRepo.salvar(new Paciente("Isabela Torres", "90123456789", LocalDate.of(1991, 9, 9), enderecoRepo.buscarPorId(9), planoRepo.buscarPorId(1)));
        pacienteRepo.salvar(new Paciente("Joao Mendes", "01234567890", LocalDate.of(1994, 10, 10), enderecoRepo.buscarPorId(10), null));
        pacienteRepo.buscarTodos().forEach(System.out::println);

        // Criando e salvando medicos
        medicoRepo.salvar(new Medico("Dr. Lucas Ramos", "11122233344", LocalDate.of(1975, 11, 11), enderecoRepo.buscarPorId(11), departamentoRepo.buscarPorId(1)));
        medicoRepo.salvar(new Medico("Dr. Marina Prado", "22233344455", LocalDate.of(1978, 12, 12), enderecoRepo.buscarPorId(12), departamentoRepo.buscarPorId(2)));
        medicoRepo.salvar(new Medico("Dr. Pedro Nunes", "33344455566", LocalDate.of(1982, 1, 13), enderecoRepo.buscarPorId(13), departamentoRepo.buscarPorId(3)));
        medicoRepo.salvar(new Medico("Dr. Sofia Castro", "44455566677", LocalDate.of(1984, 2, 14), enderecoRepo.buscarPorId(14), departamentoRepo.buscarPorId(4)));
        medicoRepo.buscarTodos().forEach(System.out::println);
    }

}
