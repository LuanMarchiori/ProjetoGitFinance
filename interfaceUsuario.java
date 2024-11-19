import java.util.Scanner;

public class interfaceUsuario {
    private Scanner scanner = new Scanner(System.in);

    public double pedirValorImovel() {
        double valor = -1;
        while (valor <= 0) {
            System.out.print("Digite o valor do imóvel (positivo): ");
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("O valor deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); // Limpa a entrada
            }
        }
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = -1;
        while (prazo <= 0) {
            System.out.print("Digite o prazo do financiamento em anos (positivo): ");
            if (scanner.hasNextInt()) {
                prazo = scanner.nextInt();
                if (prazo <= 0) {
                    System.out.println("O prazo deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next(); // Limpa a entrada
            }
        }
        return prazo;
    }

    public double pedirTaxaJurosAnual() {
        double taxa = -1;
        while (taxa <= 0) {
            System.out.print("Digite a taxa de juros anual (positiva): ");
            if (scanner.hasNextDouble()) {
                taxa = scanner.nextDouble();
                if (taxa <= 0) {
                    System.out.println("A taxa deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); // Limpa a entrada
            }
        }
        return taxa;
    }
}
