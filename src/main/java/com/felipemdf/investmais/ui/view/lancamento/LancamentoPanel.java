	package com.felipemdf.investmais.ui.view.lancamento;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.felipemdf.investmais.ui.view.ativo.components.ExpandableTableComponent;
import com.felipemdf.investmais.ui.view.lancamento.components.LancamentoComponent;

public class LancamentoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LancamentoPanel() {
        // Define o layout para preencher todo o espaço
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10, 10, 10, 10));
       

        String[] colunas = {"TIPO DE INVESTIMENTO", "ATIVO", "TIPO DE ORDEM", "DATA DE NEGOCIAÇÃO", "QUANTIDADE", "PREÇO UNITÁRIO", "VALOR TOTAL", "FONTE", "FUNÇÕES"};
        Object[][] rendaVariavel = {
            {"Ações", "ITSA4", "Compra", "13/11/2024", "20", "R$ 10,42", "R$ 208,40", "MANUAL", "..."},
            {"Ações", "TAEE3", "Compra", "13/11/2024", "17", "R$ 11,32", "R$ 192,44", "MANUAL", "..."}
        };

        // Adicionando os painéis dinâmicos
        add(new LancamentoComponent("Renda Variável", rendaVariavel, colunas));
        add(Box.createVerticalStrut(20));
        add(new LancamentoComponent("CDB / LCI / LCA / LC / RDB", rendaVariavel, colunas));
        add(Box.createVerticalStrut(20));
        add(new LancamentoComponent("Tesouro Direto", rendaVariavel, colunas));
       
        
	}

}
