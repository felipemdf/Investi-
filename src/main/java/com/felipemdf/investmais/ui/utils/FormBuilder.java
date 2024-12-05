package com.felipemdf.investmais.ui.utils;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormBuilder extends JDialog {
    protected JPanel formPanel;
    protected JPanel buttonPanel;

    public FormBuilder(Frame parent) {
        super(parent, "Adicionar Transação", true);  // JDialog modal
        setSize(400, 300);  // Tamanho fixo
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);  // Centraliza o diálogo

        // Painel principal para os campos
        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margens internas
        add(formPanel, BorderLayout.CENTER);

        // Painel para os botões
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(buttonPanel, BorderLayout.SOUTH);

        // Impedir redimensionamento
        setResizable(false);
    }
    
 // Método para adicionar uma combo box
    public void addComboBox(String labelText, String[] options, int row) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 0, 5, 0);

        // Adicionar label
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.WEST;
        JLabel label = new JLabel(labelText);
        formPanel.add(label, constraints);

        // Adicionar combo box
        constraints.gridy = row + 1;
        JComboBox<String> comboBox = new JComboBox<>(options);
        formPanel.add(comboBox, constraints);
    }
    
 // Método para adicionar um toggle (checkbox)
    public void addToggle(String labelText, int row) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 0, 5, 0);

        // Adicionar checkbox
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.WEST;
        JCheckBox checkBox = new JCheckBox(labelText);
        formPanel.add(checkBox, constraints);
    }

    // Método para adicionar um campo com rótulo acima
    public void addInput(String labelText, int row) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 0, 5, 0); // Espaçamento interno

        // Adicionar label
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = 2; // Ocupa duas colunas
        constraints.anchor = GridBagConstraints.WEST; // Alinhado à esquerda
        JLabel label = new JLabel(labelText);
        formPanel.add(label, constraints);

        // Adicionar campo de texto
        constraints.gridy = row + 1;
        JTextField textField = new JTextField(20);
        formPanel.add(textField, constraints);
    }

    // Método para adicionar dois campos na mesma linha
    public void addTwoInputs(String labelText1, String labelText2, int row) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 0, 5, 5); // Espaçamento interno

        // Campo 1
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.anchor = GridBagConstraints.WEST; // Alinhado à esquerda
        JLabel label1 = new JLabel(labelText1);
        formPanel.add(label1, constraints);

        constraints.gridx = 0;
        constraints.gridy = row + 1;
        JTextField textField1 = new JTextField(10);
        formPanel.add(textField1, constraints);

        // Campo 2
        constraints.gridx = 1;
        constraints.gridy = row;
        JLabel label2 = new JLabel(labelText2);
        formPanel.add(label2, constraints);

        constraints.gridx = 1;
        constraints.gridy = row + 1;
        JTextField textField2 = new JTextField(10);
        formPanel.add(textField2, constraints);
    }

    // Método para adicionar os botões Salvar e Cancelar
    public void addButtons(ActionListener saveAction, ActionListener cancelAction) {
        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(saveAction);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(cancelAction);

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
    }

    // Exibir o formulário
    public void displayForm() {
        setVisible(true);
    }
}