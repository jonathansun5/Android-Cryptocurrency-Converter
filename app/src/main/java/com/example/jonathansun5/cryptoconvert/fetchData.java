package com.example.jonathansun5.cryptoconvert;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class fetchData extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.coinmarketcap.com/v1/ticker/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            JsonReader jsonReader = new JsonReader(inputStreamReader);
            jsonReader.beginArray();
            MainActivity.idAndPriceValue = new HashMap<String, Double>();
            while (jsonReader.hasNext()) {
                jsonReader.beginObject();
                String id = "";
                Double price_usd = null;
                while (jsonReader.hasNext()) {
                    String name = jsonReader.nextName();
                    switch (name) {
                        case "id":
                            id = jsonReader.nextString();
                            break;
                        case "price_usd":
                            price_usd = jsonReader.nextDouble();
                            MainActivity.idAndPriceValue.put(id, price_usd);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
            }
            Log.d("hashmap is", MainActivity.idAndPriceValue.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
