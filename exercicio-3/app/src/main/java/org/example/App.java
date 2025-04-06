/*
Batalha naval é um jogo de tabuleiro em que dois jogadores precisam afundar a frota do adversário.
Cada jogador possui um tabuleiro com dimensões 10×10.
No início da partida, os jogadores posicionam seus navios na vertical ou horizontal, não sendo permitido a sobreposição de navios.
A Tabela 1 apresenta uma lista dos navios em jogo.
Desenvolva um aplicativo em Java que gere um tabuleiro, posicione de forma aleatória a frota de um jogador e imprima na tela o tabuleiro gerado.
Para casas que contém um navio posicionado, imprima o símbolo do navio.
Para as casas que não contém navios, imprima o caractere ponto. Separe as casas da mesma linha com espaços.

*/

/*

Porta-aviões - 5 (Tamanho) - P (Símbolo)
Encouraçado - 4 (Tamanho) - E (Símbolo)
Cruzador - 3 (Tamanho) - C (Símbolo)
Submarino - 3 (Tamanho) - S (Símbolo)
Contratorpedeiro - 2 (Tamanho) - N (Símbolo)

*/
package org.example;

public class App {

    public static void main(String[] args) {
        String[][] tabuleiro = new String[10][10];

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = ".";
            }
        }
    }
}
