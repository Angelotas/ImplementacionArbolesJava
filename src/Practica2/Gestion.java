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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;
import jerarquicos.*;

/**
 *
 * @author Ángel
 */
public class Gestion {
    
    
    ABB<Medicamento> arbol= new ABB<Medicamento>();
    Medicamento medicamento;
    FileWriter fichero = null;
    FileReader fichero2 = null;
    PrintWriter pw = null;  //para la escritura
    BufferedReader br = null; //para la lectura
        
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
                        System.out.println("\n--------------------------------------");
                        System.out.println("\tLISTADO DE MEDICAMENTOS");
                        System.out.println("--------------------------------------\n");
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
                        System.out.print("\tPrecio(€): ");
                        float precio= MyInput.readFloat();
                        System.out.print("\tSeguridad social(%): ");
                        float segSoc= MyInput.readFloat();

                        medicamento = new Medicamento(cod,nombre,lab,precio,segSoc);
                        arbol.insertarSinDuplicados(medicamento);
                        System.out.println("\n->Medicamento creado con éxito...");


                    break;

                    case 3:
                        System.out.println("\n--------------------------------------");
                        System.out.println("\tELIMINAR MEDICAMENTO");
                        System.out.println("--------------------------------------\n");
                        this.arbol.esVacio();
                        System.out.print("\tCódigo del medicamento que se desa BORRAR: ");
                        String c= this.pedirCodigoMed(); //excepción
                        Medicamento aux= new Medicamento(c,null,null,0,0); //medicamento auxiliar con el código a buscar
                        medicamento = arbol.buscarPorCod(aux).getDato();
                        
                        System.out.println("\n¿Está seguro de que desea BORRAR el siguiente medicamento?(s/n)");
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
                        System.out.println("\n--------------------------------------");
                        System.out.println("\tMODIFICAR MEDICAMENTO");
                        System.out.println("--------------------------------------\n");
                        this.arbol.esVacio();
                        System.out.print("\tCÓDIGO del medicamento que se desa MODIFICAR: ");
                        String codigo= this.pedirCodigoMed(); //excepción
                        medicamento = this.buscarMedicamentoCod(codigo);
                        
       
                        System.out.println("\n¿Está seguro de que desea MODIFICAR el siguiente medicamento?(s/n)");
                        System.out.println(medicamento.toString());
                        System.out.print("\t-->Descisión: ");
                        String s= MyInput.readString();
                        if (s.charAt(0)== 's'){
                            this.ModidicarMedicamento(medicamento);
                        }
                        else{
                            System.out.println("\n->Modificado candelado...");
                        }
                    break;

                    case 5:

                        System.out.println("\n--------------------------------------");
                        System.out.println("\tCONSULTAR POR CÓDIGO");
                        System.out.println("--------------------------------------\n");
                        this.arbol.esVacio();
                        System.out.print("\tCÓDIGO del medicamento que se desa CONSULTAR: ");
                        String co= this.pedirCodigoMed(); //excepción
                        medicamento = this.buscarMedicamentoCod(co);
                        System.out.println(medicamento.toString());
                        
                    break;

                    case 6:
                        
                        System.out.println("\n--------------------------------------");
                        System.out.println("\tCONSULTAR POR NOMBRE");
                        System.out.println("--------------------------------------\n");
                        this.arbol.esVacio();
                        System.out.print("\tNOMBRE del medicamento que se desa CONSULTAR: ");
                        String nom= MyInput.readString();
                        this.buscarMedicamentoNom(nom); //excepción
                            
                    break;

                    case 7:
                        System.out.println("\n--------------------------------------");
                        System.out.println("\tCARGAR FICHERO");
                        System.out.println("--------------------------------------\n");
                        
                        try{
                            fichero2 = new FileReader("MEDICAMENTOS.txt");
                            
                            br = new BufferedReader(fichero2);
                            
                            this.cargarDatos(br); //carga los datos linea a linea
                            
                            System.out.println("\n-->Los datos se han cargado correctamente...");
                            
                            br.close();
                            fichero2.close();
                            
                        }
                        catch(Exception e){
                            System.out.println("\n**Error al cargar los datos**\n");
                        }
                        
                        
                    break;

                    case 8:
                        System.out.println("\n--------------------------------------");
                        System.out.println("\tSALVAR FICHERO");
                        System.out.println("--------------------------------------\n");
                        this.arbol.esVacio();
                        
                        try{
                            
                            fichero = new FileWriter("MEDICAMENTOS.txt");
                            pw = new PrintWriter(fichero);
                            
                            this.imprFormatoFich(arbol.getRaiz(), pw);
                            
                            fichero.close();
                            System.out.println("\n-->Los datos se han guardado correctamente...");
                        }
                        catch(Exception e){
                            System.out.println("\n**Existe un problema en el guardado de datos**");
                        }
                    break;
                    
                    case 0:
                        System.out.println("\n|--------------------------------------------------|");
                        System.out.println("|\tGracias por usar nuestra aplicación\t   |\n|\t\tHasta pronto...\t\t\t   |");
                        System.out.println("|--------------------------------------------------|\n");
                    break;
                    
                    default:
                        System.out.println("\n**Opción inválida, seleccione una del 0 al 8**\n");
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
            catch (NumberFormatException e){
                System.out.println("\n**La opción debe ser numérica**\n");
            }
            
        }while (opcion != 0);
    }
    
    public String pedirCodigoMed() throws FormatoMedicamentoInvalido{
        String cod;
        
        cod = MyInput.readString();
        /*if (cod.length() != 6){
            throw new FormatoMedicamentoInvalido("\n**El código del dni debe tener 6 dígitos**\n");
        }
        return cod;*/
        Pattern formato = Pattern.compile("[0-9]{6,}"); //Si la cadena esta formada por 6 dígitos numéricos
        Matcher mat= formato.matcher(cod);
        if (mat.matches()){
            return cod;
        }
        else
            throw new FormatoMedicamentoInvalido ("\n**El código de barras debe tener 6 dígitos numéricos**\n");
        
    }
    
    public void ModidicarMedicamento (Medicamento m) throws ElementoNoEncontrado{ 
    //hace uso del método genérico ModificarNodo
        
        String codig= m.getCodigoB();
        System.out.print("\n\t-Nuevo nombre: ");
        String nom= MyInput.readString();
        //m.setNombre(nom);
        
        System.out.print("\t-Nuevo laborario: ");
        String lab= MyInput.readString();
        //m.setLaboratorio(lab);
        
        System.out.print("\t-Nuevo precio(€): ");
        float pre= MyInput.readFloat();
        //m.setPrecio(pre);
        
        System.out.print("\t-Nuevo valor de seguridad social(%): ");
        float ss= MyInput.readFloat();
        //m.setPorcentajeSS(ss);
        
        Medicamento nuevo = new Medicamento(codig,nom,lab,pre,ss); //este medicamento reescribirá el dato del nodo que se quiere modificar
        NodoABB<Medicamento> nodoModificar = arbol.buscarPorCod(m); //el nodo que se quiere modificar
        arbol.ModificarNodo(nodoModificar, nuevo);
        
        System.out.println("\n-->Modificación realizada con éxito");

    }
    
    public Medicamento buscarMedicamentoCod(String cod) throws ElementoNoEncontrado{
        
        Medicamento aux= new Medicamento(cod,null,null,0,0); //medicamento auxiliar con el código a buscar
        return arbol.buscarPorCod(aux).getDato();
    }
    public void buscarMedicamentoNom (String nom) throws ElementoNoEncontrado {
        
        Medicamento aux= new Medicamento (null,nom,null,0,0);
        arbol.buscarPorNom(aux);
    }
    
    protected String imprFormatoFich(NodoABB<Medicamento> actual,PrintWriter pw){
        //metodo que devuelve una cadena con la información que se escribirá en el fichero de texto
        
        String tabulaciones= this.numTab(arbol.getNivel(actual));
        String res= tabulaciones+""+actual.getDato().toStringFich(); //tabulaciones por nivel + formato establecido
        pw.println(res); //lo escribe en el fichero en pre-orden
        if (actual.getIzq() != null){
            res+=imprFormatoFich(actual.getIzq(),pw);
        }
        if (actual.getDer()!= null){
            res+=imprFormatoFich(actual.getDer(),pw);
        }
        return res;  
        
    }
    
    protected void cargarDatos(BufferedReader br) throws IOException, ElementoDuplicado{
        
        String linea; //linea completa
        String linea2=""; //linea sin tabulaciones
        this.arbol=null; //antes hay que borrar el arbol
        this.arbol = new ABB();

        while ((linea=br.readLine()) != null){
            linea2 = linea.replaceAll("\t", ""); //linea eliminando  las tabulaciones
            String[] datos= linea2.split("#");
            String codigoBa= datos[0];
            String nomb= datos[1];
            String labo= datos[2];
            float pre= Float.parseFloat(datos[3]);
            float segS= Float.parseFloat(datos[4]);

            medicamento = new Medicamento(codigoBa,nomb,labo,pre,segS);
            this.arbol.insertarSinDuplicados(medicamento);
        }
        
    }
    public String numTab(int nivel){
        String tab="";
        for (int i=0; i< nivel; i++){
            tab+="\t";
        }
        return tab;
    } 
}
