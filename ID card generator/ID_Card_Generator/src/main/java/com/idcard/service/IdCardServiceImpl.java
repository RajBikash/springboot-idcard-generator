package com.idcard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.idcard.model.Idcard;
import com.idcard.repository.IdCardRepository;

@Service
public class IdCardServiceImpl implements IdCardService {
	
	private final IdCardRepository idCardRepository;
	
	public IdCardServiceImpl(IdCardRepository idCardRepository) {
		this.idCardRepository= idCardRepository;
	}

	@Override
	public Idcard saveIdcard(Idcard idcard) {
		
		return idCardRepository.save(idcard);
	}

	@Override
	public List<Idcard> getIdcards() {
	
		return idCardRepository.findAll();
	}

	@Override
	public Idcard getIdcardById(Long id) {
		
		return idCardRepository.findById(id).orElse(null);
	}
	
}
