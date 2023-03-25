package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Kategorija;
import hr.java.vjezbe.entitet.Korisnik;


import java.math.BigDecimal;
import java.util.Scanner;

public class Glavna {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        //unos broja korisnika
        System.out.print("Unesite broj korisnika koji želite unijeti: ");
        int brojKorisnika = Integer.parseInt(scanner.nextLine());

        //unos korisnika
        Korisnik[] korisnici = new Korisnik[brojKorisnika];
        for (int i = 0; i < korisnici.length; i++) {
            System.out.println("Unesite podatke za " +(i+1) + ".korisnika");
            System.out.print("Ime: ");
            String ime = scanner.nextLine();
            System.out.print("Prezime: ");
            String prezime = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Telefon: ");
            String telefon = scanner.nextLine();
            korisnici[i] = new Korisnik(ime, prezime, email, telefon);
        }

        //unos broja kategorija
        System.out.print("Unesite broj kategorija koji želite unijeti: ");
        int brojKategorija = Integer.parseInt(scanner.nextLine());

        //unos kategorija i artikala
        Kategorija[] kategrije = new Kategorija[brojKategorija];
        for (int i = 0; i < brojKategorija; i++) {
            System.out.println("Unesite podatke za " + (i+1) +".kategoriju:");
            System.out.print("Naziv: ");
            String naziv = scanner.nextLine();
            System.out.print("Broj artikla:");
            int brojArtikla = Integer.parseInt(scanner.nextLine());
            Artikl[] artikli = new Artikl[brojArtikla];
            for (int j = 0; j < artikli.length; j++){
                System.out.println("Unesite podatke za: " +(j+1) +".artikl:");
                System.out.print("Naslov: ");
                String naslov = scanner.nextLine();
                System.out.print("Opis: ");
                String opis = scanner.nextLine();
                System.out.print("Cijena: ");
                String cijenaString = scanner.nextLine();
                BigDecimal cijena = new BigDecimal(cijenaString);
                artikli[j] = new Artikl(naslov, opis, cijena);
            }
            kategrije[i] = new Kategorija(naziv, artikli);
        }

        //ispis podataka
        System.out.println("Korisnici:");
        for (Korisnik korisnik : korisnici) {
            System.out.println(korisnik.getIme() + " " + korisnik.getPrezime() + ", " +korisnik.getEmail() +", " +korisnik.getTelefon());
        }

        System.out.println("\nKategorije i artikli:");
        for (Kategorija kategorija : kategrije) {
            System.out.println(kategorija.getNaziv() + ":");
            for (Artikl artikl : kategorija.getArtikli()) {
                System.out.println(artikl.getNaslov() +" - " + artikl.getOpis() + " - " +artikl.getCijena());
            }
            System.out.println();
        }
        scanner.close();
    }
}
