package ru.topaztree.topaztree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.topaztree.topaztree.entity.TopazTreeEntity;

@Repository
public interface TopazTreeRepository extends JpaRepository<TopazTreeEntity, Long> {
}
