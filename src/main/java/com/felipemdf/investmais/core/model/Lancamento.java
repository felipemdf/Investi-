package com.felipemdf.investmais.core.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.felipemdf.investmais.core.model.enums.FormaTitulo;
import com.felipemdf.investmais.core.model.enums.Indexador;
import com.felipemdf.investmais.core.model.enums.TipoAtivo;
import com.felipemdf.investmais.core.model.enums.TipoLancamento;
import com.felipemdf.investmais.core.model.enums.TipoTitulo;

@Entity
public class Lancamento extends EntidadeBase{

	@ManyToOne
    @JoinColumn(name = "ativo_id", nullable = false)
    private Ativo ativo;
	
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipoLancamento;
	
	private LocalDate dataCompra;
	
	private BigDecimal precoUnitario;
	
	private BigDecimal quantidade;
	
	private BigDecimal taxaCorretagem;
	
	private BigDecimal taxaEmolumento;
	
	private BigDecimal taxaImposto;
	
	private BigDecimal valorTotal;
	
}
