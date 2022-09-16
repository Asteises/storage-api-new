package ru.asteises.storageapi.mapper;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.asteises.storageapi.entity.Item;
import ru.asteises.storageapi.model.SystemItem;
import ru.asteises.storageapi.model.SystemItemImport;
import ru.asteises.storageapi.model.SystemItemImportRequest;
import ru.asteises.storageapi.service.ItemService;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

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

    public abstract SystemItem toSystemItem(Item item);

//    @InheritInverseConfiguration
//    @Mapping(target = "id", source = "item.id")
//    @Mapping(target = "url", source = "item.url")
//    @Mapping(target = "parentId", source = "item.parentId")
//    @Mapping(target = "type", source = "item.type")
//    @Mapping(target = "size", source = "item.size")
//    public abstract SystemItemImport toSystemItemImport(Item item);
}
