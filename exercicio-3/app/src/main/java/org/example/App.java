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
                /*
                Nesse trecho, é recebido uma posição aleatória dentro do tabuleiro, e em seguida será
                selecionado uma direção (Norte, Sul, Leste, Oeste) aleatória e verificá-la se está vazia.
                Se não for o caso, outro ponto será gerado e o algoritmo irá repetir.
                */
                linha = rand.nextInt(10);
                coluna = rand.nextInt(10);
                direcao = verificando_posicoes(tabuleiro, barcos[i], linha, coluna, rand);
            } while (direcao == -1);

            inserir_barco(tabuleiro, barcos[i], linha, coluna, direcao);
        }
    }

    public static int verificando_posicoes(String[][] tabuleiro, Barco barco, int linha, int coluna, Random random) {
        int sentido = random.nextInt(4);
        boolean regiao_livre = true;

        /*
        Nessa função, o que está acontecendo é que será gerado um sentido aleatório (Norte, Sul, Leste, Oeste) em forma de inteiro, e será verificado
        se não há nenhum barco ocupando o espaço. Portanto, se não for o caso, será retornado o valor da direção, que será usada futuramente
        para inserir o barco; Se o contrário, isso é se o espaço não estiver livre, retornará '-1', que fará com que essa função seja executada novamente.
        */

        for (int i = 0; i < barco.getTamanhoBarco(); i++) {
            switch (sentido) {
                case 0: // Sentido norte
                    if (linha - i < 0 || !tabuleiro[linha - i][coluna].equals(".")) {
                        regiao_livre = false;
                    }
                    break;
                case 1: // Sentido sul
                    if (linha + i >= tabuleiro.length || !tabuleiro[linha + i][coluna].equals(".")) {
                        regiao_livre = false;
                    }
                    break;
                case 2: // Sentido leste
                    if (coluna + i >= tabuleiro[0].length || !tabuleiro[linha][coluna + i].equals(".")) {
                        regiao_livre = false;
                    }
                    break;
                case 3: // Sentido oeste
                    if (coluna - i < 0 || !tabuleiro[linha][coluna - i].equals(".")) {
                        regiao_livre = false;
                    }
                    break;
            }
            if (!regiao_livre) {
                return -1;
            }
        }
        return sentido;
    }

    public static void inserir_barco(String[][] tabuleiro, Barco barco, int linha, int coluna, int direcao) {

        /*
        Após fazer a verificação, será inserido na linha ou coluna o símbolo do barco, obtido através da classe, de acordo com a direção sem
        nenhuma obstrução.
        */

        /*
        Porta-aviões - 5 (Tamanho) - P (Símbolo)
        Encouraçado - 4 (Tamanho) - E (Símbolo)
        Cruzador - 3 (Tamanho) - C (Símbolo)
        Submarino - 3 (Tamanho) - S (Símbolo)
        Contratorpedeiro - 2 (Tamanho) - N (Símbolo)
        */

        for (int i = 0; i < barco.getTamanhoBarco(); i++) {
            switch (direcao) {
                case 0: // Sentido norte
                    tabuleiro[linha - i][coluna] = String.valueOf(barco.getSimbolo());
                    break;
                case 1: // Sentido sul
                    tabuleiro[linha + i][coluna] = String.valueOf(barco.getSimbolo());
                    break;
                case 2: // Sentido leste
                    tabuleiro[linha][coluna + i] = String.valueOf(barco.getSimbolo());
                    break;
                case 3: // Sentido oeste
                    tabuleiro[linha][coluna - i] = String.valueOf(barco.getSimbolo());
                    break;
            }
        }

    }

}