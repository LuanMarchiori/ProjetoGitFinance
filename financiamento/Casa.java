package financiamento;

public class Casa extends Financiamento {
    private double areaConstruida; // em m²
    private double tamanhoTerreno; // em m²

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public String obterDetalhesEspecificos() {
        return String.format("Área Construída: %.2f m², Tamanho do Terreno: %.2f m²", areaConstruida, tamanhoTerreno);
    }
}
