package com.developer.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tb_contas_receber")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class ContaReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String descricao;

    @Column(name = "valor_receber")
    Double valorReceber;

    @Column(name = "data_vencimento")
    Date dataVencimento;

    @Column(name = "data_recebimento")
    LocalDateTime dataRecebimento;

    @Column(name = "valor_recebido")
    Double valorRecebido;

}
