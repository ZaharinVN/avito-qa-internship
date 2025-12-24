package ru.avito.qa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class AdsList {
    @JsonProperty("ads")
    private List<Ad> ads;
}
