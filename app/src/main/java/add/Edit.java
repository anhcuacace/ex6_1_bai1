package add;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tunanh.ex6_1_bai1.MainActivity;
import com.tunanh.ex6_1_bai1.R;

public class Edit extends AppCompatActivity {
    private EditText TVtitle, TVcontent;
    private TextView cancel,save;
    public static final String KEY_TITLE ="KEY_TITLE";
    public static final String KEY_CONTENT ="KEY_CONTENT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        into();
        click();

    }
    public void click(){

        anhxa();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit.super.onBackPressed();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                String title= TVtitle.getText().toString();

                String content= TVcontent.getText().toString();
                intent.putExtra(KEY_TITLE,title);
                intent.putExtra(KEY_CONTENT,content);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
    public void anhxa(){
        TVtitle=(EditText) findViewById(R.id.edt_edtitle);
        save=(TextView) findViewById(R.id.tv_save_ed);
        TVcontent =(EditText) findViewById(R.id.edt_edcontent);
        cancel=(TextView) findViewById(R.id.tv_cancel_ed);
    }
    public void into(){
        anhxa();
        TVtitle.setText(getIntent().getStringExtra(MainActivity.KEY_TITLE));
        TVcontent.setText(getIntent().getStringExtra(MainActivity.KEY_CONTENT));
    }
}
