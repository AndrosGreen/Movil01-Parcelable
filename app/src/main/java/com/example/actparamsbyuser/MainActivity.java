package com.example.actparamsbyuser;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnRegistro;

    ActivityResultLauncher<Intent> mStartRegistro = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){

                        Intent intent = result.getData();

                        Usuario usuario = intent.getParcelableExtra("usuario_test");

                        String notificacion = "nombre : " + usuario.getNombre() + "\n"
                                            + "tel: " + usuario.getTelefono() + "\n"
                                            + "email: " + usuario.getEmail() + "\n"
                                            + "password: " + usuario.getPassword();

                        Toast.makeText(MainActivity.this, notificacion, Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistro = (Button) findViewById(R.id.btnIniciarRegistro);

        btnRegistro.setOnClickListener(view -> {
            mStartRegistro.launch(new Intent(this,ActividadRegistro.class));
        });

    }
}