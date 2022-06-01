package com.tunanh.ex6_1_bai1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import add.AddFile;
import add.Edit;

public class MainActivity extends AppCompatActivity {
    ArrayList<model_folder> arrayList = new ArrayList<>();
    MainAdapter mainAdapter ;
    TextView textView;
    ImageButton imageButton;
    RecyclerView recyclerView;
    public static final int REQUEST_CODE_TO_EDIT = 101;
    public static final String KEY_TITLE="KEY_TITLE";
    public static final String KEY_CONTENT="KEY_CONTENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        click();

        String title= getIntent().getStringExtra(AddFile.KEY_TITlE);
        String content= getIntent().getStringExtra(AddFile.KEY_CONTENT);
        arrayList.add(new model_folder(R.drawable.img,title,content));
        mainAdapter.notifyDataSetChanged();
    }
    private void click(){
        textView = (TextView) findViewById(R.id.tv_add);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddFile.class);
                startActivity(intent);
            }
        });
        imageButton= (ImageButton) findViewById(R.id.imgbtn_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.super.onBackPressed();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_TO_EDIT) {
            if (resultCode == RESULT_OK) {
                String title = data.getStringExtra(Edit.KEY_TITLE);
                String content= data.getStringExtra(Edit.KEY_CONTENT);

            }
        }
    }

    private void InitView(){
        recyclerView=(RecyclerView)findViewById(R.id.main_rcl_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        arrayList.add(new model_folder(R.drawable.img,"Tổng hợp tin tức thời sự","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"));
        arrayList.add(new model_folder(R.drawable.img,"Do It Your Self","Sơn tùng MTP quá đẹp trai hát hay"));
        arrayList.add(new model_folder(R.drawable.img,"Cảm hứng sáng tạo","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."));
        arrayList.add(new model_folder(R.drawable.img,"Tổng hợp tin tức thời sự","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."));
        arrayList.add(new model_folder(R.drawable.img,"Do It Your Self","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."));
        arrayList.add(new model_folder(R.drawable.img,"Cảm hứng sáng tạo","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."));
        mainAdapter = new MainAdapter(arrayList,this);
        recyclerView.setAdapter(mainAdapter);


    }
}