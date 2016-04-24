package com.onlineretail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.onlineretail.domain.Category;

@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
