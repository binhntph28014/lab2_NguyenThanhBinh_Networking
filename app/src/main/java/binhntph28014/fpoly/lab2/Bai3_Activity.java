package binhntph28014.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai3_Activity extends AppCompatActivity implements View.OnClickListener{
    public static final String SERVER_CANH = "http://192.168.56.1/api_android/nguyenthanhbinh/canh_POST.php";
    private EditText edtCanh;
    private Button btnSend;
    private TextView tvResult;
    String strCanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        edtCanh = (EditText) findViewById(R.id.edtCanh);
        btnSend = (Button) findViewById(R.id.btnSend);
        tvResult = (TextView) findViewById(R.id.tvResult2);
        btnSend.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend:
                strCanh = edtCanh.getText().toString();
                BackgroundTaskCanh_POST backgroundTask = new BackgroundTaskCanh_POST(tvResult, strCanh,this);
                backgroundTask.execute();
                break;
        }
    }
}