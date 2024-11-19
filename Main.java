import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        interfaceUsuario interfaceUsuario = new interfaceUsuario();

        // Lista para armazenar os financiamentos
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Adicionando quatro financiamentos com dados fornecidos pelo usuário
        for (int i = 1; i <= 4; i++) {
            System.out.println("Financiamento " + i + ":");
            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

            // Criação e adição do financiamento
            Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
            financiamentos.add(financiamento);
        }

        // Salvando dados em um arquivo de texto
        salvarDadosEmArquivo(financiamentos, "financiamentos.txt");

        // Lendo e exibindo os dados salvos
        System.out.println("\nDados salvos no arquivo de texto:");
        lerDadosDoArquivo("financiamentos.txt");

        // Salvando o ArrayList serializado
        salvarArrayListSerializado(financiamentos, "financiamentos.dat");

        // Lendo o ArrayList serializado
        System.out.println("\nDados lidos do arquivo serializado:");
        ArrayList<Financiamento> financiamentosLidos = lerArrayListSerializado("financiamentos.dat");
        for (Financiamento financiamento : financiamentosLidos) {
            System.out.println(financiamento);
        }
    }

    // Método para salvar os dados em um arquivo de texto
    private static void salvarDadosEmArquivo(ArrayList<Financiamento> financiamentos, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Financiamento financiamento : financiamentos) {
                writer.write(financiamento.toString());
                writer.newLine();
            }
        }
    }

    // Método para ler os dados do arquivo de texto
    private static void lerDadosDoArquivo(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }

    // Método para salvar o ArrayList serializado
    private static void salvarArrayListSerializado(ArrayList<Financiamento> financiamentos, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(financiamentos);
        }
    }

    // Método para ler o ArrayList serializado
    private static ArrayList<Financiamento> lerArrayListSerializado(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<Financiamento>) ois.readObject();
        }
    }
}
