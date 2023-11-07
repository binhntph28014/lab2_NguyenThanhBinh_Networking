package binhntph28014.fpoly.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai4_Activity extends AppCompatActivity implements View.OnClickListener{
    public static final String SERVER_WIDTH = "http://192.168.56.1/api_android/nguyenthanhbinh/giaiphuongtrinh_POST.php";
    private EditText edtWidth, edtLength;
    private EditText edtHight;
    private Button btnSend;
    private TextView tvResult;
    String strWidth, strLength, strHight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        edtLength = (EditText) findViewById(R.id.edtLength);
        edtWidth =(EditText) findViewById(R.id.edtWidth);
        edtHight =(EditText) findViewById(R.id.edtHight);
        btnSend = (Button) findViewById(R.id.btnSend4);
        tvResult = (TextView) findViewById(R.id.tvResult4);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend4:
                strWidth = edtWidth.getText().toString();
                strLength = edtLength.getText().toString();
                strHight = edtHight.getText().toString();
                BackgroundTaskHCN_POST backgroundTask = new BackgroundTaskHCN_POST(tvResult, strWidth, strLength,strHight, this);
                backgroundTask.execute();
                break;
        }
    }

}