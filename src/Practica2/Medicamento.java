/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

/**
 *
 * @author Ángel
 */
public class Medicamento implements ComparaNombre<Medicamento>{

    private String codigoB;
    private String nombre;
    private String laboratorio;
    private float precio;
    private float porcentajeSS;
    
    public Medicamento (String c, String nom, String lab, float pre, float por){
        this.codigoB=c;
        this.nombre=nom;
        this.laboratorio=lab;
        this.precio=pre;
        this.porcentajeSS=por;
    }
   
    public String getCodigoB() {
        return codigoB;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPorcentajeSS() {
        return porcentajeSS;
    }

    public void setPorcentajeSS(float porcentajeSS) {
        this.porcentajeSS = porcentajeSS;
    }
    
    
    
    @Override
    public String toString(){
        return "\nCodigo: "+this.codigoB+"| Nombre: "+this.nombre+"| Laboratorio: "+this.laboratorio+"| Precio: "+this.precio+"| PorcentajeSS: "+this.porcentajeSS+"\n ";
    }
    
    public String toStringFich(){
        return this.codigoB+"#"+this.nombre+"#"+this.laboratorio+"#"+this.precio+"#"+this.porcentajeSS;
    }

    @Override
    public int compareTo(Medicamento m) {
        if (this.codigoB.compareTo(m.getCodigoB()) > 0){
            return 0; //este codigo es mayor que el que le pasamos por referencia
                      //Ej. 7.compareTo(6) --> return 0  res.
        }
        else if (this.codigoB.compareTo(m.getCodigoB()) < 0){
            return 1; //este codigo es menor que el que le pasamos por referencia
        }
        else{
            return 2;  //ambos códigos son iguales
        }
    }
    @Override
    public int compareToNombre(Medicamento m) {
        
        if ((m.getNombre().compareTo(this.nombre)) == 0){ //el nombre de los medicamentos es igual
            return 2;
        }
        else
            return 1;
    }

    

    
}
