package br.com.tst.web.rest;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<Veiculo> findAll() {
        return service.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo create(@RequestBody Veiculo veiculo) {
    	veiculo = service.save(veiculo);
        return veiculo;
    }
    
    @DeleteMapping
    public void delete(@RequestBody Integer id) {
    	Veiculo veiculo = service.findById(id);
    	service.delete(veiculo);
    }
    
    @PutMapping
    public void update(@RequestBody Veiculo veiculo) {
    	service.update(veiculo);
    }
    
    @GetMapping("/classificacao/{codRisco}")
    public List<Veiculo> buscaPorRisco(@PathVariable Integer codRisco) {
        return service.findByRisco(codRisco);
    }
}
