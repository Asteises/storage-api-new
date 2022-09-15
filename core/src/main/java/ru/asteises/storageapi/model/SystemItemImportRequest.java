package ru.asteises.storageapi.model;

import java.net.URI;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import ru.asteises.storageapi.model.SystemItemImport;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SystemItemImportRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-13T18:54:19.973988900+03:00[Europe/Moscow]")
public class SystemItemImportRequest {

  @JsonProperty("items")
  @Valid
  private List<SystemItemImport> items = null;

  @JsonProperty("updateDate")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private Date updateDate;

  public SystemItemImportRequest items(List<SystemItemImport> items) {
    this.items = items;
    return this;
  }

  public SystemItemImportRequest addItemsItem(SystemItemImport itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Импортируемые элементы
   * @return items
  */
  @Valid 
  @Schema(name = "items", description = "Импортируемые элементы", required = false)
  public List<SystemItemImport> getItems() {
    return items;
  }

  public void setItems(List<SystemItemImport> items) {
    this.items = items;
  }

  public SystemItemImportRequest updateDate(Date updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  /**
   * Время обновления добавляемых элементов.
   * @return updateDate
  */
  @Valid 
  @Schema(name = "updateDate", example = "2022-05-28T21:12:01Z", description = "Время обновления добавляемых элементов.", required = false)
  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemItemImportRequest systemItemImportRequest = (SystemItemImportRequest) o;
    return Objects.equals(this.items, systemItemImportRequest.items) &&
        Objects.equals(this.updateDate, systemItemImportRequest.updateDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, updateDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemItemImportRequest {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    updateDate: ").append(toIndentedString(updateDate)).append("\n");
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

