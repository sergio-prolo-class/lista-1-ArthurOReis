package org.example;

public class App {
    public static void main(String[] args) {
        switch(args[0]){
            case "quadrado":
                System.out.println("É um quadrado");
                break;
            case "triangulo":
                System.out.println("É um triangulo");
                break;
            case "losango":
                System.out.println("É um losango");
                break;
            default:
                System.out.println("Forma desconhecida");
                break;
        }
    }
}