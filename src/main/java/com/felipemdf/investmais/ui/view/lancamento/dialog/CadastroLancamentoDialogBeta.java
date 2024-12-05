package com.felipemdf.investmais.ui.view.lancamento.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroLancamentoDialogBeta extends JDialog {

    private JPanel mainPanel;
    private JComboBox<String> categoriaComboBox;
    private JPanel defaultFormPanel;
    private JPanel rendaFixaFormPanel;
    private JPanel bottomPanel;

   
    public CadastroLancamentoDialogBeta(Frame parent) {
        super(parent, "Adicionar Lançamento", true);

        setSize(500, 580); 
        setLocationRelativeTo(parent); 
        setResizable(false); 

        // Painel principal usando BorderLayout
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        categoriaComboBox = new JComboBox<>(new String[]{"Ações", "CDB / LCI / LCA / LC / RDB"});
        categoriaComboBox.addActionListener(new CategoriaActionListener());
        categoriaComboBox.setPreferredSize(new Dimension(200, 25));
        
        // Painel superior para a ComboBox
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(categoriaComboBox);

        // Criação dos painéis de formulário
        defaultFormPanel = createDefaultFormPanel();
        rendaFixaFormPanel = createRendaFixaFormPanel();
        
        // Painel para o Total e Botões
        bottomPanel = createBottomPanel();

        // Adicionar os painéis ao BorderLayout
        mainPanel.add(topPanel, BorderLayout.NORTH); // ComboBox no topo
        mainPanel.add(defaultFormPanel, BorderLayout.CENTER); // Painel de formulário no centro
        mainPanel.add(bottomPanel, BorderLayout.SOUTH); // Botões no final
        
        add(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

	private JPanel createDefaultFormPanel() {
		int fieldHeight = 25; 

	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout(0, 0)); 
	    panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	   
	    JPanel formPanel = new JPanel();
	    formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS)); 

	    formPanel.add(createLabelAndField("Ativo:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Corretora/Banco:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Data:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Quantidade:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Preço Unitário:", Integer.MAX_VALUE, fieldHeight));
	    
	    formPanel.add(createLabelAndField("Corretagem:", Integer.MAX_VALUE, fieldHeight));   
	    formPanel.add(createLabelAndField("Emolumentos:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Impostos:", Integer.MAX_VALUE, fieldHeight));
	    
	    panel.add(formPanel, BorderLayout.NORTH);

	    return panel;
	}


	private JPanel createRendaFixaFormPanel() {
		int fieldHeight = 25; 

	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout(0, 0)); 
	    panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	   
	    JPanel formPanel = new JPanel();
	    formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS)); 

	    formPanel.add(createLabelAndField("Ativo:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Corretora/Banco:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Data:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Emissor:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createComboBoxField("Tipo de Título:", new String[]{"CDB", "LCI", "LCA", "LC", "RDB"}));
	    formPanel.add(createComboBoxField("Indexador:", new String[]{"CDI", "IPCA", "Prefixado"}));
	    formPanel.add(createLabelAndField("Data de Vencimento:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Quantidade:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Preço Unitário:", Integer.MAX_VALUE, fieldHeight));
	    
	    formPanel.add(createLabelAndField("Corretagem:", Integer.MAX_VALUE, fieldHeight));   
	    formPanel.add(createLabelAndField("Emolumentos:", Integer.MAX_VALUE, fieldHeight));
	    formPanel.add(createLabelAndField("Impostos:", Integer.MAX_VALUE, fieldHeight));
	    
	    panel.add(formPanel, BorderLayout.NORTH);

	    return panel;
	}


	
	// Método para criar o painel inferior com o Total e Botões
	private JPanel createBottomPanel() {
	    JPanel bottomPanel = new JPanel();
	    bottomPanel.setLayout(new BorderLayout());
	
	    JLabel totalLabel = new JLabel("TOTAL: R$ 0,00");
	    totalLabel.setFont(new Font("Arial", Font.BOLD, 14));

	    JPanel buttonsPanel = new JPanel();
	    JButton btnSalvar = new JButton("Salvar");
	    JButton btnCancelar = new JButton("Cancelar");
	    btnCancelar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	        }
	    });
	    buttonsPanel.add(btnSalvar);
	    buttonsPanel.add(btnCancelar);
	

	    bottomPanel.add(totalLabel, BorderLayout.NORTH);
	    bottomPanel.add(buttonsPanel, BorderLayout.CENTER);
	
	    return bottomPanel;
	}

	
	private JPanel createLabelAndField(String labelText, int fieldWidth, int fieldHeight) {
		 JPanel panel = new JPanel();
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		 // Cria a label e a define alinhada à esquerda
		 JLabel label = new JLabel(labelText);
		 label.setAlignmentX(Component.LEFT_ALIGNMENT);  // Alinha a label à esquerda
		
		 // Cria o JTextField e o define alinhado à esquerda
		 JTextField textField = new JTextField();
		 textField.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
		 textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, fieldHeight)); // Para garantir que ocupe toda a largura
		 textField.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinha o campo de texto à esquerda
		
		 // Adiciona a label e o text field ao painel
		 panel.add(label);
		 panel.add(textField);
		 panel.add(Box.createVerticalStrut(10));
		
		 return panel;
	}


	private JPanel createComboBoxField(String labelText, String[] options) {
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	    JLabel label = new JLabel(labelText);
	    label.setAlignmentX(Component.LEFT_ALIGNMENT);

	    JComboBox<String> comboBox = new JComboBox<>(options);
	    comboBox.setPreferredSize(new Dimension(Integer.MAX_VALUE, 25));
	    comboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
	    comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);

	    panel.add(label);
	    panel.add(comboBox);
	    panel.add(Box.createVerticalStrut(10));

	    return panel;
	}
	
    private class CategoriaActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.remove(defaultFormPanel);
            mainPanel.remove(rendaFixaFormPanel);
            mainPanel.remove(bottomPanel);

            if (categoriaComboBox.getSelectedItem().equals("Ações")) {
                mainPanel.add(defaultFormPanel, BorderLayout.CENTER);
                mainPanel.add(bottomPanel, BorderLayout.SOUTH);
                setSize(500, 580); 
            } else {
                mainPanel.add(rendaFixaFormPanel, BorderLayout.CENTER);
                mainPanel.add(bottomPanel, BorderLayout.SOUTH);
                setSize(500, 780);
            }

            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }
    
    
}
