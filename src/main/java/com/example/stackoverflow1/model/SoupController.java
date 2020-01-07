package com.example.stackoverflow1.model;

import com.sun.tools.javac.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SoupController {

    private SoupRepository soupRepository;

    @RequestMapping(value = "create")
    public Soup create() {
        Ingredient ingredient = Ingredient.builder().name("ingredient").build();
        Soup soup = Soup.builder()
                .name("Soup")
                .ingredients(List.of(ingredient))
                .build();
        return soupRepository.save(soup);
    }

    @RequestMapping(value = "delete")
    public void delete() {
        soupRepository.deleteById(1L);
    }

}
