package org.example;

public class App {
    public static void main(String[] args) {
        switch(args[0]){
            case "quadrado":
                System.out.println("É um quadrado");
                break;
            case "triangulo":
                get_triangulo(args[1]);
                break;
            case "losango":
                System.out.println("É um losango");
                break;
            default:
                System.out.println("Forma desconhecida");
                break;
        }
    }
    
    public static void get_triangulo(String tamanho_str){
        int tamanho = Integer.parseInt(tamanho_str);
        String triangulo[][] = new String[tamanho][tamanho];
        int espaco = tamanho - 1;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                triangulo[i][j] = (j - espaco < 0) ? " " : "*";
            }
            espaco--;
        }

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(triangulo[i][j]);
            }
            System.out.print("\n");
        }
    }
}