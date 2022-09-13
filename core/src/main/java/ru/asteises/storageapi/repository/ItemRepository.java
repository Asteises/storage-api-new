package ru.asteises.storageapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.storageapi.entity.Item;

import java.util.UUID;

//TODO Реализовать эндпоит ImportsApiController
@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
}
