package com.myapplication.myapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.viewmoney> {
ArrayList<Money>arrmoney;

    public adapter(ArrayList<Money> arrmoney) {
        this.arrmoney = arrmoney;
    }

    @NonNull
    @Override
    public viewmoney onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.gorunum,parent,false);
        return new viewmoney(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewmoney holder, int position) {
holder.gets(arrmoney.get(position),position);
    }

    @Override
    public int getItemCount() {
        return arrmoney.size();
    }

    public class viewmoney extends RecyclerView.ViewHolder{
TextView txt1,txt2;
        public viewmoney(@NonNull View itemView) {
            super(itemView);
        }
        public void gets(Money money,Integer position){
            txt1=itemView.findViewById(R.id.txt1);
            txt2=itemView.findViewById(R.id.txt2);
            txt1.setText(arrmoney.get(position).currency);
txt2.setText(arrmoney.get(position).price);

        }

    }
}
