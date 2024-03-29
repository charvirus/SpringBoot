package com.charvirus.book.springboot.web;

import com.charvirus.book.springboot.config.auth.LoginUser;
import com.charvirus.book.springboot.config.auth.dto.SessionUser;
import com.charvirus.book.springboot.service.posts.PostsService;
import com.charvirus.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());

        if(user != null){
            System.out.println(user.getName());
            model.addAttribute("loginUserName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/{id}")
    public String postsView(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts-view",dto);
        return "posts-view";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts-update",dto);
        return "posts-update";
    }
}
