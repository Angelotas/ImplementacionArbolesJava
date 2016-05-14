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
    private E dato;
    private NodoABB<E> izq,der;
    private int tamanyo;
    
    
    public NodoABB (E dato, NodoABB<E> izq, NodoABB<E> der){
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
    public NodoABB(E dato){
        this(dato,null,null);
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoABB<E> getIzq() {
        return izq;
    }

    public void setIzq(NodoABB<E> izq) {
        this.izq = izq;
    }

    public NodoABB<E> getDer() {
        return der;
    }

    public void setDer(NodoABB<E> der) {
        this.der = der;
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }
    
    
}
