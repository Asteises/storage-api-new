package ru.asteises.storageapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.storageapi.mapper.ItemMapper;
import ru.asteises.storageapi.model.SystemItem;
import ru.asteises.storageapi.model.SystemItemImportRequest;
import ru.asteises.storageapi.repository.ItemRepository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void importItems(List<SystemItemImportRequest> systemItemImportRequest) {

        //TODO Сделать через stream и попробовать сделать get запрос на получение Item
        for (SystemItemImportRequest s : systemItemImportRequest) {
            s.getItems().stream().map(systemItemImport -> ItemMapper.INSTANCE.toItem(systemItemImport,
                            new Date(s.getUpdateDate().getTime())))
                    .forEach(itemRepository::save);
        }
    }

    public SystemItem exportSystemItems(UUID itemId) {
        return ItemMapper.INSTANCE.toSystemItem(itemRepository.findById(itemId).get());
    }
}

