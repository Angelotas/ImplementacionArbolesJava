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
public class NodoABB<E> {
    E dato;
    NodoABB<E> izq,der;
    int tamanyo;
    
    
    NodoABB (E dato, NodoABB<E> izq, NodoABB<E> der){
        this.dato=dato;
        this.izq=izq;
        this.der=der;
        this.tamanyo=1;
        if (izq != null){
            tamanyo+=izq.tamanyo;
        }
        if (der != null){
            tamanyo+=der.tamanyo;
        }
    }
    
    NodoABB(E dato){
        this(dato,null,null);
    }
}
