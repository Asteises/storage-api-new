package ru.asteises.storageapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.asteises.storageapi.mapper.ItemMapper;
import ru.asteises.storageapi.model.SystemItemImport;
import ru.asteises.storageapi.model.SystemItemImportRequest;
import ru.asteises.storageapi.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void  ImportItems(SystemItemImportRequest systemItemImportRequest) {
        List<SystemItemImport> systemItemImport = systemItemImportRequest.getItems();
        for (SystemItemImport itemDto : systemItemImport) {
            itemRepository.save(ItemMapper.INSTANCE.toItem(itemDto));
        }
    }
}
