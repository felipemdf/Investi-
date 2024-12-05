/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.felipemdf.investmais;

import com.felipemdf.investmais.config.DatabaseConnection;
import com.felipemdf.investmais.ui.InvestiMaisWindow;
import com.felipemdf.investmais.ui.InvestiMaisWindow;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fmari_v4rpu9g
 */
public class InvestMais {

    public static void main(String[] args) {
    	try (Connection conn = DatabaseConnection.getConnection()) {

    	
    	} catch (SQLException e) {
    		System.err.println("Erro ao executar SELECT: " + e.getMessage());
    	}
        EventQueue.invokeLater(() -> {
        	try {
				InvestiMaisWindow frame = new InvestiMaisWindow();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
    }
}
