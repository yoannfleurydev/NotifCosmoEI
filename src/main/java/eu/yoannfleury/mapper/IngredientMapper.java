package eu.yoannfleury.mapper;

import eu.yoannfleury.dto.IngredientDTO;
import eu.yoannfleury.entity.Ingredient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientMapper {
    public static IngredientDTO entityToDTO(Ingredient entity) {
        return new IngredientDTO(
                entity.getId(),
                entity.getName()
        );
    }

    public static Ingredient DTOToEntity(IngredientDTO dto) {
        return new Ingredient(dto.getName());
    }

    public static List<IngredientDTO> entityListToDTOList(List<Ingredient> entities) {
        List<IngredientDTO> list = new ArrayList<>();

        for (Ingredient entity :
                entities) {
            list.add(entityToDTO(entity));
        }

        return list;
    }
}