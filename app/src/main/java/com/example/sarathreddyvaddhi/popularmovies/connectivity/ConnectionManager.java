package com.example.sarathreddyvaddhi.popularmovies.connectivity;

import android.os.AsyncTask;
import android.util.Log;

import com.example.sarathreddyvaddhi.popularmovies.model.Result;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by sarathreddyvaddhi on 10/2/16.
 */
public class ConnectionManager extends AsyncTask<String, Void, String> {

    String server_response;
    ArrayList result = new ArrayList();

    Result resultInterface;

    @Override
    protected String doInBackground(String... strings) {

        URL url;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();


                server_response = readStream(urlConnection.getInputStream());
                Log.v("CatalogClient", server_response);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return server_response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.e("Response", "" + server_response);

        JsonParser jsonParser = new JsonParser();
        try {
             result = (ArrayList) jsonParser.JsonParser(server_response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setResult(result);
        if(resultInterface!=null)
        resultInterface.getResult(result);

    }

    public Result getResultInterface() {
        return resultInterface;
    }

    public void setResultInterface(Result resultInterface) {
        this.resultInterface = resultInterface;
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }


    public ArrayList getResult() {
        return result;
    }

    public void setResult(ArrayList result) {
        this.result = result;
    }
}