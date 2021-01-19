package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Transactions {

    Connection connection;
    public Transactions(Connection conn){
        this.connection = conn;
    }
    public String consultId(int id){
        String animal="";
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT nombre "
                +"FROM animal "
                +"WHERE id = " + "'"+id+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animal = rs.getString("nombre");
                a.add(String.valueOf(animal));
            }
            return animal;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultTodos(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultPelo(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE pelo = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultPlumas(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE plumas = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultHuevo(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE huevo = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultVuela(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE vuela = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultNada(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE nada = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultDepred(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE depredador = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultDientes(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE dientes = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultVert(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE vertebrado = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultVeneno(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE venenoso = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultAleta(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE aletas = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultPata(int patas){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE patas = " + "'"+patas+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultCola(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE cola = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public ArrayList<String> consultDomestico(){
        int animalId=0;
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT id "
                +"FROM animal "
                +"WHERE domestico = " + "'"+1+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                animalId = rs.getInt("id");
                a.add(String.valueOf(animalId));
            }
            return a;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
    public String consultExtra(int id){
        String extra="";
        ArrayList<String> a=new ArrayList<String>();
        String query = "SELECT extra "
                +"FROM animal "
                +"WHERE id = " + "'"+id+"'";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                extra = rs.getString("extra");
                return extra;
            } else {
                return "";
            }
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
            return null;
        }
    }
}
