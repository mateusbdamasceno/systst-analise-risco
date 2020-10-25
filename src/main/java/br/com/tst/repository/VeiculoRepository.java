package br.com.tst.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tst.db.ConnectionFactory;
import br.com.tst.domain.Veiculo;

@Component
public class VeiculoRepository{
	
	ConnectionFactory con;
	
	@Autowired 
	private VeiculoTable table;
	
	public Veiculo save ( Veiculo veiculo ) {
		VeiculoTable.getInstance().getRecords().add( veiculo );
		int i = VeiculoTable.getInstance().getRecords().indexOf( veiculo );
		Long id = Long.parseLong( String.valueOf( i ) );
		veiculo.setId(id);
		return veiculo; 
		
	}

	public void delete ( Veiculo veiculo ) {
		PreparedStatement comando = null;
		try {
			String sql = "DELETE FROM  veiculos WHERE id= ?";
			comando = con.createConnectonDb().prepareStatement(sql);
			comando.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public Veiculo update( Veiculo veiculo ) {
		PreparedStatement comando = null;
		
		try {
			String sql = "update veiculos set marca=?, modelo=?,ano=?,valor=?,risco?";
			comando = con.createConnectonDb().prepareStatement(sql);
			comando.setString(1, veiculo.getMarca());
			comando.setString(2, veiculo.getModelo());
			comando.setInt(3, veiculo.getAno());
			comando.setDouble(4, veiculo.getValor());
			comando.setInt(5, veiculo.getRisco().getCodigo());
			
			comando.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return veiculo;
	}
	
	public List<Veiculo> findAll ( ) {
		return VeiculoTable.getInstance().getRecords();
	}

	public Veiculo findById() {
		PreparedStatement comando = null;
		Veiculo veiculo = new Veiculo();
		try {
			String sql = "select * FROM  veiculos WHERE id= ?";
			comando = con.createConnectonDb().prepareStatement(sql);
			comando.execute();
			veiculo = (Veiculo) comando.getResultSet();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return veiculo;
	}
	
}
