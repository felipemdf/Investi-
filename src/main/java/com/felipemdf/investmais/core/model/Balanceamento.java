package com.felipemdf.investmais.core.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.felipemdf.investmais.core.model.enums.TipoAtivo;

@Entity
public class Balanceamento extends EntidadeBase{

	@Enumerated(EnumType.STRING)
	private TipoAtivo tipoAtivo;
	
	private BigDecimal percentual;
}
