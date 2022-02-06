package br.com.agencia.boaViagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agencia.boaViagem.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato,Integer> {


}
