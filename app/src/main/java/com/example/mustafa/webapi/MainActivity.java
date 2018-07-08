package com.example.mustafa.webapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button get = findViewById(R.id.get);
        final Button getId = findViewById(R.id.getID);
        final Button delete = findViewById(R.id.delete);
        final Button post = findViewById(R.id.post);
        textView = findViewById(R.id.hello);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new background().execute("https://mungcalendar.herokuapp.com/appointments");
            }
        });
        getId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = ((EditText)findViewById(R.id.appointmentId)).getText().toString();
                new background().execute("https://mungcalendar.herokuapp.com/appointments/"+str);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = ((EditText)findViewById(R.id.appointmentId)).getText().toString();
                new background().execute("https://mungcalendar.herokuapp.com/appointments/"+str);
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =((EditText)findViewById(R.id.name)).getText().toString();
                String from =((EditText)findViewById(R.id.from)).getText().toString();
                String to =((EditText)findViewById(R.id.to)).getText().toString();


                new background().execute("https://mungcalendar.herokuapp.com/appointments",name,from,to);
            }
        });

    }
    class background extends AsyncTask<String,String,String>{
        protected String doInBackground (String ... params){
            HttpURLConnection connection = null;
            BufferedReader bufferedReader = null;
            String file = "";

            if(params.length>1){
                try{
                    System.out.println("PARAMS > 1" + params.length);
                    for(int i=0; i<params.length;i++){
                        System.out.println(params[i]);
                    }


                    URL url = new URL(params[0]);
                    Log.d("url",params[0]);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name",params[1]);
                    jsonObject.put("from",params[2]);
                    jsonObject.put("to",params[3]);

                    Log.i("JSON", jsonObject.toString());

                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Accept","application/json");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.connect();





                    DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes(jsonObject.toString());
                    dos.flush();
                    dos.close();

                    Log.i("STATUS", String.valueOf(connection.getResponseCode()));
                    Log.i("MSG" , connection.getResponseMessage());

                    connection.disconnect();

                    file = connection.getResponseMessage();
                }catch (Exception e){

                }
                return file;
            }
            else{
                try{
                    URL url = new URL(params[0]);
                    Log.d("url",params[0]);

                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = bufferedReader.readLine()) != null){
                        Log.d("line:",line);
                        file += line;
                    }
                }catch (Exception e){

                }
                return file;
            }

        }
        protected void onPostExecute(String s){
            Log.d("fromPostExecute",s);
            textView.setText(s);
        }
    }

}
