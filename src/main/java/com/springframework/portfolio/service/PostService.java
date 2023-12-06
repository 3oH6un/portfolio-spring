package com.springframework.portfolio.service;

import com.springframework.portfolio.dto.PostDto;
import com.springframework.portfolio.dto.request.PostUpdateRequest;
import com.springframework.portfolio.dto.request.PostAddRequest;
import com.springframework.portfolio.dto.response.PostResponse;
import com.springframework.portfolio.entity.Post;
import com.springframework.portfolio.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final FileService fileService;

    public PostService(PostRepository postRepository,
                       CategoryService categoryService,
                       FileService fileService) {

        this.postRepository = postRepository;
        this.categoryService = categoryService;
        this.fileService = fileService;
    }

    @Transactional
    public PostResponse insertPost(PostAddRequest request, MultipartFile file) {

        String fileName = fileService.uploadFile(file);

        Post post = Post.builder()
                .title(request.getTitle())
                .category(categoryService.getCategoryReference(request.getCategory()))
                .repImg(fileName)
                .description(request.getDescription())
                .content(request.getContent())
                .build();

        postRepository.save(post);

        return new PostResponse(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> selectAllPosts() {

        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostResponse selectPost(Long postNum) {

        Post post = postRepository.findById(postNum).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 게시글입니다..")
        );
        return new PostResponse(post);
    }

    @Transactional
    public PostResponse updatePost(Long num, PostUpdateRequest request) {

        Post post = postRepository.findById(num).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 게시글입니다.")
        );

        PostDto postDto = PostDto.builder()
                .title(request.getTitle())
                .category(categoryService.getCategoryReference(request.getCategory()))
                .repImg(request.getRepImg())
                .content(request.getContent())
                .build();

        return new PostResponse(post.updatePost(postDto));
    }

    @Transactional
    public void deletePost(Long postNum) {

        postRepository.delete(postRepository.findById(postNum).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 게시글입니다.")
        ));
    }
}
