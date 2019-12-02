package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Picture implements Serializable{

	@Id @GeneratedValue
	private long id;
	private String emplacement;
	@ManyToOne
	@JsonIgnore
	private Site site;
	
	
	public Picture() {
		super();
	}
	public Picture(String emplacement, Site site) {
		super();
		this.emplacement = emplacement;
		this.site = site;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
	
	
	
}
