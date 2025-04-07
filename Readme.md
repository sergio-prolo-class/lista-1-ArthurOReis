# Lista 1: Ambiente Java, git e Gradle
## Engenharia de Telecomunicações - Prof. Sergio Prolo
## Programação Orientada a Objetos sergio.prolo@ifsc.edu.br

#### 31/03/2025
#### Aluno: Arthur Oliveira dos Reis

- No repositório do GitHub, há uma pasta separada para cada exercício. Dentro de cada, você deve
criar um projeto Java utilizando o Gradle e configurar seus arquivos para que a tarefa run seja
executada de modo ‘silencioso’.

- Durante o desenvolvimento, é importante realizar commits frequentes. Por exemplo: um commit
após a criação do projeto, outro após implementar uma funcionalidade, e assim por diante. Ao
concluir um exercício, não esqueça de fazer um push para atualizar o repositório no GitHub.

- Na raiz do projeto, edite o arquivo Readme.md e inclua o seu nome. Esse arquivo deve ser atualizado a cada novo exercício resolvido, com instruções claras de como executar a aplicação Java
correspondente.

- Não envie para o repositório arquivos binários ou gerados automaticamente, como arquivos .class,
arquivos da IDE ou outros arquivos temporários. Use o .gitignore para evitar isso (veja os slides
sobre git).

- Todas as aplicações desenvolvidas serão avaliadas com base em critérios de legibilidade, clareza e
organização do código [15 pontos].

---

## Aplicação 1 

```shell
gradle run --args "triangulo 5"

    *
   **
  ***
 ****
*****
```

```shell
gradle run --args "losango 5"

  *
 ***
*****
 ***
  *
```

```shell
gradle run --args "retangulo 8 5"

********
*      *
*      *
*      *
********
```


## Aplicação 2

```shell
gradle run --args "amarelo branco verde azul"

Resistência: 4,9 M Ohms (+- 0,25%)
```


## Aplicação 3

```shell
gradle run
C C C . . . . . . .
. . . . . . . . . .
. . . . . S S S . .
. . . . . . . . . .
. P P P P P . . . .
. . . . . . . E . .
. . . . . . . E . .
. . . . . . . E . .
. . . . . . . E . .
. . . N N . . . . .
```

## Aplicação 4

```shell
gradle run < tabuleiro.txt

Tabuleiro válido
```
