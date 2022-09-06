// game
package com.gri.JavaExam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="games")

public class Game {

		// -------------------- PRIMARY KEY ---------------------------------------------
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		// -------------------- DATA CREATION TRACKERS -------------------------------------
		@Column(updatable=false)
		private Date createdAt;
		private Date updatedAt;

		// -------------------- MEMBER VARIABLES ---------------------------------------------
		@NotEmpty(message="Title is required! Must be min 2 characters!")
		@Size(min=1, max=100) // if you don't put max it will show huge ugly number in error message
		private String name; // need validations
		
		@NotEmpty(message="Genre is required! Must be min 2 chracters!")
		@Size(min=2, max=80) // max 80 is because our table-cell is big enough only for this amount
		private String genre;
		
		@NotEmpty(message="Description is required! Must have min 10 characters!")
		@Size(min=10, max=10000)
		private String description;
		
		private Integer rating;
		
		// -------------------- RELATIONSHIPS ---------------------------------------------
		@ManyToOne(fetch=FetchType.LAZY) // many games to one user
		@JoinColumn(name="user_id") // it's a foreign key! singular name of the table users
		private User creator; // this must correspond to mappedBy=creator on User.java

		// -------------------- CONSTRUCTORS ---------------------------------------------
		public Game () {}

		// -------------------- DATA CREATION EVENT ---------------------------------------------
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
		
		// -------------------- GETTERS / Setters ---------------------------------------------

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getRating() {
			return rating;
		}

		public void setRating(Integer rating) {
			this.rating = rating;
		}

		public User getCreator() {
			return creator;
		}

		public void setCreator(User creator) {
			this.creator = creator;
		}
}
		
