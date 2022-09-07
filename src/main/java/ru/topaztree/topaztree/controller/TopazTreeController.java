package ru.topaztree.topaztree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topaztree.topaztree.dto.TopazTreeDto;
import ru.topaztree.topaztree.dto.TopazForestDto;
import ru.topaztree.topaztree.service.TopazTreeService;

import java.util.List;

@RestController
public class TopazTreeController {

    @Autowired
    private TopazTreeService topazTreeService;
    @PostMapping("/forest_control")
    public int saveAndReturnTree(@RequestBody TopazTreeDto topazTreeDto) {
        return topazTreeService.calculateWeightOfTree(topazTreeDto);
    }
    @PostMapping("/forest_control/save")
    public int saveTree(@RequestBody TopazTreeDto topazTreeDto) {
        return topazTreeService.saveInDataBase(topazTreeDto).getTreeWeight();
    }

    @GetMapping("/trees")
    public List<TopazForestDto> getAll() {
        return topazTreeService.getAllTrees();
    }

    @GetMapping("/tree{id}")
    public TopazForestDto getTreeById(Long id) {
        return topazTreeService.findTreeById(id);
    }

}
