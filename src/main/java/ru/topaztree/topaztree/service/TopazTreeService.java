package ru.topaztree.topaztree.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.topaztree.topaztree.config.MapperUtil;
import ru.topaztree.topaztree.dto.TopazTreeDto;
import ru.topaztree.topaztree.dto.TopazForestDto;
import ru.topaztree.topaztree.entity.TopazTreeEntity;
import ru.topaztree.topaztree.repository.TopazTreeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TopazTreeService {
    final private TopazTreeRepository topazTreeRepository;
    private ModelMapper modelMapper;

    public int calculateWeightOfChildren(TopazTreeDto topazTreeDto) {
        int childrenWeight = 0;
        if (topazTreeDto.getChildren() != null) {
            for (TopazTreeDto tree : topazTreeDto.getChildren()) {
                childrenWeight += tree.getWeight() + calculateWeightOfChildren(tree);

            }
        }
        return childrenWeight;
    }

    public int calculateWeightOfTree(TopazTreeDto topazTreeDto) {
        int weight;
        weight = topazTreeDto.getWeight() + calculateWeightOfChildren(topazTreeDto);
        return weight;
    }

    public TopazForestDto convertToTopazForestDto(TopazTreeEntity topazTreeEntity) {
        return modelMapper.map(topazTreeEntity, TopazForestDto.class);
    }


    public List<TopazForestDto> getAllTrees() {
        List<TopazTreeEntity> topazTreeEntities = topazTreeRepository.findAll();
        List<TopazForestDto> list;
        list = MapperUtil.convertList(topazTreeEntities, this::convertToTopazForestDto);
        return list.stream().peek(tree -> tree.setTopazTreeDto(null)).collect(Collectors.toList());
    }

    public TopazForestDto findTreeById(Long id) {
        TopazTreeEntity topazTreeEntity = topazTreeRepository.getReferenceById(id);
        return convertToTopazForestDto(topazTreeEntity);
    }

    public TopazTreeEntity saveInDataBase(TopazTreeDto topazTreeDto) {
        TopazTreeEntity topazTreeEntity = new TopazTreeEntity();
        topazTreeEntity.setRequestTime(LocalDateTime.now());
        topazTreeEntity.setName(topazTreeDto.getName());
        topazTreeEntity.setTreeWeight(calculateWeightOfTree(topazTreeDto));
        topazTreeEntity.setTopazTreeDto(topazTreeDto);
        return topazTreeRepository.save(topazTreeEntity);

    }

}
