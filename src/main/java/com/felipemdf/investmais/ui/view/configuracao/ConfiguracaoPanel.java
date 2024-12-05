package com.felipemdf.investmais.ui.view.configuracao;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConfiguracaoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfiguracaoPanel() {
        // Define o layout para preencher todo o espaço
        setLayout(new BorderLayout());

        // Exemplo de conteúdo
        JLabel label = new JLabel("Configuracao", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        // Adiciona o label ao centro do painel
        add(label, BorderLayout.CENTER);
	}

}
