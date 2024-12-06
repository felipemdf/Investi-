package com.felipemdf.investmais.core.model;


import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

@MappedSuperclass
@Getter
public class EntidadeBase {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	 
	@CreationTimestamp
    private Instant createdAt;
	
	@UpdateTimestamp
    private Instant updatedAt;
}
