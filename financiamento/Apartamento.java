package financiamento;

public class Apartamento extends Financiamento {
    private int numeroVagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public String obterDetalhesEspecificos() {
        return String.format("Número de Vagas na Garagem: %d, Número do Andar: %d", numeroVagasGaragem, numeroAndar);
    }
}
