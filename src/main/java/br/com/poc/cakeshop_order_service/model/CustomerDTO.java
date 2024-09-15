package br.com.poc.cakeshop_order_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.OffsetDateTime;

@Builder
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "{customer.nome.notblank}")
    @Length(min = 5, max = 255, message = "{customer.nome.size}")
    private String name;

    @Email(message = "{customer.email.invalid}")
    @NotBlank(message = "{customer.email.notblank}")
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime createAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime updateAt;

}
