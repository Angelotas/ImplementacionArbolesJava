/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicos;

/**
 *
 * @author Ángel
 */
public class ABB <E extends Comparable<E>>{
    protected NodoABB<E> raiz;
    
    public ABB(){
        raiz = null;
    }
    
    public ABB(E x){
        raiz = new NodoABB<E>(x);
    }
    
    public int tamanyo(){
        return 1;
    }
    public boolean esVacio(){
        return true;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public int altura(){
        return 1;
    }
    protected int altura(NodoABB<E> actual){
        return 1;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public void insertarSinDuplicados(E x){
        //insertar a partir de la raiz del árbol
        NodoABB<E> n= new NodoABB<E>(x);
        
    }
    protected NodoABB<E> insertarSinDuplicados(E x, NodoABB<E> actual){
        //insertar sin duplicado a partir de un determinado nodo
        return null;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public void insertarConDuplicados(E x){
        //insertar con duplicado desde la raiz del árbol
        NodoABB<E> n= new NodoABB<E>(x);
        
    }
    protected NodoABB<E> insertarConDuplicados(E x, NodoABB<E> actual){
        //insertar con duplicado a partir de un determinado nodo
        return null;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public void actualizar(E x){
        //Si x no esta se inserta, pero si esta, el árbol actualiza el nodo con el nuevo valor
        NodoABB<E> n= new NodoABB<E>(x);
    }
    protected NodoABB<E> actualizar(E x, NodoABB<E> actual){
        //Si x no esta se inserta, pero si esta, el árbol actualiza el nodo con el nuevo valor
        NodoABB<E> n= new NodoABB<E>(x);
        return null;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public E recuperar(E x){
        return null;
    }
    protected NodoABB<E> recuperar (E x, NodoABB<E> n){
        return null;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public E recuperarMin(){
        //devuelve el dato de tipo E mas pequeño del árbol
        return null;
    }
    protected NodoABB<E> recuperarMin(NodoABB<E> actual){
        //devuelve el dato de tipo E mas pequeño del nodo que se le pasa por referencia
        return null;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public void eliminar(E x){
        
    }
    protected NodoABB<E> eliminar (E x, NodoABB<E> actual){
        return null;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public void eliminarMin(){
        
    }
    protected NodoABB<E> eliminarMin(NodoABB<E> actual){
        return null;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
}
