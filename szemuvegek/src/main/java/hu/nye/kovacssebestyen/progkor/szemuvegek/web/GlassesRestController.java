package hu.nye.kovacssebestyen.progkor.szemuvegek.web;

import hu.nye.kovacssebestyen.progkor.szemuvegek.data.model.Glasses;
import hu.nye.kovacssebestyen.progkor.szemuvegek.service.GlassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/glasses")
public class GlassesRestController {

    private final GlassesService glassesService;

    @Autowired
    public GlassesRestController(GlassesService glassesService) {
        this.glassesService = glassesService;
    }

    @GetMapping("/{id}")
    public Glasses getGlassesById(@PathVariable Long id) {
        return glassesService.getGlassesById(id);
    }

    @PostMapping
    public Glasses createGlasses(@RequestBody Glasses glasses) {
        return glassesService.createGlasses(glasses);
    }

    @GetMapping
    public List<Glasses> getAllGlasses() {
        return glassesService.getAllGlasses();
    }

    @PutMapping
    public Glasses updateGlasses(@RequestBody Glasses glasses) {
        return glassesService.updateGlasses(glasses);
    }

    @DeleteMapping("/{id}")
    public void removeGlassesById(@PathVariable Long id) {
        glassesService.deleteGlassesById(id);
    }
}