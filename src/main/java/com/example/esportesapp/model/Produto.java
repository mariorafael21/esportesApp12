package com.example.esportesapp.model;

import com.example.esportesapp.message.Mensagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUri;
    private Date deleted = null;
    @Size(min = 1, message = Mensagem.ERRO_TAMANHO)
    private String nome;
    @Size(min = 1, message = Mensagem.ERRO_TAMANHO)
    private String cor;
    @Size(min = 1, message = Mensagem.ERRO_TAMANHO)
    String marca;
    private Integer tamanho;
    @Size(min = 1, message = Mensagem.ERRO_TAMANHO)
    private String genero;

}
