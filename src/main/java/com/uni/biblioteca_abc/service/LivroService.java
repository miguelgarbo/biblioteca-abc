package com.uni.biblioteca_abc.service;
import com.uni.biblioteca_abc.model.Livro;
import com.uni.biblioteca_abc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro save(Livro livro){
        return this.livroRepository.save(livro);}

    public List<Livro> findAll(){
        return this.livroRepository.findAll();}

    public Livro findById(Long id){
        return this.livroRepository.findById(id).get();
    }

    public String deleteById(Long id){
        this.livroRepository.deleteById(id);
        return "Livro Deletada Com Sucesso !";
    }

    public String update(Long id, Livro livroInfoNew){

        Livro livroSelecionado = this.livroRepository.findById(id).get();

        if(livroInfoNew.getTitulo() !=null){
            livroSelecionado.setTitulo(livroInfoNew.getTitulo());
        }

        if(livroInfoNew.getAno() != null){
            livroSelecionado.setAno(livroInfoNew.getAno());
        }

        if(livroInfoNew.getISSN() != null){
            livroSelecionado.setISSN(livroInfoNew.getISSN());
        }

        if(livroInfoNew.getSinopse() != null){
            livroSelecionado.setSinopse(livroInfoNew.getSinopse());
        }

        if(livroInfoNew.getNumeroPaginas() != null){
            livroSelecionado.setNumeroPaginas(livroInfoNew.getNumeroPaginas());
        }

        this.livroRepository.save(livroSelecionado);
        return "Alteração feita com sucesso! ";
    }


}
