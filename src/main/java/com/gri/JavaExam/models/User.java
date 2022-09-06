//game
package com.gri.JavaExam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	// -------------------- PRIMARY KEY ---------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// -------------------- DATA CREATION TRACKERS -------------------------------------
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;

	// -------------------- MEMBER VARIABLES ---------------------------------------------
	@NotEmpty(message="Username is required")
	@Size(min=2, message="Username must have at least 2 characters")
	private String userName;
	
	@NotEmpty(message="Email is required")
	@Size(min=2, message="Email must have at least 2 characters")
	private String email;
	
	@NotEmpty(message="Password is required")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	private String password;
	
	@Transient // This is required to password confirmation. It means that field bellow won't be saved in database and needed only for confirmation
	@NotEmpty(message="Please confirm password")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	private String confirmPassword;
	// -------------------- RELATIONSHIPS ---------------------------------------------
	@OneToMany(mappedBy = "creator", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Game>Games;

	// -------------------- CONSTRUCTORS ---------------------------------------------
	public User () {}

	// -------------------- DATA CREATION EVENT ---------------------------------------------
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	// -------------------- GETTERS AND SETTERS ---------------------------------------------
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Game> getGames() {
		return Games;
	}

	public void setGames(List<Game> games) {
		Games = games;
	}
	
}
