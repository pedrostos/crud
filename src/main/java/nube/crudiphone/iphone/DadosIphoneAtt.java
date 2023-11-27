package nube.crudiphone.iphone;


import jakarta.validation.constraints.NotNull;

public record DadosIphoneAtt(
        @NotNull
        Long id,
        String modelo,
        String cor,
        Double preco) {
}
