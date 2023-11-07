package binhntph28014.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai1_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName, edtScore;
    private Button btnSend;
    private TextView tvResult;
    String strName, strScore;
    public static final String SERVER_NAME = "http://192.168.56.1/api_android/nguyenthanhbinh/student_GET.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        edtName = (EditText) findViewById(R.id.edtName);
        edtScore =(EditText) findViewById(R.id.edtScore);
        btnSend = (Button) findViewById(R.id.btnSend);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend:
                strName = edtName.getText().toString();
                strScore = edtScore.getText().toString();
                BackgroundTask_GET backgroundTask = new BackgroundTask_GET(tvResult, strName, strScore, this);
                backgroundTask.execute();
                break;
        }
    }
}