package br.com.tst.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tst.domain.Veiculo;
import br.com.tst.enums.TipoRiscoEnum;
import br.com.tst.repository.VeiculoRepository;

@Service
@Validated
public class VeiculoService {

    @Autowired private VeiculoRepository repository;

    public List<Veiculo> findAll() {
        return (List<Veiculo>) repository.findAll();
    }

    public Veiculo save(Veiculo veiculo) {
    	classificaRisco(veiculo);
        return repository.save(veiculo);
    }
    
    public void delete(Veiculo veiculo) {
        repository.delete(veiculo);
    }
    
    public void update(Veiculo veiculo) {
        repository.update(veiculo);
    }
    
    public Veiculo findById(Integer id){
    	return repository.findById();
    } 
    
    public void classificaRisco(Veiculo veiculo){
    	if(veiculo.getAno()<2010) {
    		veiculo.setRisco(TipoRiscoEnum.RISCO_ALTO);
    	}else if(veiculo.getAno()>=2010 && veiculo.getAno()<2015){
    		veiculo.setRisco(TipoRiscoEnum.RISCO_MEDIO);
    	}else {
    		veiculo.setRisco(TipoRiscoEnum.RISCO_BAIXO);
    	}
    }
    
    public List<Veiculo> findByRisco(Integer codRisco) {
    	List<Veiculo> veiculosReturn = new ArrayList<Veiculo>();
    	
    	List<Veiculo> veiculos = findAll();
    	
    	for (Veiculo veiculo : veiculos) {
    		if(veiculo.getRisco().getCodigo()==codRisco) {
    			veiculosReturn.add(veiculo);
    		}
		}
    	
    	return veiculosReturn;
    }

}
