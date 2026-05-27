package Ejercicio2;

import Ejercicio1.Funko;
import Ejercicio1.Status;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Funciones {
    public static ArrayList<Funko> importList(){
        ArrayList<Funko> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("funkos.csv"))){
            String linea;
            String[] datos = new String[5];
            if (datos.length == 5){
                Status status;
                if (datos[4].equalsIgnoreCase("EMBALAJE ORIGINAL")){
                    status = Status.EMBALAJE_ORIGINAL;
                }
                else if (datos[4].equalsIgnoreCase("SIN EMBALAJE ORIGINAL")){
                    status = Status.SIN_EMBALAJE;
                } else status = Status.PRECINTADA;

                list.add(new Funko(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[3]), status, datos[2].equalsIgnoreCase("SI")));
            }
        } catch (IOException e){}

       return list;
    }

    public static void saveListToCSV(ArrayList <Funko> funkoList){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("funkos.csv"))){
            for (Funko f : funkoList){
                String bool = f.isLimitedEdition() ? "SÍ" : "NO";
                String stText = f.getStatus() == Status.EMBALAJE_ORIGINAL ? "EMBALAJE ORIGINAL" : f.getStatus() == Status.SIN_EMBALAJE ? "SIN EMBALAJE ORIGINAL" : "PRECINTADO";
                bw.write(f.getName() + "#" + stText);
                bw.newLine();
            }
        }catch (IOException e){}
    }

    public static void deleteFunko (Scanner read, ArrayList<Funko> funkoList){
        String nameToDelete = read.nextLine();
        for(int i = 0; i < funkoList.size(); i++){
            if (funkoList.get(i).getName().equalsIgnoreCase(nameToDelete)){
                funkoList.remove(i);
                saveListToCSV(funkoList);
                break;
            }
        }
    }

    public static void showNewestFunko(Scanner read, ArrayList <Funko> funkoList){
        int newestYear = 0;
        for (Funko f : funkoList){
            if (f.getReleaseYear() > newestYear){
                newestYear = f.getReleaseYear();
            }
        }
    }

    public static void showOldestFunko(Scanner read, ArrayList <Funko> funkoList){
        int oldestYear = 9999;
        for (Funko f : funkoList){
            if (f.getReleaseYear() < oldestYear){
                oldestYear = f.getReleaseYear();
            }
        }
    }
    public static void showAvgPrice (ArrayList <Funko> funkoList){
        double total = 0;
        for (Funko f : funkoList) total += f.getBasePrice();
        if (!funkoList.isEmpty()) System.out.println(total / funkoList.size());
    }
}
