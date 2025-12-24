package ru.avito.qa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ad {
    @JsonProperty("id")
    private Long itemId;

    @JsonProperty("sellerId")
    private Long sellerId;

    private String title;
    private String description;
    private Integer price;
}
