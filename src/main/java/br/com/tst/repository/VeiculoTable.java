package br.com.tst.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.tst.domain.Veiculo;

@Component
public final class VeiculoTable {
	
	private static VeiculoTable instance ;
	private static ArrayList<Veiculo> records; 
	
	private VeiculoTable(){
	}

	public static synchronized VeiculoTable getInstance() {
		if ( instance== null ) {
			instance = new VeiculoTable();
			instance.records = new ArrayList<>();
		}
		return instance;
	}

	public static ArrayList<Veiculo> getRecords() {
		return records;
	}



}
