package br.com.trainning.pdv2.domain.model;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

public class Carrinho implements Cloneable, Serializable {

    private static final long serialVersionUID = -1382880549600149967L;
    private int id;
    private String idCompra;
    private int encerrada;
    private int enviada;

    public int getEncerrada() {
        return encerrada;
    }

    public void setEncerrada(int encerrada) {
        this.encerrada = encerrada;
    }

    public int getEnviada() {
        return enviada;
    }

    public void setEnviada(int enviada) {
        this.enviada = enviada;
    }

    public Carrinho () {

    }

    public Carrinho (int idIn) {

        this.id = idIn;

    }

    public int getId() {
        return this.id;
    }
    public void setId(int idIn) {
        this.id = idIn;
    }

    public String getIdCompra() {
        return this.idCompra;
    }
    public void setIdCompra(String idCompraIn) {
        this.idCompra = idCompraIn;
    }

    public void setAll(int idIn,
                       String idCompraIn) {
        this.id = idIn;
        this.idCompra = idCompraIn;
    }

    public boolean hasEqualMapping(Carrinho valueObject) {

        if (valueObject.getId() != this.id) {
            return(false);
        }
        if (this.idCompra == null) {
            if (valueObject.getIdCompra() != null)
                return(false);
        } else if (!this.idCompra.equals(valueObject.getIdCompra())) {
            return(false);
        }

        return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("\nclass Compra, mapping to table compra\n");
        out.append("Persistent attributes: \n");
        out.append("id = " + this.id + "\n");
        out.append("idCompra = " + this.idCompra + "\n");
        return out.toString();
    }

    public Object clone() {
        Carrinho cloned = new Carrinho();

        cloned.setId(this.id);
        if (this.idCompra != null)
            cloned.setIdCompra(new String(this.idCompra));
        return cloned;
    }
}