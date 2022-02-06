package br.com.agencia.boaViagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agencia.boaViagem.model.Contato;
import br.com.agencia.boaViagem.repository.ContatoRepository;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

   public List<Contato> listAll(){
       return contatoRepository.findAll();
   }

   public void save(Contato contato){
       contatoRepository.save(contato);
   }

   public Contato get(Integer id){
       return contatoRepository.findById(id).get();
   }
   
   public void update(Integer id, Contato newContato) {
       Contato oldContato = contatoRepository.getById(id);
       oldContato.setNome(newContato.getNome());
       oldContato.setMensagem(newContato.getMensagem());
       contatoRepository.save(oldContato);
   }


   public void delete(Integer id){
       contatoRepository.deleteById(id);
   }
}
