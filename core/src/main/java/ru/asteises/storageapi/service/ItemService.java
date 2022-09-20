package ru.asteises.storageapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.storageapi.entity.Item;
import ru.asteises.storageapi.exception.ItemNotFound;
import ru.asteises.storageapi.mapper.ItemMapper;
import ru.asteises.storageapi.model.SystemItem;
import ru.asteises.storageapi.model.SystemItemImportRequest;
import ru.asteises.storageapi.repository.ItemRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void importItems(List<SystemItemImportRequest> systemItemImportRequest) {
        for (SystemItemImportRequest s : systemItemImportRequest) {
            s.getItems().stream().map(systemItemImport -> ItemMapper.INSTANCE.toItem(systemItemImport,
                            new Date(s.getUpdateDate().getTime())))
                    .forEach(itemRepository::save);
        }
    }

    public SystemItem exportSystemItems(UUID itemId) throws ItemNotFound {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isPresent()) {
            return optionalItem.map(ItemMapper.INSTANCE::toSystemItem).orElse(null);
        }
        throw new ItemNotFound("Item not found");
    }

    public void deleteItem(UUID itemId) throws ItemNotFound {
        if (itemRepository.findById(itemId).isPresent()) {
            itemRepository.deleteById(itemId);
            return;
        }
        throw new ItemNotFound("Item not found");
    }
}

