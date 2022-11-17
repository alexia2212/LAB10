package com.example.lab10.DTOS;

public class ExpLossDTO {
    private int id_contrato;
    private float expLoss;
    private String cliente_nro_id;

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public float getExpLoss() {
        return expLoss;
    }

    public void setExpLoss(float expLoss) {
        this.expLoss = expLoss;
    }

    public String getCliente_nro_id() {
        return cliente_nro_id;
    }

    public void setCliente_nro_id(String cliente_nro_id) {
        this.cliente_nro_id = cliente_nro_id;
    }
}
