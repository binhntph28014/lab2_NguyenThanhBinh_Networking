package binhntph28014.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai2_Activity extends AppCompatActivity implements View.OnClickListener{
    public static final String SERVER_WIDTH = "http://192.168.56.1/api_android/nguyenthanhbinh/rectangle_POST.php";
    private EditText edtWidth, edtLength;
    private Button btnSend;
    private TextView tvResult;
    String strWidth, strLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        edtLength = (EditText) findViewById(R.id.edtLength);
        edtWidth =(EditText) findViewById(R.id.edtWidth);
        btnSend = (Button) findViewById(R.id.btnSend1);
        tvResult = (TextView) findViewById(R.id.tvResult1);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend1:
                strWidth = edtWidth.getText().toString();
                strLength = edtLength.getText().toString();
                BackgroundTask_POST backgroundTask = new BackgroundTask_POST(tvResult, strWidth, strLength, this);
                backgroundTask.execute();
                break;
        }
    }

}