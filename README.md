# Simulação de Gerenciamento de Memória

Este programa em Java simula o gerenciamento de memória em um sistema de computador. Ele utiliza três estratégias de alocação de memória: First Fit, Best Fit e Worst Fit. O programa permite aos usuários realizar diversas operações de memória, como escrever novos processos, excluir processos e visualizar o estado atual da memória.

## Sumário

1. [Recursos](#recursos)
2. [Apresentação do Sistema de Gerenciamento de Memória](#apresentação-do-sistema-de-gerenciamento-de-memória)
3. [Dependências](#dependências)
4. [Instalação](#instalação)
5. [Uso](#uso)
6. [Estratégias de Alocação de Memória](#estratégias-de-alocação-de-memória)
7. [Visão Geral das Classes](#visão-geral-das-classes)

## Recursos

- Simulação de gerenciamento de memória com três estratégias de alocação: First Fit, Best Fit e Worst Fit.
- Escrita de novos processos na memória.
- Exclusão de processos da memória.
- Visualização do estado atual da memória.
- Interface simples e intuitiva para o usuário via linha de comando.

## Apresentação do Sistema de Gerenciamento de Memória

### Arquitetura do Sistema

O sistema é composto pelas seguintes classes:

- `Main`: Contém o método principal para executar o programa. Lida com a entrada e interação do usuário.
- `MemoryManager`: Gerencia a memória física e fornece métodos para escrever, excluir e recuperar processos de memória. Implementa as estratégias de alocação de memória.
- `Process`: Representa um processo com um identificador único e um tamanho especificado na memória.
- `Execute`: Facilita a interação com o sistema, permitindo criar e apagar processos.

A comunicação entre as classes ocorre da seguinte forma:

- `Main` interage com `MemoryManager` e `Execute` para controlar o fluxo principal do programa.
- `MemoryManager` recebe comandos de alocação e desalocação de processos, implementando diferentes estratégias de alocação.
- `Execute` fornece métodos para criar e apagar processos, delegando as operações ao `MemoryManager`.
- `Process` é usado para representar os processos na memória, fornecendo informações sobre o tamanho e o ID.

### Funcionamento do Sistema

O sistema é inicializado com uma memória física de 128 KB e permite as seguintes operações:

1. Criar um novo processo com um tamanho especificado.
2. Apagar um processo existente fornecendo o ID do processo.
3. Ler o estado atual da memória física.
4. Sair do programa.

A alocação de memória é realizada de acordo com a estratégia selecionada pelo usuário (FirstFit, BestFit ou WorstFit). Caso não haja espaço suficiente na memória, uma mensagem de erro é exibida.

## Dependências

Este projeto não possui dependências externas além do Java Development Kit (JDK) padrão.

## Instalação

1. Clone o repositório em sua máquina local:

    ```bash
    git clone https://github.com/taavaresdiego/memoryProject.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd memoryProject
    ```

3. Compile os arquivos Java:

    ```bash
    javac *.java
    ```

## Uso

1. Execute o programa principal:

    ```bash
    java memorymanagement.Main
    ```

2. Siga as instruções na tela para selecionar uma estratégia de alocação de memória e realizar operações de memória.

## Estratégias de Alocação de Memória

1. **First Fit**:
    - Pesquisa a memória desde o início e aloca o primeiro bloco disponível de memória que seja grande o suficiente para acomodar o processo.

2. **Best Fit**:
    - Pesquisa toda a memória em busca do menor bloco disponível que possa acomodar o processo. Seleciona o bloco com o menor desperdício.

3. **Worst Fit**:
    - Pesquisa toda a memória em busca do maior bloco disponível. Aloca o processo no bloco com o máximo de espaço disponível.

## Visão Geral das Classes

1. **Main**: Contém o método principal para executar o programa. Lida com a entrada e interação do usuário.
2. **MemoryManager**: Gerencia a memória física e fornece métodos para escrever, excluir e recuperar processos de memória. Implementa as estratégias de alocação de memória.
3. **Process**: Representa um processo com um identificador único e um tamanho especificado na memória.
4. **Execute**: Facilita a interação com o sistema, permitindo criar e apagar processos.

