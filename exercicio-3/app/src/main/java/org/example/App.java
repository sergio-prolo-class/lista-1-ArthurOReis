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
import java.util.Random;

class Barco {
    private String nome;
    private int tamanho;
    private boolean foi_inserido;
    private char simbolo;

    public Barco() {
        this.nome = "";
        this.tamanho = 0;
        this.foi_inserido = false;
        this.simbolo = '#';
    }

    public void setNomeDoBarco(String nome) {
        this.nome = nome;
    }

    public void setTamanhoBarco(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setFoiInserido(boolean foi_inserido) {
        this.foi_inserido = foi_inserido;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public String getNomeDoBarco() {
        return nome;
    }

    public int getTamanhoBarco() {
        return tamanho;
    }

    public boolean getFoiInserido() {
        return foi_inserido;
    }

    public char getSimbolo() {
        return simbolo;
    }
}

public class App {

    public static void main(String[] args) {

        /*
        
        Inicializando o tabuleiro em forma de arranjos duplos de String
        
        */

        String[][] tabuleiro = new String[10][10];

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = ".";
            }
        }

        /*

        Para esse exercício, resolvi criar uma classe do tipo Barco, pois na minha cabeça fazia sentido,
        principalmente pelo fato de que os barcos possuem atributos o suficiente para inserí-los em uma
        estrutura, dessa forma, utilizando a POO a meu favor para facilitar a renderização de barcos no
        tabuleiro, na ordem certa
        
        */

        Barco barcos[] = new Barco[5];

        barcos[0] = new Barco();
        barcos[0].setNomeDoBarco("Porta-aviões");
        barcos[0].setTamanhoBarco(5);
        barcos[0].setSimbolo('P');

        barcos[1] = new Barco();
        barcos[1].setNomeDoBarco("Encouraçado");
        barcos[1].setTamanhoBarco(4);
        barcos[1].setSimbolo('E');

        barcos[2] = new Barco();
        barcos[2].setNomeDoBarco("Cruzador");
        barcos[2].setTamanhoBarco(3);
        barcos[2].setSimbolo('C');

        barcos[3] = new Barco();
        barcos[3].setNomeDoBarco("Submarino");
        barcos[3].setTamanhoBarco(3);
        barcos[3].setSimbolo('S');

        barcos[4] = new Barco();
        barcos[4].setNomeDoBarco("Contratorpedeiro");
        barcos[4].setTamanhoBarco(2);
        barcos[4].setSimbolo('N');

        set_Barcos(barcos, tabuleiro); // Essa função é a responsável por todo o trabalho de inserir e posicionar os barcos

        /*
        
        Por fim, é exibido o tabuleiro final, depois de todo o trabalho por baixo dos panos
        
        */
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void set_Barcos(Barco[] barcos, String[][] tabuleiro) {
        Random rand = new Random();

        for (int i = 0; i < barcos.length; i++) {
            int linha, coluna, direcao;

            do {
                linha = rand.nextInt(10);
                coluna = rand.nextInt(10);
                direcao = verificando_posicoes(tabuleiro, barcos[i], linha, coluna, rand);
            } while (direcao == -1);

            inserir_barco(tabuleiro, barcos[i], linha, coluna, direcao);
        }
    }

    public static int verificando_posicoes(String[][] tabuleiro, Barco barco, int linha, int coluna, Random random) {
        return 1;
    }

    public static void inserir_barco(String[][] tabuleiro, Barco barco, int linha, int coluna, int direcao) {

    }

}