package Financas.Lebre.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="ativos")
public class Ativos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false, length = 255)
    private Integer valorAtivoFinal;

    @Column(nullable = false, length = 40)
    private Double tempInvestimento;

    @Column(nullable = false, length = 255)
    private Integer perdaValorAtivo;

    @Column(nullable = false, length = 255)
    private Integer valorAtivo;

    @Column(nullable = false, length = 15)
    private String nomeAtivo;

    @Column(nullable = false, length = 40)
    private LocalDate data;

    //Constructor


    public Ativos() {
    }

    public Ativos(Integer id) {
        this.id = id;
    }

    //Getters and Setters


    public Double getTempInvestimento() {
        return tempInvestimento;
    }

    public void setTempInvestimento(Double tempInvestimento) {
        this.tempInvestimento = tempInvestimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValorAtivoFinal() {
        return valorAtivoFinal;
    }

    public void setValorAtivoFinal(Integer valorAtivoFinal) {
        this.valorAtivoFinal = valorAtivoFinal;
    }

    public Integer getPerdaValorAtivo() {
        return perdaValorAtivo;
    }

    public void setPerdaValorAtivo(Integer perdaValorAtivo) {
        this.perdaValorAtivo = perdaValorAtivo;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
