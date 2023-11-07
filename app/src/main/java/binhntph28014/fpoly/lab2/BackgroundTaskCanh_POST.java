package binhntph28014.fpoly.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroundTaskCanh_POST extends AsyncTask<Void, Void, Void> {
    String duongdan = Bai3_Activity.SERVER_CANH;
    TextView tvResult;
    String strCanh;
    String strResult;
    ProgressDialog pDialog;
    Context context;

    public BackgroundTaskCanh_POST(TextView tvResult, String strCanh, Context context) {
        this.tvResult = tvResult;
        this.strCanh = strCanh;
        this.context = context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Calculating...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL (duongdan);
            String param = "canh=" +this.strCanh;
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput (true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode (param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            PrintWriter print = new PrintWriter (urlConnection.getOutputStream());
            print.print (param);
            print.close();
            String line = "";
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb= new StringBuffer();
            while ((line = bfr.readLine()) != null) {
                sb.append(line);
            }
            strResult = sb.toString();
            urlConnection.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute (Void result) {
        super.onPostExecute(result);
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
        tvResult.setText(strResult);

    }
}
