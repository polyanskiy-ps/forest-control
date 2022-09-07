package ru.topaztree.topaztree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topaztree.topaztree.dto.TopazTreeDto;
import ru.topaztree.topaztree.dto.TopazForestDto;
import ru.topaztree.topaztree.service.TopazTreeService;

import java.util.List;

@RestController
@RequestMapping("api/v1/forest")
public class TopazTreeController {
    @Autowired
    private TopazTreeService topazTreeService;

    @PostMapping
    public int returnTreeWeight(@RequestBody TopazTreeDto topazTreeDto) {
        return topazTreeService.calculateWeightOfTree(topazTreeDto);
    }

    @PostMapping("/save")
    public int saveTree(@RequestBody TopazTreeDto topazTreeDto) {
        return topazTreeService.saveInDataBase(topazTreeDto).getTreeWeight();
    }

    @GetMapping
    public List<TopazForestDto> getAll() {
        return topazTreeService.getAllTrees();
    }

    @GetMapping("/tree")
    public TopazForestDto getTreeById(@RequestParam Long id) {
        return topazTreeService.findTreeById(id);
    }

    @DeleteMapping("/tree")
    public void deleteTreeById(@RequestParam Long id) {
        topazTreeService.deleteTreeById(id);
    }

}
