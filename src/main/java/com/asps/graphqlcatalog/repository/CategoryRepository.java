package com.asps.graphqlcatalog.repository;

import com.asps.graphqlcatalog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}