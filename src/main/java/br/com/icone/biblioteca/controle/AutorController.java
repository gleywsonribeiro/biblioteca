/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icone.biblioteca.controle;

import br.com.icone.biblioteca.modelo.Autor;
import br.com.icone.biblioteca.modelo.repositorio.AutorFacade;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Gleywson
 */
@ManagedBean
@ViewScoped
public class AutorController {

    @Inject
    private AutorFacade repositorio;
    
    private Autor autor;
    
    private List<Autor> autores;
    
    public AutorController() {
        this.autor = new Autor();
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Autor> getAutores() {
        if(autores == null) {
            autores = repositorio.findAll();
        }
        return autores;
    }
    
    
    public  void salvar() {
        if(autor.getId() == null) {
            repositorio.create(autor);
        }
        else {
            repositorio.edit(autor);
        }
        autor = new Autor();
        autores = null;
//        FacesContext.getCurrentInstance().addMessage(null, "Salvo com sucesso!");
    }
    
    
    public void remover() {
        repositorio.remove(autor);
        this.autor = new Autor();
        this.autores = null;
    }
    
}
