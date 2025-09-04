package com.idcard.service;

import java.util.List;

import com.idcard.model.Idcard;

public interface IdCardService {
	Idcard saveIdcard(Idcard idcard);
	List<Idcard>getIdcards();
	Idcard getIdcardById(Long id);

}
