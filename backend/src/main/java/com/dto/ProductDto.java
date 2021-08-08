package com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.model.ProductOption;
import com.model.Warranty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProductDto {
    private String name;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate published;
    private Long brandId;
    private List<ProductOption> productOptions;
    private Warranty warranty;
}
