package br.com.agencia.boaViagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.agencia.boaViagem.model.Contato;
import br.com.agencia.boaViagem.service.ContatoService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/getAll")
    public List<Contato> list(){
        return contatoService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Contato contato){
        contatoService.save(contato);
        return "New Contato Added";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> get(@PathVariable Integer id) {
        try {
            Contato contato = contatoService.get(id);
            return new ResponseEntity<Contato>(contato, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Contato>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@RequestBody Contato newContato, @PathVariable Integer id) {
        try {
            contatoService.update(id, newContato);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Contato>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        contatoService.delete(id);
        return "Contato Excluido.";
    }



}
