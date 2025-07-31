package com.uni.biblioteca_abc.service;
import com.uni.biblioteca_abc.model.Autor;
import com.uni.biblioteca_abc.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor save(Autor autor){
        return this.autorRepository.save(autor);}

    public List<Autor> findAll(){
        return this.autorRepository.findAll();}

    public Autor findById(Long id){
        return this.autorRepository.findById(id).get();
    }

    public String deleteById(Long id){
        this.autorRepository.deleteById(id);
        return "Autor Deletado Com Sucesso !";
    }

    public String update(Long id, Autor autorInfoNew){
        Autor autorSelecionado = this.autorRepository.findById(id).get();

        if(autorInfoNew.getNome() !=null){
            autorSelecionado.setNome(autorInfoNew.getNome());
        }

        if(autorInfoNew.getCpf() != null){
            autorSelecionado.setCpf(autorInfoNew.getCpf());
        }

        if(autorInfoNew.getIdade() != null){
            autorSelecionado.setIdade(autorInfoNew.getIdade());
        }
        this.autorRepository.save(autorSelecionado);
        return "Alteração feita com sucesso! ";
    }
}
