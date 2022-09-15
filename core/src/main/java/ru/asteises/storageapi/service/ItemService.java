package ru.asteises.storageapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.storageapi.entity.Item;
import ru.asteises.storageapi.mapper.ItemMapper;
import ru.asteises.storageapi.model.SystemItemImport;
import ru.asteises.storageapi.model.SystemItemImportRequest;
import ru.asteises.storageapi.repository.ItemRepository;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void importItems(List<SystemItemImportRequest> systemItemImportRequest) {

        //TODO Сделать через stream и попробовать сделать get запрос на получение Item
        for (SystemItemImportRequest s : systemItemImportRequest) {
            List<SystemItemImport> systemItemImports = s.getItems();
            for (SystemItemImport systemItemImport : systemItemImports) {
                Item item = ItemMapper.INSTANCE.toItem(systemItemImport, new Date(s.getUpdateDate().getTime()));
                itemRepository.save(item);
            }
        }
    }
}
