package br.com.tst.web.rest;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tst.domain.Veiculo;
import br.com.tst.service.VeiculoService;

@RestController
@RequestMapping("/rest/veiculo")
public class VeiculoRestController {

    @Autowired private VeiculoService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Veiculo> veiculos = service.findAll();
        return ResponseEntity.ok(veiculos);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Veiculo veiculo) {
    	veiculo = service.save(veiculo);
        return ResponseEntity.ok(veiculo);
    }
    
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Integer id) {
    	Veiculo veiculo = service.findById(id);
    	service.delete(veiculo);
    	return ResponseEntity.ok("Veículo deletado com sucesso");
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Veiculo veiculo) {
    	service.update(veiculo);
    	return ResponseEntity.ok("Veículo alterado com sucesso");
    	
    }
    
    @GetMapping("/classificacao/{codRisco}")
    public ResponseEntity<?> buscaPorRisco(@PathVariable Integer codRisco) {
    	List<Veiculo> veiculos = service.findByRisco(codRisco);
    	return ResponseEntity.ok(veiculos);
    }
}
