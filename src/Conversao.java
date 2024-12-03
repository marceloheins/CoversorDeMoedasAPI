import com.google.gson.JsonObject;

public class Conversao {
    private double valorOriginal;
    private double valorConvertido;
    private String moedaBase;
    private String moedaDestino;

    public Conversao(double valorOriginal, String moedaBase, String moedaDestino) {
        this.valorOriginal = valorOriginal;
        this.moedaBase = moedaBase;
        this.moedaDestino = moedaDestino;
    }

    public void realizaConversao(double taxaDeCambio) {
        this.valorConvertido = valorOriginal * taxaDeCambio;

    }

    public JsonObject gerarSaidaJson() {
        JsonObject resultado = new JsonObject();
        resultado.addProperty("Valor Original", valorOriginal);
        resultado.addProperty("Moeda Base", moedaBase);
        resultado.addProperty("Moeda Destino", moedaDestino);
        resultado.addProperty("Valor Convertido ", valorConvertido);
        return resultado;
    }
}



