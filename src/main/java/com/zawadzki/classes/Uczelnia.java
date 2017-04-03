/*String createUczelniaSQL = "CREATE TABLE IF NOT EXISTS Uczelnia" + "( "
					+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + "miejscowosc VARCHAR(50) NOT NULL"
					+ "rokZalozenia VARCHAR(50 NOT NULL" + "nazwaRektora VARCHAR(50) NOT NULL"
					+ "email VARCHAR(50) NOT NULL" + "adres VARCHAR(50) NOT NULL" + ")";*/
package com.zawadzki.classes;
//K-M Programs
//http://km-programs.pl/
public class Uczelnia {

	private int id;
	private String nazwa;
	private String miejscowosc;
	private int rokZalozenia;
	private String nazwaRektora;
	private String email;
	private String adres;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNazwa()
	{
		return nazwa;
	}
	
	public void setNazwa(String nazwa)
	{
		this.nazwa=nazwa;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public int getRokZalozenia() {
		return rokZalozenia;
	}

	public void setRokZalozenia(int rokZalozenia) {
		this.rokZalozenia = rokZalozenia;
	}

	public String getNazwaRektora() {
		return nazwaRektora;
	}

	public void setNazwaRektora(String nazwaRektora) {
		this.nazwaRektora = nazwaRektora;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adres == null) ? 0 : adres.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((miejscowosc == null) ? 0 : miejscowosc.hashCode());
		result = prime * result + ((nazwaRektora == null) ? 0 : nazwaRektora.hashCode());
		result = prime * result + rokZalozenia;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uczelnia other = (Uczelnia) obj;
		if (adres == null) {
			if (other.adres != null)
				return false;
		} else if (!adres.equals(other.adres))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (miejscowosc == null) {
			if (other.miejscowosc != null)
				return false;
		} else if (!miejscowosc.equals(other.miejscowosc))
			return false;
		if (nazwaRektora == null) {
			if (other.nazwaRektora != null)
				return false;
		} else if (!nazwaRektora.equals(other.nazwaRektora))
			return false;
		if (rokZalozenia != other.rokZalozenia)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + " , " + nazwa + " \n " + miejscowosc + " ," + rokZalozenia + " \n" + nazwaRektora + " ," + email + " ," + adres;
	}

	public Uczelnia() {

	}

	public Uczelnia(int id, String nazwa, String miejscowosc, int rokZalozenia, String nazwaRektora, String email, String adres) {
		super();
		this.id=id;
		this.nazwa = nazwa;
		this.miejscowosc = miejscowosc;
		this.rokZalozenia = rokZalozenia;
		this.nazwaRektora = nazwaRektora;
		this.email = email;
		this.adres = adres;
	}

}
