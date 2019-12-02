package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Site implements Serializable{

	@Id @GeneratedValue
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String title;
	@Column(length = 3000) 
	@NotNull
	private String description;
	private double x;
	private double y;
	private float ratting;
	private String date_creation;
	
	@OneToMany(mappedBy = "site",fetch = FetchType.LAZY)
	private List<Picture> pictures;
	
	@OneToMany(mappedBy = "site",fetch = FetchType.LAZY)
	private List<comment> comments;
	
	
	
	
	public List<comment> getComments() {
		return comments;
	}

	public void setComments(List<comment> comments) {
		this.comments = comments;
	}

	public Site() {
		super();
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}

	public Site(String name, String title, String description, double x, double y, float ratting,
			String date_creation) {
		super();
		this.name = name;
		this.title = title;
		this.description = description;
		this.x = x;
		this.y = y;
		this.ratting = ratting;
		this.date_creation = date_creation;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public float getRatting() {
		return ratting;
	}

	public void setRatting(float ratting) {
		this.ratting = ratting;
	}

	

	
	
	
	
	
	
	
}
