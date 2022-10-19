package br.senai.sc.editoralivros.model.service;

import br.senai.sc.editoralivros.model.entities.Autor;
import br.senai.sc.editoralivros.model.entities.Livro;
import br.senai.sc.editoralivros.model.entities.Status;
import br.senai.sc.editoralivros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<Livro> findById(Long isbn) {
        return livroRepository.findById(isbn);
    }

    public List<Livro> findByStatus(Status status) {
        return livroRepository.findByStatus(status);
    }

    public List<Livro> findByAutor(Autor autor) {
        return livroRepository.findByAutor(autor);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public void deleteById(Long isbn) {
        livroRepository.deleteById(isbn);
    }

    public boolean existsById(Long isbn) {
        return livroRepository.existsById(isbn);
    }
}
