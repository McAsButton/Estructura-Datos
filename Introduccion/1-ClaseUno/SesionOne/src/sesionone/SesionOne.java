package sesionone;

import java.util.Scanner;

public class SesionOne {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        char sw;
        int subTotal = 0;
        
        do{
            subTotal += insertSells();
            System.out.println("Desea comprar más artículos (S/N):");
            sw = scan.next().toUpperCase().charAt(0);
        }while(sw == 'S');
        
         Double dbsubTotal = Double.valueOf(subTotal);
        System.out.println("Total a pagar: " + (dbsubTotal * 1.16));
    }

    private static int insertSells() {
        System.out.println("Ingrese A para aseo, V para Verduras, G para Granos: ");
        char opc = scan.next().toUpperCase().charAt(0);
        int quantity = 0;
        int priceA = 20000, priceV = 5000, priceG = 10000;
        int total = 0;

        switch (opc) {
            case 'A': {
                System.out.println("Ingrese la cantidad de artículos de aseo: ");
                quantity = scan.nextByte();
                total = priceA * quantity;
                break;
            }
            case 'V': {
                System.out.println("Ingrese la cantidad de verduras: ");
                quantity = scan.nextByte();
                total = priceV * quantity;
                break;
            }
            case 'G': {
                System.out.println("Ingrese la cantidad de Granos: ");
                quantity = scan.nextByte();
                total = priceG * quantity;
                break;
            }
            default: {
                break;
            }
        }
        return total;

    }

}
