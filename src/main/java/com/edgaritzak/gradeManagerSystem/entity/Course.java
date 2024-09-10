package com.edgaritzak.gradeManagerSystem.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TBL_COURSE")
public class Course {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="COURSE_NAME")
	private String courseName;
	@Column(name="COURSE_DESCRIPTION")
	private String description;
	
	//Relationships
	@OneToMany(mappedBy = "course")
    private List<Group> Group;
}