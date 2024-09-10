package com.edgaritzak.gradeManagerSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TBL_INSCRIPTIONS")
public class InscriptionsStudents {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="ID_GROUP")
	private Group group;
	@ManyToOne
	@JoinColumn(name="ID_STUDENT")
	private Student student;
	@Column(name="SCORE")
	private int score;
}
