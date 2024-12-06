package com.felipemdf.investmais.core.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.felipemdf.investmais.core.model.enums.FormaTitulo;
import com.felipemdf.investmais.core.model.enums.Indexador;
import com.felipemdf.investmais.core.model.enums.TipoAtivo;
import com.felipemdf.investmais.core.model.enums.TipoTitulo;

@Entity
public class Ativo extends EntidadeBase{

	private Long carteiraId;
	
	@OneToMany(mappedBy = "ativo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Lancamento> lancamentos;
	
	@Enumerated(EnumType.STRING)
	private TipoAtivo tipoAtivo;
	
	@Enumerated(EnumType.STRING)
	private TipoTitulo tipoTitulo;
	
	@Enumerated(EnumType.STRING)
	private FormaTitulo formaTitulo; 
	
	private Indexador indexadorTitulo;
	
	private String emissor;
	
	private LocalDate dataVencimento;
	
}
