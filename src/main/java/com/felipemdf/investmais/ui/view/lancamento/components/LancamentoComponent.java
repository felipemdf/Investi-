package com.felipemdf.investmais.ui.view.lancamento.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.felipemdf.investmais.ui.view.lancamento.dialog.CadastroLancamentoDialog;

public class LancamentoComponent extends JPanel {

    public LancamentoComponent(String titulo, Object[][] dados, String[] colunas) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Para destacar o painel

        // Header: Título e Botão de ação
        JPanel headerPanel = criarHeader(titulo);
        add(headerPanel, BorderLayout.NORTH);

        // Tabela de dados
        JTable table = criarTabela(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 180));
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel criarHeader(String titulo) {
    	JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(new EmptyBorder(20, 10, 10, 10)); // Margens internas

        // Título
        JLabel titleLabel = new JLabel(titulo.toUpperCase());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.BLACK);

        // Painel para os campos de pesquisa e botão
        JPanel searchAndButtonPanel = new JPanel(new GridBagLayout()); // Centralização vertical
        searchAndButtonPanel.setBackground(Color.WHITE);
        searchAndButtonPanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // Espaçamento entre título e campos

        // Configuração para alinhamento e espaçamento
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0); // Espaçamento horizontal entre os elementos

        // Campo de pesquisa à esquerda
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(250, 25)); // Tamanho adequado
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        searchField.setToolTipText("Pesquisar...");
        gbc.gridx = 0; // Primeira coluna
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        searchAndButtonPanel.add(searchField, gbc);

        // Botão à direita
        JButton actionButton = new JButton("Incluir Lançamento");
        actionButton.setFont(new Font("Arial", Font.PLAIN, 14));
        actionButton.setPreferredSize(new Dimension(180, 30)); // Botão maior
        actionButton.setBackground(Color.WHITE);
        actionButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        actionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbc.gridx = 1; // Segunda coluna
        gbc.anchor = GridBagConstraints.EAST; // Alinha à direita
        
        // Adicionar ação ao botão
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroLancamentoDialog lancamentoDialog = new CadastroLancamentoDialog((Frame) SwingUtilities.getWindowAncestor(LancamentoComponent.this));
                lancamentoDialog.setVisible(true);
            }
        });
        searchAndButtonPanel.add(actionButton, gbc);

        // Adiciona o título no topo e os campos de pesquisa/botão na parte inferior
        headerPanel.add(titleLabel, BorderLayout.NORTH);
        headerPanel.add(searchAndButtonPanel, BorderLayout.SOUTH);

        return headerPanel;
    }

    private JTable criarTabela(Object[][] dados, String[] colunas) {
        DefaultTableModel tableModel = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Torna as células não editáveis
            }
        };

        JTable table = new JTable(tableModel);

        return table;
    }
}
