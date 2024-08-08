package pooinicial;

import java.util.Scanner;
import model.Manager;
import model.Elector;

public class PooInicial {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        contractRegister();
    }

    private static void contractRegister() {
        Manager objManager = new Manager();

        System.out.println("Ingrese el número del contrato: ");
        String nroContract = scan.next();

        System.out.println("Ingrese la fecha del contrato: ");
        String dateContract = scan.next();

        System.out.println("Ingrese la descripción del contrato: ");
        String descriptionContract = scan.next();

        System.out.println("Ingrese E para registrar el contrato como Elector: ");
        char swElector = scan.next().toUpperCase().charAt(0);
        scan.nextLine();

        String peopleType = "";
        if (swElector == 'E') {
            System.out.println("Ingrese el tipo de persona: ");
            peopleType = scan.next();

            Elector objElector = new Elector(nroContract, dateContract, descriptionContract, peopleType);

            if (objElector.register(objElector)) {
                System.out.println("Contrato ingresado correctamente!!...");
            } else {
                System.out.println("Contra no ingresado verifique o intentelo de nuevo!!...");
            }

        } else {
            Manager objManagerTwo = new Manager(nroContract, dateContract, descriptionContract);

            if (objManagerTwo.register(objManagerTwo)) {
                System.out.println("Contrato ingresado correctamente!!...");
            } else {
                System.out.println("Contra no ingresado verifique o intentelo de nuevo!!...");
            }
        }

//        objContract.nroContract = nroContract;
//        objContract.date = dateContract;
//        objContract.description = descriptionContract;
//        if (objContract.register(nroContract, dateContract, descriptionContract)) {
//            System.out.println("Contrato ingresado correctamente!!...");
//        } else {
//            System.out.println("Contra no ingresado verifique o intentelo de nuevo!!...");
//        }
//        Contract objContracTwo = new Contract(nroContract, dateContract, descriptionContract);
        System.out.println("\nDatos del Objeto...");
//        System.out.println(objContracTwo.nroContract);
//        System.out.println(objContracTwo.date);
//        System.out.println(objContracTwo.description);

    }

}
