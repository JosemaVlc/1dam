/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.*;

/**
 *
 * @author jmore
 */
public class Productos {    
    private String CODIGO_ARTICULO;
    private String SECCION;
    private String NOMBRE;
    private double PRECIO;
    private String PAIS;
    private Date FECHA;
    
    public Productos(String CODIGO_ARTICULO, String SECCION, String NOMBRE, double PRECIO, String PAIS, Date FECHA) {
        this.CODIGO_ARTICULO = CODIGO_ARTICULO;
        this.SECCION = SECCION;
        this.NOMBRE = NOMBRE;
        this.PRECIO = PRECIO;
        this.PAIS = PAIS;
        this.FECHA = FECHA; 
    }

    public String getCODIGO_ARTICULO() {
        return CODIGO_ARTICULO;
    }

    public void setCODIGO_ARTICULO(String CODIGO_ARTICULO) {
        this.CODIGO_ARTICULO = CODIGO_ARTICULO;
    }

    public String getSECCION() {
        return SECCION;
    }

    public void setSECCION(String SECCION) {
        this.SECCION = SECCION;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public double getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(double PRECIO) {
        this.PRECIO = PRECIO;
    }

    public String getPAIS() {
        return PAIS;
    }

    public void setPAIS(String PAIS) {
        this.PAIS = PAIS;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }
}
