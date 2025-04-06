/*
    Decodificador de resistência
*/

/*
Resistor é um componente eletrônico que transforma energia elétrica em energia térmica, limitando a corrente elétrica em um circuito.
A resistência de um resistor, medida em Ohms (Ω), é representada por meio de faixas coloridas impressas em seu corpo.
_As duas primeiras faixas indicam os dois dígitos iniciais do valor_, _a terceira faixa indica um multiplicador_,
_e a quarta faixa (opcional) indica a tolerância da resistência_.
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
            System.out.println("Insira em um formato para ler as faixas de um resistor, exemplo, 'marrom preto vermelho dourado'");
        }

        int faixa_um = get_faixa(args[0]);
        int faixa_dois = get_faixa(args[1]);
        String multiplicador = get_multiplicador(args[2]);
        String tolerancia = get_tolerancia(args);

        if (faixa_um == -1 || faixa_dois == -1 || multiplicador.isEmpty() || tolerancia.isEmpty()) {
            return;
        }

        String faixas_calculada = calcula_faixas (faixa_um, faixa_dois, multiplicador);

        System.out.print(faixas_calculada + " " + tolerancia);

    }

    public static int get_faixa(String cor) {
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