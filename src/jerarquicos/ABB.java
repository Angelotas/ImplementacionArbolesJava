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
    protected int altura;
    
    public ABB(){
        raiz = null;
    }
    
    public ABB(E x){
        raiz = new NodoABB<E>(x);
    }
    
    public NodoABB<E> getRaiz(){
        return this.raiz;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public int tamanyo(){ //numero de nodos hasta llegar al fin, contandose a sí mismo.
        return this.tamanyo(raiz);
    }
    protected int tamanyo(NodoABB<E> actual){
        if (actual != null){
            return actual.getTamanyo();
        }
        else{
            return 0;
        }
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public void esVacio() throws ArbolVacio{
        if (this.raiz == null){
            throw new ArbolVacio("\n**El árbol está vacío, antes debes introducir medicamentos (opc 2)**\n");
        }
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public int getAltura(){ //número de palitos del nodo hasta el fin del arbol
        return 1;
    }
    protected void getAltura(NodoABB<E> actual, int nivel){
            
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
        
        if ( this.raiz == null ){
            res = new NodoABB<E>(x);
            this.raiz = res;
        }
        else{
           if (actual == null){ //ha llegado al caso base
                res = new NodoABB<E>(x);
            }
            else{
                int resC = actual.getDato().compareTo(x);
                if (resC == 2){
                    throw new ElementoDuplicado("***Este medicamento ya esta en el árbol***");
                }
                else if(resC == 1){
                    res.setDer(insertarSinDuplicados (x, actual.getDer()));
                }
                else if (resC ==0){
                    res.setIzq(insertarSinDuplicados (x, actual.getIzq())); 
                }
                actual.setTamanyo(actual.getTamanyo() + 1);
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
        return res.getDato();
    }
    protected NodoABB<E> recuperar (E x, NodoABB<E> actual){
        //Busca a partir de un determinado nodo del arbol
        NodoABB<E> res=actual;
        if (actual != null){
            int resC = actual.getDato().compareTo(x);
            if (resC == 0){ //ir hacia la derecha puesto que el dato x es mayor que el dato de n
                this.recuperar(x,actual.getDer());
            }
            else if(resC == 1){
                this.recuperar(x, actual.getIzq());
            }
            //Si es igual, no entrará a ningún método recursivo y se devolverá el nodo
        }
        return res;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public E recuperarMin(){
        //devuelve el dato de tipo E mas pequeño del árbol
        NodoABB<E> res = this.recuperarMin(this.raiz);
        return res.getDato();
    }
    protected NodoABB<E> recuperarMin(NodoABB<E> actual){
        //sin necesidad de método recursivo
        NodoABB<E> res= actual;
        while (actual.getIzq() != null){
            res = actual.getIzq();
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
        
        if (actual.getDato().compareTo(x) == 1){ //si x es mayor que el actual
            res.setDer(eliminar(x, actual.getDer()));
        }
        else if (actual.getDato().compareTo(x) == 0){ //si x es menor que el actual
            res.setIzq(eliminar(x, actual.getIzq()));
        }
        else if (actual.getDato().compareTo(x) == 2){ //si x es igual al actual
            if (actual.getIzq() != null && actual.getDer() != null){
                res.setDato(recuperarMin(actual.getDer()).getDato());
                res.setDer(eliminarMin(actual.getDer()));
            }
            else 
                res = (actual.getIzq() != null) ? actual.getIzq():actual.getDer();
        }
        actual.setTamanyo(actual.getTamanyo() - 1);
        return res;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public void eliminarMin(){
        this.raiz = eliminarMin(this.raiz);
    }
    protected NodoABB<E> eliminarMin(NodoABB<E> actual){
        if ( actual.getIzq() != null ){
            actual.setTamanyo(actual.getTamanyo() - 1);
            actual.setIzq(eliminarMin(actual.getIzq())); 
        }
        else{
            actual = actual.getDer();
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
        if (actual.getIzq() != null){
            res+=ImprimirInOrden(actual.getIzq());
        }
        res+=actual.getDato().toString()+"\n";
        if (actual.getDer() != null){
            res+=ImprimirInOrden(actual.getDer());
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
