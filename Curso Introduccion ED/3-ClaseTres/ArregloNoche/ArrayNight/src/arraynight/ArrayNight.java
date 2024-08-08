package arraynight;

import java.util.Scanner;

public class ArrayNight {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        byte[] ages = insertUniArray(createUniArray());
//        showUniArray(ages);
//        System.out.println("El promedio de las edades es: " + averageUniArray(ages));

        byte[][] ages = insertBiArray(createBiArray());
        showBiArray(ages);
        
        System.out.println("\nEl promedio de las edades es: " + averageBiArray(ages));
    }

    private static byte[] createUniArray() {
        // When developer know the datas on the Array
        byte ageOne[] = {45, 65, 90, 80, 55};

        // Other way when developer know the datas on the Array     
        byte[] ageTwo = new byte[]{45, 65, 90, 80, 55};

        // When developer don't know the datas on the Array
        System.out.println("Ingrese la cantidad de edades que desea:");
        byte agesQuty = scan.nextByte();

        byte[] ageThree = new byte[agesQuty];

        return ageThree;
    }

    private static byte[] insertUniArray(byte[] createUniArray) {
        System.out.println("\nIngrese las edades al vector");

        for (int i = 0; i < createUniArray.length; i++) {
            System.out.println("Ingrese la " + (i + 1) + " edad: ");
            createUniArray[i] = scan.nextByte();
        }

        return createUniArray;
    }

    private static void showUniArray(byte[] ages) {
        System.out.println("\nContenido del vector");

        for (int i = 0; i < ages.length; i++) {
            System.out.println("La " + (i + 1) + " edad es: " + ages[i]);
        }
    }

    private static String averageUniArray(byte[] ages) {
        int ageSum = 0;

        for (int i = 0; i < ages.length; i++) {
            ageSum += ages[i];
        }

        return String.valueOf(ageSum / ages.length);
    }

    private static byte[][] createBiArray() {
        // When developer know the datas on the Bidimentional Array
        byte ageOne[][] = {{45, 65, 90}, {80, 55, 18}, {22, 35, 20}};

        // Other way when developer know the datas on the Bidimentional Array     
        byte[][] ageTwo = new byte[][]{{45, 65, 90}, {80, 55, 18}, {22, 35, 20}};

        // When developer don't know the datas on the Bidimentional Array
        System.out.println("Ingrese la cantidad de filas y columnas que desea "
                + "sobre la matrix:");
        byte agesQuty = scan.nextByte();

        byte[][] ageThree = new byte[agesQuty][agesQuty];

        return ageThree;
    }

    private static byte[][] insertBiArray(byte[][] biArray) {
        System.out.println("Ingresando edades a la matrix cuadrada");

        for (int f = 0; f < biArray.length; f++) {
            for (int c = 0; c < biArray[f].length; c++) {
                System.out.println("Ingrese la edad en la posición " + (f + 1) + " - " + (c + 1) + " = ");
                biArray[f][c] = scan.nextByte();
            }
        }

        return biArray;
    }

    private static void showBiArray(byte[][] ages) {
        System.out.println("\nContenido de las edades en la matrix cuadrada");

        for (int f = 0; f < ages.length; f++) {
            for (int c = 0; c < ages[f].length; c++) {
                System.out.println("La edad en la posición " + (f + 1) + " - " + (c + 1) + " es:"
                        + ages[f][c]);
            }
        }
    }

    private static String averageBiArray(byte[][] ages) {
        int totalRow = 0, egeStorage = 0;
        
        for (int f = 0; f < ages.length; f++) {
            for (int c = 0; c < ages[f].length; c++) {
                totalRow += ages[f][c];
            }
            egeStorage += totalRow;
            totalRow = 0;
        }
        
        return String.valueOf( egeStorage/(ages.length * ages[0].length));
    }

}
