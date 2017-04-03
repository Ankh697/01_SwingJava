package com.zawadzki.classes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
//K-M Programs
//http://km-programs.pl/
/**
 * Created by Marcin on 2017-01-24.
 */
public class Szyfrowanie {
    enum RodzajZnaku {MALA_LITERA, DUZA_LITERA, CYFRA, INNY_ZNAK}

    private static Integer integerKey = 24;

    private static final String ENCRYPTION_KEY = "KQUWSPDX";

    private static Map<Integer, RodzajZnaku> generujMapa(String napis) {
        Map<Integer, RodzajZnaku> mapaZnakow = new HashMap<>();
        for (int i = 0; i < napis.length(); i++) {
            char z = napis.charAt(i);
            if (Character.isUpperCase(z)) {
                mapaZnakow.put(i, RodzajZnaku.DUZA_LITERA);
            } else if (Character.isLowerCase(z)) {
                mapaZnakow.put(i, RodzajZnaku.MALA_LITERA);
            } else if (Character.isDigit(z)) {
                mapaZnakow.put(i, RodzajZnaku.CYFRA);
            } else {
                mapaZnakow.put(i, RodzajZnaku.INNY_ZNAK);
            }
        }
        return mapaZnakow;
    }

    private static char[][] generujTablicaKluczDuzeLitery() {
        int w = ENCRYPTION_KEY.length();
        int k = 26;

        char[][] znaki = new char[w][k];

        for (int i = 0; i < w; i++) {
            znaki[i][0] = ENCRYPTION_KEY.charAt(i);
            char kolejnyZnak = ENCRYPTION_KEY.charAt(i);
            for (int j = 1; j < k; j++) {
                kolejnyZnak++;
                if (kolejnyZnak > 'Z') {
                    kolejnyZnak = 'A';
                }
                znaki[i][j] = kolejnyZnak;
            }
        }
        return znaki;
    }

    private static char[][] generujTablicaKluczMaleLitery() {
        String encryptionKeySmall = ENCRYPTION_KEY.toLowerCase();
        int w = encryptionKeySmall.length();
        int k = 26;

        char[][] znaki = new char[w][k];

        for (int i = 0; i < w; i++) {
            znaki[i][0] = encryptionKeySmall.charAt(i);
            char kolejnyZnak = encryptionKeySmall.charAt(i);
            for (int j = 1; j < k; j++) {
                kolejnyZnak++;
                if (kolejnyZnak > 'z') {
                    kolejnyZnak = 'a';
                }
                znaki[i][j] = kolejnyZnak;
            }
        }
        return znaki;
    }

    //SZYFROWANIE
    public static String szyfrowanie(String napis) {
        //jakie mamy problemy przy szyfrowaniu?
        //1. moga byc duze i male litery
        //2. moga wystapic cyfry, te tez pasowaloby zaszyfrowac w jakis sposob
        //3. moga wystapic inne znaki - te tez trzeba jakos zaszyfrowac

        //wprowadzimy mape, ktora oprocz zaszyfrowanego znaku przechowywac bedzie
        //info jaki to byl znak przed szyfrowaniem

        //zasady szyfrowania dla poszczegolnych znakow
        //1. duze litery wedlug tablicy szyfrujacej
        //2. male litery wedlug tablicy szyfujacej ale wczesniej trzeba bedzie zamienic na duza litere
        //3. cyfry - zapisujesz dopelnieni do 10 czyli cyfre 7 kodujesz jako 3 bo 7 + 3 = 10
        //4. inne znaki - przechowujesz za pomoca szyfru cezara czyli kazdy taki znak zwiekszasz o k
        //ktore rowniez zrobimy jako stala skladowo klasy

        char[][] tabKluczDuze = generujTablicaKluczDuzeLitery();
        char[][] tabKluczMale = generujTablicaKluczMaleLitery();
        Map<Integer, RodzajZnaku> mapaZnakow = generujMapa(napis);
        StringBuilder wynik = new StringBuilder();
        int idx = 0; //numer kolejnego wiersza z ktoeego bede bral literki

        //przechodzimy po napisie ktory szyfrujemy
        for (int i = 0; i < napis.length(); i++) {
            //teraz musimy sprawdzic z jakim znakiem mamy do czynienia i tu pomoze nam mapa
            if (mapaZnakow.get(i).equals(RodzajZnaku.DUZA_LITERA)) {
                //napis.charAt(i) - 'A' -> przesuniecie pomiedzy znakiem szyfrowanym a
                //litera 'A' ktore pozniej przeklada sie na odpowiednia pozycje
                //w tablicy
                wynik.append(tabKluczDuze[idx][napis.charAt(i) - 'A']);

                idx++;
                if (idx >= tabKluczDuze.length) {
                    idx = 0;
                }
            }
            else if (mapaZnakow.get(i).equals(RodzajZnaku.MALA_LITERA))
            {
                wynik.append(tabKluczMale[idx][napis.charAt(i) - 'a']);

                idx++;
                if (idx >= tabKluczMale.length) {
                    idx = 0;
                }
            }
            else if (mapaZnakow.get(i).equals(RodzajZnaku.CYFRA))
            {
                wynik.append(10 - Character.getNumericValue(napis.charAt(i)));
            }
            else if (mapaZnakow.get(i).equals(RodzajZnaku.INNY_ZNAK))
            {
                //szyfr Cezara dla pozostalych znakow
                wynik.append((char)(napis.charAt(i) + integerKey));
            }
        }
        System.out.println("SZYFROWANIE -> " + wynik.toString());
        return wynik.toString();
    }

    //DESZYFROWANIE
    public static String odszyfrowanie(String napis) {
        char[][] tabKluczDuze = generujTablicaKluczDuzeLitery();
        char[][] tabKluczMale = generujTablicaKluczMaleLitery();

        StringBuilder wynik = new StringBuilder();
        int idx = 0; //numer kolejnego wiersza z ktoeego bede bral literki
        Map<Integer, RodzajZnaku> mapaZnakow = generujMapa(napis);

        //przechodzimy po napisie ktory odszyfrujemy
        for (int i = 0; i < napis.length(); i++) {
            if (mapaZnakow.get(i) == RodzajZnaku.DUZA_LITERA)
            {
                //przegladam kolejny wiersz z tablicy kluczy
                for (int j = 0; j < tabKluczDuze[idx].length; j++) {
                    if (tabKluczDuze[idx][j] == napis.charAt(i)) {
                        wynik.append((char) ('A' + j));
                        break;
                    }
                }

                idx++;

                if (idx >= tabKluczDuze.length) {
                    idx = 0;
                }
            }
            else if (mapaZnakow.get(i) == RodzajZnaku.MALA_LITERA)
            {
                //przegladam kolejny wiersz z tablicy kluczy
                for (int j = 0; j < tabKluczMale[idx].length; j++) {
                    if (tabKluczMale[idx][j] == napis.charAt(i)) {
                        wynik.append((char) ('a' + j));
                        break;
                    }
                }

                idx++;

                if (idx >= tabKluczMale.length) {
                    idx = 0;
                }
            }
            else if (mapaZnakow.get(i) == RodzajZnaku.CYFRA)
            {
                wynik.append(10 - Character.getNumericValue(napis.charAt(i)));
            }
            else
            {
                wynik.append((char)(napis.charAt(i) - integerKey));
            }
        }
        System.out.println("ODSZYFROWANIE -> " + wynik.toString());
        return wynik.toString();
    }


}
