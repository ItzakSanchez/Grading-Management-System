package com.edgaritzak.gradeManagerSystem.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "inscriptionsStudents")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TBL_GROUP")
public class Group {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "ID_COURSE")
	private Course course;
	@ManyToOne
	@JoinColumn(name = "ID_TEACHER")
	private Teacher teacher;
	@Column(name="GROUP_SEMESTER")
	private int semester;
	@Column(name="GROUP_YEAR")
	private int year;
	
	//Relationships
	@OneToMany(mappedBy="group")
	private List<InscriptionsStudents> inscriptionsStudents;
}
