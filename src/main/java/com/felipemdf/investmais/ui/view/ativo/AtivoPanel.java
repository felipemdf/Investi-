package com.felipemdf.investmais.ui.view.ativo;

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

public class AtivoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AtivoPanel() {
        // Define o layout para preencher todo o espaço
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10, 10, 10, 10));
       

        add(new ExpandableTableComponent(Color.BLUE));  
        add(Box.createVerticalStrut(10));
        add(new ExpandableTableComponent(Color.YELLOW)); 
        add(Box.createVerticalStrut(10));
        add(new ExpandableTableComponent(Color.GREEN));
        add(Box.createVerticalStrut(10));
       
        
	}

}
