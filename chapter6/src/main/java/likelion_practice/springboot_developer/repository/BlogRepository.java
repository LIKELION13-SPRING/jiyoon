package likelion_practice.springboot_developer.repository;

import likelion_practice.springboot_developer.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
