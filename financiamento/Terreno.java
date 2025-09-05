package financiamento;

public class Terreno extends Financiamento {
    private String tipoZona; // Exemplo: "Residencial" ou "Comercial"

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public String obterDetalhesEspecificos() {
        return String.format("Tipo de Zona: %s", tipoZona);
    }
}
