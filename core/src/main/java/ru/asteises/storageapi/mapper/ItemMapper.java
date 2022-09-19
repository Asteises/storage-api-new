package ru.asteises.storageapi.mapper;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.asteises.storageapi.entity.Item;
import ru.asteises.storageapi.model.SystemItem;
import ru.asteises.storageapi.model.SystemItemImport;
import ru.asteises.storageapi.model.SystemItemImportRequest;
import ru.asteises.storageapi.model.SystemItemType;
import ru.asteises.storageapi.service.ItemService;

import java.sql.Date;
import java.time.LocalDateTime;
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

    @Mapping(target = "children", source = "item", qualifiedByName = "childrenMap")
    public abstract SystemItem toSystemItem(Item item);

    //TODO Доделать маппер и упростить его используя stream
    @Named("children")
    public List<SystemItem> children(Item item) {
        List<SystemItem> systemItems = new ArrayList<>();
        item.getItems().stream()
                .filter(i -> i.getType().equals(SystemItemType.FILE) && !i.getItems().isEmpty())
                .map(ItemMapper.INSTANCE::toSystemItem).collect(Collectors.toList());
        return systemItems;

//        if (item.getItems().isEmpty() && item.getType().equals(SystemItemType.FILE)) {
//            return null;
//        } else {
//            for (Item i : item.getItems()) {
//                systemItems.add(this.toSystemItem(i));
//            }
//            return systemItems;
//        }

//        if(!item.getItems().isEmpty()) {
//            for (Item i: item.getItems()) {
//                if (i.getType() == SystemItemType.FILE) {
//                    systemItems.add(this.toSystemItem(i));
//                } else {
//                    systemItems.add(this.toSystemItem(i));
//                }
//            }
//        } else {
//            return null;
//        }
//        return systemItems;
    }

//    @InheritInverseConfiguration
//    @Mapping(target = "id", source = "item.id")
//    @Mapping(target = "url", source = "item.url")
//    @Mapping(target = "parentId", source = "item.parentId")
//    @Mapping(target = "type", source = "item.type")
//    @Mapping(target = "size", source = "item.size")
//    public abstract SystemItemImport toSystemItemImport(Item item);
}
