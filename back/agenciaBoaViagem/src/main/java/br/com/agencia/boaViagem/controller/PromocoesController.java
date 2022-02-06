package br.com.agencia.boaViagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.agencia.boaViagem.model.Promocoes;
import br.com.agencia.boaViagem.service.PromocoesService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/promocoes")
public class PromocoesController {

    @Autowired
    private PromocoesService promocoesService;

    @GetMapping("/getAll")
    public List<Promocoes> list(){
        return promocoesService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Promocoes promocoes){
        promocoesService.save(promocoes);
        return "New Promocoes Added";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocoes> get(@PathVariable Integer id) {
        try {
            Promocoes promocoes = promocoesService.get(id);
            return new ResponseEntity<Promocoes>(promocoes, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Promocoes>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocoes> update(@RequestBody Promocoes newPromocoes, @PathVariable Integer id) {
        try {
            promocoesService.update(id, newPromocoes);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Promocoes>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        promocoesService.delete(id);
        return "Promocoes Excluido.";
    }



}
