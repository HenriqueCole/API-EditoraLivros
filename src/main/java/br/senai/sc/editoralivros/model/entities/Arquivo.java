package br.senai.sc.editoralivros.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_arquivos")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor()
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String tipo;

    @NonNull
    @Lob
    private byte[] dados;

}
