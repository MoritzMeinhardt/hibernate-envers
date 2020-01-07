package com.example.stackoverflow1;

import com.example.stackoverflow1.model.Ingredient;
import com.example.stackoverflow1.model.IngredientRepository;
import com.example.stackoverflow1.model.Soup;
import com.example.stackoverflow1.model.SoupRepository;
import com.sun.tools.javac.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private IngredientRepository ingredientRepository;
    private SoupRepository soupRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
/*
        Ingredient ingredient = Ingredient.builder().name("ingredient").build();
        Soup soup = Soup.builder()
                .name("Soup")
                .ingredients(List.of(ingredient))
                .build();
        soupRepository.save(soup);
*/

        System.out.println("Loaded Soups...");
    }
}
