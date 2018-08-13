package com.example.mustafa.webapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


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
        /*post.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name =((EditText)findViewById(R.id.name)).getText().toString();
                String from =((EditText)findViewById(R.id.from)).getText().toString();
                String to =((EditText)findViewById(R.id.to)).getText().toString();


                new background().execute("https://mungcalendar.herokuapp.com/appointments",name,from,to);
            }
        });*/
        post.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name =((EditText)findViewById(R.id.name)).getText().toString();
                String from =((EditText)findViewById(R.id.from)).getText().toString();
                String to =((EditText)findViewById(R.id.to)).getText().toString();


                new background().execute("https://europewest.services.azureml.net/subscriptions/c64a1919c86141bb840179922eeb9fdd/services/900abb1ba6f8412e9e6bf78d8f402f69/execute?api-version=2.0&format=swagger",name,from,to);
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
                    URL url = new URL(params[0]);
                    Log.d("adsgfdhfsadurl",params[0]);

                    JSONObject jsonObject = new JSONObject();


                    String jsonString ="{\n" +
                            "\n" +
                            "  \"Inputs\": {\n" +
                            "\n" +
                            "    \"input1\": [\n" +
                            "\n" +
                            "      {\n" +
                            "\n" +
                            "        \"firstKeyTimestamp1\": 1,\n" +
                            "\n" +
                            "        \"bigramValue1\": 1,\n" +
                            "\n" +
                            "        \"upDownInterStroke1\": 1,\n" +
                            "\n" +
                            "        \"secondKeyTimestamp1\": 1,\n" +
                            "\n" +
                            "        \"keyHoldTime1\": 1,\n" +
                            "\n" +
                            "        \"upUpInterStroke1\": 1,\n" +
                            "\n" +
                            "        \"downDownInterStroke1\": 1,\n" +
                            "\n" +
                            "        \"downUpInterStroke1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXavg1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXrms1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXstandardDeviation1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumPositive1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumNegative1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYavg1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYrms1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYstandardDeviation1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumPositive1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumNegative1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZavg1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZrms1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZstandardDeviation1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumPositive1\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumNegative1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXavg1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXrms1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXstandardDeviation1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumPositive1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumNegative1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYavg1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYrms1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYstandardDeviation1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumPositive1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumNegative1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZavg1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZrms1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZstandardDeviation1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumPositive1\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumNegative1\": 1,\n" +
                            "\n" +
                            "        \"firstKeyTimestamp2\": 1,\n" +
                            "\n" +
                            "        \"bigramValue2\": 1,\n" +
                            "\n" +
                            "        \"upDownInterStroke2\": 1,\n" +
                            "\n" +
                            "        \"secondKeyTimestamp2\": 1,\n" +
                            "\n" +
                            "        \"keyHoldTime2\": 1,\n" +
                            "\n" +
                            "        \"upUpInterStroke2\": 1,\n" +
                            "\n" +
                            "        \"downDownInterStroke2\": 1,\n" +
                            "\n" +
                            "        \"downUpInterStroke2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXavg2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXrms2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXstandardDeviation2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumPositive2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumNegative2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYavg2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYrms2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYstandardDeviation2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumPositive2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumNegative2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZavg2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZrms2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZstandardDeviation2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumPositive2\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumNegative2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXavg2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXrms2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXstandardDeviation2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumPositive2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumNegative2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYavg2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYrms2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYstandardDeviation2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumPositive2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumNegative2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZavg2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZrms2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZstandardDeviation2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumPositive2\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumNegative2\": 1,\n" +
                            "\n" +
                            "        \"firstKeyTimestamp3\": 1,\n" +
                            "\n" +
                            "        \"bigramValue3\": 1,\n" +
                            "\n" +
                            "        \"upDownInterStroke3\": 1,\n" +
                            "\n" +
                            "        \"secondKeyTimestamp3\": 1,\n" +
                            "\n" +
                            "        \"keyHoldTime3\": 1,\n" +
                            "\n" +
                            "        \"upUpInterStroke3\": 1,\n" +
                            "\n" +
                            "        \"downDownInterStroke3\": 1,\n" +
                            "\n" +
                            "        \"downUpInterStroke3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXavg3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXrms3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXstandardDeviation3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumPositive3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumNegative3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYavg3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYrms3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYstandardDeviation3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumPositive3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumNegative3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZavg3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZrms3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZstandardDeviation3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumPositive3\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumNegative3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXavg3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXrms3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXstandardDeviation3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumPositive3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumNegative3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYavg3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYrms3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYstandardDeviation3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumPositive3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumNegative3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZavg3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZrms3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZstandardDeviation3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumPositive3\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumNegative3\": 1,\n" +
                            "\n" +
                            "        \"firstKeyTimestamp4\": 1,\n" +
                            "\n" +
                            "        \"bigramValue4\": 1,\n" +
                            "\n" +
                            "        \"upDownInterStroke4\": 1,\n" +
                            "\n" +
                            "        \"secondKeyTimestamp4\": 1,\n" +
                            "\n" +
                            "        \"keyHoldTime4\": 1,\n" +
                            "\n" +
                            "        \"upUpInterStroke4\": 1,\n" +
                            "\n" +
                            "        \"downDownInterStroke4\": 1,\n" +
                            "\n" +
                            "        \"downUpInterStroke4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXavg4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXrms4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXstandardDeviation4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumPositive4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumNegative4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYavg4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYrms4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYstandardDeviation4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumPositive4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumNegative4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZavg4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZrms4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZstandardDeviation4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumPositive4\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumNegative4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXavg4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXrms4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXstandardDeviation4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumPositive4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumNegative4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYavg4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYrms4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYstandardDeviation4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumPositive4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumNegative4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZavg4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZrms4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZstandardDeviation4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumPositive4\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumNegative4\": 1,\n" +
                            "\n" +
                            "        \"firstKeyTimestamp5\": 1,\n" +
                            "\n" +
                            "        \"bigramValue5\": 1,\n" +
                            "\n" +
                            "        \"upDownInterStroke5\": 1,\n" +
                            "\n" +
                            "        \"secondKeyTimestamp5\": 1,\n" +
                            "\n" +
                            "        \"keyHoldTime5\": 1,\n" +
                            "\n" +
                            "        \"upUpInterStroke5\": 1,\n" +
                            "\n" +
                            "        \"downDownInterStroke5\": 1,\n" +
                            "\n" +
                            "        \"downUpInterStroke5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXavg5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXrms5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXstandardDeviation5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumPositive5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerXsumNegative5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYavg5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYrms5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYstandardDeviation5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumPositive5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerYsumNegative5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZavg5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZrms5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZstandardDeviation5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumPositive5\": 1,\n" +
                            "\n" +
                            "        \"accelerometerZsumNegative5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXavg5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXrms5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXstandardDeviation5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumPositive5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeXsumNegative5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYavg5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYrms5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYstandardDeviation5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumPositive5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeYsumNegative5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZavg5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZrms5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZstandardDeviation5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumPositive5\": 1,\n" +
                            "\n" +
                            "        \"gyroscopeZsumNegative5\": 1,\n" +
                            "\n" +
                            "        \"Label\": \"genuine\"\n" +
                            "\n" +
                            "      }\n" +
                            "\n" +
                            "    ]\n" +
                            "\n" +
                            "  },\n" +
                            "\n" +
                            "  \"GlobalParameters\": {}\n" +
                            "\n" +
                            "}";

                    jsonObject = new JSONObject(jsonString);

                    Log.i("JSON", jsonObject.toString());


                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    //connection.setRequestProperty("Accept","application/json");
                    //connection.setRequestProperty("Authentication","Bearer Q70lWlPwbjFQDWHcPkvZSrx1RTReqvu9DuW/Ff1JO1cZNhVb7d5ekJ2ra0eJ4PF1au7HtX3NTxIiyFwXEORxow==");

                    connection.setRequestProperty("Authorization","Bearer Q70lWlPwbjFQDWHcPkvZSrx1RTReqvu9DuW/Ff1JO1cZNhVb7d5ekJ2ra0eJ4PF1au7HtX3NTxIiyFwXEORxow==");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.connect();





                    DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes(jsonObject.toString());
                    dos.flush();
                    dos.close();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while((line = reader.readLine()) != null)
                    {
                        // Append server response in string
                        sb.append(line + "\n");
                    }
                    String text = sb.toString();
                    reader.close();
                    System.out.println(text);

                    JSONObject jsonResponse = new JSONObject(text);

                    System.out.println(jsonResponse.toString());
                    jsonResponse = jsonResponse.getJSONObject("Results");
                    System.out.println("RESULTS:    "+jsonResponse.toString());
                    JSONArray jsonArrayOutput2 = jsonResponse.getJSONArray("output2");
                    JSONObject output2 =jsonArrayOutput2.getJSONObject(0);
                    System.out.println("OUTPUT2:"+output2.toString());

                    file = output2.get("Scored Labels").toString();


                    //String result = jsonResponse.get("Scored Labels");
                    //System.out.println(result);


                    Log.i("STATUS", String.valueOf(connection.getResponseCode()));
                    Log.i("MSG" , connection.getResponseMessage());

                    connection.disconnect();


                    //file = connection.getResponseMessage();
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
