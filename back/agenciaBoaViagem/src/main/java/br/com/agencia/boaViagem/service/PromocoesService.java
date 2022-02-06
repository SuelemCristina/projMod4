package br.com.agencia.boaViagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agencia.boaViagem.model.Promocoes;
import br.com.agencia.boaViagem.repository.PromocoesRepository;

import java.util.List;

@Service
public class PromocoesService {

    @Autowired
    private PromocoesRepository promocoesRepository;

   public List<Promocoes> listAll(){
       return promocoesRepository.findAll();
   }

   public void save(Promocoes promocoes){
       promocoesRepository.save(promocoes);
   }

   public Promocoes get(Integer id){
       return promocoesRepository.findById(id).get();
   }
   
   public void update(Integer id, Promocoes newPromocoes) {
       Promocoes oldPromocoes = promocoesRepository.getById(id);
       oldPromocoes.setNome(newPromocoes.getNome());
       oldPromocoes.setEmail(newPromocoes.getEmail());
       oldPromocoes.setCep(newPromocoes.getCep());
       oldPromocoes.setCidade(newPromocoes.getCidade());
       oldPromocoes.setComplemento(newPromocoes.getComplemento());
       oldPromocoes.setEndereco(newPromocoes.getEndereco());
       oldPromocoes.setEstado(newPromocoes.getEstado());
       oldPromocoes.setNumero(newPromocoes.getNumero());
       oldPromocoes.setTelefone(newPromocoes.getTelefone());








       promocoesRepository.save(oldPromocoes);
   }


   public void delete(Integer id){
       promocoesRepository.deleteById(id);
   }
}
