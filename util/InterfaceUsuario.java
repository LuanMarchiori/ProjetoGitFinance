package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner = new Scanner(System.in);

    public String pedirTipoImovel() {
        String tipo = "";
        while (tipo.isEmpty()) {
            System.out.print("Digite o tipo de imóvel (casa, apartamento ou terreno): ");
            tipo = scanner.nextLine().trim(); // Usar trim() para remover espaços extras
            if (!(tipo.equalsIgnoreCase("casa") || tipo.equalsIgnoreCase("apartamento") || tipo.equalsIgnoreCase("terreno"))) {
                System.out.println("Tipo inválido. Tente novamente.");
                tipo = "";  // Limpa o valor e pede novamente
            }
        }
        return tipo; // Agora retorna o tipo de imóvel corretamente
    }

    public double pedirValorImovel() {
        double valor = -1;
        while (valor <= 0) {
            System.out.print("Digite o valor do imóvel (positivo): ");
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                scanner.nextLine(); // Limpa a linha pendente
                if (valor <= 0) {
                    System.out.println("O valor deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); // Limpa a entrada
            }
        }
        return valor; // Agora retorna o valor do imóvel corretamente
    }

    public int pedirPrazoFinanciamento() {
        int prazo = -1;
        while (prazo <= 0) {
            System.out.print("Digite o prazo do financiamento em anos (positivo): ");
            if (scanner.hasNextInt()) {
                prazo = scanner.nextInt();
                scanner.nextLine(); // Limpa a linha pendente
                if (prazo <= 0) {
                    System.out.println("O prazo deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next(); // Limpa a entrada
            }
        }
        return prazo; // Agora retorna o prazo do financiamento corretamente
    }

    public double pedirTaxaJurosAnual() {
        double taxa = -1;
        while (taxa <= 0) {
            System.out.print("Digite a taxa de juros anual (positiva): ");
            if (scanner.hasNextDouble()) {
                taxa = scanner.nextDouble();
                scanner.nextLine(); // Limpa a linha pendente
                if (taxa <= 0) {
                    System.out.println("A taxa deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); // Limpa a entrada
            }
        }
        return taxa; // Agora retorna a taxa de juros corretamente
    }

    // Para pegar o tamanho do terreno, não vamos misturar com outras opções
    public double pedirTamanhoTerreno() {
        double tamanhoTerreno = -1;
        while (tamanhoTerreno <= 0) {
            System.out.print("Digite o tamanho do terreno (em m²): ");
            if (scanner.hasNextDouble()) {
                tamanhoTerreno = scanner.nextDouble();
                scanner.nextLine(); // Limpa a linha pendente
                if (tamanhoTerreno <= 0) {
                    System.out.println("O tamanho do terreno deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.next(); // Limpa a entrada
            }
        }
        return tamanhoTerreno; // Retorna o tamanho do terreno corretamente
    }

    public double pedirAreaConstruida() {
        double areaConstruida = -1;
        while (areaConstruida <= 0) {
            System.out.print("Digite a área construída (em m²): ");
            if (scanner.hasNextDouble()) {
                areaConstruida = scanner.nextDouble();
                scanner.nextLine(); // Limpa a linha pendente
                if (areaConstruida <= 0) {
                    System.out.println("A área construída deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.next(); // Limpa a entrada
            }
        }
        return areaConstruida; // Retorna a área construída corretamente
    }

    public int pedirNumeroVagasGaragem() {
        int numeroVagas = -1;
        while (numeroVagas <= 0) {
            System.out.print("Digite o número de vagas na garagem: ");
            if (scanner.hasNextInt()) {
                numeroVagas = scanner.nextInt();
                scanner.nextLine(); // Limpa a linha pendente
                if (numeroVagas <= 0) {
                    System.out.println("O número de vagas deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.next(); // Limpa a entrada
            }
        }
        return numeroVagas; // Retorna o número de vagas na garagem corretamente
    }

    public int pedirNumeroAndar() {
        int numeroAndar = -1;
        while (numeroAndar <= 0) {
            System.out.print("Digite o número do andar: ");
            if (scanner.hasNextInt()) {
                numeroAndar = scanner.nextInt();
                scanner.nextLine(); // Limpa a linha pendente
                if (numeroAndar <= 0) {
                    System.out.println("O número do andar deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.next(); // Limpa a entrada
            }
        }
        return numeroAndar; // Retorna o número do andar corretamente
    }

    public String pedirTipoZona() {
        String tipoZona = "";
        while (tipoZona.isEmpty()) {
            System.out.print("Digite o tipo de zona (Residencial/Comercial): ");
            tipoZona = scanner.nextLine().trim(); // Usar trim() para remover espaços extras
            if (!(tipoZona.equalsIgnoreCase("residencial") || tipoZona.equalsIgnoreCase("comercial"))) {
                System.out.println("Tipo inválido. Tente novamente.");
                tipoZona = ""; // Limpa o valor e pede novamente
            }
        }
        return tipoZona; // Retorna o tipo de zona corretamente
    }
}
