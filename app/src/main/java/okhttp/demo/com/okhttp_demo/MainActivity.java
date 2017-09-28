package okhttp.demo.com.okhttp_demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Some url endpoint that you may have
        String myUrl = "https://www.stage2d0065.stage.paypal.com";

        //String myUrl = "http://www.google.com";

        //String to place our result in
        Void result;

        //Instantiate new instance of our class
        HttpGetRequest getRequest = new HttpGetRequest();

        //Perform the doInBackground method, passing in our url
        try {
            result = getRequest.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }





        /*try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /*void run() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtString.setText(myResponse);
                    }
                });

            }
        });
    }*/

    public class HttpGetRequest extends AsyncTask<Void, Void, Void> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;
        @Override
        protected Void doInBackground(Void... params){
           // String stringUrl = params[0];
            String result;
            String inputLine;
            try {

                //String hostname = "www.gmail.com";
                String hostname = "www.stage2d0065.stage.paypal.com";
                //String hostname = "www.paypal.com";

                CertificatePinner certificatePinner = new CertificatePinner.Builder()
                        //.add(hostname, "sha256/asMiZzD598/uDdSq2AREjX+zwE/Zf/rW6C3qZmSQFBk")
                        //pph staging - asMiZzD598/uDdSq2AREjX+zwE/Zf/rW6C3qZmSQFBk
                        //gmail - 2Da7v7HWfSm7+dm5qq/KJ9n8Fhog40wqMMN8eyjbit0=
                        //dummy - AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=
                        .add(hostname, "sha256/2Da7v7HWfSm7+dm5qq/KJ9n8Fhog40wqMMN8eyjbit0=")
                        .build();
                OkHttpClient client = new OkHttpClient.Builder().certificatePinner(certificatePinner).build();

                Request request = new Request.Builder()
                        .url("https://" + hostname)
                        .build();
                try {
                    client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }



                /*//Create a URL object holding our url
                URL myUrl = new URL(stringUrl);

                //Create a connection
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();

                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                //Connect to our url
                connection.connect();

                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());

                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();

                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }

                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();

                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();
            }
            catch(IOException e){
                e.printStackTrace();
                result = null;
            }
            return result;*/
        } finally {

            }
            return null;
            }

        protected void onPostExecute(Void result){
            //super.onPostExecute(result);
            System.out.println("Post Execute: "+ result);
        }
    }

}
