package com.example.administrator.kwft.activity.Confirm_Mpesa_Details;

    import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

    public class BackgroundTask extends AsyncTask<String,Void,String> {
        Context context;

        BackgroundTask(Context context) {
            this.context = context;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String getAccount = "http://murihchenist.000webhostapp.com/";
            //String register_url = "http://192.168.43.68/registration.php";
            String method = params[0];
            if (method.equals("getAccount")) {
                String account_no = params[1];
                try {
                    URL url = new URL(getAccount);
                    //CREATE A HTTP URL CONNECTION
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    //WE ARE ENCODING THE DATA BEFORE WE SEND IT
                    String data = URLEncoder.encode("account_no", "UTF-8") + "=" + URLEncoder.encode(account_no, "UTF-8");
                    //WRITE DATA INTO BUFFERED WRITER
                    bufferedWriter.write(data);
                    //flash the data
                    bufferedWriter.flush();
                    //close the buffered writer
                    bufferedWriter.close();
                    //close the output stream
                    outputStream.close();
                    //create some input stream to fetch response from the server
                    InputStream inputStream = httpURLConnection.getInputStream();
                    inputStream.close();
                    httpURLConnection.disconnect();


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return "Balance Details";
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(context,result,Toast.LENGTH_LONG).show();

        }


    }