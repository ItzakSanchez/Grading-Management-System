package com.edgaritzak.gradeManagerSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TBL_ADMIN")
public class Admin{
	
	@Id
	@Column(name="ID")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "ID_SYSTEM_USER")
	private SystemUser systemUser;
	 
}
