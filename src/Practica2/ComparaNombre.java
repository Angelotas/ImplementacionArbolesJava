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
public interface ComparaNombre<E> extends Comparable<E>{
    
    public abstract int compareToNombre(E x);
}
