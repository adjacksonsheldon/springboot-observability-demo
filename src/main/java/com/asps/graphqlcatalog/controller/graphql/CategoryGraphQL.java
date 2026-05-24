package com.asps.graphqlcatalog.controller.graphql;

import com.asps.graphqlcatalog.entity.Category;
import com.asps.graphqlcatalog.dto.input.CreateCategoryInput;
import com.asps.graphqlcatalog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryGraphQL {

    private final CategoryService categoryService;

    @MutationMapping
    public Category createCategory(@Argument CreateCategoryInput category){
        final var document = Category.builder()
                .name(category.getName())
                .description(category.getDescription())
                .build();

        return categoryService.save(document);
    }

    @MutationMapping
    public Boolean deleteCategory(@Argument Long id){
        return categoryService.deleteById(id);
    }

    @QueryMapping
    public Category category(@Argument Long id){
        return categoryService.findById(id);
    }

    @QueryMapping
    public List<Category> categories(){
        return categoryService.findAll();
    }
}
