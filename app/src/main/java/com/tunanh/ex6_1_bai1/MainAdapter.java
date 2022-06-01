package com.tunanh.ex6_1_bai1;

import static add.AddFile.KEY_CONTENT;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import add.Edit;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private ArrayList<model_folder> model_folders;
    private Context context;
    public int number;


    public MainAdapter(ArrayList<model_folder> model_folders, Context context) {
        this.model_folders = model_folders;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View folderView = inflater.inflate(R.layout.folder_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(folderView);
        return viewHolder.LinkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        model_folder model_folder= model_folders.get(position);
        holder.text_title.setText(model_folder.getTitle());
        holder.text_content.setText(model_folder.getContent());
    }

    @Override
    public int getItemCount() {
        return model_folders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        MainAdapter mainAdapter;
        TextView text_title, text_content;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_title=itemView.findViewById(R.id.text_title);
            text_content=itemView.findViewById(R.id.text_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context.getApplicationContext(), Edit.class);

                    String title= text_title.getText().toString();


                    String content= text_content.getText().toString();
                    intent.putExtra(MainActivity.KEY_TITLE,title);
                    intent.putExtra(MainActivity.KEY_CONTENT,content);

                    context.startActivity(intent);
                }
            });

        }

        public MyViewHolder LinkAdapter(MainAdapter adapter){
            this.mainAdapter = adapter;
            return this;
        }
    }
}
