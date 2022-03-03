package com.example.libraryapp;


    import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
        ArrayList<Category> categories ;
        Context context ;

        public CategoryAdapter(Context contex , ArrayList<Category> categories  ) {
            this.context = context ;
            this.categories = categories;
        }

        @NonNull
        @Override
        public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            context = parent.getContext();
            View v  = LayoutInflater.from(context).inflate(R.layout.item_des , null , false);

            return new CategoryViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

            Category cat = categories.get(position);
            String name = cat.getName();
            holder.textView.setText(name);
            holder.v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, cat.getId()+" //  "+cat.getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context , recayclerView.class ) ;
                    intent.putExtra("id" , cat.getId());
                    intent.putExtra("name" , cat.getName());
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return categories.size();
        }
    }
}
