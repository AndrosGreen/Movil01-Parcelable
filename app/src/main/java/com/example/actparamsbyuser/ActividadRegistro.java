package com.example.actparamsbyuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ActividadRegistro extends AppCompatActivity {

    EditText txtNombre, txtTel, txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_registro);

        txtNombre = findViewById(R.id.txtNombre);
        txtTel = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);

    }

    public void btnRegistrar_onClick (View v){
        Log.e("mensaje log", "el nombre es : " + txtNombre.getText());

        String nombre = txtNombre.getText().toString();
        String telefono = txtTel.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        Usuario usuario = new Usuario(nombre,telefono,email,password);

        Intent datos = new Intent();

        datos.putExtra("usuario_test", usuario);

        setResult(RESULT_OK, datos);
        finish();
    }
}