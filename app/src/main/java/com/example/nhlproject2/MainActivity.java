package com.example.nhlproject2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    TextView textViewStatus;
    Button buttonGetFact;

    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = findViewById(R.id.textViewStatus);

        setupButtonGetPlayerInformation();

    }
    private void getPlayerInformation() {
        // Define URL to use. Using NHL Player API here.
        // ---- Remember to add the following permission to the AndroidManifest.xml file
        //      <uses-permission android:name="android.permission.INTERNET" />
        String url = "https://statsapi.web.nhl.com/api/v1/people/8471214";
        // Create a Volley web request to receive back a JSON object.
        // This requires two listeners for Async response, onResponse() and onErrorResponse()
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {

                        Gson gson = new Gson();
                        PlayerInformation alexOvechkin = gson.fromJson(response.toString(), PlayerInformation.class);
                        String name = alexOvechkin.people.get(0).fullName;
                        PlayerInformation.CurrentTeam team = alexOvechkin.people.get(0).currentTeam;
                        textViewStatus.setText(name + team);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textViewStatus.setText("ERROR Response: " + error.toString());
                    }
                });

        // Create a RequestQueue used to send web requests using Volley
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);
    }
    private void setupButtonGetPlayerInformation() {
        buttonGetFact = findViewById(R.id.buttonGetFact);
        buttonGetFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "getPlayerInformation onClick");
                getPlayerInformation();
            }
        });
    }
}