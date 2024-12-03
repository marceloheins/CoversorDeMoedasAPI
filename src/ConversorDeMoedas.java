import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;





public class ConversorDeMoedas {
  private String chaveApi;

        public ConversorDeMoedas(String chaveApi){
            this.chaveApi = chaveApi;

        }

        public double obterTaxaDeCambio( String moedaBase, String moedaDestino) throws Exception {
            String url = "https://v6.exchangerate-api.com/v6/bb1a35834962d90e00277d57/latest/" + moedaBase;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            JSONObject jsonResponse = new JSONObject(response.toString());

            if (jsonResponse.getString ("result").equals("success")){
                if (jsonResponse.getJSONObject("conversion_rates").has(moedaDestino)) {
                    return jsonResponse.getJSONObject("conversion_rates").getDouble(moedaDestino);
                }else{
                    throw new Exception("Moeda de destino inválida. ");
                }
            }else{
                throw new Exception("Erro ao obter as taxas de cãmbio.");
            }
        }

}



