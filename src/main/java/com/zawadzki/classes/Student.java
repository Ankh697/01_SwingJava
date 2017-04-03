/*	+ "( "
				+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
				+ "imie VARCHAR(50) NOT NULL, "
				+ "nazwisko VARCHAR(50) NOT NULL, "
				+ "wiek INTEGER NOT NULL, "
				+ "adres VARCHAR(50) NOT NULL, "
				+ "rokStudiow INTEGER NOT NULL, "
				+ "email VARCHAR(50) NOT NULL, "
				+ "telefon VARCHAR(50) NOT NULL "
				+ ");";
*/
package com.zawadzki.classes;
//K-M Programs
//http://km-programs.pl/
public class Student {

	private int id;
	private String imie;
	private String nazwisko;
	private int wiek;
	private String adres;
	private int rokStudiow;
	private String email;
	private String telefon;

	public Student(int id, String imie, String nazwisko, int wiek, String adres, int rokStudiow, String email,
			String telefon) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
		this.adres = adres;
		this.rokStudiow = rokStudiow;
		this.email = email;
		this.telefon = telefon;
	}

	public Student() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getRokStudiow() {
		return rokStudiow;
	}

	public void setRokStudiow(int rokStudiow) {
		this.rokStudiow = rokStudiow;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return id + "," + imie + " ," + nazwisko + "\n" + wiek + " ," + adres + " \n" + rokStudiow + " ," + email + " ,"
				+ telefon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adres == null) ? 0 : adres.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + rokStudiow;
		result = prime * result + ((telefon == null) ? 0 : telefon.hashCode());
		result = prime * result + wiek;
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
		Student other = (Student) obj;
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
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (rokStudiow != other.rokStudiow)
			return false;
		if (telefon == null) {
			if (other.telefon != null)
				return false;
		} else if (!telefon.equals(other.telefon))
			return false;
		if (wiek != other.wiek)
			return false;
		return true;
	}

}
