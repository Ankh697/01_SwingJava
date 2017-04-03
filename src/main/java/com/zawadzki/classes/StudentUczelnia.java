package com.zawadzki.classes;
//K-M Programs
//http://km-programs.pl/
public class StudentUczelnia {

	private int id;
	private String imie;
	private String nazwisko;
	private int wiek;
	private String adresUczelnia;
	private int rokStudiow;
	private String studentEmail;
	private String telefon;
	private String nazwa;
	private String miejscowosc;
	private int rokZalozenia;
	private String nazwaRektora;
	private String uczelniaEmail;
	private String adresStudent;

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

	public String getAdresUczelnia() {
		return adresUczelnia;
	}

	public void setAdresUczelnia(String adresUczelnia) {
		this.adresUczelnia = adresUczelnia;
	}

	public int getRokStudiow() {
		return rokStudiow;
	}

	public void setRokStudiow(int rokStudiow) {
		this.rokStudiow = rokStudiow;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
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

	public String getUczelniaEmail() {
		return uczelniaEmail;
	}

	public void setUczelniaEmail(String uczelniaEmail) {
		this.uczelniaEmail = uczelniaEmail;
	}

	public String getAdresStudent() {
		return adresStudent;
	}

	public void setAdresStudent(String adresStudent) {
		this.adresStudent = adresStudent;
	}

	public StudentUczelnia(int id, String imie, String nazwisko, int wiek, String adresUczelnia, int rokStudiow,
			String studentEmail, String telefon, String nazwa, String miejscowosc, int rokZalozenia,
			String nazwaRektora, String uczelniaEmail, String adresStudent) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
		this.adresUczelnia = adresUczelnia;
		this.rokStudiow = rokStudiow;
		this.studentEmail = studentEmail;
		this.telefon = telefon;
		this.nazwa = nazwa;
		this.miejscowosc = miejscowosc;
		this.rokZalozenia = rokZalozenia;
		this.nazwaRektora = nazwaRektora;
		this.uczelniaEmail = uczelniaEmail;
		this.adresStudent = adresStudent;
	}

	public StudentUczelnia() {

	}

	@Override
	public String toString() {
		return "StudentUczelnia [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", wiek=" + wiek
				+ ", adresUczelnia=" + adresUczelnia + ", rokStudiow=" + rokStudiow + ", studentEmail=" + studentEmail
				+ ", telefon=" + telefon + ", nazwa=" + nazwa + ", miejscowosc=" + miejscowosc + ", rokZalozenia="
				+ rokZalozenia + ", nazwaRektora=" + nazwaRektora + ", uczelniaEmail=" + uczelniaEmail
				+ ", adresStudent=" + adresStudent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresStudent == null) ? 0 : adresStudent.hashCode());
		result = prime * result + ((adresUczelnia == null) ? 0 : adresUczelnia.hashCode());
		result = prime * result + id;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((miejscowosc == null) ? 0 : miejscowosc.hashCode());
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result + ((nazwaRektora == null) ? 0 : nazwaRektora.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + rokStudiow;
		result = prime * result + rokZalozenia;
		result = prime * result + ((studentEmail == null) ? 0 : studentEmail.hashCode());
		result = prime * result + ((telefon == null) ? 0 : telefon.hashCode());
		result = prime * result + ((uczelniaEmail == null) ? 0 : uczelniaEmail.hashCode());
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
		StudentUczelnia other = (StudentUczelnia) obj;
		if (adresStudent == null) {
			if (other.adresStudent != null)
				return false;
		} else if (!adresStudent.equals(other.adresStudent))
			return false;
		if (adresUczelnia == null) {
			if (other.adresUczelnia != null)
				return false;
		} else if (!adresUczelnia.equals(other.adresUczelnia))
			return false;
		if (id != other.id)
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (miejscowosc == null) {
			if (other.miejscowosc != null)
				return false;
		} else if (!miejscowosc.equals(other.miejscowosc))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		if (nazwaRektora == null) {
			if (other.nazwaRektora != null)
				return false;
		} else if (!nazwaRektora.equals(other.nazwaRektora))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (rokStudiow != other.rokStudiow)
			return false;
		if (rokZalozenia != other.rokZalozenia)
			return false;
		if (studentEmail == null) {
			if (other.studentEmail != null)
				return false;
		} else if (!studentEmail.equals(other.studentEmail))
			return false;
		if (telefon == null) {
			if (other.telefon != null)
				return false;
		} else if (!telefon.equals(other.telefon))
			return false;
		if (uczelniaEmail == null) {
			if (other.uczelniaEmail != null)
				return false;
		} else if (!uczelniaEmail.equals(other.uczelniaEmail))
			return false;
		if (wiek != other.wiek)
			return false;
		return true;
	}
	
	

}
