package hu.nye.kovacssebestyen.progkor.szemuvegek.web.controller;

import hu.nye.kovacssebestyen.progkor.szemuvegek.data.model.Glasses;
import hu.nye.kovacssebestyen.progkor.szemuvegek.service.GlassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * A szemüvegek listáját alakító függvények controllerrel való kezelése.
 */
@RequestMapping("/glasses")
@Controller
public class GlassesController {

    private final GlassesService glassesService;

    @Autowired
    public GlassesController(GlassesService glassesService) {
        this.glassesService = glassesService;
    }

    /**
     * A szemüvegek id-je alapján lekéri a szemüveg adatait.
     *
     * @param model a modelnek egy attributumába kerül majd a szemüvege
     *
     * @param id a szemuveg azonosítója
     *
     * @return a hely ahova küldje az eredményt
     */
    @GetMapping("/{id}")
    public String getGlassesById(Model model, @PathVariable Long id) {
        Glasses glasses = glassesService.getGlassesById(id);
        model.addAttribute("glasses", glasses);
        return "edit";
    }

    @GetMapping("/create")
    public String createGlasses(Model model) {
        return "create";
    }

    /**
     * Létrehozza a szemüveget a megadott adatokkal.
     *
     * @param model a modelnek egy attributumába kerül majd a szemüvege
     *
     * @param glasses a szemüveg létrehozásához megadott adatok
     *
     * @return a hely ahova küldje az eredményt
     */
    @PostMapping("/create")
    public String createGlasses(Model model, Glasses glasses) {
        Glasses createdGlasses = glassesService.createGlasses(glasses);
        model.addAttribute("glasses", createdGlasses);
        return "edit";
    }

    /**
     * Lekéri az összes szemüveg adatait.
     *
     * @param model a modelnek egy attributumába kerülnek majd a szemüvegek
     *
     * @return a hely ahova küldje az eredményt
     */
    @GetMapping
    public String getAllGlasses(Model model) {
        List<Glasses> glassesList = glassesService.getAllGlasses();
        model.addAttribute("moreGlasses", glassesList);
        return "list";
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateGlasses(Model model, Glasses glasses) {
        Glasses updatedGlasses = glassesService.updateGlasses(glasses);
        return "edit";
    }

    /**
     * Törli a szemüveget a megadott id alapján.
     *
     * @param model a modelnek egy attributumába kerül majd a szemüvege
     *
     * @param id a szemuveg azonosítója
     *
     * @return a hely ahova küldje az eredményt
     */
    @GetMapping("/{id}/delete")
    public String removeGlassesById(Model model, @PathVariable Long id) {
        glassesService.deleteGlassesById(id);
        List<Glasses> glassesList = glassesService.getAllGlasses();
        model.addAttribute("moreGlasses", glassesList);
        return "list";
    }
}
