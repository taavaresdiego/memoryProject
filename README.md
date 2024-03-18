# Simulação de Gerenciamento de Memória

Este programa em Java simula o gerenciamento de memória em um sistema de computador. Ele utiliza três estratégias de alocação de memória: First Fit, Best Fit e Worst Fit. O programa permite aos usuários realizar diversas operações de memória, como escrever novos processos, excluir processos e visualizar o estado atual da memória.

## Sumário

1. [Recursos](#recursos)
2. [Dependências](#dependências)
3. [Instalação](#instalação)
4. [Uso](#uso)
5. [Estratégias de Alocação de Memória](#estratégias-de-alocação-de-memória)
6. [Visão Geral das Classes](#visão-geral-das-classes)
7. [Contribuição](#contribuição)
8. [Licença](#licença)

## Recursos

- Simulação de gerenciamento de memória com três estratégias de alocação: First Fit, Best Fit e Worst Fit.
- Escrita de novos processos na memória.
- Exclusão de processos da memória.
- Visualização do estado atual da memória.
- Interface simples e intuitiva para o usuário via linha de comando.

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

4. **ScreenUtil**: Classe utilitária para limpar a tela do console.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar relatórios de bugs, solicitações de recursos ou pull requests por meio do [repositório no GitHub](https://github.com/taavaresdiego/memoryProject).

## Licença
