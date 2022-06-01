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

public class AddFile extends AppCompatActivity {
    public static final String KEY_TITlE = "KEY_TITlE";
    public static final String KEY_CONTENT = "KEY_CONTENT";

    TextView cancel,save;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_folder);
        click();
    }
    private void click(){
        cancel=(TextView) findViewById(R.id.tv_cancel_add);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFile.super.onBackPressed();
            }
        });
        save=(TextView) findViewById(R.id.tv_save_add);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);

                EditText edtTitle = (EditText)findViewById(R.id.edt_inputtitle);
                String title= edtTitle.getText().toString();
                EditText edtContent = (EditText)findViewById(R.id.edt_inputcontent);
                String content= edtContent.getText().toString();

                intent.putExtra(KEY_TITlE,title);
                intent.putExtra(KEY_CONTENT,content);

                startActivity(intent);
            }
        });
    }
}
