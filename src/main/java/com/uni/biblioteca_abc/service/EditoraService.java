package com.uni.biblioteca_abc.service;
import com.uni.biblioteca_abc.model.Editora;
import com.uni.biblioteca_abc.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public Editora save(Editora editora){
        return this.editoraRepository.save(editora);}

    public List<Editora> findAll(){
        return this.editoraRepository.findAll();}

    public Editora findById(Long id){
        return this.editoraRepository.findById(id).get();
    }

    public String deleteById(Long id){
        this.editoraRepository.deleteById(id);
        return "Editora Deletada Com Sucesso !";
    }

    public String update(Long id, Editora editoraInfoNew){

        Editora editoraSelecionado = this.editoraRepository.findById(id).get();

        if(editoraInfoNew.getNome() !=null){
            editoraSelecionado.setNome(editoraInfoNew.getNome());
        }

        if(editoraInfoNew.getEndereco() != null){
            editoraSelecionado.setEndereco(editoraInfoNew.getEndereco());
        }

        if(editoraInfoNew.getTelefone() != null){
            editoraSelecionado.setTelefone(editoraInfoNew.getTelefone());
        }

        this.editoraRepository.save(editoraSelecionado);
        return "Alteração feita com sucesso! ";
    }
}
