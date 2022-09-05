package ru.topaztree.topaztree.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.topaztree.topaztree.dto.TopazTreeDto;
import ru.topaztree.topaztree.entity.TopazTreeEntity;
import ru.topaztree.topaztree.repository.TopazTreeRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TopazTreeService {
    final private TopazTreeRepository topazTreeRepository;

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

    public TopazTreeEntity saveInDataBase(TopazTreeDto topazTreeDto) {
        TopazTreeEntity topazTreeEntity = new TopazTreeEntity();
        topazTreeEntity.setRequestTime(LocalDateTime.now());
        topazTreeEntity.setTreeWeight(calculateWeightOfTree(topazTreeDto));
        topazTreeEntity.setTopazTreeDto(topazTreeDto);
        return topazTreeRepository.save(topazTreeEntity);

    }

}
