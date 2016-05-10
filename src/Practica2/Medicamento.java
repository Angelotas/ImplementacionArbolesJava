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
public class Medicamento implements Comparable<Medicamento>{

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
    
    public String getCodigoB(){
        return this.codigoB;
    }
    
    public String toString(){
        return "\n\t..::MEDICAMENTO::..\n-->Código de barras: "+this.codigoB+"\n-->Nombre: "+this.nombre+"\nLaboratorio: "
                +this.laboratorio+"\n-->Precio: "+this.precio+"\nPorcentaje SS: "+this.porcentajeSS+"\n ";
    }
    
}
