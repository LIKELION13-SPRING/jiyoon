package likelion_practice.springboot_developer.service;

import jakarta.transaction.Transactional;
import likelion_practice.springboot_developer.domain.Article;
import likelion_practice.springboot_developer.dto.AddArticleRequest;
import likelion_practice.springboot_developer.dto.UpdateArticleRequest;
import likelion_practice.springboot_developer.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article=blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
