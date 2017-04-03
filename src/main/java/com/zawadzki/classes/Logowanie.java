package com.zawadzki.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//K-M Programs
//http://km-programs.pl/
public class Logowanie {
	private int id;
	private String user;
	private String haslo;
	private Role role;

	public Logowanie(int id, String user, String haslo, String role) {
		super();
		this.id = id;
		this.user = user;
		this.haslo = haslo;
		setRola(role);
	}
	
	public Logowanie()
	{
		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Logowanie logowanie = (Logowanie) o;

		if (id != logowanie.id) return false;
		if (user != null ? !user.equals(logowanie.user) : logowanie.user != null) return false;
		if (haslo != null ? !haslo.equals(logowanie.haslo) : logowanie.haslo != null) return false;
		return role == logowanie.role;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (user != null ? user.hashCode() : 0);
		result = 31 * result + (haslo != null ? haslo.hashCode() : 0);
		result = 31 * result + (role != null ? role.hashCode() : 0);
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public Role getRola() {
		return role;
	}

	public void setRola(String role) {
		List<Role> roleList = new ArrayList<>(Arrays.asList(Role.values()));
		String rolesRegex = "(" + roleList
				.stream()
				.map(r -> r.toString())
				.collect(Collectors.joining("|")) + ")";
		if (role.matches(rolesRegex))
		{
			this.role = Role.valueOf(role);
		}
		else
		{
			this.role = Role.USER;
		}
	}

	@Override
	public String toString() {
		return "Logowanie [id=" + id + ", user=" + user + ", haslo=" + haslo + ", rola=" + role + "]";
	}

}
