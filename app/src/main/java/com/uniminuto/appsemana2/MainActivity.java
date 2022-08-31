package com.uniminuto.appsemana2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private EditText editTextNombre;
private CalendarView calendarPicker;
private EditText editTextTelefono;
private EditText editTextEmail;
private EditText editTextDescripcion;
private Button btnEnviarContacto;
private String fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlace de datos en la interfaz para la toma de datos
        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextTelefono = (EditText) findViewById(R.id.editTextTelefono);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextDescripcion = (EditText) findViewById(R.id.editTextDescripcion);
        //Instancia del boton para enviar los datos del contacto
        btnEnviarContacto = (Button) findViewById(R.id.btnEnviarContacto);
        //Obtencion de la fecha por medio del calendarView
        calendarPicker =(CalendarView) findViewById(R.id.calendarPicker);
        calendarPicker.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            fecha = dayOfMonth+"/"+(month+1)+"/"+year;
                });
        btnEnviarContacto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(MainActivity.this,ConfirmacionDatos.class);
                        intent.putExtra("nombre",editTextNombre.getText().toString());
                        intent.putExtra("fecha",fecha);
                        intent.putExtra("telefono",editTextTelefono.getText().toString());
                        intent.putExtra("email",editTextEmail.getText().toString());
                        intent.putExtra("descripcion",editTextDescripcion.getText().toString());
                        startActivity(intent);

                    }
                });



    }

}