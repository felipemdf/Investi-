package com.felipemdf.investmais.ui.view.lancamento.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.felipemdf.investmais.ui.utils.ContentLayout;
import com.felipemdf.investmais.ui.utils.FormBuilder;
import com.felipemdf.investmais.ui.utils.GridBagBuilder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CadastroLancamentoDialog extends JDialog {

	private JPanel mainPanel;
    private JComboBox<String> categoriaComboBox;
    private JPanel defaultFormPanel;
    private JPanel rendaFixaFormPanel;
    private JPanel bottomPanel;
    
    public CadastroLancamentoDialog(Frame parent) {
    	super(parent, "Adicionar Lançamento", true);

        setSize(450, 350); 
        setLocationRelativeTo(parent); 
        setResizable(false); 

        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 128, 0));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(212, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(129)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(152, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);
    }
}
