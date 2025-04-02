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

public class Bicicleta extends Vehiculo{
    
    private CuadroBici cuadro;
    private String tipo;

    public Bicicleta() {
    }

    public Bicicleta(int id, String marca, int cantidadCambios, float rodado, CuadroBici cuadro, String tipo) {
        super(id, marca, cantidadCambios, rodado);
        this.cuadro = cuadro;
        this.tipo = tipo;
    }

    public CuadroBici getCuadro() {
        return cuadro;
    }

    public void setCuadro(CuadroBici cuadro) {
        this.cuadro = cuadro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " cuadro=" + cuadro + ", tipo=" + tipo;
    }
    
    
    
    
}
