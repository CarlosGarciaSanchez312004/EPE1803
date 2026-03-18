package org.example.epe1803.controllers;

import org.example.epe1803.entities.Item;
import org.example.epe1803.services.ItemService;
import org.example.epe1803.services.LLMService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ItemWebController {

    private final ItemService itemService;
    private final LLMService llmService;

    public ItemWebController(ItemService itemService, LLMService llmService) {
        this.itemService = itemService;
        this.llmService = llmService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "index";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable("id") int id, Model model) {
        Item item = itemService.findById(id);
        String recomendacion = llmService.generateRecomendacion(String.valueOf(id));

        model.addAttribute("item", item);
        model.addAttribute("recomendacion", recomendacion);
        return "detalle";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        Item item = itemService.findById(id);
        model.addAttribute("item", item);
        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String guardarEdicion(@PathVariable("id") int id, @ModelAttribute Item itemActualizado) {

        Item itemOriginal = itemService.findById(id);
        if (itemOriginal != null) {
            itemOriginal.setTitle(itemActualizado.getTitle());
            itemOriginal.setPrice(itemActualizado.getPrice());
            itemOriginal.setCategory(itemActualizado.getCategory());
            itemOriginal.setDescription(itemActualizado.getDescription());
            itemOriginal.setRate(itemActualizado.getRate());
            itemOriginal.setCount(itemActualizado.getCount());
            itemOriginal.setColor(itemActualizado.getColor());
            itemOriginal.setManufacturer(itemActualizado.getManufacturer());
            itemOriginal.setEAN(itemActualizado.getEAN());
            itemOriginal.setImage(itemActualizado.getImage());

            itemService.save(itemOriginal);
        }
        return "redirect:/";
    }

}