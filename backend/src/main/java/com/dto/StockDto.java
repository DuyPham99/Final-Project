package com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.model.ProductOption;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class StockDto {
    private Long idStock;

    @NotEmpty
    private long amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    @NotEmpty
    private LocalDateTime dateInput;

    @NotEmpty
    private Long idProductOption;

    private ProductOption productOption;
}
