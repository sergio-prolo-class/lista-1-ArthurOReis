package org.example;

public class App {
    public static void main(String[] args) {
        /* 
        Switch-case de decisão de como agir de acordo com argumento recebido;
        Caso um argumento inválido (não esperado pelo algoritmo), retornará uma resposta padrão seguido de saída;
        */
        switch(args[0]){
            case "retangulo":
                get_retangulo(args[1], args[2]);
                break;
            case "triangulo":
                get_triangulo(args[1]);
                break;
            case "losango":
                System.out.println("É um losango");
                break;
            default:
                System.out.println("Forma desconhecida ou não prevista");
                break;
        }
    }

    public static void get_triangulo(String tamanho_str){
        int tamanho = Integer.parseInt(tamanho_str);
        String triangulo[][] = new String[tamanho][tamanho];
        int espaco_restante = tamanho - 1; // Variável referente ao tamanho dos vetores (começando no index zero, o que explica o porquê do tamanho decrementado por um)

        /*
        Nessa iteração com um conjunto de vetores do tamanho de um quadrado perfeito, é verificado
        em cada linha todos os espaços restantes para cada ponto inserido
        
        i: altura
        j: largura
        */
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                triangulo[i][j] = (j - espaco_restante < 0) ? " " : "*";
            }
            espaco_restante--;
        }

        /*
        Imprimindo o triângulo
        */
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(triangulo[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void get_retangulo(String largura_str, String altura_str){
        int largura = Integer.parseInt(largura_str);
        int altura = Integer.parseInt(altura_str);
        String retangulo[][] = new String[altura][largura];
        
        /*
        Nessa iteração com um conjunto de vetores do tamanho de um quadrado perfeito, é verificado
        em cada linha se a iteração está nas extremidades verticais do retângulo; Enquanto que nas
        extremidades horizontais são preenchidas por padrão
        
        i: altura
        j: largura
        */
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                retangulo[0][j] = "*";
                retangulo[i][j] = (j == 0 || j - (largura - 1) == 0) ? "*"  : " ";
                retangulo[altura - 1][j] = "*";
            }
        }

        /*
        Imprimindo o retângulo
        */
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                System.out.print(retangulo[i][j]);
            }
            System.out.print("\n");
        }
    }
}