package ru.asteises.storageapi.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.asteises.storageapi.entity.Item;
import ru.asteises.storageapi.model.SystemItem;
import ru.asteises.storageapi.model.SystemItemImport;
import ru.asteises.storageapi.model.SystemItemType;
import ru.asteises.storageapi.service.ItemService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Преобразуем SystemItemImport в Item и обратно
 */
@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class, Date.class, Collections.class},
        uses = {SystemItemImport.class, ItemService.class})
public abstract class ItemMapper {

    public static final ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);


    @Mapping(target = "date", source = "date")

    public abstract Item toItem(SystemItemImport systemItemImport, Date date);

    @Mapping(target = "children", source = "item", qualifiedByName = "childrenMapping")
    @Mapping(target = "size", source = "item", qualifiedByName = "sizeCount")
    public abstract SystemItem toSystemItem(Item item);

    @Named("childrenMapping")
    public List<SystemItem> childrenMapping(Item item) {
        if (SystemItemType.FILE.equals(item.getType())) {
            return null;
        }
        if (!item.getItems().isEmpty()) {
            return item.getItems().stream()
                    .map(this::toSystemItem)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Named("sizeCount")
    public long sizeCount(Item item) {
        if (SystemItemType.FILE.equals(item.getType())) {
            return item.getSize();
        }
        long size = item.getItems().size();
        for (Item i : item.getItems()) {
            if (SystemItemType.FOLDER.equals(i.getType())) {
                size += sizeCount(i);
            }
        }
        return size;
    }
}
