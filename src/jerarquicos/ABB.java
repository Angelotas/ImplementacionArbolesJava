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
}
