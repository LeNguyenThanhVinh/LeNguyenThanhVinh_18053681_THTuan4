package com.example.lenguyenthanhvinh_18053681_thtuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements SendingData{
    TextView txtThanhTien;
    private int Qualify=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frmBelow,BelowFragment.newInstance("0")).commit();
        txtThanhTien = findViewById(R.id.txtThanhTien);

    }

    @Override
    public void sendData(String data) {
        Qualify = Integer.parseInt(data);
        long TT = Qualify*141800;
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        txtThanhTien.setText(formatter.format(TT)+" đ");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frmBelow,BelowFragment.newInstance(String.valueOf(Qualify))).commit();
    }
}