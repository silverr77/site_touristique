package com.example.demo.entities;

import java.io.Serializable;

import javax.annotation.security.DenyAll;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class comment implements Serializable{

	@Id @GeneratedValue
	private long id;
	private String email;
	private String name;
	private String contenu;
	private int ratting;
	private String date_creation;
	
	@ManyToOne
	@JsonIgnore
	private Site site;
	
	
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	public comment(String email, String name, String contenu, int ratting, String date_creation, Site site) {
		super();
		this.email = email;
		this.name = name;
		this.contenu = contenu;
		this.ratting = ratting;
		this.date_creation = date_creation;
		this.site = site;
	}
	
	public String getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	public int getRatting() {
		return ratting;
	}
	public void setRatting(int ratting) {
		this.ratting = ratting;
	}
	public comment() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
	
	
	
	
	
}
