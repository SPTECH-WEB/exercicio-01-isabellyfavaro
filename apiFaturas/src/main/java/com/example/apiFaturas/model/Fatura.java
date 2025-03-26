package com.example.apiFaturas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "faturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do cartão não pode estar em branco.")
    @Pattern(regexp = "\\d{4}\\s\\d{6}\\s\\d{6}",
            message = "O número do cartão deve possuir o formato: 0000 000000 000000")
    @JsonProperty("numeroCartao") // Garante compatibilidade com o JSON
    private String numeroCartao;

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 3, max = 100, message = "O nome deve possuir de 3 a 100 caracteres")
    private String nomeTitular;

    @NotNull(message = "O valor não pode ser nulo.")
    @DecimalMin(value = "10.00", message = "O valor mínimo é 10 reais")
    @DecimalMax(value = "5000.00", message = "O valor máximo é 5.000")
    private Double valor;

    @NotNull(message = "A data não pode ser nula.")
    @FutureOrPresent(message = "A data de pagamento deve ser atual ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email não pode estar em branco.")
    @Email(message = "O email deve ser válido")
    private String emailContato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O número do cartão não pode estar em branco.") @Pattern(regexp = "\\d{4}\\s\\d{6}\\s\\d{6}",
            message = "O número do cartão deve possuir o formato: 0000 000000 000000") String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(@NotBlank(message = "O número do cartão não pode estar em branco.") @Pattern(regexp = "\\d{4}\\s\\d{6}\\s\\d{6}",
            message = "O número do cartão deve possuir o formato: 0000 000000 000000") String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public @NotBlank(message = "O nome não pode estar em branco.") @Size(min = 3, max = 100, message = "O nome deve possuir de 3 a 100 caracteres") String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(@NotBlank(message = "O nome não pode estar em branco.") @Size(min = 3, max = 100, message = "O nome deve possuir de 3 a 100 caracteres") String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public @NotNull(message = "O valor não pode ser nulo.") @DecimalMin(value = "10.00", message = "O valor mínimo é 10 reais") @DecimalMax(value = "5000.00", message = "O valor máximo é 5.000") Double getValor() {
        return valor;
    }

    public void setValor(@NotNull(message = "O valor não pode ser nulo.") @DecimalMin(value = "10.00", message = "O valor mínimo é 10 reais") @DecimalMax(value = "5000.00", message = "O valor máximo é 5.000") Double valor) {
        this.valor = valor;
    }

    public @NotNull(message = "A data não pode ser nula.") @FutureOrPresent(message = "A data de pagamento deve ser atual ou futura") LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(@NotNull(message = "A data não pode ser nula.") @FutureOrPresent(message = "A data de pagamento deve ser atual ou futura") LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public @NotBlank(message = "O email não pode estar em branco.") @Email(message = "O email deve ser válido") String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(@NotBlank(message = "O email não pode estar em branco.") @Email(message = "O email deve ser válido") String emailContato) {
        this.emailContato = emailContato;
    }
}
