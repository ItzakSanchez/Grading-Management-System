package com.edgaritzak.gradeManagerSystem.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString(exclude = "inscriptionsStudents")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TBL_STUDENT")
public class Student{
	
	@Id
	@Column(name="ID")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "ID_SYSTEM_USER")
	private SystemUser systemUser;
	
	//Relationships
	@OneToMany(mappedBy = "student")
	private List<InscriptionsStudents> inscriptionsStudents;
}
