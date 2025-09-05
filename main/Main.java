package main;

import financiamento.*;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Lista para armazenar os financiamentos
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Adicionando quatro financiamentos com dados fornecidos pelo usuário
        for (int i = 1; i <= 4; i++) {
            System.out.println("Financiamento " + i + ":");
            String tipoImovel = interfaceUsuario.pedirTipoImovel(); // Pergunta o tipo de imóvel
            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

            Financiamento financiamento = null;

            // Criação do financiamento com base no tipo escolhido
            switch (tipoImovel.toLowerCase()) {
                case "casa":
                    double areaConstruida = interfaceUsuario.pedirAreaConstruida();
                    double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
                    financiamento = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, tamanhoTerreno);
                    break;
                case "apartamento":
                    int numeroVagasGaragem = interfaceUsuario.pedirNumeroVagasGaragem();
                    int numeroAndar = interfaceUsuario.pedirNumeroAndar();
                    financiamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar);
                    break;
                case "terreno":
                    String tipoZona = interfaceUsuario.pedirTipoZona();
                    financiamento = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
                    break;
                default:
                    System.out.println("Tipo de imóvel inválido.");
            }

            if (financiamento != null) {
                financiamentos.add(financiamento);
            }
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
        for (Financiamento financiamentoLido : financiamentosLidos) {
            System.out.println(financiamentoLido);
            System.out.println(financiamentoLido.obterDetalhesEspecificos()); // Exibe os detalhes específicos de cada tipo
        }
    }

    // Métodos para salvar e ler dados permanecem iguais
    private static void salvarDadosEmArquivo(ArrayList<Financiamento> financiamentos, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Financiamento financiamento : financiamentos) {
                writer.write(financiamento.toString());
                writer.newLine();
            }
        }
    }

    private static void lerDadosDoArquivo(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }

    private static void salvarArrayListSerializado(ArrayList<Financiamento> financiamentos, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(financiamentos);
        }
    }

    private static ArrayList<Financiamento> lerArrayListSerializado(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<Financiamento>) ois.readObject();
        }
    }
}
