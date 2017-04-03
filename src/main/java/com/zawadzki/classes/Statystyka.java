package com.zawadzki.classes;
//K-M Programs
//http://km-programs.pl/
public class Statystyka {
	private String najstarszyStudent;
	private String najmlodszyStudent;
	private String najstarszaUczelnia;
	private String najmlodszaUczelnia;
	private double sredniWiekStudentow;
	private int iloscStudentowNaPoszczegolnychRocznikach;
	private int iloscStudentowWPoszczegolnychWojewodztwach;
	public String getNajstarszyStudent() {
		return najstarszyStudent;
	}
	public void setNajstarszyStudent(String najstarszyStudent) {
		this.najstarszyStudent = najstarszyStudent;
	}
	public String getNajmlodszyStudent() {
		return najmlodszyStudent;
	}
	public void setNajmlodszyStudent(String najmlodszyStudent) {
		this.najmlodszyStudent = najmlodszyStudent;
	}
	public String getNajstarszaUczelnia() {
		return najstarszaUczelnia;
	}
	public void setNajstarszaUczelnia(String najstarszaUczelnia) {
		this.najstarszaUczelnia = najstarszaUczelnia;
	}
	public String getNajmlodszaUczelnia() {
		return najmlodszaUczelnia;
	}
	public void setNajmlodszaUczelnia(String najmlodszaUczelnia) {
		this.najmlodszaUczelnia = najmlodszaUczelnia;
	}
	public double getSredniWiekStudentow() {
		return sredniWiekStudentow;
	}
	public void setSredniWiekStudentow(double sredniWiekStudentow) {
		this.sredniWiekStudentow = sredniWiekStudentow;
	}
	public int getIloscStudentowNaPoszczegolnychRocznikach() {
		return iloscStudentowNaPoszczegolnychRocznikach;
	}
	public void setIloscStudentowNaPoszczegolnychRocznikach(int iloscStudentowNaPoszczegolnychRocznikach) {
		this.iloscStudentowNaPoszczegolnychRocznikach = iloscStudentowNaPoszczegolnychRocznikach;
	}
	public int getIloscStudentowWPoszczegolnychWojewodztwach() {
		return iloscStudentowWPoszczegolnychWojewodztwach;
	}
	public void setIloscStudentowWPoszczegolnychWojewodztwach(int iloscStudentowWPoszczegolnychWojewodztwach) {
		this.iloscStudentowWPoszczegolnychWojewodztwach = iloscStudentowWPoszczegolnychWojewodztwach;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iloscStudentowNaPoszczegolnychRocznikach;
		result = prime * result + iloscStudentowWPoszczegolnychWojewodztwach;
		result = prime * result + ((najmlodszaUczelnia == null) ? 0 : najmlodszaUczelnia.hashCode());
		result = prime * result + ((najmlodszyStudent == null) ? 0 : najmlodszyStudent.hashCode());
		result = prime * result + ((najstarszaUczelnia == null) ? 0 : najstarszaUczelnia.hashCode());
		result = prime * result + ((najstarszyStudent == null) ? 0 : najstarszyStudent.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sredniWiekStudentow);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Statystyka other = (Statystyka) obj;
		if (iloscStudentowNaPoszczegolnychRocznikach != other.iloscStudentowNaPoszczegolnychRocznikach)
			return false;
		if (iloscStudentowWPoszczegolnychWojewodztwach != other.iloscStudentowWPoszczegolnychWojewodztwach)
			return false;
		if (najmlodszaUczelnia == null) {
			if (other.najmlodszaUczelnia != null)
				return false;
		} else if (!najmlodszaUczelnia.equals(other.najmlodszaUczelnia))
			return false;
		if (najmlodszyStudent == null) {
			if (other.najmlodszyStudent != null)
				return false;
		} else if (!najmlodszyStudent.equals(other.najmlodszyStudent))
			return false;
		if (najstarszaUczelnia == null) {
			if (other.najstarszaUczelnia != null)
				return false;
		} else if (!najstarszaUczelnia.equals(other.najstarszaUczelnia))
			return false;
		if (najstarszyStudent == null) {
			if (other.najstarszyStudent != null)
				return false;
		} else if (!najstarszyStudent.equals(other.najstarszyStudent))
			return false;
		if (Double.doubleToLongBits(sredniWiekStudentow) != Double.doubleToLongBits(other.sredniWiekStudentow))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Statystyka [najstarszyStudent=" + najstarszyStudent + ", najmlodszyStudent=" + najmlodszyStudent
				+ ", najstarszaUczelnia=" + najstarszaUczelnia + ", najmlodszaUczelnia=" + najmlodszaUczelnia
				+ ", sredniWiekStudentow=" + sredniWiekStudentow + ", iloscStudentowNaPoszczegolnychRocznikach="
				+ iloscStudentowNaPoszczegolnychRocznikach + ", iloscStudentowWPoszczegolnychWojewodztwach="
				+ iloscStudentowWPoszczegolnychWojewodztwach + ", toString()=" + super.toString() + "]";
	}
	public Statystyka(String najstarszyStudent, String najmlodszyStudent, String najstarszaUczelnia,
			String najmlodszaUczelnia, double sredniWiekStudentow, int iloscStudentowNaPoszczegolnychRocznikach,
			int iloscStudentowWPoszczegolnychWojewodztwach) {
		super();
		this.najstarszyStudent = najstarszyStudent;
		this.najmlodszyStudent = najmlodszyStudent;
		this.najstarszaUczelnia = najstarszaUczelnia;
		this.najmlodszaUczelnia = najmlodszaUczelnia;
		this.sredniWiekStudentow = sredniWiekStudentow;
		this.iloscStudentowNaPoszczegolnychRocznikach = iloscStudentowNaPoszczegolnychRocznikach;
		this.iloscStudentowWPoszczegolnychWojewodztwach = iloscStudentowWPoszczegolnychWojewodztwach;
	}
	
	public Statystyka()
	{
		
	}
	
	

}
