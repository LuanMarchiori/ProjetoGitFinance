import java.io.Serializable;

public class Financiamento implements Serializable {
    private double valorImovel;
    private int prazoFinanciamento; // em anos
private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double calcularPagamentoMensal() {
        double prazoMeses = prazoFinanciamento * 12;
        double taxaMensal = taxaJurosAnual / 12 / 100;
        return (valorImovel / prazoMeses) * (1 + taxaMensal);
    }

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    @Override
    public String toString() {
        return String.format("Valor do Imóvel: R$ %.2f, Prazo: %d anos, Taxa de Juros: %.2f%%, Pagamento Mensal: R$ %.2f, Total Pago: R$ %.2f",
                valorImovel, prazoFinanciamento, taxaJurosAnual, calcularPagamentoMensal(), calcularTotalPagamento());
    }
}
