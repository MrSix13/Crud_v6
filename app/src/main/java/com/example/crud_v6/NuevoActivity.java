package com.example.crud_v6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud_v6.DB.DbContactos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreoElectronico;
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre            = findViewById(R.id.txtNombre);
        txtTelefono          = findViewById(R.id.txtTelefono);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        btnGuardar           = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.InsertarContactos(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreoElectronico.getText().toString());

                if(!txtNombre.getText().toString().equals("") && !txtTelefono.getText().toString().equals("") && !txtCorreoElectronico.getText().toString().equals("")){
                    if(id >0){
                        Toast.makeText(NuevoActivity.this, "Registro Guardado", Toast.LENGTH_LONG).show();
                        limpiar();
                    }else{
                        Toast.makeText(NuevoActivity.this, "Error al Guardar Registro", Toast.LENGTH_LONG).show();
                        limpiar();
                    }
                }else{
                    Toast.makeText(NuevoActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }



            }
        });
    }
    private void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
    }
}