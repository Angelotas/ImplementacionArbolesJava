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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int compareToNombre(Medicamento m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
