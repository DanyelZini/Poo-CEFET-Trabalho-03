
# Sistema de Gerenciamento Hospitalar

Este projeto é um sistema de gerenciamento hospitalar em Java, com operações CRUD para pacientes, médicos, agendamentos, departamentos, endereços, planos de saúde e salas. O sistema é executado via terminal, com menus interativos.

## Estrutura do Projeto

- **src/model/**: Contém as classes de domínio, como `Paciente`, `Medico`, `Agenda`, `Departamento`, `Endereco`, `PlanoSaude` e `Sala`.
- **src/repository/**: Repositórios responsáveis pelo armazenamento em memória e operações CRUD para cada entidade.
- **src/interfaces/**: Interface genérica `CrudRepository` para padronizar as operações CRUD.
- **src/menu/**: Menus interativos para cada entidade, além do menu principal.
- **src/util/**: Utilitários como validação e formatação de CPF e inicialização de dados de exemplo.
- **src/App.java**: Classe principal que inicializa os repositórios e exibe o menu principal.

## Funcionamento

1. **Inicialização**: O sistema carrega dados de exemplo ao iniciar.
2. **Menu Principal**: Permite acessar os menus de CRUD para cada entidade.
3. **Operações CRUD**: Cada menu permite criar, listar, atualizar e remover registros.
4. **Validações**: O sistema valida CPFs e garante unicidade dos dados principais.

## Como Executar

1. Compile os arquivos Java em `src/` (saída em `bin/`).
2. Execute a classe `App` para iniciar o sistema.

