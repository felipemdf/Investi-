package com.felipemdf.investmais.service.lancamento.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.felipemdf.investmais.enums.TipoLancamento;

public class LancamentoBean {
	private Long id;
	private Long id_ativo;
	private LocalDate data_lancamento;
	private TipoLancamento tipo_lancamento;
	private BigDecimal quantidade;
	private BigDecimal preco_unitario;
	private BigDecimal taxa_corretagem;
	private BigDecimal taxa_emolumento;
	private BigDecimal taxa_imposto;
	private BigDecimal outras_taxas;
	private BigDecimal valor_total;
	

	public LancamentoBean(Long id, Long id_ativo, LocalDate data_lancamento, TipoLancamento tipo_lancamento, BigDecimal quantidade, BigDecimal preco_unitario, BigDecimal taxa_corretagem, BigDecimal taxa_emolumento, BigDecimal taxa_imposto, BigDecimal outras_taxas, BigDecimal valor_total) {
		this.id = id;
		this.id_ativo = id_ativo;
		this.data_lancamento = data_lancamento;
		this.tipo_lancamento = tipo_lancamento;
		this.quantidade = quantidade;
		this.preco_unitario = preco_unitario;
		this.taxa_corretagem = taxa_corretagem;
		this.taxa_emolumento = taxa_emolumento;
		this.taxa_imposto = taxa_imposto;
		this.outras_taxas = outras_taxas;
		this.valor_total = valor_total;
	}
	public Long getId() {
		return id;
	}
	public Long getId_ativo() {
		return id_ativo;
	}
	public LocalDate getData_lancamento() {
		return data_lancamento;
	}
	public TipoLancamento getTipo_lancamento() {
		return tipo_lancamento;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public BigDecimal getPreco_unitario() {
		return preco_unitario;
	}
	public BigDecimal getTaxa_corretagem() {
		return taxa_corretagem;
	}
	public BigDecimal getTaxa_emolumento() {
		return taxa_emolumento;
	}
	public BigDecimal getTaxa_imposto() {
		return taxa_imposto;
	}
	public BigDecimal getOutras_taxas() {
		return outras_taxas;
	}
	public BigDecimal getValor_total() {
		return valor_total;
	}
	
}

