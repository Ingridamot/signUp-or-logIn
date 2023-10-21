package com.motuziene;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static final HashMap<String, String> VARTOTOJO_SAUGYKLA = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean noriuAtliktiVeiksmus = true;

        while (noriuAtliktiVeiksmus) {
            System.out.println("pasirinkite ką norite atlikti");
            System.out.println("[1] - jei norite registruotis");
            System.out.println("[2] - jei norite prisijungti");
            System.out.println("[0] - jei norite uzdaryti programa");
            int pasirinkimas = scanner.nextInt();
            switch (pasirinkimas) {
                case 1 -> vartotojoRegistracija();
                case 2 -> vartotojoPrisijungimas();
                case 0 -> noriuAtliktiVeiksmus = false;
                default -> System.out.println("neteisingas pasirinkimas, bandykite dar kartą");
            }
        }
    }

    private static void vartotojoPrisijungimas() {
        System.out.println("Įveskite vartotojo vardą");
        String userName = scanner.next();
        System.out.println("Įveskite slaptažodį");
        String userPass = scanner.next();
        String uzkoduotasuserPass = uzkoduotiSlaptazodi(userPass);
        boolean found = false;

        for (Map.Entry<String, String> entry : VARTOTOJO_SAUGYKLA.entrySet()) {
            String storedUserName = entry.getKey();
            String storedUserPass = entry.getValue();

            if (userName.equals(storedUserName) && uzkoduotasuserPass.equals(storedUserPass)) {
                found = true;
                System.out.println("Sėkmingai prisijungėte!");
                break;
            }
        }
        if (!found) {
            System.out.println("Neteisingas vartotojo vardas arba slaptažodis");
        }
    }

    private static void vartotojoRegistracija() {
        System.out.println("Iveskite vartotojo vardą");
        String userName = scanner.next();
        System.out.println("Iveskite pasirinktą slaptažodį");
        String userPass = scanner.next();
        System.out.println("pakartokite ivesta slaptazodi");
        String userPass2 = scanner.next();

        if (userPass.equals(userPass2)) {
            String uzkoduotasPass = uzkoduotiSlaptazodi(userPass);
            VARTOTOJO_SAUGYKLA.put(userName, uzkoduotasPass);
        } else {
            System.out.println("slaptazodziai nesutampa, bandykite dar karta");
        }
    }

    public static String uzkoduotiSlaptazodi(String userPass) {
        return DigestUtils.sha256Hex(userPass);
    }
}
