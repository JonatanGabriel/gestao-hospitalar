# SGHSS - Sistema de Gestão Hospitalar e de Serviços de Saúde 🏥

Projeto **backend** desenvolvido com **Java 21, Spring Boot e PostgreSQL**, voltado para a gestão completa de pacientes, profissionais de saúde, prontuários e consultas.  
Construído com foco em **segurança (LGPD)**, **escalabilidade** e **arquitetura em camadas**.

---

## 🔧 Tecnologias Utilizadas
- Java 21  
- Spring Boot (Web, Data JPA, Security)  
- PostgreSQL  
- JWT (autenticação)  
- Postman (testes de API)  
- IntelliJ IDEA  

---

## 🏥 Funcionalidades

### Pacientes
- Cadastro, edição e exclusão  
- Listagem geral e por ID  
- Registro de histórico clínico (prontuários)  
- Vínculo com consultas  

### Médicos
- Cadastro, edição e exclusão  
- Gerenciamento de agenda por meio das consultas  

### Consultas
- Agendamento e cancelamento  
- Vínculo entre médico e paciente  
- Registro de observações e tipo de consulta  

### Prontuários
- Criação com anotações médicas e receitas digitais  
- Ligação com paciente e médico  
- Consulta e exclusão  

### Segurança
- Cadastro de usuários com senha criptografada  
- Login com **JWT**  
- Proteção de rotas sensíveis  
- Conformidade com a **LGPD**  

### Relatórios
- Total de consultas por paciente  

---

## 🔐 Fluxo de Autenticação
1. Login: `POST /usuarios/login`  
2. Copie o **token JWT** retornado  
3. Utilize no header das requisições:  

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 21  
- PostgreSQL  
- Maven (via IntelliJ IDEA ou terminal)  
- Postman  

### Passos:
1. Clone o repositório
2. Configure o banco PostgreSQL com:
    - Database: `gestao_hospitalar`
    - Usuário e senha no `application.properties`
3. Rode o projeto (`GestaoHospitalarApplication.java`)
4. Use o Postman para acessar os endpoints REST

---

## 📁 Organização do Projeto

├── controller        -> Camada de controle (endpoints REST)
├── model             -> Entidades do sistema
├── repository        -> Acesso e persistência de dados
├── service           -> Regras de negócio
├── dto               -> Objetos de transferência de dados
└── application.properties

---

### 📌 Exemplos de Endpoints
*Criar Paciente*
POST /pacientes
Content-Type: application/json
Authorization: Bearer <token>

{
  "nome": "João Silva",
  "cpf": "12345678900",
  "dataNascimento": "1990-01-01",
  "telefone": "99999-9999"
}

*Listar Pacientes*
GET /pacientes
Authorization: Bearer <token>

*Criar Consulta*
POST /consultas
Content-Type: application/json
Authorization: Bearer <token>

{
  "pacienteId": 1,
  "medicoId": 2,
  "data": "2025-08-20T10:30:00",
  "observacoes": "Consulta de rotina",
  "tipo": "Clínico Geral"
}

---

### 🖼️ Representações Visuais

*Arquitetura do Sistema*
[Cliente/Postman] → [Controller] → [Service] → [Repository] → [PostgreSQL]

*Modelo de Entidades*
Paciente (1) ---- (N) Consulta (N) ---- (1) Médico
   |                                   |
   |---- (N) Prontuário (N) ------------|
