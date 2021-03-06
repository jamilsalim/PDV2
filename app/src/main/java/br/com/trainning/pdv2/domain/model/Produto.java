package br.com.trainning.pdv2.domain.model;

import com.google.gson.annotations.SerializedName;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

/**
 * Created by android on 05/03/2016.
 */
@Table("Produto")
public class Produto extends Model {

    @Key
    @Column("id")
    @AutoIncrement
    private long id;
    @Column("Descricao")
    private String descricao;
    @Column("Unidade")
    private String unidade;
    @Column("CodigoBarra")
    private String codigoBarras;
    @Column("Preco")
    private double preco;
    @Column("Foto")
    private String foto;
    @Column("Latitude")
    private double latitude;
    @Column("Longitude")
    private double longitude;
    @Column("Status")
    @SerializedName("ativo")
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
