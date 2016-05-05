/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;
import Entrada.MyInput;
import Excepciones.ElementoDuplicado;
import jerarquicos.*;

/**
 *
 * @author Ángel
 */
public class Gestion {
    
    
    ABB<Medicamento> arbol= new ABB<Medicamento>();
        
    public void menu() throws ElementoDuplicado{
        int opcion;
        
        do{
            
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
                    this.arbol.ImprimirInOrden();
                break;

                case 2:
                    
                    Medicamento m1 = new Medicamento("1","1","1",12,12);
                    Medicamento m2 = new Medicamento("2","2","2",12,12);
                    Medicamento m3 = new Medicamento("3","3","3",12,12);

                    this.arbol.insertarSinDuplicados(m1);
                    this.arbol.insertarSinDuplicados(m2);
                    this.arbol.insertarSinDuplicados(m3);

                break;

                case 3:

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
        }while (opcion != 0);
    }
}
