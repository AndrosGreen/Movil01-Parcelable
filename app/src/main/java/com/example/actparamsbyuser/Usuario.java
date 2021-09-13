package com.example.actparamsbyuser;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private String nombre;
    private String telefono;
    private String email;
    private String password;

    public Usuario(String nombre, String telefono, String email, String password) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public Usuario(Parcel in) {
        this.nombre = in.readString();
        this.telefono = in.readString();
        this.email = in.readString();
        this.password = in.readString();
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nombre);
        parcel.writeString(this.telefono);
        parcel.writeString(this.email);
        parcel.writeString(this.password);
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        public Usuario createFromParcel(Parcel in) {
            Usuario usuario = new Usuario(in);
            return usuario;
        }

        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

}
