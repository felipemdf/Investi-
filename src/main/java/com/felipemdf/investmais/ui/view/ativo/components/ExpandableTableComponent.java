package com.felipemdf.investmais.ui.view.ativo.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.extras.FlatSVGIcon;


public class ExpandableTableComponent extends JPanel {

    private boolean isExpanded = true;
    private JLabel iconLabel;
    
    private JTextField searchField;
    
    private JPanel headerPanel;
    
    private JTable table;
    private JScrollPane scrollPane;
    
    public ExpandableTableComponent(Color background) {
    	setLayout(new BorderLayout());
    	setBackground(background);
    	
    	// Campo de pesquisa à esquerda
        searchField = new JTextField(15);  
        searchField.setMaximumSize(new Dimension(200, 0));
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        searchField.setToolTipText("Pesquisar...");            
        
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.WEST); 
        
        headerPanel = criarHeaderPanel();
        

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); 
        topPanel.add(searchPanel);  
        topPanel.add(headerPanel);  

        
     // Criação da tabela com as colunas
        String[] columnNames = {"Ativo", "Quantidade", "Preço Atual", "Variação", "Saldo", "Minha Nota", "% Ideal", "Comprar?", "Opções"};
        Object[][] data = {
            {"Ação 1", "100", "R$ 50,00", "2%", "R$ 5000,00", "8", "50%", "Sim", "Editar"},
            {"Ação 2", "50", "R$ 30,00", "-1%", "R$ 1500,00", "6", "30%", "Não", "Excluir"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        scrollPane = new JScrollPane(table); 

        scrollPane.setVisible(isExpanded);
        
        add(scrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH); 
        

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                setPanelSize();
            }

            @Override
            public void componentResized(ComponentEvent e) {
                setPanelSize();
            } 
        });
        
  
    }

    private void setPanelSize() {
        int height = 0;
    	// Considerando o campo de pesquisa
        height += searchField.getPreferredSize().height;  // Altura do campo de pesquisa

        // Considerando o cabeçalho
        height += headerPanel.getPreferredSize().height;  // Altura do headerPanel

        if (isExpanded) {
            height += 200; 
        }
        
        int width = getParent() != null ? getParent().getWidth() - 20 : 1200 - 20; 

        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
    }
    
    private JPanel criarHeaderPanel() {
        // Painel principal do header com BoxLayout horizontal
        JPanel headerPanel = new JPanel();        
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS)); // Layout horizontal
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setPreferredSize(new Dimension(0, 40));
        headerPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Primeira e segunda colunas juntas
        JPanel leftGroup = new JPanel();
        leftGroup.setLayout(new BoxLayout(leftGroup, BoxLayout.X_AXIS)); 
        leftGroup.setBackground(Color.WHITE);
        leftGroup.setAlignmentY(Component.CENTER_ALIGNMENT);  

        // Configura o ícone inicial
        iconLabel = new JLabel();
        setIcon("assets/arrow_drop_up.svg");

        // Adicionando SVG e as labels
        leftGroup.add(iconLabel);
        leftGroup.add(Box.createHorizontalStrut(10)); // Espaço entre o ícone e a label
        leftGroup.add(criarLabelComValor("AÇÕES", "2 ATIVOS"));

        // Colunas intermediárias e final
        JPanel valorTotal = criarLabelComValor("VALOR TOTAL:", "R$ 403,62");
        JPanel variacao = criarLabelComValor("VARIAÇÃO:", "0,69%");
        JPanel naCarteira = criarLabelComValor("% NA CARTEIRA:", "40,48% (Meta: 40%)");

        // Adiciona os componentes ao painel principal
        headerPanel.add(leftGroup); // Grupo da esquerda
        headerPanel.add(Box.createHorizontalGlue()); // Espaço flexível entre o grupo da esquerda e as colunas
        headerPanel.add(valorTotal); // Coluna central 1
        headerPanel.add(Box.createHorizontalGlue()); // Espaço flexível entre as colunas
        headerPanel.add(variacao); // Coluna central 2
        headerPanel.add(Box.createHorizontalGlue()); // Espaço flexível entre as colunas
        headerPanel.add(naCarteira); // Última coluna
       
        // Adiciona MouseListener ao headerPanel para alternar o ícone do SVG ao clicar
        headerPanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {   
            	toggleTableVisibility();    
            	
                // Força o layout do painel para reposicionar os componentes
                revalidate();
                repaint();
                
  
            }
        });
        
        return headerPanel;
    }
    
    // Alterna a visibilidade da tabela
    private void toggleTableVisibility() {
        isExpanded = !isExpanded;
        
        String iconPath = isExpanded ? "assets/arrow_drop_up.svg" : "assets/arrow_drop_down.svg";
        setIcon(iconPath);
        
        scrollPane.setVisible(isExpanded); // Altera a visibilidade do JScrollPane (tabela)
        
        setPanelSize();
    }
    
    private void setIcon(String iconPath) {
        iconLabel.setIcon(new FlatSVGIcon(iconPath));        
    }
    
    private JPanel criarLabelComValor(String labelText, String valueText) {
        // Painel que vai conter o rótulo e o valor
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Layout horizontal
        panel.setBackground(Color.WHITE);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT); // Centraliza o conteúdo verticalmente

        // Criando o rótulo
        JLabel label = new JLabel(labelText, SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBackground(Color.WHITE);
        label.setOpaque(true);

        // Criando o valor
        JLabel value = new JLabel(valueText, SwingConstants.LEFT);
        value.setFont(new Font("Arial", Font.PLAIN, 14));
        value.setBackground(Color.WHITE);
        value.setOpaque(true);

        // Adiciona o rótulo e o valor no painel
        panel.add(label);
        panel.add(Box.createHorizontalStrut(5)); 
        panel.add(value);

        return panel;
    }
}
