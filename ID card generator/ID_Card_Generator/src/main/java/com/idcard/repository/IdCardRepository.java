package com.idcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idcard.model.Idcard;

public interface IdCardRepository extends JpaRepository<Idcard,Long> {

}
