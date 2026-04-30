# Relatorio de Refatoracao - Projeto Integrador

## 1) Principios SOLID aplicados

### SRP (Single Responsibility Principle)
- Classe afetada: `CONTROLLER/UsuarioUtil.java`
  - Antes: acessava dados e tambem preenchia `JTable`.
  - Depois: ficou responsavel apenas por acesso a dados, retornando `List<Usuario>`.
  - Resultado: a responsabilidade de renderizar tabela ficou na tela `VIEWS/CadastroUser.java`.

- Classe afetada: `CONTROLLER/VendasUtil.java`
  - Antes: acessava dados e manipulava visualizacao da tabela.
  - Depois: consultas separadas em metodos que retornam `List<Vendas>`, com mapeamento de dados centralizado.
  - Resultado: menor acoplamento entre camada de dados e interface Swing.

- Novas classes utilitarias:
  - `SERVICE/CpfUtils.java`: regra unica para limpar, validar e formatar CPF.
  - `SERVICE/DataUtils.java`: regra unica para conversao de datas (`dd/MM/yyyy` <-> `yyyy-MM-dd`).
  - Justificativa: remocao de duplicacao de regra e centralizacao de comportamento.

## 2) Refatoracoes aplicadas

### Refatoracao 1: Extracao de responsabilidades de UI da camada de dados
- Arquivos afetados:
  - `src/CONTROLLER/UsuarioUtil.java`
  - `src/VIEWS/CadastroUser.java`
- Mudancas:
  - `listarUsuarios(JTable)` foi substituido por `listarUsuarios()` retornando lista.
  - A tela `CadastroUser` ganhou metodo proprio para preencher a tabela.

### Refatoracao 2: Reutilizacao de regra de CPF
- Arquivos afetados:
  - `src/SERVICE/CpfUtils.java` (novo)
  - `src/VIEWS/Dados.java`
  - `src/VIEWS/Relatorio.java`
- Mudancas:
  - Removida duplicacao de formatacao de CPF das telas.
  - Aplicada chamada unica de utilitario para formatar e limpar CPF.

### Refatoracao 3: Reutilizacao de regra de data
- Arquivos afetados:
  - `src/SERVICE/DataUtils.java` (novo)
  - `src/CONTROLLER/VendasUtil.java`
  - `src/MODEL/Vendas.java`
- Mudancas:
  - Conversao de data padronizada em classe utilitaria.
  - Validacao de data em `Vendas` com `setLenient(false)` para evitar datas invalidas.

### Refatoracao 4: Metodo main para testes
- Arquivo criado:
  - `src/TESTES/TesteRefatoracaoMain.java`
- Cobertura dos testes no `main()`:
  - Conversao e validacao de CPF.
  - Conversao de data para banco e exibicao.
  - Cenario de erro com data invalida no objeto `Vendas`.

## 3) Padrao de projeto

- Padrao observado e reforcado: separacao em camadas (View/Model/Controller + Service).
- Justificativa:
  - Views tratam somente interacao com usuario.
  - Controller trata acesso a dados.
  - Service concentra regras reutilizaveis (CPF e data).

## 4) Evidencias do repositorio GitHub

Inserir no envio final:
- Link do repositorio.
- Prints da estrutura do projeto com as novas classes.
- Print dos commits de refatoracao.
- Print da execucao da classe `TESTES.TesteRefatoracaoMain`.

Sugestao de commits:
1. `refactor: separar listagem de usuarios da camada de UI`
2. `refactor: centralizar regra de cpf e data em services`
3. `test: adicionar TesteRefatoracaoMain com cenarios basicos`
