# Relatorio de Refatoracao - Projeto Integrador

## 1) Principios SOLID aplicados

### SRP (Single Responsibility Principle)
- `REPOSITORY` ficou responsavel por acesso a banco e SQL:
  - `src/REPOSITORY/ClienteRepository.java`
  - `src/REPOSITORY/UsuarioRepository.java`
  - `src/REPOSITORY/VendasRepository.java`
- `CONTROLLER` passou a orquestrar fluxo e tratamento de mensagens:
  - `src/CONTROLLER/ClienteUtil.java`
  - `src/CONTROLLER/UsuarioUtil.java`
  - `src/CONTROLLER/VendasUtil.java`
- `SERVICE` centralizou regras reutilizaveis:
  - `src/SERVICE/CpfUtils.java`
  - `src/SERVICE/DataUtils.java`
- `VIEWS` ficaram com responsabilidade de UI (preencher tabela, campos e eventos):
  - `src/VIEWS/CadastroUser.java`
  - `src/VIEWS/Relatorio.java`

### OCP (Open/Closed Principle) - aplicado de forma parcial
- Regras de CPF e data foram extraidas para classes especificas, permitindo evoluir validacoes sem alterar varias telas.

## 2) Refatoracoes aplicadas

### Refatoracao A: Extracao de SQL para repositories
- Antes: SQL e regras misturados em `Util`.
- Depois: SQL isolado em classes `REPOSITORY`.
- Beneficio: menor acoplamento, melhor manutencao e melhor legibilidade.

### Refatoracao B: Remocao de dependencia de JTable na camada de controle
- Antes: `UsuarioUtil` e `VendasUtil` manipulavam `JTable`.
- Depois: `Util` retorna listas, e `VIEW` preenche tabela.
- Classes afetadas:
  - `src/CONTROLLER/UsuarioUtil.java`
  - `src/CONTROLLER/VendasUtil.java`
  - `src/VIEWS/CadastroUser.java`
  - `src/VIEWS/Relatorio.java`

### Refatoracao C: Eliminacao de duplicacao de regra de CPF e data
- Antes: formatacao/validacao repetida em varios arquivos.
- Depois: centralizacao em `CpfUtils` e `DataUtils`.

### Refatoracao D: Validacao de data mais segura em `Vendas`
- `setLenient(false)` aplicado no formatador de data para impedir datas invalidas.
- Arquivo afetado: `src/MODEL/Vendas.java`.

## 3) Testes no main()

Classe criada:
- `src/TESTES/TesteRefatoracaoMain.java`

Testes implementados:
1. Conversao e validacao de CPF.
2. Conversao de data tela/banco.
3. Cenario de erro com data invalida no model `Vendas`.

## 4) Evidencias para o GitHub

Incluir no envio:
1. Link do repositorio novo.
2. Captura da estrutura de pastas (`MODEL`, `REPOSITORY`, `SERVICE`, `CONTROLLER`, `VIEWS`, `TESTES`).
3. Captura da execucao de `TesteRefatoracaoMain`.
4. Captura dos commits.

Sugestao de commits:
1. `refactor: create repository and service layers`
2. `refactor: remove JTable dependency from controllers`
3. `test: add TesteRefatoracaoMain and final report`
