package com.zawadzki.main;

import com.zawadzki.classes.*;
import com.zawadzki.database.Database;
import com.zawadzki.panels.PanelLogowanie;

import javax.swing.*;
import java.util.List;

/**
 * Hello world!
 *
 */
//K-M Programs
//http://km-programs.pl/
public class App {

    public static void createAndShowGui()
    {
        JFrame frame = new JFrame("PIERWSZE OKNO"); //reprezentuje okienko
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //PanelGlowny panel = new PanelGlowny();
        PanelLogowanie panel = new PanelLogowanie(); //tutaj robie obiekt panelu, ktoy przed chwila
        //PanelTabela panel = new PanelTabela();
        //utworzylem zeby za chwile przekazac go do okienka
        //PanelUczelnia panel = new PanelUczelnia();
        //PanelKonwersjaWalut panel = new PanelKonwersjaWalut();

        panel.setVisible(true); //ustawiasz panel na widoczny
        frame.setContentPane(panel); //wlasnie tutaj ustawiasz ze panel ktory utworzyles wyzje ma byc wyswietlany
        //w okienku frame
        //frame.setJMenuBar(panel.createMenu()); //ustawienie menu w oknie glownym
        frame.setLocationRelativeTo(null); //ustawia okienko w centrum ekranu
        frame.setVisible(true); //ustawiamy okienko zeby bylo widoczne
        frame.setResizable(true); //pozwala okienku sie rozciagac lub nie - za pomoca myszki
        frame.pack(); //metoda pack analizuje jakie komponenty znajduja sie w okienku
        //i dostosowuje wymiar okienka do tych komponentow

    }
    public static void main(String[] args) {
        /*
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj napis");
		String napis = sc.nextLine();

		//jak w wyrazeniu regularnym wstawisz . to oznacza ona ze w tym miejscu moze pojawic sie dowolny znak
		//a jak dasz \\. to znaczy ze chcesz zeby w tym miejscu pojawila sie kropka
		while (!napis.matches(".{3,}@[a-z]+\\.pl"))
		{
			System.out.println("Podaj napis");
			napis = sc.nextLine();
		}
		*/


        Database.connect();
        Database.createTables();
        System.out.println(Database.liczbaStudentowNaPoszczegolnychLatachStudiow());
        System.out.println(Database.liczbaStudentowZPoszczegolnychWojewodztw());

        //Database.insertLogowanie(new Logowanie(0,"a",Szyfrowanie.szyfrowanie("a"), "ADMIN"));
        //Database.insertLogowanie(new Logowanie(0,"z",Szyfrowanie.szyfrowanie("z"), "USER"));



	/*	Database.insertStudent(new Student(0, "Adam", "Nowak", 21, "ul. Cicha 7 10-100 Warszawa",
				2, "adamnowak@gmail.com", "656455677"));
		Database.insertStudent(new Student(0, "Pawel", "Nowakowski", 22, "ul. Glosna 12 00-150 Warszawa",
				2, "pawelnowakowski@gmail.com", "545354543"));
		Database.insertStudent(new Student(0, "Monika", "Cicha", 23, "ul. Hukowa 15-400 Warszawa",
				2, "monikacicha@gmail.com", "987657342"));
		Database.insertStudent(new Student(0, "Wojtek", "Kat", 26, "ul. Torturowa 12 33-345 Krakow",
				2, "wojtekkat@gmail.com", "666765654"));
		Database.insertStudent(new Student(0, "Robert", "Mlot", 33, "ul. Mlotkowa 30-303 Szczecin",
				2, "robertmlot@gmail.com", "763834721"));
		Database.insertStudent(new Student(0, "Zbigniew", "Nowacki", 24, "ul. Muzyczna 12 40-402 Gdanska",
				2, "zbigniewnowacki@gmail.com", "874837433"));
		Database.insertStudent(new Student(0, "Hubert", "Hak", 32, "ul. Szczecinska 22 09-220 Warszawa",
				2, "huberthak@gmail.com", "838234345"));
		Database.insertStudent(new Student(0, "Maksymilian", "Nowak", 25, "ul. Dwunasta 22 02-333 Warszawa",
				2, "maksnowak@gmail.com", "873929432"));*/


		/*
		Database.updateStudent(new Student(8, "Anna", "Gwozdz", 19, "ul. Mala 2 76-111 Szczecin",
				1, "annagwozdz@gmail.com", "888765456"));
		*/

		/*
		Database.deleteStudent(8);
		*/

        List<Student> lista = Database.selectStudent();
        for (Student ss : lista)
        {
            System.out.println(ss);
        }


		/*Database.insertUczelnia(new Uczelnia(-1, "AGH" ,"Lbn", 1954, "Jan Kowalski", "jankowalski@gmail.com", "ul. bajeczna"));
		Database.insertUczelnia(new Uczelnia(-1, "PW" ,"Warszawa", 1994, "PAWEL BOJAK", "pawelbojak@gmail.com", "ul.Bojacka 12"  ));
		Database.insertUczelnia(new Uczelnia(-1, "PK" ,"Krakow", 1945, "Adam Nowak", "adamnowak@gmail.com", "ul. Nowacka 22"));
		Database.insertUczelnia(new Uczelnia(-1, "UJ" ,"Szczecin", 1956, "Robert Lotny", "robertlotny@gmail.com", "ul. Lotna 23" ));
		Database.insertUczelnia(new Uczelnia(-1, "SGH" ,"Poznań", 1974, "Adam Nawałka", "adamnawalka@gmail.com", "ul. nawalkowa 34"));*/


		/*
		Database.updateUczelnia(new Uczelnia(1, "Warszawa", 1955, "Adam Pawel", "adampawel@gmail.com", "ul. Pawłowa 15"));
		Database.deleteUczelnia(3);
		*/
        List<Uczelnia> uczelnia = Database.selectUczelnia();

        for(Uczelnia u : uczelnia)
        {
            System.out.println(u);
        }
		/*
		Database.selectUczelnia();



		*/


		/*Database.insertWpis(new Wpis(0, 2, 4));
		Database.insertWpis(new Wpis(0, 1, 1));
		Database.insertWpis(new Wpis(0, 2, 2));
		Database.insertWpis(new Wpis(0, 4, 2));
		Database.insertWpis(new Wpis(0, 5, 2));*/


        //Database.deleteWpis(3);
		/*
		Database.updateWpis(new Wpis(2, 4, 1));

		List<Wpis> wpis = Database.selectWpis();

		for(Wpis w : wpis)
		{
			System.out.println(w);
		}
		*/

        List<StudentUczelnia> su = Database.selectInnerJoinStudentUczelnia();
        for (StudentUczelnia el : su)
        {
            System.out.println(el);
        }

        //Database.insertLogowanie(new Logowanie(0,"user","user","user"));
        //Database.insertLogowanie(new Logowanie(0,"user","user1","user"));
        //Database.insertLogowanie(new Logowanie(0,"admin","admin","admin"));

        //Database.updateLogowanie(new Logowanie(1, "Henio", "userek", "admin"));
        System.out.println(Database.pobierzHaslo("Henio"));

        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        List<String> imiona = Database.selectImionaStudenci();
        for(String imie : imiona)
        {
            System.out.println(imie);
        }
        System.out.println("---------------------------------");
        List<String> nazwisko = Database.selectNazwiskoStudentow();
        for(String n  : nazwisko)
        {
            System.out.println(n);
        }
        System.out.println("---------------------------------");
        List<String> miejscowosc = Database.selectMiejscowoscUczelnia();
        for(String m : miejscowosc)
        {
            System.out.println(m);
        }
        System.out.println("---------------------------------");
        List<Integer> kolekcjaWiek = Database.selectWiekStudentow();
        for(Integer w : kolekcjaWiek)
        {
            System.out.println(w);
        }
        System.out.println("---------------------------------");
        List<Integer> kolekcjaRokStudiow = Database.selectRokStudiow();
        for(Integer r : kolekcjaRokStudiow)
        {
            System.out.println(r);
        }

        /*
        String user = "a";
        String pass = "abcDE";
        Database.insertLogowanie(new Logowanie(0, user, Szyfrowanie.szyfrowanie(pass), Role.ADMIN.toString()));

        String user1 = "b";
        String pass1 = "abcDE";
        Database.insertLogowanie(new Logowanie(1, user1, Szyfrowanie.szyfrowanie(pass1), Role.USER.toString()));
        */

        javax.swing.SwingUtilities.invokeLater( () -> {createAndShowGui();}
        );


    }

}
