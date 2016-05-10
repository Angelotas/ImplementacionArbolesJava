/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicos;
import Excepciones.*;

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
    
    public int tamanyo(){ //numero de nodos hasta llegar al fin, contandose a sí mismo.
        return this.tamanyo(raiz);
    }
    protected int tamanyo(NodoABB<E> actual){
        if (actual != null){
            return actual.tamanyo;
        }
        else{
            return 0;
        }
    }
    public boolean esVacio(){
        return true;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public int altura(){ //número de palitos del nodo hasta el fin del arbol
        return 1;
    }
    protected int altura(NodoABB<E> actual){
        return 1;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public void insertarSinDuplicados(E x) throws ElementoDuplicado{
        //insertar a partir de la raiz del árbol
        NodoABB<E> res = insertarSinDuplicados(x, this.raiz);
    }
    protected NodoABB<E> insertarSinDuplicados(E x, NodoABB<E> actual) throws ElementoDuplicado{
        //insertar sin duplicado a partir de un determinado nodo
        NodoABB<E> res = actual;
        if (actual == null){ //ha llegado al caso base
            res = new NodoABB<E>(x);
        }
        else{
            int resC = actual.dato.compareTo(x);
            if (resC == 2){
                throw new ElementoDuplicado("***Este medicamento ya esta en el árbol***");
            }
            else if(resC == 1){
                res.der = insertarSinDuplicados (x, actual.der);
            }
            else if (resC ==0){
                res.izq = insertarSinDuplicados (x, actual.izq);
            }
            actual.tamanyo++;
        }
        return res;
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
        NodoABB<E> res= actualizar(x, this.raiz);
    }
    protected NodoABB<E> actualizar(E x, NodoABB<E> actual){
        //Actualiza los nodos del árbol y en caso de no estar un nodo, lo inserta
        NodoABB<E> res= actual;
        if ( actual == null ){
            res = new NodoABB<E>(x);
        }
        else{
            int resC = actual.dato.compareTo(x);
            if (resC == 2){
                res.dato = x;
            }
            else{
                int tamanyoHijosActual =  (actual.tamanyo)-1;
                if (resC == 1){
                    res.der = actualizar(x, actual.der);
                }
                else
                        res.izq = actualizar(x, actual.izq);
                
                if ((res.izq.tamanyo + res.der.tamanyo) != tamanyoHijosActual){
                    actual.tamanyo++;
                }
            }
        }
        return res;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public E recuperar(E x) throws ElementoNoEncontrado{
        //Busca a partir de del nodo raiz del árbol, si devuelve null lanza la excepción
        //de nodo no encontrado.
        NodoABB<E> res= recuperar(x, this.raiz);
        if (res == null){
            throw new ElementoNoEncontrado("\n***No se encuentra el dato***\n");
        }
        return res.dato;
    }
    protected NodoABB<E> recuperar (E x, NodoABB<E> n){
        //Busca a partir de un determinado nodo del arbol
        NodoABB<E> res=n;
        if (n != null){
            int resC = n.dato.compareTo(x);
            if (resC == 0){ //ir hacia la derecha puesto que el dato x es mayor que el dato de n
                this.recuperar(x,n.der);
            }
            else if(resC == 1){
                this.recuperar(x, n.izq);
            }   
        }
        return res;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public E recuperarMin(){
        //devuelve el dato de tipo E mas pequeño del árbol
        NodoABB<E> res = this.recuperarMin(this.raiz);
        return res.dato;
    }
    protected NodoABB<E> recuperarMin(NodoABB<E> actual){
        //devuelve el dato de tipo E mas pequeño del nodo que se le pasa por referencia
        NodoABB<E> res = actual;
        if ( actual.izq != null ){
            this.recuperarMin(actual.izq);
        }
        return res;
            
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public void eliminar(E x) throws ElementoNoEncontrado{
        this.raiz = eliminar(x,raiz);
    }
    protected NodoABB<E> eliminar (E x, NodoABB<E> actual) throws ElementoNoEncontrado{
        NodoABB<E> res= actual;
        if (actual == null)
            throw new ElementoNoEncontrado("\n***El dato no existe***\n");
        
        if (actual.dato.compareTo(x) == 1){ //si x es mayor que el actual
            res.der= eliminar(x, actual.der);
        }
        else if (actual.dato.compareTo(x) == 0){ //si x es menor que el actual
            res.izq= eliminar(x, actual.izq);
        }
        else if (actual.dato.compareTo(x) == 2){ //si x es igual al actual
            if (actual.izq != null && actual.der != null){
                res.dato = recuperarMin(actual.der).dato;
                res.der = eliminarMin(actual.der);
            }
            else 
                res = (actual.izq != null) ? actual.izq:actual.der;
        }
        actual.tamanyo--;
        return res;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public void eliminarMin(){
        this.raiz = eliminarMin(this.raiz);
    }
    protected NodoABB<E> eliminarMin(NodoABB<E> actual){
        if ( actual.izq != null){
            actual.tamanyo--;
            actual.izq = eliminarMin(actual.izq);
        }
        else{
            actual = actual.der;
        }
        return actual;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public void ImprimirInOrden (){
        System.out.println(ImprimirInOrden(this.raiz));
    }
    
    protected String ImprimirInOrden(NodoABB<E> actual){
        String res= "";
        if (actual.izq != null){
            res+=ImprimirInOrden(actual.izq);
        }
        res+=actual.dato.toString()+"\n";
        if (actual.der != null){
            res+=ImprimirInOrden(actual.der);
        }
        return res;
    }
    
    /*
    int subizq = 0;
    int subder = 0;
    
    public void Balance(Nodo<E> actual, boolean lado, int i) {

        if (actual != null) {

            if (actual.der() == null && reco.der() == null) {
                if (lado) {
                    subder = (i > subder) ? i : subder;
                } else {
                    subizq = (i > subizq) ? i : subizq;
                }
            }

            Balance(reco.getDer(), lado, i + 1);
            if (i == 0) {
                lado = false;
            }
            Balance(reco.getIzq(), lado, i + 1);
        }

    }*/
}
