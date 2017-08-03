package com.example.ardidy.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnMinus, btnPlus, btnProses;
    EditText edtJumlah;


    private List<DataModel> dataList = new ArrayList<>();
    RecyclerView recyclerPesanan;
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Spinner spinner = (Spinner) findViewById(R.id.spinnerVarian);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.variant, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        btnMinus = (Button) findViewById(R.id.btnKurang);
        btnPlus = (Button) findViewById(R.id.btnTambah);
        btnProses = (Button) findViewById(R.id.btnProses);
        edtJumlah = (EditText) findViewById(R.id.edtJumlah);


        mAdapter = new DataAdapter(dataList);
        recyclerPesanan = (RecyclerView) findViewById(R.id.recyclerPesanan);
        recyclerPesanan.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerPesanan.setLayoutManager(llm);
        recyclerPesanan.setItemAnimator(new DefaultItemAnimator());
        recyclerPesanan.setAdapter(mAdapter);

//
//        dataList.add(new DataModel("1", "aaa","5"));
//        dataList.add(new DataModel("1", "aaa","5"));
//        dataList.add(new DataModel("1", "aaa","5"));
//        dataList.add(new DataModel("1", "aaa","5"));
//        dataList.add(new DataModel("1", "aaa","5"));
//        dataList.add(new DataModel("1", "aaa","5"));
//        dataList.add(new DataModel("1", "aaa","5"));
//        dataList.add(new DataModel("1", "aaa","5"));
//        dataList.add(new DataModel("1", "aaa","5"));
//        dataList.add(new DataModel("1", "aaa","5"));


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtJumlah.getText().toString());
                Log.d("isi", ""+a);
                if(a > 0){
                    a--;
                    edtJumlah.setText(""+a);
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtJumlah.getText().toString());
                a++;
                Log.d("isi", ""+a);
                edtJumlah.setText(""+a);
            }
        });



        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String jumlah = edtJumlah.getText().toString();
                final String rasa = spinner.getSelectedItem().toString();

//                Toast.makeText(MainActivity.this, "Pesanan anda : "+rasa+ " sebanyak : "+jumlah+ " buah", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Dialog");
                builder.setMessage("Pesanan anda : "+rasa+ " sebanyak : "+jumlah+ " buah");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dataList.add(new DataModel(""+(dataList.size() + 1), rasa, jumlah));
                        mAdapter.notifyDataSetChanged();
                        edtJumlah.setText("0");
                        Toast.makeText(MainActivity.this, "Pesanan anda : "+rasa+ " sebanyak : "+jumlah+ " buah", Toast.LENGTH_SHORT).show();

                    }
                });
//                builder.setNegativeButton("Cancel", null);
                builder.show();


            }
        });




    }
}
