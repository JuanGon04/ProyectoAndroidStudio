package com.example.actividad01;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView ced, nom, tel, email, h;
    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();

        Bundle received = getIntent().getExtras();
        ced = findViewById(R.id.setcedula);
        nom = findViewById(R.id.setnombre);
        tel = findViewById(R.id.setele);
        email = findViewById(R.id.setemail);
        ced.setText(received.getString("id"));
        nom.setText(received.getString("nombre"));
        tel.setText(received.getString("tel"));
        email.setText(received.getString("email"));

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause",Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy",Toast.LENGTH_LONG).show();
    }

public void volver(){
    Intent ir = new Intent(this, MainActivity2.class);
    ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(ir);
}

    public void contar(View d){
        contador++;
        h.setText("Contador: "+ contador);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contadorEjemplo", contador);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador = savedInstanceState.getInt("contadorEjemplo");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.agree) {
            Toast.makeText(this, "agree", Toast.LENGTH_LONG).show();
        } else if (id == R.id.badThread) {
            Toast.makeText(this, "badThread", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}