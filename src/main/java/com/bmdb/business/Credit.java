package com.bmdb.business;

import javax.persistence.*;

@Entity
public class Credit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//instance variables
	private int id;
	@ManyToOne
	@JoinColumn(name="ActorID")
	private Actor actor;
	@ManyToOne
	@JoinColumn(name="MovieID")
	private Movie movie;
	private String role;
	
	public Credit(int id, Actor actor, Movie movie, String role) {
		super();
		this.id = id;
		this.actor = actor;
		this.movie = movie;
		this.role = role;
	}
	
	public Credit(Actor actor, Movie movie, String role) {
		super();
		this.actor = actor;
		this.movie = movie;
		this.role = role;
	}
	
	public Credit() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the actor
	 */
	public Actor getActor() {
		return actor;
	}

	/**
	 * @param actor the actor to set
	 */
	public void setActor(Actor actor) {
		this.actor = actor;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", actor=" + actor + ", movie=" + movie + ", role=" + role + "]";
	}
	
}

