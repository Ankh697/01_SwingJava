package com.zawadzki.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zawadzki.classes.*;

//K-M Programs
//http://km-programs.pl/



public class Database {

	private static String DRIVER = "org.sqlite.JDBC";
	private static String DB = "jdbc:sqlite:Dziekanat.db";
	private static Connection conn;
	private static Statement stat;



	public static void connect() {

		try {
			Class.forName(DRIVER);

			conn = DriverManager.getConnection(DB);



			stat = conn.createStatement();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createTables() {
		try {
			String createStudentSQL = "CREATE TABLE IF NOT EXISTS Student " + "( "
					+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + "imie VARCHAR(50) NOT NULL, "
					+ "nazwisko VARCHAR(50) NOT NULL, " + "wiek INTEGER NOT NULL, " + "adres VARCHAR(50) NOT NULL, "
					+ "rokStudiow INTEGER NOT NULL, " + "email VARCHAR(50) NOT NULL, " + "telefon VARCHAR(50) NOT NULL "
					+ ");";

			/*
			 * id integer not null primary key auto_increment, miejscowosc
			 * varchar(50) not null, rokZalozenia Integer not null, nazwaRektora
			 * varchar(50) not null, email varchar(50) not null, adres
			 * varchar(50) not null
			 */

			String createUczelniaSQL = "CREATE TABLE IF NOT EXISTS Uczelnia" 
					+ "( "
					+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
					+ "nazwa VARCHAR(50) NOT NULL, "
					+ "miejscowosc VARCHAR(50) NOT NULL, "
					+ "rokZalozenia INTEGER NOT NULL, " 
					+ "nazwaRektora VARCHAR(50) NOT NULL, "
					+ "email VARCHAR(50) NOT NULL, " 
					+ "adres VARCHAR(50) NOT NULL " + ")";


			String createWpisSQL = "CREATE TABLE IF NOT EXISTS Wpis " 
					+ "( "
					+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " 
					+ "idS INTEGER NOT NULL, "
					+ "idU INTEGER NOT NULL, "
					+ "FOREIGN KEY (idS) REFERENCES Student(id) ON DELETE CASCADE ON UPDATE CASCADE, "
					+ "FOREIGN KEY (idU) REFERENCES Uczelnia(id) ON DELETE CASCADE ON UPDATE CASCADE" 
					+ ")";
			
			String createLogowanieSQL = "CREATE TABLE IF NOT EXISTS Logowanie "
					+ " ( "
					+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
					+ "user VARCHAR(50) NOT NULL UNIQUE, "
					+ "haslo VARCHAR(50) NOT NULL, "
					+ "rola VARCHAR(50) NOT NULL "
					+ ");";

			stat.execute(createStudentSQL);
			stat.execute(createUczelniaSQL);
			//stat.execute("drop table Logowanie");
			stat.execute(createWpisSQL);
			stat.execute(createLogowanieSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void insertLogowanie(Logowanie l)
	{
		
		try {
			String insertLogowanieSQL = "INSERT INTO Logowanie "
					+ "(haslo, user, rola ) " + "VALUES"
					+ "(?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(insertLogowanieSQL);
			ps.setString(1, l.getHaslo());
			ps.setString(2, l.getUser());
			ps.setString(3, l.getRola().toString());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertStudent(Student s) {

		try {
			String insertStudentSQL = "INSERT INTO Student "
					+ "( imie, nazwisko, wiek, adres, rokStudiow, email, telefon ) " + "VALUES"
					+ "(?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = conn.prepareStatement(insertStudentSQL);
			ps.setString(1, s.getImie()); // znaki zapytania numerujesz od 1
			ps.setString(2, s.getNazwisko());
			ps.setInt(3, s.getWiek());
			ps.setString(4, s.getAdres());
			ps.setInt(5, s.getRokStudiow());
			ps.setString(6, s.getEmail());
			ps.setString(7, s.getTelefon());
			ps.execute(); // wykonanie sparametryzowanego zapytania
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertUczelnia(Uczelnia u) {

		try {
			String insertUczelniaSQL = "INSERT INTO Uczelnia "
					+ "(nazwa, miejscowosc, rokZalozenia, nazwaRektora, email, adres) VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = conn.prepareStatement(insertUczelniaSQL);
			ps.setString(1, u.getNazwa());
			ps.setString(2, u.getMiejscowosc());
			ps.setInt(3, u.getRokZalozenia());
			ps.setString(4, u.getNazwaRektora());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getAdres());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertWpis(Wpis w) {

		try {
			String insertWpisSQL = "INSERT INTO Wpis " + "(idS, idU) VALUES (?, ?);";
			PreparedStatement ps = conn.prepareStatement(insertWpisSQL);
			ps.setInt(1, w.getIdS());
			ps.setInt(2, w.getIdU());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

/*	private int id;
	private String user;
	private String haslo;
	private String rola;*/
	public static void updateStudent(Student s) {

		try {

			String updateStudentSQL = "UPDATE Student SET "
					+ "imie = ?, nazwisko = ?, wiek = ?, adres = ?, rokStudiow= ?, email= ?, telefon= ? "
					+ "WHERE id = ?;";

			PreparedStatement ps = conn.prepareStatement(updateStudentSQL);

			ps.setString(1, s.getImie()); // znaki zapytania numerujesz od 1
			ps.setString(2, s.getNazwisko());
			ps.setInt(3, s.getWiek());
			ps.setString(4, s.getAdres());
			ps.setInt(5, s.getRokStudiow());
			ps.setString(6, s.getEmail());
			ps.setString(7, s.getTelefon());
			ps.setInt(8, s.getId());
			ps.execute(); // wykonanie sparametryzowanego zapytania
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateLogowanie(Logowanie l)
	{
		
		try {
			String updateLogowanieSQL = "UPDATE Logowanie SET "
					+ "user = ?, haslo = ?, rola = ? "
					+ "WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(updateLogowanieSQL);
			ps.setString(1, l.getUser());
			ps.setString(2, l.getHaslo());
			ps.setString(3, l.getRola().toString());
			ps.setInt(4, l.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	// miejscowosc, rokZalozenia, nazwaRektora, email, adres " + "(?, ?, ?, ?, ?
	public static void updateUczelnia(Uczelnia u) {

		try {
			String updateUczelniaSQL = "UPDATE Uczelnia SET "
					+ "nazwa = ?, miejscowosc = ?, rokZalozenia = ?, nazwaRektora = ?, email = ?, adres = ? " + "WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(updateUczelniaSQL);
			ps.setString(1, u.getNazwa());
			ps.setString(2, u.getMiejscowosc());
			ps.setInt(3, u.getRokZalozenia());
			ps.setString(4, u.getNazwaRektora());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getAdres());
			ps.setInt(7, u.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	public static void updateWpis(Wpis w) {

		try {
			String updateWpisSQL = "UPDATE Wpis SET " + "idS = ?, idU = ? " + "WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(updateWpisSQL);
			ps.setInt(1, w.getIdS());
			ps.setInt(2, w.getIdU());
			ps.setInt(3, w.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteStudent(int id) {
		try {
			String deleteStudentSQL = "DELETE FROM Student WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(deleteStudentSQL);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteLogowanie(int id){
		
		try {
			String deleteLogowanieSQL = "DELETE FROM Logowanie WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(deleteLogowanieSQL);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteUczelnia(int id) {

		try {
			String deleteUczelniaSQL = "DELETE FROM Uczelnia WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(deleteUczelniaSQL);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteWpis(int id) {
		String deleteWpisSQL = "DELETE FROM Wpis WHERE id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(deleteWpisSQL);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Student> selectStudent() {

		try {
			List<Student> studenci = new ArrayList<>();

			String sqlSelectStudent = "SELECT * FROM Student";

			ResultSet rs = stat.executeQuery(sqlSelectStudent);

			while (rs.next()) {
				// pobieram dane z kolejnego wiersza uzyskanego za pomoca select
				int id = rs.getInt("id");
				String imie = rs.getString("imie");
				String nazwisko = rs.getString("nazwisko");
				int wiek = rs.getInt("wiek");
				String adres = rs.getString("adres");
				int rokStudiow = rs.getInt("rokStudiow");
				String email = rs.getString("email");
				String telefon = rs.getString("telefon");
				studenci.add(new Student(id, imie, nazwisko, wiek, adres, rokStudiow, email, telefon));
			}
			return studenci;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// miejscowosc, rokZalozenia, nazwaRektora, email, adres " + "(?, ?, ?, ?, ?
	public static List<Uczelnia> selectUczelnia() {

		try {
			List<Uczelnia> uczelnia = new ArrayList<>();

			String sqlSelectUczelnia = "SELECT * FROM Uczelnia";

			ResultSet rs = stat.executeQuery(sqlSelectUczelnia);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nazwa = rs.getString("nazwa");
				String miejscowosc = rs.getString("miejscowosc");
				int rokZalozenia = rs.getInt("rokZalozenia");
				String nazwaRektora = rs.getString("nazwaRektora");
				String email = rs.getString("email");
				String adres = rs.getString("adres");

				uczelnia.add(new Uczelnia(id, nazwa, miejscowosc, rokZalozenia, nazwaRektora, email, adres));
			}
			return uczelnia;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Logowanie> selectLogowanie() {

		try {
			List<Logowanie> logowanie= new ArrayList<>();

			String sqlSelectLogowanie = "SELECT * FROM Logowanie";

			ResultSet rs = stat.executeQuery(sqlSelectLogowanie);

			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("user");
				String haslo = rs.getString("haslo");
				String rola = rs.getString("rola");

				logowanie.add(new Logowanie(id, user, haslo, rola));
			}
			return logowanie;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String pobierzHaslo(String user)
	{
		try {
			String sql = "SELECT haslo FROM Logowanie WHERE user = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return rs.getString("haslo");
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static String pobierzRole(String user){
		try {
			String sql = "SELECT rola FROM Logowanie WHERE user LIKE ?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getString("rola");
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
				
				
	}

	public static List<Wpis> selectWpis() {

		try {
			List<Wpis> wpis = new ArrayList<>();
			String sqlSelectWpis = "SELECT * FROM Wpis";
			ResultSet rs = stat.executeQuery(sqlSelectWpis);
			while (rs.next()) {
				int id = rs.getInt("id");
				int idS = rs.getInt("idS");
				int idU = rs.getInt("idU");
				wpis.add(new Wpis(id, idS, idU));
			}
			return wpis;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}


	public static List<StudentUczelnia> selectInnerJoinStudentUczelnia()
	{
	
		/*
		select *
		from
    	a
        inner join
    	b
        on a.common = b.common
        inner join 
    	c
        on b.common = c.common 
		*/
		
		List<StudentUczelnia> lista = new ArrayList<>();
		try {
			String sqlInnerJoin = 
					"SELECT Wpis.id, Student.imie, Student.nazwisko, Student.wiek, Student.adres, Student.rokStudiow, Student.email, Student.telefon, "
					+ "Uczelnia.nazwa, Uczelnia.miejscowosc, Uczelnia.rokZalozenia, Uczelnia.nazwaRektora, Uczelnia.email, Uczelnia.adres FROM "
					+ "Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON Wpis.idU = Uczelnia.id";
			
			ResultSet rs = stat.executeQuery(sqlInnerJoin);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String imie = rs.getString(2);
				String nazwisko = rs.getString(3);
				int wiek = rs.getInt(4);
				String adresStudent = rs.getString(5);
				int rokStudiow = rs.getInt(6);
				String studentEmail = rs.getString(7);
				String telefon = rs.getString(8);
				String nazwa = rs.getString(9);
				String miejscowosc = rs.getString(10);
				int rokZalozenia = rs.getInt(11);
				String nazwaRektora = rs.getString(12);
				String uczelniaEmail = rs.getString(13);
				String adresUczelnia = rs.getString(14);
				
				
				lista.add(new StudentUczelnia(id,imie, nazwisko, wiek, adresUczelnia, rokStudiow, studentEmail, telefon, nazwa, miejscowosc, rokZalozenia, nazwaRektora, uczelniaEmail, adresStudent));
			}
			return lista;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	
	
	public static List<Integer> selectIdFromStudent()
	{
		try {
			List<Integer> ids = new ArrayList<>();
			String selectIdSQL = "SELECT id FROM Student";
			ResultSet rs = stat.executeQuery(selectIdSQL);
			while(rs.next())
			{
				ids.add(rs.getInt("id"));
			}
			return ids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Integer> selectIdFromUczelnia()
	{
		try {
			List<Integer> ids = new ArrayList<>();
			String selectIdSQL = "SELECT id FROM Uczelnia";
			ResultSet rs = stat.executeQuery(selectIdSQL);
			while(rs.next())
			{
				ids.add(rs.getInt("id"));
			}
			return ids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Student selectStudentById(int id)
	{
		
		PreparedStatement ps;
		try {
			String selectByIdSQL = "SELECT * FROM Student WHERE id = ?;";
			ps = conn.prepareStatement(selectByIdSQL);
			ps.setInt(1, id);
			
			//jako ze jest to select potrzebuje pobrac dane do result set
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				return new Student(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getString(7), 
						rs.getString(8)
						);
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Uczelnia selectUczelniaById (int id)
	{
		try {
			PreparedStatement ps;
			String selectByIdSQL = " SELECT * FROM Uczelnia WHERE id = ?;";
			ps = conn.prepareStatement(selectByIdSQL);
			ps.setInt(1, id);
			
		
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			return new Uczelnia(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7));
		}
		return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	/*this.id = id;
	this.imie = imie;
	this.nazwisko = nazwisko;
	this.wiek = wiek;
	this.adres = adres;
	this.rokStudiow = rokStudiow;
	this.email = email;
	this.telefon = telefon;*/
	public static Student najmlodszyStudent()
	{
		
		try {
			String sql = "select * from Student where wiek = (select min(wiek) from Student);";
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next())
			{
				return new Student(
						rs.getInt("id"),
						rs.getString("imie"),
						rs.getString("nazwisko"),
						rs.getInt("wiek"),
						rs.getString("adres"),
						rs.getInt("rokStudiow"),
						rs.getString("email"),
						rs.getString("telefon")
				);
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Student najstarszyStudent()
	{
		
		try {
			String sql = "select * from Student where wiek = (select max(wiek) from Student);";
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next())
			{
				return new Student(
						rs.getInt("id"),
						rs.getString("imie"),
						rs.getString("nazwisko"),
						rs.getInt("wiek"),
						rs.getString("adres"),
						rs.getInt("rokStudiow"),
						rs.getString("email"),
						rs.getString("telefon")
						);
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static double sredniSredniWiekStudentow(){
	
		String sql = "select avg(wiek) from Student";
		
		try {
			ResultSet rs =stat.executeQuery(sql);
			if(rs.next())
			{
				return rs.getDouble(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	/*String sql = "select avr(wiek) from Student";
	ResultSet rs = stat.executeQuery(sql);
	if(rs.next())
	{
		return rs.getDouble(1);
	}*/
/*	private int id;
	private String nazwa;
	private String miejscowosc;
	private int rokZalozenia;
	private String nazwaRektora;
	private String email;
	private String adres;*/
	public static Uczelnia najmlodszaUczelnia()
	{
		
				try {
					String sql = "select * from Uczelnia where RokZalozenia = (select max(RokZalozenia) from Uczelnia);";
					ResultSet rs = stat.executeQuery(sql);
					if(rs.next())
					{
						return new Uczelnia(
								rs.getInt("id"),
								rs.getString("nazwa"),
								rs.getString("miejscowosc"),
								rs.getInt("rokZalozenia"),
								rs.getString("nazwaRektora"),
								rs.getString("email"),
								rs.getString("adres")
								);
					}
					return null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	}
	
	public static Uczelnia najstarszaUczelnia()
	{
				try {
					String sql = "select * from Uczelnia where RokZalozenia = (select min(RokZalozenia) from Uczelnia);";
					ResultSet rs = stat.executeQuery(sql);
					if(rs.next())
					{
						return new Uczelnia(
								rs.getInt("id"),
								rs.getString("nazwa"),
								rs.getString("miejscowosc"),
								rs.getInt("rokZalozenia"),
								rs.getString("nazwaRektora"),
								rs.getString("email"),
								rs.getString("adres")
								);
					}
					return null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	}
	
	public static List<String> liczbaStudentowNaPoszczegolnychLatachStudiow()
	{
		List<String> listaStatystyka = new ArrayList<>();
		try {
			String sqlInnerJoin = 
					"SELECT Student.rokStudiow, COUNT(DISTINCT Wpis.id) FROM "
					+ "Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON Wpis.idU = Uczelnia.id "
					+ "GROUP BY Student.rokStudiow";
			
			ResultSet rs = stat.executeQuery(sqlInnerJoin);
			
			int rokS = 0;
			int iloscStudentow = 0;
			while(rs.next())
			{
				rokS = rs.getInt(1);
				iloscStudentow = rs.getInt(2);
				String s = rokS + "-" + iloscStudentow;
				listaStatystyka.add(s);
			}
			System.out.println(listaStatystyka);
			return listaStatystyka;
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	public static List<String> liczbaStudentowZPoszczegolnychWojewodztw()
	{
		List<String> listaStatystyka = new ArrayList<>();
		try {
			String sqlInnerJoin = 
					"SELECT Uczelnia.miejscowosc, COUNT(DISTINCT Wpis.id) FROM "
					+ "Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON Wpis.idU = Uczelnia.id "
					+ "GROUP BY Uczelnia.miejscowosc";
			
			ResultSet rs = stat.executeQuery(sqlInnerJoin);
			
			String miejscowosc = "";
			int iloscStudentow = 0;
			while(rs.next())
			{
				miejscowosc = rs.getString(1);
				iloscStudentow = rs.getInt(2);
				String s = miejscowosc + "-" + iloscStudentow;
				listaStatystyka.add(s);
			}
			return listaStatystyka;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public static List<String> selectImionaStudenci()
	{
		try {
			List<String> listaImionStudentow = new ArrayList<>();
			String sqlInneJoin = 
					"SELECT DISTINCT Student.imie FROM Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON Wpis.idU = Uczelnia.id ";
			ResultSet rs = stat.executeQuery(sqlInneJoin);
			while(rs.next())
			{
				listaImionStudentow.add(rs.getString(1));
			}
			return listaImionStudentow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<String> selectNazwiskoStudentow()
	{
		
		try {
			List<String> listaNazwiskoStudentow = new ArrayList<>();
			String sqlInnerJoin =
					"SELECT DISTINCT Student.nazwisko FROM Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON Wpis.idU = Uczelnia.id ";
			ResultSet rs = stat.executeQuery(sqlInnerJoin);
			while(rs.next())
			{
				listaNazwiskoStudentow.add(rs.getString(1));
			}
			return listaNazwiskoStudentow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<String> selectMiejscowoscUczelnia()
	{
		try {
			List<String> listaMiejscowosciStudentow = new ArrayList<>();
			String sqlInnerJoin =
					"SELECT DISTINCT Uczelnia.miejscowosc FROM Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON Wpis.idU = Uczelnia.id ";
			ResultSet rs = stat.executeQuery(sqlInnerJoin);
			while(rs.next())
			{
				listaMiejscowosciStudentow.add(rs.getString(1));
			}
			return listaMiejscowosciStudentow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Integer> selectWiekStudentow()
	{
		try {
			List<Integer> listaWiekuStudentow = new ArrayList<>();
			String sqlInnerJoin = 
					"SELECT DISTINCT Student.wiek FROM Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON Wpis.idU = Uczelnia.id ";
			ResultSet rs = stat.executeQuery(sqlInnerJoin);
			while(rs.next())
			{
				listaWiekuStudentow.add(rs.getInt(1));
			}
			return listaWiekuStudentow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Integer> selectRokStudiow()
	{	
		try {
			List<Integer> listaRocznikowStudentow = new ArrayList<>();
			String sqlInnerJoin = 
					"SELECT DISTINCT Student.rokStudiow FROM Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON Wpis.idU = Uczelnia.id ";
			ResultSet rs = stat.executeQuery(sqlInnerJoin);
			while(rs.next())
			{
				listaRocznikowStudentow.add(rs.getInt(1));
			}
			return listaRocznikowStudentow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Integer> selectWiekStudentowWiekszyNiz(int wiek)
	{
		try {
			List<Integer> listaWiekuStudentow = new ArrayList<>();
			String sqlInnerJoin = 
					"SELECT DISTINCT Student.wiek FROM Student INNER JOIN Wpis ON "
					+ "Student.id = Wpis.idS INNER JOIN Uczelnia ON Wpis.idU = Uczelnia.id "
					+ "WHERE Student.wiek >= ?";
			PreparedStatement ps = conn.prepareStatement(sqlInnerJoin);
			ps.setInt(1,  wiek);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				listaWiekuStudentow.add(rs.getInt(1));
			}
			return listaWiekuStudentow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Integer> selectWiekStudentowMniejszyNiz(int wiek)
	{
		try {
			List<Integer> listaWiekuStudentow = new ArrayList<>();
			String sqlInnerJoin = 
					"SELECT DISTINCT Student.wiek FROM Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON "
					+ "Wpis.idU = Uczelnia.id  WHERE Student.wiek <= ?";
			PreparedStatement ps = conn.prepareStatement(sqlInnerJoin);
			ps.setInt(1,  wiek);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				listaWiekuStudentow.add(rs.getInt(1));
			}
			return listaWiekuStudentow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Integer> selectRokStudiowStudentowMniejszyNiz(int rokStudiow)
	{
		try {
			List<Integer> listaWiekuStudentow = new ArrayList<>();
			String sqlInnerJoin = 
					"SELECT DISTINCT Student.rokStudiow FROM Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON "
					+ "Wpis.idU = Uczelnia.id  WHERE Student.rokStudiow <= ?";
			PreparedStatement ps = conn.prepareStatement(sqlInnerJoin);
			ps.setInt(1,  rokStudiow);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				listaWiekuStudentow.add(rs.getInt(1));
			}
			return listaWiekuStudentow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Integer> selectRokStudiowStudentowWiekszyNiz(int rokStudiow)
	{
		try {
			List<Integer> listaWiekuStudentow = new ArrayList<>();
			String sqlInnerJoin = 
					"SELECT DISTINCT Student.rokStudiow FROM Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON "
					+ "Wpis.idU = Uczelnia.id  WHERE Student.rokStudiow >= ?";
			PreparedStatement ps = conn.prepareStatement(sqlInnerJoin);
			ps.setInt(1,  rokStudiow);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				listaWiekuStudentow.add(rs.getInt(1));
			}
			return listaWiekuStudentow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<StudentUczelnia> filtrujStudentUczelnia(boolean isImie, boolean isNazwisko, boolean isMiejscowosc, 
			boolean isWiek, boolean isRokStudiow, List<String> imiona, List<String> nazwiska, List<String> miejscowosci, 
			int wiekOd, int wiekDo, int rokStudiowOd, int rokStudiowDo)
	{
		String imionaSql = " AND Student.imie IN ('" + String.join("','", imiona) + "') ";
		String nazwiskaSql = " AND Student.nazwisko IN ('" + String.join("','", nazwiska) + "') ";
		String miejscowosciSql = " AND Uczelnia.miejscowosc IN ('" + String.join("','", miejscowosci) + "') ";
		String wiekSql = " AND Student.Wiek BETWEEN " + wiekOd + " AND " + wiekDo + " ";
		String rokStudiowSql = " AND Student.rokStudiow BETWEEN " + rokStudiowOd + " AND " + rokStudiowDo + " ";
		
		String sqlInnerJoin = 
				"SELECT Wpis.id, Student.imie, Student.nazwisko, Student.wiek, Student.adres, Student.rokStudiow, Student.email, "
				+ "Student.telefon, "
				+ "Uczelnia.nazwa, Uczelnia.miejscowosc, Uczelnia.rokZalozenia, Uczelnia.nazwaRektora, Uczelnia.email, Uczelnia.adres "
				+ "FROM Student INNER JOIN Wpis ON Student.id = Wpis.idS INNER JOIN Uczelnia ON "
				+ "Wpis.idU = Uczelnia.id WHERE 1 = 1";
		
		if(isImie)
		{
			sqlInnerJoin += imionaSql;
		}
		if (isNazwisko)
		{
			sqlInnerJoin += nazwiskaSql;
		}
		if (isMiejscowosc)
		{
			sqlInnerJoin += miejscowosciSql;
		}
		if (isWiek)
		{
			sqlInnerJoin += wiekSql;
		}
		if (isRokStudiow)
		{
			sqlInnerJoin += rokStudiowSql;
		}
		
		sqlInnerJoin += ";";
		
		System.out.println(sqlInnerJoin);
		
		List<StudentUczelnia> lista = new ArrayList<>();
		
		ResultSet rs;
		try {
			rs = stat.executeQuery(sqlInnerJoin);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String imie = rs.getString(2);
				String nazwisko = rs.getString(3);
				int wiek = rs.getInt(4);
				String adresStudent = rs.getString(5);
				int rokStudiow = rs.getInt(6);
				String studentEmail = rs.getString(7);
				String telefon = rs.getString(8);
				String nazwa = rs.getString(9);
				String miejscowosc = rs.getString(10);
				int rokZalozenia = rs.getInt(11);
				String nazwaRektora = rs.getString(12);
				String uczelniaEmail = rs.getString(13);
				String adresUczelnia = rs.getString(14);
				
				
				lista.add(new StudentUczelnia(id,imie, nazwisko, wiek, adresUczelnia, rokStudiow, studentEmail, telefon, nazwa, miejscowosc, rokZalozenia, nazwaRektora, uczelniaEmail, adresStudent));
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
}
