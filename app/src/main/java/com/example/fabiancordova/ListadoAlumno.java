package com.example.fabiancordova;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListadoAlumno extends Activity {
    ListView lv;

    public Alumno[] datos =
            new Alumno[]{
                    new Alumno("Primer Lugar", R.drawable.primerpuesto,R.raw.dog2),
                    new Alumno("Segundo Lugar", R.drawable.segundopuesto,2),
                    new Alumno("Tercer Lugar", R.drawable.tercerpuesto,3)
            };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_alumnos);

        lv = (ListView) findViewById(R.id.LstOpciones);

        AdaptadorAlumnos adaptador = new AdaptadorAlumnos(this,datos);
        lv.setAdapter(adaptador);

    }

    class AdaptadorAlumnos extends ArrayAdapter<Alumno>{

        public AdaptadorAlumnos(Context context,Alumno[] datos){
            super(context,R.layout.item_list,datos);
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.item_list,null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            ImageView imagen = (ImageView) item.findViewById(R.id.imgportada);
            imagen.setImageResource(datos[position].getImagen());

            final MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.dog2);

            imagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaPlayer.start();
                }
            });

            return (item);
        }
    }
}
