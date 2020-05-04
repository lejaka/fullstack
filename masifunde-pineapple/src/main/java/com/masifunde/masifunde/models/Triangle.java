package com.masifunde.masifunde.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Triangle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int triangleId;
    private int rowsToPrint;
    private String symbolToPrint;
    private String nameOfShape;
    private LocalDateTime createdDate;
    private int user_id;


    public int getTriangleId() {
        return triangleId;
    }

    public void setTriangleId(int triangleId) {
        this.triangleId = triangleId;
    }

    public int getRowsToPrint() {
        return rowsToPrint;
    }

    public void setRowsToPrint(int rowsToPrint) {
        this.rowsToPrint = rowsToPrint;
    }

    public String getSymbolToPrint() {
        return symbolToPrint;
    }

    public void setSymbolToPrint(String symbolToPrint) {
        this.symbolToPrint = symbolToPrint;
    }

    public String getNameOfShape() {
        return nameOfShape;
    }

    public void setNameOfShape(String nameOfShape) {
        this.nameOfShape = nameOfShape;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = LocalDateTime.now();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
