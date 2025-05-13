# SGHSS - Sistema de Gestão Hospitalar e de Serviços de Saúde

Projeto back-end desenvolvido com Java, Spring Boot e PostgreSQL para gestão completa de pacientes, profissionais de saúde, prontuários e consultas, com foco em segurança (LGPD), escalabilidade e arquitetura em camadas.

## 🔧 Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (autenticação)
- PostgreSQL
- Postman (testes)
- IntelliJ IDEA

## 🏥 Funcionalidades Implementadas

### Pacientes
- Cadastro, edição e exclusão
- Listagem geral e por ID
- Registro de histórico clínico (prontuários)
- Vínculo com consultas

### Médicos
- Cadastro, edição e exclusão
- Gerenciamento de agenda via consultas

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
- Login com JWT (JSON Web Token)
- Proteção de rotas sensíveis
- Conformidade com a LGPD

### Relatórios
- Total de consultas por paciente

## 🔐 Acesso e Autenticação
Para acessar os endpoints protegidos:
1. Faça login via `POST /usuarios/login`
2. Copie o token JWT retornado
3. Adicione como `Authorization: Bearer <token>` nos headers do Postman

## 🚀 Como Executar o Projeto

### Pré-requisitos:
- Java 21
- PostgreSQL
- IntelliJ com Maven
- Postman

### Passos:
1. Clone o repositório
2. Configure o banco PostgreSQL com:
   - Database: `gestao_hospitalar`
   - Usuário e senha no `application.properties`
3. Rode o projeto (`GestaoHospitalarApplication.java`)
4. Use o Postman para acessar os endpoints REST

## 📁 Organização do Projeto

