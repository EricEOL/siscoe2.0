package br.com.siscoe.siscoe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String login;
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<>();
}
