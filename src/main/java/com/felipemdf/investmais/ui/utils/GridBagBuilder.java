package com.felipemdf.investmais.ui.utils;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class GridBagBuilder {
    private final JPanel panel; // Painel onde os componentes serão adicionados
    private final GridBagConstraints constraints;

    public GridBagBuilder(JPanel panel) {
        this.panel = panel;
        this.panel.setLayout(new GridBagLayout());
        this.constraints = new GridBagConstraints();
        this.constraints.insets = new Insets(5, 5, 5, 5); // Margens padrão
    }

    public GridBagBuilder setGrid(int gridx, int gridy) {
        this.constraints.gridx = gridx;
        this.constraints.gridy = gridy;
        return this;
    }

    public GridBagBuilder setFill(int fill) {
        this.constraints.fill = fill;
        return this;
    }

    public GridBagBuilder setWeight(double weightx, double weighty) {
        this.constraints.weightx = weightx;
        this.constraints.weighty = weighty;
        return this;
    }

    public GridBagBuilder setInsets(Insets insets) {
        this.constraints.insets = insets;
        return this;
    }

    public GridBagBuilder setAnchor(int anchor) {
        this.constraints.anchor = anchor;
        return this;
    }

    public GridBagBuilder add(Component component) {
        this.panel.add(component, (GridBagConstraints) this.constraints.clone());
        return this;
    }
}
