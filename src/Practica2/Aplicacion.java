/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import Excepciones.ElementoDuplicado;

/**
 *
 * @author Ángel
 */
public class Aplicacion {
    
    public static void main ( String [] args ) throws ElementoDuplicado{
        Gestion g= new Gestion();
        g.menu();
    }
}
