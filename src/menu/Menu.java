package menu;

public class Menu {
    java.util.Scanner scanner;

    public Menu() {
        scanner = new java.util.Scanner(System.in);
    }

    public void exibir() {
        int opcao;
        do {
            System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("1. CRUD Agendamento");
            System.out.println("2. CRUD Paciente");
            System.out.println("3. CRUD Médico");
            System.out.println("4. CRUD Departamento");
            System.out.println("5. CRUD Endereço");
            System.out.println("6. CRUD Plano de Saúde");
            System.out.println("7. CRUD Sala");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            switch (opcao) {
                case 1:
                    try {
                        MenuAgendamento.exibir(scanner);
                    } catch (Exception e) {
                        System.out.println("Erro na opção 1: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        MenuPaciente.exibir(scanner);
                    } catch (Exception e) {
                        System.out.println("Erro na opção 2: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        MenuMedico.exibir(scanner);
                    } catch (Exception e) {
                        System.out.println("Erro na opção 3: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        MenuDepartamento.exibir(scanner);
                    } catch (Exception e) {
                        System.out.println("Erro na opção 4: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        MenuEndereco.exibir(scanner);
                    } catch (Exception e) {
                        System.out.println("Erro na opção 5: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        MenuPlanoSaude.exibir(scanner);
                    } catch (Exception e) {
                        System.out.println("Erro na opção 6: " + e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        MenuSala.exibir(scanner);
                    } catch (Exception e) {
                        System.out.println("Erro na opção 7: " + e.getMessage());
                    }
                    break;
                case 0:
                    try {
                        System.out.println("Saindo...");
                    } catch (Exception e) {
                        System.out.println("Erro na opção 0: " + e.getMessage());
                    }
                    break;
                default:
                    try {
                        System.out.println("Opção inválida!");
                    } catch (Exception e) {
                        System.out.println("Erro ao tratar a opção inválida: " + e.getMessage());
                    }
            }
        } while (opcao != 0);
        scanner.close();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibir();
    }
}
