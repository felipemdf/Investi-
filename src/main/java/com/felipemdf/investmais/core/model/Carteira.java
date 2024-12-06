package com.felipemdf.investmais.core.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Carteira extends EntidadeBase{
	String nome;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "carteira_id")
    private Set<Balanceamento> balanceamentos;
	
    @OneToMany(mappedBy = "carteiraId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Ativo> ativos;
}
