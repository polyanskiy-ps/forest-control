package ru.topaztree.topaztree.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopazForestDto {
    private Long id;
    private LocalDateTime requestTime;
    private String name;
    private int treeWeight;
    private TopazTreeDto topazTreeDto;

}
