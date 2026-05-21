Sistema ERP em desenvolvimento para gerenciamento de ordens de serviço,
manutenção técnica, controle de estoque e atendimento ao cliente.

O objetivo do projeto é centralizar os processos operacionais de assistência
técnica, permitindo rastreabilidade de equipamentos, histórico de manutenções
e controle de itens utilizados nos serviços.

---

## Funcionalidades

### Clientes
- Cadastro de clientes físicos e jurídicos
- Histórico de atendimentos
- Relacionamento com equipamentos

### Equipamentos
- Registro de equipamentos por cliente
- Controle de fabricante e modelo
- Histórico de manutenção

### Ordens de Serviço
- Abertura e acompanhamento de OS
- Controle de status
- Associação com manutenção e serviços técnicos

### Manutenção
- Registro de defeitos e diagnósticos
- Controle de peças utilizadas
- Histórico técnico

### Estoque
- Cadastro de itens
- Controle de quantidade por estoque
- Movimentação de entrada e saída

### Serviços
- Atendimento remoto
- Serviço local
- Controle de itens utilizados em serviços

---

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Docker
- Git/GitHub
- Swagger / OpenAPI

---

## Arquitetura Atual

Atualmente o projeto utiliza arquitetura organizada por camadas.

```text
com.gestaooserp
└── dev
    ├── controller
    ├── entity
    ├── repository
    └── service
```

Essa estrutura foi adotada inicialmente para acelerar o desenvolvimento das
regras de negócio e da modelagem do domínio do sistema.

---

## Evolução Arquitetural Planejada

Com o crescimento do ERP e aumento da quantidade de entidades e regras de
negócio, o projeto será gradualmente migrado para uma arquitetura modular
baseada em domínio.

### Estrutura planejada

```text
com.gestaooserp
│
├── cliente
├── manutencao
├── estoque
├── item
├── ordemservico
├── equipamento
├── common
├── config
└── exception
```

Cada módulo possuirá sua própria organização interna contendo:
- controller
- service
- repository
- entity
- dto

### Objetivos da evolução arquitetural

- Melhorar escalabilidade
- Facilitar manutenção
- Reduzir acoplamento
- Organizar responsabilidades por contexto de negócio

---

## Modelagem do Banco de Dados

O sistema está sendo modelado utilizando relacionamento relacional normalizado,
visando escalabilidade e manutenção futura.

### Principais decisões arquiteturais

- Separação entre clientes físicos e jurídicos utilizando herança (`JOINED`)
- Entidades associativas para controle de itens em manutenção
- Organização baseada em domínio
- Controle de estoque desacoplado dos itens
- Estrutura preparada para movimentação de estoque futura

---

## Principais Entidades

- Cliente
- ClienteFisico
- ClienteJuridico
- Equipamento
- OrdemServico
- Manutencao
- Item
- Estoque
- ManutencaoItem
- ServicoLocal
- AtendimentoRemoto

---

## Roadmap do Projeto

### Backend
- [ ] Implementar DTO Pattern
- [ ] Implementar Swagger / OpenAPI
- [ ] Criar Exception Handler global
- [ ] Adicionar Bean Validation
- [ ] Implementar autenticação JWT

### Banco de Dados
- [ ] Implementar movimentação de estoque
- [ ] Adicionar auditoria de operações
- [ ] Melhorar rastreabilidade de itens

### Infraestrutura
- [ ] Dockerização completa
- [ ] Deploy em VPS
- [ ] Pipeline CI/CD


---

## Objetivos de Aprendizado

Este projeto também está sendo utilizado para aprofundamento em:

- Arquitetura Backend
- Modelagem de Banco de Dados
- Spring Boot
- APIs REST
- Boas práticas de desenvolvimento
- Organização modular
- Docker e deploy

---

## Status do Projeto

🚧 Em desenvolvimento

O sistema está em evolução contínua e novas funcionalidades estão sendo
adicionadas gradualmente.

---

## Autor

Hiago Ramos

Desenvolvedor Backend Java focado em:
- Spring Boot
- Modelagem de sistemas
- APIs REST
- Arquitetura de software
- Sistemas ERP e gestão operacional
