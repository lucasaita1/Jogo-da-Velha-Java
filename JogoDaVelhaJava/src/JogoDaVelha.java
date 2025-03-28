import java.util.Scanner;

public class JogoDaVelha {

     private static char[][] tabuleiro = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        private static char jogadorAtual = 'X';

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean jogoEmAndamento = true;

            while (jogoEmAndamento) {
                imprimirTabuleiro();
                System.out.println("Jogador " + jogadorAtual + ", escolha uma linha (0, 1 ou 2) e uma coluna (0, 1 ou 2):");
                int linha = scanner.nextInt();
                int coluna = scanner.nextInt();

                if (movimentoValido(linha, coluna)) {
                    tabuleiro[linha][coluna] = jogadorAtual;
                    if (verificarVencedor()) {
                        imprimirTabuleiro();
                        System.out.println("Jogador " + jogadorAtual + " venceu!");
                        jogoEmAndamento = false;
                    } else if (tabuleiroCheio()) {
                        imprimirTabuleiro();
                        System.out.println("O jogo terminou em empate!");
                        jogoEmAndamento = false;
                    } else {
                        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Movimento inválido. Tente novamente.");
                }
            }
            scanner.close();
        }

        private static void imprimirTabuleiro() {
            System.out.println("  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(tabuleiro[i][j]);
                    if (j < 2) System.out.print("|");
                }
                System.out.println();
                if (i < 2) System.out.println("  -----");
            }
        }

        private static boolean movimentoValido(int linha, int coluna) {
            return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ';
        }

        private static boolean verificarVencedor() {
            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual)
                    return true;
                if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)
                    return true;
            }
            if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual)
                return true;
            if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)
                return true;
            return false;
        }

        private static boolean tabuleiroCheio() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }
    }

