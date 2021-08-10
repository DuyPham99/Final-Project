package com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.model.Brand;
import com.model.ProductOption;
import com.model.Warranty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
public class ProductDto {
    @NotEmpty
    private Long idProduct;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotEmpty
    private LocalDate published;

    @NotEmpty
    private Long brandId;

    @NotEmpty
    private List<ProductOption> productOptions;

    @NotEmpty
    private Warranty warranty;

    private Brand brand;
}
