package com.example.ardidy.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ardidy on 8/3/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

        private List<DataModel> dataList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView nomor, namaBarang, jumlahBarang;

            public MyViewHolder(View view) {
                super(view);
                nomor = (TextView) view.findViewById(R.id.txtNomor);
                namaBarang = (TextView) view.findViewById(R.id.txtNamaItem);
                jumlahBarang = (TextView) view.findViewById(R.id.txtJumlah);
            }
        }


        public DataAdapter(List<DataModel> moviesList) {
            this.dataList = moviesList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_pesanan, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            DataModel model = dataList.get(position);
            holder.nomor.setText(model.getNomor());
            holder.namaBarang.setText(model.getNamaBarang());
            holder.jumlahBarang.setText(model.getJumlahBarang());
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }



}
