package ru.asteises.storageapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import ru.asteises.storageapi.model.SystemItemType;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SystemItem
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-13T18:54:19.973988900+03:00[Europe/Moscow]")
public class SystemItem {

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("url")
  private String url;

  @JsonProperty("date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date date;

  @JsonProperty("parentId")
  private UUID parentId;

  @JsonProperty("type")
  private SystemItemType type;

  @JsonProperty("size")
  private Long size;

  @JsonProperty("children")
  @Valid
  private List<SystemItem> children = null;

  public SystemItem id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентфикатор
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "элемент_1_1", description = "Уникальный идентфикатор", required = true)
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public SystemItem url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Ссылка на файл. Для папок поле равнно null.
   * @return url
  */
  
  @Schema(name = "url", description = "Ссылка на файл. Для папок поле равнно null.", required = false)
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public SystemItem date(Date date) {
    this.date = date;
    return this;
  }

  /**
   * Время последнего обновления элемента.
   * @return date
  */
  @NotNull @Valid 
  @Schema(name = "date", example = "2022-05-28T21:12:01Z", description = "Время последнего обновления элемента.", required = true)
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public SystemItem parentId(UUID parentId) {
    this.parentId = parentId;
    return this;
  }

  /**
   * id родительской папки
   * @return parentId
  */
  
  @Schema(name = "parentId", example = "элемент_1_1", description = "id родительской папки", required = false)
  public UUID getParentId() {
    return parentId;
  }

  public void setParentId(UUID parentId) {
    this.parentId = parentId;
  }

  public SystemItem type(SystemItemType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull @Valid 
  @Schema(name = "type", required = true)
  public SystemItemType getType() {
    return type;
  }

  public void setType(SystemItemType type) {
    this.type = type;
  }

  public SystemItem size(Long size) {
    this.size = size;
    return this;
  }

  /**
   * Целое число, для папки - это суммарный размер всех элеметов.
   * @return size
  */
  
  @Schema(name = "size", description = "Целое число, для папки - это суммарный размер всех элеметов.", required = false)
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public SystemItem children(List<SystemItem> children) {
    this.children = children;
    return this;
  }

  public SystemItem addChildrenItem(SystemItem childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * Список всех дочерних элементов. Для файлов поле равно null.
   * @return children
  */
  @Valid 
  @Schema(name = "children", description = "Список всех дочерних элементов. Для файлов поле равно null.", required = false)
  public List<SystemItem> getChildren() {
    return children;
  }

  public void setChildren(List<SystemItem> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemItem systemItem = (SystemItem) o;
    return Objects.equals(this.id, systemItem.id) &&
        Objects.equals(this.url, systemItem.url) &&
        Objects.equals(this.date, systemItem.date) &&
        Objects.equals(this.parentId, systemItem.parentId) &&
        Objects.equals(this.type, systemItem.type) &&
        Objects.equals(this.size, systemItem.size) &&
        Objects.equals(this.children, systemItem.children);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, date, parentId, type, size, children);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemItem {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

