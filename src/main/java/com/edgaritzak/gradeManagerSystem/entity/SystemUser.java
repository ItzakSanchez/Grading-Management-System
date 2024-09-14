package com.edgaritzak.gradeManagerSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = {"student", "teacher"})
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TBL_SYSTEM_USER")
public class SystemUser {

	@Id
	@Column(name="ID")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="ROLE")
	private String role;
	
	//Relationships
	@OneToOne(mappedBy = "systemUser")
    private Student student;
	
	@OneToOne(mappedBy = "systemUser")
    private Teacher teacher;

	@OneToOne(mappedBy = "systemUser")
    private Admin admin;
}
