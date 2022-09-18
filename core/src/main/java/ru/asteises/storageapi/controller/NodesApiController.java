package ru.asteises.storageapi.controller;

import org.springframework.http.ResponseEntity;
import ru.asteises.storageapi.model.SystemItem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import ru.asteises.storageapi.service.ItemService;

import java.util.Optional;
import java.util.UUID;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-13T18:54:19.973988900+03:00[Europe/Moscow]")
@Controller
@RequestMapping("${openapi.yetAnotherDiskOpen.base-path:}")
public class NodesApiController implements NodesApi {

    private final NativeWebRequest request;
    private final ItemService itemService;

    @Autowired
    public NodesApiController(NativeWebRequest request, ItemService itemService) {
        this.request = request;
        this.itemService = itemService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<SystemItem> getItemById(UUID itemId) {
        return ResponseEntity.ok(itemService.exportSystemItems(itemId));
    }

}
