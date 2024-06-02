import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class Solicitudes {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";
    private final Gson gson = new Gson();

    public Datos getExchangeRate(String monedaBase, String monedaConvertida) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API_URL + monedaBase))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            RateResponse rateResponse = gson.fromJson(response.body(), RateResponse.class);
            double rate = rateResponse.rates().get(monedaConvertida);
            return new Datos(monedaBase, monedaConvertida, rate);
        } else {
            throw new Exception("Error en la respuesta de la API");
        }
    }
}

class RateResponse {
    private String base;
    private java.util.Map<String, Double> rates;

    public String base() {
        return base;
    }

    public java.util.Map<String, Double> rates() {
        return rates;
    }
}