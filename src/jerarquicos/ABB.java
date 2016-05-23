/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicos;
import Excepciones.*;
import Practica2.ComparaNombre;
import Practica2.Medicamento;

/**
 *
 * @author Ángel
 */
public class ABB <E extends ComparaNombre<E>>{
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
            throw new ArbolVacio("\n**El árbol está vacío, antes debes introducir medicamentos (opc 2) o cargar datos del fichero MEDICAMENTOS.txt (opc7)**\n");
        }
    }
    
    
    public int getNivel(NodoABB<E> nodoComprobar){ //en que nivel se encuentra el nodo del arbol
        NodoABB<E> actual = this.raiz;
        int nivel = 0; //se inicializa a 1 ya que estamos en la raiz
        
        while (actual != null){
            int comp= nodoComprobar.getDato().compareTo(actual.getDato()); //utiliza el compareTo reescrito en medicamento
            if (comp == 0){ //el actual es menor, habrá que ir hacia la derecha
                actual = actual.getDer();
                nivel++;
            }
            else if (comp == 1){ //el actual es mayor, habra que ir hacia la izquierda
                actual = actual.getIzq();
                nivel++;
            }
            else if (comp == 2) //se ha llegado al nodoComprobar y ya tenemos su nivel respecto de la raiz
                break;
        }
        return nivel;
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
    
    protected NodoABB<E> recuperarMin(NodoABB<E> actual){
        
        NodoABB<E> res = actual;
        if (actual.getIzq() != null){
            res = recuperarMin(actual.getIzq());
        }
        return res;
            
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    
    public void eliminar(E x) throws ElementoNoEncontrado{
        this.raiz = eliminar(x,raiz);
    }
    protected NodoABB<E> eliminar (E x, NodoABB<E> actual) throws ElementoNoEncontrado{
        //Caso 1-> borrado de nodo sin hijos
        //Caso 2-> borrado de nodo con 2 hijos
        //Caso 3-> borrado de nodo con 2 hijos y sus hijos tienen hijos (nos falla)
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
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    public void ModificarNodo(NodoABB<E> existente, E datoNuevo){
        existente.setDato(datoNuevo);
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
    protected NodoABB<E> buscarPorCod(E x, NodoABB<E> actual){
        NodoABB<E> res = actual;
        
        if (actual != null){
            int compara= actual.getDato().compareTo(x);
            if (compara == 1){ //buscar por la derecha
                System.out.println("der");
                res =this.buscarPorCod(x, res.getDer());
            }
            else if (compara == 0){ //buscar por la izquierda
                System.out.println("izq");
                res =this.buscarPorCod(x, res.getIzq());
            }
        }
        return res;
    }
    
    public NodoABB<E> buscarPorCod(E x) throws ElementoNoEncontrado{
        
        NodoABB<E> res = this.buscarPorCod(x, this.raiz);
        if (res == null){
            throw new ElementoNoEncontrado("\n**No se encuentra el medicamento con ese código**\n");
        }
        else
            return res;
    }
    /*---------------------------------------------------------------------*/
    /*---------------------------------------------------------------------*/
  
    protected String buscarPorNom(E x, NodoABB<E> actual){
        String listaE="";
        if (actual.getIzq() != null){
            listaE += buscarPorNom(x, actual.getIzq());
        }
        if (actual.getDato().compareToNombre(x) == 2){
            listaE += actual.getDato().toString();
        }
        if (actual.getDer() != null){
            listaE += buscarPorNom(x, actual.getDer());
        }
        return listaE;
    }
    
    public void buscarPorNom (E x) throws ElementoNoEncontrado{
        String listaE="";
        listaE = this.buscarPorNom(x, raiz);
        if (listaE.compareTo("") == 1){
            throw new ElementoNoEncontrado("\n**No se encuentran medicamentos con ese nombre**\n");
        }
        else
            System.out.println(listaE);
    } 
}
