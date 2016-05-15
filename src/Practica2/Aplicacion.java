/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import Excepciones.ArbolVacio;
import Excepciones.ElementoDuplicado;
import Excepciones.ElementoNoEncontrado;
import Excepciones.FormatoMedicamentoInvalido;

/**
 *
 * @author Ángel
 */
public class Aplicacion {
    
    public static void main ( String [] args ) throws ElementoDuplicado, ElementoNoEncontrado, FormatoMedicamentoInvalido, ArbolVacio{
        Gestion g= new Gestion();
        g.menu();
    }
}
