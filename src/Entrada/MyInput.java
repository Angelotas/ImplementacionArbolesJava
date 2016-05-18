/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrada;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Ángel
 */
public class MyInput {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {}
       // Lee una cadena de caracteres desde el teclado
    public static String readString() {
    BufferedReader br = new BufferedReader(new
    InputStreamReader(System.in),1);
    String string="";
    try {
            string = br.readLine(); }
    catch (IOException ex) {
        System.out.println(ex); }
    return string; }
// Lee un dato tipo int desde el teclado
public static int readInt() {
return Integer.parseInt(readString()); }
// Lee un dato tipo double desde el teclado
public static double readDouble() {
return Double.parseDouble(readString()); }
//Lee un dato tipo byte desde el teclado
public static byte readByte() {
return Byte.parseByte(readString()); }
// Lee un dato tipo short desde el teclado
public static short readShort() {
return Short.parseShort(readString()); }
// Lee un dato tipo long desde el teclado
public
static long readLong() {
return Long.parseLong(readString()); }
//Lee un dato tipo float desde el teclado
public static float readFloat() {
return Float.parseFloat(readString()); }
    
 
}

