package com.motuziene;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final HashMap<String, String> VARTOTOJO_SAUGYKLA = new HashMap<String, String>();
    public static Programa programa = new Programa(SCANNER.nextLine(),SCANNER.nextLine());

    public static void main( String[] args ) {
        while (true) {
            System.out.println("pasirinkite ką norite atlikti");
            System.out.println("[1] - jei norite registruotis");
            System.out.println("[2] - jei norite prisijungti");
            int pasirinkimas = SCANNER.nextInt();
            SCANNER.nextLine();
            switch (pasirinkimas) {
                case 1 -> vartotojoRegistracija();
                case 2 -> {}
                default -> {
                    System.out.println("neteisingas pasirinkimas, bandykite dar kartą");
                }
            }
        }
    }

    private static void vartotojoRegistracija() {
        System.out.println("Iveskite vartotojo vardą");
        String userName = SCANNER.nextLine();
        System.out.println("Iveskite pasirinktą slaptažodį");
        String userPass = SCANNER.nextLine();
        System.out.println("pakartokite ivesta slaptazodi");
        String userPass2 = SCANNER.nextLine();

        if (userPass.equals(userPass2)) {
            String uzkoduotasPass = programa.uzkoduotiSlaptazodi(userPass);
            VARTOTOJO_SAUGYKLA.put(userName,uzkoduotasPass);
        } else {
            System.out.println("slaptazodziai nesutampa, bandykite dar karta");
        }
    }
}
