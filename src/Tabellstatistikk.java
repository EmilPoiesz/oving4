import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

/**
 * Created by Emil on 29.09.2016.
 */
public class Tabellstatistikk {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int numberOfValues;
        double snitt, varians, sdavik;
        ArrayList<Integer> values = new ArrayList<>();

        System.out.println("Hvor mange verdier skal leses inn?");
        numberOfValues = sc.nextInt();

        for(int i = 0; i < numberOfValues; i++){
            System.out.println("Oppgi verdi " + (i+1) + ":");
            values.add(sc.nextInt());
        }
        snitt = getSnitt(values);
        varians = getVarians(values, snitt);
        sdavik = getSdAvik(varians);

        System.out.println("Tabell:");
        for(int i = 0; i < values.size(); i++){
            System.out.println((double) values.get(i));
        }
        System.out.println("Snitt:  " + snitt);
        System.out.println("Varians:  " + varians);
        System.out.println("StanderdAvvik:  " + sdavik);
    }

    private static double getSdAvik(double varians) {
        return sqrt(varians);
    }

    private static double getVarians(ArrayList<Integer> values, double snitt) {
        double varians = 0;
        for(Integer i : values){
            varians = varians + ((i - snitt)*(i - snitt));
        }
        return varians/values.size();
    }

    private static double getSnitt(ArrayList<Integer> values) {
        double sum = 0;
        for(Integer i : values){
            sum += i;
        }
        return sum/values.size();
    }
}
