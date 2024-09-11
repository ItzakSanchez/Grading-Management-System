package com.edgaritzak.gradeManagerSystem.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "group")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TBL_COURSE")
public class Course {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="COURSE_NAME")
	private String name;
	@Column(name="COURSE_DESCRIPTION")
	private String description;
	
	//Relationships
	@OneToMany(mappedBy = "course")
    private List<Group> group;
}