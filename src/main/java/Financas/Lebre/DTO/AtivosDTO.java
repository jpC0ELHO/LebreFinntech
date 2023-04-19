package Financas.Lebre.DTO;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;


public class AtivosDTO {


    @NotBlank
    private Double tempInvestimento;

    @NotBlank
    private Integer perdaValorAtivo;
    @NotBlank
    private Integer valorAtivo;

    @NotBlank
    private String nomeAtivo;


    //Getters and Setters


    public Integer getPerdaValorAtivo() {
        return perdaValorAtivo;
    }

    public void setPerdaValorAtivo(Integer perdaValorAtivo) {
        this.perdaValorAtivo = perdaValorAtivo;
    }

    public Double getTempInvestimento() {
        return tempInvestimento;
    }

    public void setTempInvestimento(Double tempInvestimento) {
        this.tempInvestimento = tempInvestimento;
    }



    public Integer getValorAtivo() {
        return valorAtivo;
    }

    public void setValorAtivo(Integer valorAtivo) {
        this.valorAtivo = valorAtivo;
    }

    public String getNomeAtivo() {
        return nomeAtivo;
    }

    public void setNomeAtivo(String nomeAtivo) {
        this.nomeAtivo = nomeAtivo;
    }
}
