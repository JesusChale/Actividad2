package com.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception{
        //Conexion a Base de Datos
        DBAdmin accesoDB = new DBAdmin();
        Transactions transactions = new Transactions(accesoDB.getConnection());

        //Variables
        int respuesta;
        int idCaract = 0;
        boolean extraEncontrar = false;
        //Listas
        ArrayList<String> listSeleccion = new ArrayList<String>();
        ArrayList<String> listTemp = new ArrayList<String>();
        ArrayList<String> caracteristicas = new ArrayList<String>(Arrays.asList(
                "pelo","plumas","huevo", "vuela","nada","dientes","vertebrado",
                "venenoso","aletas","cola","domestico","depredador"));
        ArrayList<String> preguntas = new ArrayList<String>(Arrays.asList(
                "¿Tiene pelo?","¿Tiene plumas?","¿Nace de un huevo?","¿Vuela?","¿Nada?","¿Tiene dientes?",
                "¿Es vertebrado?","¿Es venenoso?","¿Tiene aletas?","¿Tiene cola?","¿Es domestico?","¿Es un depredador?"));

        //Obtener todos los animales
        listSeleccion = transactions.consultTodos();

        //Primer pregunta
        respuesta = obtResp("¿Cuantas patas tiene?",true);
        //System.out.println("Respuesta "+respuesta);
        listTemp = transactions.consultPata(respuesta);
        listSeleccion = reduccionPatas(respuesta,listSeleccion,listTemp);

        //Realizar preguntas
        while (caracteristicas.size()>0 && listSeleccion.size()>1) {
            //Obtener caracteristicas resultados Media
            idCaract = elegirCaract(listSeleccion,caracteristicas,preguntas,transactions);
            //System.out.println("Caracteristica: "+ idCaract);
            respuesta = obtResp(preguntas.get(idCaract),false);
            listTemp = obtenerListCaract(caracteristicas.get(idCaract),transactions);
            listSeleccion = reduccion(respuesta,listSeleccion,listTemp);
            caracteristicas.remove(idCaract);
            preguntas.remove(idCaract);
            /*for (String a:caracteristicas) {
                System.out.println(a);
            }*/
            /*System.out.println("Animales disponibles");
            for (String a:listSeleccion) {
                System.out.println(a);
            }*/
        }

        //Imprimir Resultado
        if (listSeleccion.size()==1) {
            System.out.println("El animal es:");
            System.out.println(transactions.consultId(Integer.parseInt(listSeleccion.get(0))));
        } else {
            if (listSeleccion.size() > 1) {
                for (int y = 0;y<listSeleccion.size();y++){
                    respuesta = obtResp(transactions.consultExtra(Integer.parseInt(listSeleccion.get(y))),false);
                    if (respuesta==1){
                        System.out.println("El animal es:");
                        System.out.println(transactions.consultId(Integer.parseInt(listSeleccion.get(y))));
                        y = listSeleccion.size();
                        extraEncontrar = true;
                    }
                }
                if (!extraEncontrar) {
                    System.out.println("No se pudo encontrar el animal");
                }
            } else {
                System.out.println("No se pudo encontrar el animal");
            }
        }
    }
    //Preguntar y Obtener respuestas
    public static int obtResp(String preg,boolean patas){
        Scanner sc = new Scanner(System.in);
        int respuesta;
        boolean posible;
        String resp;
        do{ //Evita pattern incorrecto
            System.out.println(preg);
            resp = sc.nextLine();
            if (patas) {
                posible = Pattern.compile("^[02456]{1}$").
                        matcher(resp).matches();
                if (posible) {
                    respuesta = Integer.parseInt(resp);
                } else {
                    respuesta = 0;
                }
            } else {
                posible = Pattern.compile("Si|si|SI|No|no|NO").
                        matcher(resp).matches();
                if (resp.equals("Si")|| resp.equals("si") || resp.equals("SI")){
                    respuesta = 1;
                } else {
                    respuesta = 0;
                }
            }
        }while(!posible);
        //Eleccion

        return respuesta;
    }
    //ELegir mejor pregunta
    public static int elegirCaract(ArrayList<String> listSeleccion, ArrayList<String> caracteristicas,
                                   ArrayList<String> preguntas, Transactions transactions){
        ArrayList<String> count = new ArrayList<String>();
        ArrayList<String> borrar = new ArrayList<String>();
        ArrayList<String> listTemp = new ArrayList<>();
        int tamaño = 0;
        int tamTemp = 0;
        int idObj = 0;
        int positivo = 0;
        int negativo = 0;
        int diferencia = 0;
        String caract;
        //Llenar count, list para obtener diferencia a la mitad de los id disponibles
        for (int k=0;k<caracteristicas.size();k++){
            caract = caracteristicas.get(k);
            listTemp = obtenerListCaract(caract,transactions);
            positivo = reduccion(1,listSeleccion,listTemp).size();
            negativo = reduccion(0,listSeleccion,listTemp).size();
            //Si positivo o negativo es 0 simboliza que la caracteristica es igual para todos los id
            if (positivo==0 || negativo==0){
                //LLenar List para borrar caracteristicas inutiles
                borrar.add(caract);
            } else {
                //Llenar List para diferencias a la mitad
                diferencia = Math.abs(positivo-negativo);
                count.add(String.valueOf(diferencia));
            }
        }
        //Eliminar caracteristicas inutiles
        for (int h=0;h < borrar.size();h++){
            for (int g=0;g < caracteristicas.size();g++){
                if (borrar.get(h).equals(caracteristicas.get(g))){
                    caracteristicas.remove(g);
                    preguntas.remove(g);
                }
            }
        }
        //Seleccion de mejor opcion
        tamaño = Integer.parseInt(count.get(0));
        for (int f=1;f<count.size();f++){
            tamTemp = Integer.parseInt(count.get(f));
            if (tamTemp < tamaño) {
                idObj = f;
                tamaño = tamTemp;
            }
        }

        return idObj;
    }
    //Obtener lista de una caracteristica
    public static ArrayList<String> obtenerListCaract(String caract, Transactions transactions){
        ArrayList listTemp = new ArrayList<String>();

        switch (caract){
            case "pelo":
                listTemp = transactions.consultPelo();
                break;
            case "plumas":
                listTemp = transactions.consultPlumas();
                break;
            case "huevo":
                listTemp = transactions.consultHuevo();
                break;
            case "vuela":
                listTemp = transactions.consultVuela();
                break;
            case "nada":
                listTemp = transactions.consultNada();
                break;
            case "depredador":
                listTemp = transactions.consultDepred();
                break;
            case "dientes":
                listTemp = transactions.consultDientes();
                break;
            case "vertebrado":
                listTemp = transactions.consultVert();
                break;
            case "venenoso":
                listTemp = transactions.consultVeneno();
                break;
            case "aletas":
                listTemp = transactions.consultAleta();
                break;
            case "cola":
                listTemp = transactions.consultCola();
                break;
            case "domestico":
                listTemp = transactions.consultDomestico();
                break;
        }
        return listTemp;
    }
    //Reducir lista de animales disponibles
    public static ArrayList<String> reduccion(int respuesta,ArrayList<String> listSeleccion,
                                              ArrayList<String> listTemp){
        ArrayList<String> listResp = new ArrayList<String>();
        String seleccion="";
        String temporal ="";
        if (respuesta==1) {
            for (int x = 0;x<listSeleccion.size();x++) {
                for (int y = 0;y<listTemp.size();y++) {
                    if (listSeleccion.get(x).equals(listTemp.get(y))){
                        listResp.add(listSeleccion.get(x));
                    }
                }
            }
        } else {
            for (String a:listSeleccion) {
                listResp.add(a);
            }
            /*System.out.println(listSeleccion.size());
            System.out.println(listSeleccion.get(1));
            System.out.println(listSeleccion.get(2));*/
            for (int x = 0;x<listSeleccion.size();x++) {
                seleccion = listSeleccion.get(x);
                for (int y = 0;y<listTemp.size();y++) {
                    temporal = listTemp.get(y);
                    if (temporal.equals(seleccion)){
                        listResp.remove(seleccion);
                    }
                }
            }
        }
        return listResp;
    }
    //Reducir lista de animales disponibles con caracteristica de patas
    public static ArrayList<String> reduccionPatas(int respuesta,ArrayList<String> listSeleccion,
                                              ArrayList<String> listTemp){
        ArrayList listResp = new ArrayList<String>();
        for (int x = 0;x<listSeleccion.size();x++) {
            for (int y = 0;y<listTemp.size();y++) {
                if (listSeleccion.get(x).equals(listTemp.get(y))){
                    listResp.add(listSeleccion.get(x));
                }
            }
        }
        return listResp;
    }
}
