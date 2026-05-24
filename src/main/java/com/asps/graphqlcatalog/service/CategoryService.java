package com.asps.graphqlcatalog.service;

import co.elastic.apm.api.ElasticApm;
import com.asps.graphqlcatalog.entity.Category;
import com.asps.graphqlcatalog.exception.CategoryNotFoundException;
import com.asps.graphqlcatalog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Category save(Category category){
        return repository.save(category);
    }

    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    public List<Category> findAll() {

        final var span = ElasticApm.currentSpan()
                .startSpan("business", "category", "buscar");

        span.setName("Buscar Categoria");

        try {
            return repository.findAll();
        } catch (Exception e) {
            span.captureException(e);
            throw new RuntimeException("Erro ao consultar categorias", e);
        } finally {
            span.end();
        }
    }

    public Boolean deleteById(Long id) {
        final var category = repository.findById(id);

        if(category.isEmpty()){
            throw new CategoryNotFoundException();
        }

        repository.deleteById(id);
        return true;
    }
}
