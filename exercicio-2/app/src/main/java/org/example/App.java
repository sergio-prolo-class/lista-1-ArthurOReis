/*
    Decodificador de resistência
*/

/*
Resistor é um componente eletrônico que transforma energia elétrica em energia térmica, limitando a corrente elétrica em um circuito.
A resistência de um resistor, medida em Ohms (Ω), é representada por meio de faixas coloridas impressas em seu corpo.
As duas primeiras faixas indicam os dois dígitos iniciais do valor, a terceira faixa indica um multiplicador,
e a quarta faixa (opcional) indica a tolerância da resistência.
*/

/*
Desenvolva um aplicativo em Java que permita ao usuário fornecer, como argumentos de linha de comando,
o nome das cores das faixas de um resistor e imprima na tela o valor da resistência correspondente. Caso o usuário forneça argumentos inválidos,
o programa deve informar a forma correta de uso.
*/

/*
Exemplo de execução:

gradle run --args "amarelo branco verde azul"

Resistência: 4,9 M Ohms (+- 0,25%)
*/

package org.example;

public class App {
    // As duas primeiras faixas indicam os dois dígitos iniciais do valor
    // a terceira faixa indica um multiplicador
    // e a quarta faixa (opcional) indica a tolerância da resistência

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Insira em um formato válido, para ler as faixas de um resistor, exemplo, 'marrom preto vermelho dourado'");
        }

        /*
        Para cada argumento recebido, será feito uma conversão de suas cores para valores correspondentes, e caso um deles ou mais falharem,
        o algoritmo irá parar de executar, seguido de uma mensagem de erro.
        */

        int faixa_um = get_faixa(args[0]);
        int faixa_dois = get_faixa(args[1]);
        String multiplicador = get_multiplicador(args[2]);
        String tolerancia = get_tolerancia(args);

        if (faixa_um == -1 || faixa_dois == -1 || multiplicador.isEmpty() || tolerancia.isEmpty()) {
            return;
        }

        String faixas_calculada = calcula_faixas(faixa_um, faixa_dois, multiplicador);

        /*
        Por fim, após a filtragem pelas cores, será calculado as faixas, transformando o multiplicador em um numero do tipo double, que
        irá multiplicar as faixas, e convertê-los de volta em símbolo de notação (1000 = 1K, 1.000.000 = 1M...), junto do valor da tolerância,
        isto é, se ela também fizer parte dos argumentos
        */

        System.out.print(faixas_calculada + " " + tolerancia);

    }

    public static int get_faixa(String cor) {
        /*
        O método converte a cor da faixa em seu valor correspondente de acordo com os atributos de um resistor.
        Retorna -1 se a cor for inválida.
        */
        switch (cor) {
            case "preto":
                return 0;
            case "marrom":
                return 1;
            case "vermelho":
                return 2;
            case "laranja":
                return 3;
            case "amarelo":
                return 4;
            case "verde":
                return 5;
            case "azul":
                return 6;
            case "violeta":
                return 7;
            case "cinza":
                return 8;
            case "branco":
                return 9;
            default:
                System.out.println("Cor inválida");
                return -1;
        }
    }

    public static String get_multiplicador(String cor) {
        /*
        Similarmente ao método 'get_faixa', nesse escopo também é convertido a cor da faixa em seu valor correspondente
        em um valor de base 10^(x).
        E também retorna -1 se a cor for inválida.
        */

        switch (cor) {
            case "preto":
                return "1";
            case "marrom":
                return "10";
            case "vermelho":
                return "100";
            case "laranja":
                return "1K";
            case "amarelo":
                return "10K";
            case "verde":
                return "100K";
            case "azul":
                return "1M";
            case "violeta":
                return "10M";
            case "cinza":
                return "100M";
            case "branco":
                return "1G";
            case "ouro":
                return "0,1";
            case "prata":
                return "0,01";
            default:
                System.out.println("Cor inválida");
                return null;
        }
    }

    public static String get_tolerancia(String[] tolerancia){
        /*
        Idêntica à outros métodos anteriores, converte-se sua cor em um diferencial correspondente, com a diferença de que
        caso não houver o argumento da tolerância, ela simplesmente retornará vazia, por ser opcional.
        E mais uma vez, retornará -1 caso for colocado uma cor não prevista.
        */
        String tolerancia_cor = tolerancia.length > 3 ? tolerancia[3] : "";

        switch (tolerancia_cor) {
            case "preto":
                return "(+- 0%)";
            case "marrom":
                return "(+- 1%)";
            case "vermelho":
                return "(+- 2%)";
            case "verde":
                return "(+- 0,5%)";
            case "azul":
                return "(+- 0,25%)";
            case "roxo":
                return "(+- 0,1%)";
            case "cinza":
                return "(+- 0,05%)";
            case "ouro":
                return "(+- 5%)";
            case "prata":
                return "(+- 10%)";
            case "":
                return "(+- 20%)";
            default:
                System.out.println("Cor inválida");
                return null;
        }
    }

    public static String calcula_faixas(int faixa_um, int faixa_dois, String multiplicador) {
        /*
        O método se resume em calcular o valor da resistência com base nas duas primeiras faixas e no multiplicador;
        Primeiramente é combinado as duas primeiras faixas em um número inteiro, depois multiplica o valor pelo multiplicador fornecido,
        e formata o resultado em Ohms, usando notação (K->mil, M->milhão...).
        */

        String resultado;
        double faixa = faixa_um * 10 + faixa_dois;

        switch (multiplicador) {
            case "1":
                faixa *= 1;
                break;
            case "10":
                faixa *= 10;
                break;
            case "100":
                faixa *= 100;
                break;
            case "1K":
                faixa *= 1000;
                break;
            case "10K":
                faixa *= 10000;
                break;
            case "100K":
                faixa *= 100000;
                break;
            case "1M":
                faixa *= 1000000;
                break;
            case "10M":
                faixa *= 10000000;
                break;
            case "100M":
                faixa *= 100000000;
                break;
            case "1G":
                faixa *= 1000000000;
                break;
            case "0,1":
                faixa *= 0.1;
                break;
            case "0,01":
                faixa *= 0.01;
                break;
            default:
                System.out.println("Multiplicador inválido");
                return null;
        }

        if (faixa >= 1000000000) {
            resultado = String.format("%.1f G", faixa / 1000000000);
        } else if (faixa >= 1000000) {
            resultado = String.format("%.1f M", faixa / 1000000);
        } else if (faixa >= 1000) {
            resultado = String.format("%.1f K", faixa / 1000);
        } else {
            resultado = String.format("%.1f", faixa);
        }
        resultado += " Ohms";

        return resultado;
    }

}