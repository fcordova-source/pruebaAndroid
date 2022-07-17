package com.example.fabiancordova;

public class Alumno {
    private String titulo;
    private int imagen;
    private int sound;

    public Alumno(String tit,int img, int s){
        titulo = tit;
        imagen = img;
        sound = s;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getImagen(){
        return imagen;
    }

    public int getSound(){
        return sound;
    }


}
