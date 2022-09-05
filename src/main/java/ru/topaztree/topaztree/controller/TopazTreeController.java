package ru.topaztree.topaztree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topaztree.topaztree.dto.TopazTreeDto;
import ru.topaztree.topaztree.entity.TopazTreeEntity;
import ru.topaztree.topaztree.service.TopazTreeService;

@RestController
public class TopazTreeController {

    @Autowired
    private TopazTreeService topazTreeService;

    @PostMapping("/topaz_tree")
    public int saveTree(@RequestBody TopazTreeDto topazTreeDto) {
        return topazTreeService.saveInDataBase(topazTreeDto).getTreeWeight();
    }

}
