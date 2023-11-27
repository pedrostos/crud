package nube.crudiphone.iphone;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "iphone")
@Entity(name = "Iphone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Iphone {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String cor;
    private Double preco;

    public Iphone(DadosIphone dados) {
        this.modelo = dados.modelo();
        this.cor = dados.cor();
        this.preco = dados.preco();
    }

    public void atualizarInformacoes(DadosIphoneAtt dados) {
        if(dados.modelo() != null){
            this.modelo = dados.modelo();
        }
        if(dados.cor() != null){
            this.cor = dados.cor();
        }
        if(dados.preco() != null){
            this.preco = dados.preco();
        }
    }
}