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

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("posts", postService.getAll());
        return "posts/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        postService.add(post);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String edit(@RequestParam("id") int id, @NotNull Model model) {
        model.addAttribute("posts", postService.getAll());
        model.addAttribute("post", postService.findById(id));
        return "posts/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Post post) {
        postService.update(post);
        return "redirect:/";
    }

}
