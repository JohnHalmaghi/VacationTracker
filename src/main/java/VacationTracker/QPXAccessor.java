package VacationTracker;
import java.io.*;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.json.Json;
import javax.json.JsonObject;

public class QPXAccessor {
    Flight flight;
    public QPXAccessor(Flight f) throws IOException {
        flight = f;
    }

    public double getLowestPrice() throws IOException, JSONException {
        String url = "https://www.googleapis.com/qpxExpress/v1/trips/search?key=AIzaSyDV1UL43UsJ2dB49tQm2tH1yxDXlfZzn10";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        JsonObject value = Json.createObjectBuilder()
                .add("request", Json.createObjectBuilder()
                    .add("passengers", Json.createObjectBuilder()
                        .add("adultCount", flight.getNumberOfPassengers()))
                .add("slice", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("origin", flight.getDepAirport())
                                .add("destination", flight.getDestAirport())
                                .add("date", flight.getDepDate()))
                        .add(Json.createObjectBuilder()
                                .add("origin", flight.getDestAirport())
                                .add("destination", flight.getDepAirport())
                                .add("date", flight.getRetDate()))))
                .add("solutions", 20)
                        .build();
        StringEntity params = new StringEntity(value.toString());
        post.setEntity(params);
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        JSONObject results = new JSONObject(responseString);
        JSONArray flights = results.getJSONObject("trips").getJSONArray("tripOption");

        String lowestPrice = flights.getJSONObject(0).getString("saleTotal");
        lowestPrice = lowestPrice.substring(3); //remove leading "USD"
        Double toReturn = Double.parseDouble(lowestPrice);
        return toReturn;
    }
}