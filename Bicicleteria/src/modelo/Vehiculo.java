/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Luis
 */
public class Vehiculo implements Serializable{
    private int id;
    private String marca;
    private int cantidadCambios;
    private float rodado;

    public Vehiculo() {
    }

    public Vehiculo(int id, String marca, int cantidadCambios, float rodado) {
        this.id = id;
        this.marca = marca;
        this.cantidadCambios = cantidadCambios;
        this.rodado = rodado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidadCambios() {
        return cantidadCambios;
    }

    public void setCantidadCambios(int cantidadCambios) {
        this.cantidadCambios = cantidadCambios;
    }
    
    public float getRodado(){
        return rodado;
    }
    
    public void setRodado(float rodado){
        this.rodado = rodado;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", marca=" + marca + ", cantidadCambios=" 
                + cantidadCambios 
                + ", rodado=" + rodado;
    }
    
    
}
