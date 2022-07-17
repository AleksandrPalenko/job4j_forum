package ru.job4j.forum.control;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.time.LocalDate;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String create() {
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        post.setCreated(LocalDate.now());
        if (post.getId() == 0) {
            postService.add(post);
        } else {
            postService.update(post);
        }
        return "redirect:/";
    }

    @GetMapping("/update")
    public String edit(@RequestParam("id") int id, @NotNull Model model) {
        model.addAttribute("post", postService.findById(id));
        return "edit";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, @NotNull Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post";
    }


}
