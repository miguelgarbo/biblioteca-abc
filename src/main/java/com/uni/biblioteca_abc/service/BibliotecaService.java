package com.uni.biblioteca_abc.service;
import com.uni.biblioteca_abc.model.Biblioteca;
import com.uni.biblioteca_abc.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public Biblioteca save(Biblioteca biblioteca){
        return this.bibliotecaRepository.save(biblioteca);}

    public List<Biblioteca> findAll(){
        return this.bibliotecaRepository.findAll();}

    public Biblioteca findById(Long id){
        return this.bibliotecaRepository.findById(id).get();
    }

    public String deleteById(Long id){
        this.bibliotecaRepository.deleteById(id);
        return "Biblioteca Deletada Com Sucesso !";
    }

    public String update(Long id, Biblioteca bibliotecaInfoNew){

        Biblioteca bibliotecaSelecionado = this.bibliotecaRepository.findById(id).get();

        if(bibliotecaInfoNew.getNome() !=null){
            bibliotecaSelecionado.setNome(bibliotecaInfoNew.getNome());
        }

        if(bibliotecaInfoNew.getTelefone() != null){
            bibliotecaSelecionado.setTelefone(bibliotecaInfoNew.getTelefone());
        }

        this.bibliotecaRepository.save(bibliotecaSelecionado);
        return "Alteração feita com sucesso! ";
    }
}
