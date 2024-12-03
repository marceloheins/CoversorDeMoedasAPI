import com.google.gson.JsonObject;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String chaveApi = "bb1a35834962d90e00277d57";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor que deseja converter: ");
        double valorParaConverter = scanner.nextDouble();

        System.out.println("BRL, EUR, USD, LIB,");
        System.out.println("Digite a moeda base: ");
        String moedaBase =  scanner.next().toUpperCase();

        System.out.println("BRL,EUR, USD, LIB ");
        System.out.println("Digite a moeda destino: ");
        String moedaDestino = scanner.next().toUpperCase();

        ConversorDeMoedas conversor = new ConversorDeMoedas(chaveApi);

        try{
            double taxaDeCambio = conversor.obterTaxaDeCambio(moedaBase, moedaDestino);

            Conversao conversao = new Conversao(valorParaConverter, moedaBase, moedaDestino);
            conversao.realizaConversao(taxaDeCambio);

            JsonObject resultadoJson = conversao.gerarSaidaJson();
            System.out.println(resultadoJson.toString());

        } catch (Exception e){
            System.out.println("ERRO: " + e.getMessage());
        }
        scanner.close();

    }
}