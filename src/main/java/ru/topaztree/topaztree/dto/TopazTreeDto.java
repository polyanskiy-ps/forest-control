package ru.topaztree.topaztree.dto;

import lombok.Data;

import java.util.List;

@Data
public class TopazTreeDto {
    private int weight;
    private List<TopazTreeDto> children;
    //test
}