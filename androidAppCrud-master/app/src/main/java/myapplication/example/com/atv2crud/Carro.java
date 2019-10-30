package myapplication.example.com.atv2crud;

import java.io.Serializable;

public class Carro implements Serializable {
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private String ano;

    public Carro(String placa, String marca, String modelo, String ano) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Carro(int id, String marca, String modelo, String placa, String ano) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return marca + " " + modelo;
    }

    public String retornaDados() {
        return "ID: " + id + "\n" +
                "MARCA: " + marca + "\n" +
                "MODELO: " + modelo + "\n" +
                "PLACA: " + placa + "\n" +
                "ANO: " + ano;
    }
}
