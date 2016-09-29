import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Emil on 29.09.2016.
 */
public class Primtallutvalg {
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        int numberOfValues = 0;
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> nonPrimes = new ArrayList<>();

        System.out.println("Hvor mange verdier skal leses inn?");
        try{
            numberOfValues = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Svaret maa vaere ett heltall stoerre enn 1...");
            System.exit(1);
        }

        if(numberOfValues < 1){
            System.out.println("Feil! Antall verdier maa vaere minst 1.");
            System.exit(1);
        }else{
            int holderValue;
            for(int i = 0; i < numberOfValues; i++){
                System.out.println("oppgi verdi " + (i+1) + ":");
                holderValue = sc.nextInt();
                if(erPrimtall(holderValue)){
                    primes.add(holderValue);
                }else{
                    nonPrimes.add(holderValue);
                }
            }

            System.out.println("Primtall:");
            for(Integer i : primes){
                System.out.println(primes.get(primes.indexOf(i)));
            }
            System.out.println("Andre tall:");
            for(Integer i : nonPrimes){
                System.out.println(nonPrimes.get(nonPrimes.indexOf(i)));
            }
        }
    }

    private static boolean erPrimtall(int holderValue) {
        if(holderValue% 2 == 0){
            return false;
        }else{
            for(int i = 3; i*i <= holderValue; i+=2){
                if(holderValue%i == 0){
                    return false;
                }
            }
        }
        return true;

    }
}
