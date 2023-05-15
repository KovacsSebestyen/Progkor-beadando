package hu.nye.kovacssebestyen.progkor.szemuvegek.web.controller;

import hu.nye.kovacssebestyen.progkor.szemuvegek.data.model.Glasses;
import hu.nye.kovacssebestyen.progkor.szemuvegek.service.GlassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RequestMapping("/glasses")
@Controller
public class GlassesController {

    private final GlassesService glassesService;

    @Autowired
    public GlassesController(GlassesService glassesService) {
        this.glassesService = glassesService;
    }

    @GetMapping("/{id}")
    public String getGlassesById(Model model, @PathVariable Long id) {
        Glasses glasses = glassesService.getGlassesById(id);
        model.addAttribute("glasses",glasses);
        return "edit";
    }

    @GetMapping("/create")
    public String createGlasses(Model model) {
        return "create";
    }

    @PostMapping("/create")
    public String createGlasses(Model model, @RequestBody Glasses glasses) {
        Glasses createdGlasses = glassesService.createGlasses(glasses);
        model.addAttribute("glasses", createdGlasses);
        return "edit";
    }

    @GetMapping
    public String getAllGlasses(Model model) {
        List<Glasses> glassesList = glassesService.getAllGlasses();
        model.addAttribute("moreGlasses", glassesList);
        return "list";
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateGlasses(Model model, @RequestBody Glasses glasses) {
        Glasses updatedGlasses = glassesService.updateGlasses(glasses);
        return "edit";
    }

    @DeleteMapping("/{id}")
    public String removeGlassesById(Model model, @PathVariable Long id) {
        glassesService.deleteGlassesById(id);
        List<Glasses> glassesList = glassesService.getAllGlasses();
        model.addAttribute("moreGlasses", glassesList);
        return "list";
    }
}
