/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Ángel
 */
public class ElementoNoEncontrado extends Exception{
    public ElementoNoEncontrado (String mensaje){
        super(mensaje);
    }
}
