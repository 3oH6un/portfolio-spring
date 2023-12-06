package com.springframework.portfolio.controller;

import com.springframework.portfolio.dto.request.PostUpdateRequest;
import com.springframework.portfolio.dto.request.PostAddRequest;
import com.springframework.portfolio.dto.response.PostResponse;
import com.springframework.portfolio.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/portfolio")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {

        this.postService = postService;
    }

    // 게시글 저장
    @PostMapping
    public PostResponse savePost(@RequestPart("request") final PostAddRequest request,
                                 @RequestPart("file") final MultipartFile file) {

        System.out.println("====================================");
        return postService.insertPost(request, file);
    }

    // 게시글 목록 조회
    @GetMapping
    public List<PostResponse> findAllPost() {

        return postService.selectAllPosts();
    }

    // 게시글 상세정보 조회
    @GetMapping("/{num}")
    public PostResponse findPostById(@PathVariable final Long num) {

        return postService.selectPost(num);
    }

    @PutMapping("/{num}")
    public PostResponse updatePost(@PathVariable final Long num,
                                   @RequestBody final PostUpdateRequest request) {

        return postService.updatePost(num, request);
    }

    @DeleteMapping("/{num}")
    public void deletePost(@PathVariable final Long num) {

        postService.deletePost(num);
    }
}
