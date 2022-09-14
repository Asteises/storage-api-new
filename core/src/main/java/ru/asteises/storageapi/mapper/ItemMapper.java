package ru.asteises.storageapi.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.asteises.storageapi.entity.Item;
import ru.asteises.storageapi.model.SystemItemImport;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

/**
 * Преобразуем SystemItemImport в Item и обратно
 */
@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class, LocalDateTime.class, Collections.class},
        uses = {SystemItemImport.class})
public abstract class ItemMapper {

    public static final ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "url", expression = "java(systemItemImport.getUrl())")
    @Mapping(target = "parentId", expression = "java(systemItemImport.getParentId())")
    @Mapping(target = "type", expression = "java(systemItemImport.getType())")
    @Mapping(target = "size", expression = "java(systemItemImport.getSize())")
//    @Mapping(target = "items", expression = "java()")
    public abstract Item toItem(SystemItemImport systemItemImport);

    @InheritInverseConfiguration
    @Mapping(target = "id", source = "item.id")
    @Mapping(target = "url", source = "item.url")
    @Mapping(target = "parentId", source = "item.parentId")
    @Mapping(target = "type", source = "item.type")
    @Mapping(target = "size", source = "item.size")
    public abstract SystemItemImport toSystemItemImport(Item item);
}
