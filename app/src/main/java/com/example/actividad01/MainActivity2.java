package com.example.actividad01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView tv3;
    EditText id, nom, tel, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle received = getIntent().getExtras();
        tv3 = findViewById(R.id.user);
        id = findViewById(R.id.cedula);
        nom = findViewById(R.id.nombre);
        tel = findViewById(R.id.tel);
        email = findViewById(R.id.correo);
        tv3.setText("Bienvenido "+received.getString("username"));
    }
    public void enviar(View d){
        //Toast.makeText(this, "Hola 2", Toast.LENGTH_LONG).show();
        Intent ir = new Intent(this, MainActivity3.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
        Bundle data  =new Bundle();
        data.putString("id", id.getText().toString());
        data.putString("nombre", nom.getText().toString());
        data.putString("tel", tel.getText().toString());
        data.putString("email", email.getText().toString());
        ir.putExtras(data);
        startActivity(ir);

    }


}