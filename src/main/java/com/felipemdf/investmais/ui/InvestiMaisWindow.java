package com.felipemdf.investmais.ui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import com.felipemdf.investmais.ui.view.ativo.AtivoPanel;
import com.felipemdf.investmais.ui.view.ativo.components.ExpandableTableComponent;
import com.felipemdf.investmais.ui.view.configuracao.ConfiguracaoPanel;
import com.felipemdf.investmais.ui.view.lancamento.LancamentoPanel;

public class InvestiMaisWindow extends JFrame {

	
	private static final Integer WINDOW_WIDTH = 1024;
	private static final Integer WINDOW_HEIGHT = 576;
	
	public InvestiMaisWindow() {
		// FRAME
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setLocationRelativeTo(null);

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		
        // Painel do Header
        JPanel headerPanel = criarHeader();
        

        // Criar o JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Ativos", new JScrollPane(new AtivoPanel()));
        tabbedPane.addTab("Lançamentos", new JScrollPane(new LancamentoPanel()));
//        tabbedPane.addTab("Configurações", new JScrollPane(new ConfiguracaoPanel()));


        getContentPane().add(headerPanel);
        getContentPane().add(Box.createRigidArea(new Dimension(0, 20))); 
        getContentPane().add(tabbedPane); 
	
	}
	
	private JPanel criarHeader() {
		// Painel do Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10)); 
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        
     // Criando coluna da carteira
        headerPanel.add(criarTotalizadorHeader("NOME DA CARTEIRA", "Minha Carteira"));
        headerPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        
        // Criando as 3 colunas no cabeçalho
        headerPanel.add(criarTotalizadorHeader("VALOR APLICADO", "R$ 995,70"));
        headerPanel.add(criarTotalizadorHeader("SALDO BRUTO", "R$ 991,02"));
        headerPanel.add(criarTotalizadorHeader("VARIAÇÃO", "-0,47%"));
        
        return headerPanel;
	}
    
    private JPanel criarTotalizadorHeader(String text1, String text2) {
        JPanel columnPanel = new JPanel();
        columnPanel.setBackground(Color.WHITE);
        columnPanel.setLayout(new BoxLayout(columnPanel, BoxLayout.Y_AXIS));

        // Adicionando os JLabels ao painel
        columnPanel.add(new JLabel(text1));
        columnPanel.add(new JLabel(text2));

        return columnPanel;
    }   
}
