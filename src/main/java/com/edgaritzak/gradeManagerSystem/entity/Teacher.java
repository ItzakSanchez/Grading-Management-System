package com.edgaritzak.gradeManagerSystem.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString(exclude = "group")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TBL_TEACHER")
public class Teacher{
	
	@Id
	@Column(name="ID")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "ID_SYSTEM_USER")
	private SystemUser systemUser;
	 
	//Relationships
	@OneToMany(mappedBy = "teacher")
    private List<Group> group;
}
