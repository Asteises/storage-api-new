package ru.asteises.storageapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import ru.asteises.storageapi.model.SystemItemImportRequest;
import ru.asteises.storageapi.service.ItemService;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-13T18:54:19.973988900+03:00[Europe/Moscow]")
@Controller
@RequestMapping("${openapi.yetAnotherDiskOpen.base-path:}")
public class ImportsApiController implements ImportsApi {

    private final NativeWebRequest request;
    private final ItemService itemService;

    @Autowired
    public ImportsApiController(NativeWebRequest request, ItemService itemService) {
        this.request = request;
        this.itemService = itemService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> importItems(List<SystemItemImportRequest> systemItemImportRequest) {
        itemService.importItems(systemItemImportRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
