/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;
import Entrada.MyInput;
import Excepciones.ArbolVacio;
import Excepciones.ElementoDuplicado;
import Excepciones.ElementoNoEncontrado;
import Excepciones.FormatoMedicamentoInvalido;
import jerarquicos.*;

/**
 *
 * @author Ángel
 */
public class Gestion {
    
    
    ABB<Medicamento> arbol= new ABB<Medicamento>();
    Medicamento medicamento;
        
    public void menu() throws ElementoDuplicado, ElementoNoEncontrado, FormatoMedicamentoInvalido, ArbolVacio{
        int opcion=0;

        do{
            try{
                
                System.out.println("\n|---------------------------------------------------------------|");
                System.out.println("|\t\t\t     ÁRBOL BINARIO\t\t\t|");
                System.out.println("|-------------------------------|-------------------------------|");
                System.out.println("| 1-Lista medicamento\t\t|  2-Añadir medicamento\t\t|");
                System.out.println("| 3-Eliminar medicamento\t|  4-Modificar medicamento\t|");
                System.out.println("| 5-Consultar por código\t|  6-Consultar por nombre\t|");
                System.out.println("| 7-Cargar fichero\t\t|  8-Salvar fichero\t\t|");
                System.out.println("| 0-Salir\t\t\t|\t\t\t\t|");
                System.out.println("|-------------------------------|-------------------------------|");
                System.out.print("\n ->Selecciona una opcion: ");
                opcion= MyInput.readInt();


                switch (opcion){

                    case 1:
                        this.arbol.esVacio();
                        this.arbol.ImprimirInOrden();
                    break;

                    case 2:
                        System.out.println("\n--------------------------------------");
                        System.out.println("\tAÑADIR MEDICAMENTO");
                        System.out.println("--------------------------------------\n");
                        System.out.print("\tCódigo [------]: ");
                        String cod= this.pedirCodigoMed();
                        System.out.print("\tNombre: ");
                        String nombre= MyInput.readString();
                        System.out.print("\tLaboratorio: ");
                        String lab= MyInput.readString();
                        System.out.print("\tPrecio: ");
                        int precio= MyInput.readInt();
                        System.out.print("\tSeguridad social(%): ");
                        int segSoc= MyInput.readInt();

                        medicamento = new Medicamento(cod,nombre,lab,precio,segSoc);
                        arbol.insertarSinDuplicados(medicamento);
                        System.out.println("\n->Medicamento creado con éxito...");


                    break;

                    case 3:
                        System.out.println("\n--------------------------------------");
                        System.out.println("\tELIMINAR MEDICAMENTO");
                        System.out.println("--------------------------------------\n");
                        this.arbol.esVacio();
                        System.out.print("\tCódigo del medicamento que se desa borrar: ");
                        String c= this.pedirCodigoMed(); //excepción
                        medicamento = this.buscarPorCod(c);  //excepción
                        
                        System.out.println("\n¿Está seguro de que desea borrar el siguiente medicamento?(s/n)");
                        System.out.println(medicamento.toString());
                        System.out.print("\t-->Descisión: ");
                        String sn= MyInput.readString();
                        if (sn.charAt(0)== 's'){
                            arbol.eliminar(medicamento);
                            System.out.println("\n->Borrado realizado con éxito...");
                        }
                        else{
                            System.out.println("\n->Borrado candelado...");
                        }
                        
                    break;

                    case 4:

                    break;

                    case 5:

                    break;

                    case 6:

                    break;

                    case 7:

                    break;

                    case 8:

                    break;
                }
            }
            catch (FormatoMedicamentoInvalido e){
                System.out.println(e.getMessage());
            }
            catch (ElementoNoEncontrado e){
                System.out.println(e.getMessage());
            }
            catch (ArbolVacio e){
                System.out.println(e.getMessage());
            }
        }while (opcion != 0);
    }
    
    public String pedirCodigoMed() throws FormatoMedicamentoInvalido{
        String cod;
        
        cod = MyInput.readString();
        if (cod.length() != 6){
            throw new FormatoMedicamentoInvalido("\n**El código del dni debe tener 6 dígitos**\n");
        }
        else
            return cod;
    }
    
    protected Medicamento buscarPorCod(String cod, NodoABB<Medicamento> actual){
        
        NodoABB<Medicamento> res = actual;
        while (actual != null){
            int compara= res.getDato().getCodigoB().compareTo(cod);
            if (compara > 0){ //el dato del nodo es mayor que el que se busca ->avanzar a izq
                System.out.println("izq");
                res = res.getIzq();
            }
            else if (compara < 0){
                System.out.println("der");
                res = res.getDer();
            }
            else if (compara == 0)
                break;
        }  
        return res.getDato();
    }
    
    public Medicamento buscarPorCod (String cod) throws ElementoNoEncontrado{
        
        Medicamento m= buscarPorCod(cod, this.arbol.getRaiz());
        if (m == null){
            throw new ElementoNoEncontrado("\n**No se encuentra el medicamento con ese código**\n");
        }
        return m;
    }
}
