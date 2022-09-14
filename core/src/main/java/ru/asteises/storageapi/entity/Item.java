package ru.asteises.storageapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import ru.asteises.storageapi.model.SystemItemType;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ITEM")
public class Item {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "URL")
    private String url;
    @Column(name = "PARENT_ID")
    private UUID parentId;
    @Column(name = "TYPE")
    private SystemItemType type;
    @Column(name = "SIZE")
    private long size;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID", nullable = true)
    private List<Item> items;

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Item item = (Item) o;
        return getId() != null && Objects.equals(getId(), item.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
