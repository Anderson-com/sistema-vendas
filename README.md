# 🛒 Sistema de Cadastro e Vendas

Sistema desktop desenvolvido em **Java Swing** com banco de dados **MySQL**, criado como Projeto Integrador do curso. O sistema permite cadastrar clientes, registrar vendas, consultar dados e gerar relatórios, com controle de acesso por tipo de usuário.

---

## 🖥️ Tecnologias Utilizadas

| Tecnologia | Versão |
|------------|--------|
| Java       | 17+    |
| Java Swing | —      |
| MySQL      | 8.0+   |
| JDBC       | —      |
| NetBeans   | 21+    |

---

## 📁 Estrutura de Pastas

```
src/
├── MODEL/          # Entidades de domínio (Cliente, Usuario, Vendas)
├── REPOSITORY/     # Acesso ao banco de dados e SQL
├── CONTROLLER/     # Orquestração do fluxo e tratamento de erros
├── SERVICE/        # Regras de negócio reutilizáveis (CPF, Data)
├── VIEWS/          # Telas da interface gráfica (Swing)
└── TESTES/         # Testes manuais das regras refatoradas
```

---

## ⚙️ Como Executar

### Pré-requisitos
- Java 17 ou superior instalado
- MySQL 8.0 ou superior instalado
- NetBeans IDE

### 1. Configurar o Banco de Dados

Execute os comandos abaixo no MySQL:

```sql
CREATE DATABASE sistema_vendas;
USE sistema_vendas;

CREATE TABLE clientes (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(15)
);

CREATE TABLE usuarios (
    login VARCHAR(50) PRIMARY KEY,
    senha VARCHAR(64) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    cpf VARCHAR(11)
);

CREATE TABLE vendas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_venda DATE NOT NULL,
    cpf_cliente VARCHAR(11) NOT NULL,
    nome_cliente VARCHAR(100),
    produto VARCHAR(100),
    valor DOUBLE
);
```

### 2. Configurar a Conexão

Edite o arquivo `src/CONTROLLER/Conexao.java` com suas credenciais:

```java
private static final String URL     = "jdbc:mysql://localhost:3306/sistema_vendas";
private static final String USUARIO = "root";
private static final String SENHA   = "sua_senha";
```

### 3. Executar o Projeto

Abra o projeto no NetBeans e execute a classe:

```
src/VIEWS/Login.java
```

### 4. Usuário Admin Padrão

Insira um usuário admin diretamente no banco para o primeiro acesso:

```sql
INSERT INTO usuarios (login, senha, tipo, cpf)
VALUES ('admin', SHA2('admin123', 256), 'admin', '00000000000');
```

---

## 🔐 Controle de Acesso

| Funcionalidade        | Admin | Operacional |
|-----------------------|:-----:|:-----------:|
| Gerenciar Usuários    |  ✅   |     ❌      |
| Cadastrar Cliente     |  ✅   |     ✅      |
| Registrar Venda       |  ✅   |     ✅      |
| Relatório de Vendas   |  ✅   |     ✅      |
| Consultar por CPF     |  ✅   |     ✅      |

---

## 🚀 Funcionalidades

- **Login** com autenticação e validação de campos
- **Cadastro de Clientes** com máscara de CPF e telefone
- **Registro de Vendas** com busca automática de cliente por CPF
- **Relatório de Vendas** com filtro por data e por período
- **Consulta de Vendas** por CPF do cliente
- **Gerenciamento de Usuários** (somente Admin): cadastro, listagem e exclusão
- **Tema escuro** aplicado em todas as telas via `UiTheme`

---

## 🧪 Testes

Execute a classe abaixo para validar as regras de negócio sem precisar de interface gráfica:

```
src/TESTES/TesteRefatoracaoMain.java
```

Cenários testados:
1. Remoção de máscara do CPF
2. Formatação de CPF
3. Conversão de data tela → banco
4. Conversão de data banco → tela
5. Rejeição de data inválida no model Vendas

---

## 📐 Princípios Aplicados

- **SRP** — cada camada tem uma única responsabilidade
- **OCP** — regras de CPF, data e tema podem ser estendidas sem alterar as telas
- **DRY** — sem duplicação de validações ou estilos

---

## 👤 Autor

**Anderson**  
Projeto Integrador — 2026
