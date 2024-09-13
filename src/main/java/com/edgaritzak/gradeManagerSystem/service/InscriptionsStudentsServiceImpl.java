package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edgaritzak.gradeManagerSystem.entity.InscriptionsStudents;
import com.edgaritzak.gradeManagerSystem.repository.InscriptionsStudentsRepository;


@Service
public class InscriptionsStudentsServiceImpl implements InscriptionsStudentsService {

	InscriptionsStudentsRepository inscriptionsStudentsRepo;
	
	@Autowired
	public InscriptionsStudentsServiceImpl(InscriptionsStudentsRepository inscriptionsStudentsRepo) {
		this.inscriptionsStudentsRepo = inscriptionsStudentsRepo;
	}

	@Transactional
	@Override
	public void updateScore(int idInscription, double score) {
		inscriptionsStudentsRepo.updateScore(idInscription, score);
	}

	@Override
	public InscriptionsStudents findInscriptionsStudentsById(int id) {
		return inscriptionsStudentsRepo.findById(id).orElseThrow(()->new NoSuchElementException("No value present"));
	}

	@Override
	public List<InscriptionsStudents> findInscriptionsStudentsByGroupId(int groupId) {
		return inscriptionsStudentsRepo.findInscriptionsStudentsByGroupId(groupId);
	}
	@Override
	public List<InscriptionsStudents> findInscriptionsStudentsByStudentId(int studentId) {
		return inscriptionsStudentsRepo.findInscriptionsStudentsByStudentId(studentId);
	}
	
	public void updateScores(Map<Integer, Integer> valuesToUpdate) {
		for(Map.Entry<Integer, Integer> entry: valuesToUpdate.entrySet()) {
			Optional<InscriptionsStudents> optionalInscription = inscriptionsStudentsRepo.findById(entry.getKey());
			if(optionalInscription.isPresent()) {
				InscriptionsStudents inscription = optionalInscription.get();
				inscription.setScore(entry.getValue());
				inscriptionsStudentsRepo.save(inscription);
			}
			
		}
	}
}
