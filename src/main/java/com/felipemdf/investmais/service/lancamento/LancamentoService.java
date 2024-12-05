package com.felipemdf.investmais.service.lancamento;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.felipemdf.investmais.config.DatabaseConnection;
import com.felipemdf.investmais.enums.TipoAtivo;
import com.felipemdf.investmais.service.lancamento.bean.LancamentoBean;

public class LancamentoService {

	public void cadastrar(Component component, TipoAtivo tipoAtivo, String ativo, LocalDate data_lancamento, Double quantidade, Double preco_unitario, Double corretagem, Double emolumentos, Double impostos ) {
//		 try (Connection conn = DatabaseConnection.getConnection()) {
//			 String sql = "INSERT INTO lancamento (categoria, valor_transacao, data, quantidade, preco_unitario, ativo, corretagem, emolumentos, impostos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		        
//			 	PreparedStatement stmt = conn.prepareStatement(sql);
//			 
//			 	stmt.setString(1, tipoAtivo);
//		        stmt.setBigDecimal(3, new BigDecimal(valorTransacao)); // Use BigDecimal para valores monetários
//		        stmt.setDate(4, Date.valueOf(data)); // Converta String para java.sql.Date
//		        stmt.setInt(5, Integer.parseInt(quantidade));
//		        stmt.setBigDecimal(6, new BigDecimal(precoUnitario));
//		        stmt.setString(7, ativo);
//		        stmt.setBigDecimal(8, new BigDecimal(corretagem));
//		        stmt.setBigDecimal(9, new BigDecimal(emolumentos));
//		        stmt.setBigDecimal(10, new BigDecimal(impostos));
//		        
//		        stmt.executeUpdate();
//		        JOptionPane.showMessageDialog(component, "Lançamento cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
//		 } catch (Exception e) {
//		        JOptionPane.showMessageDialog(component, "Erro ao salvar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//		        e.printStackTrace();
//		    }
		 
	}
}
