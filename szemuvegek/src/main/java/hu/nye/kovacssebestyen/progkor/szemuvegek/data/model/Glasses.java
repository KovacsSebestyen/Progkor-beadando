package hu.nye.kovacssebestyen.progkor.szemuvegek.data.model;

import java.util.Objects;

public class Glasses {

    private Long id;
    private String brand;
    private String color;
    private Double diopter;
    private String layer;
    private Integer orderDate;
    private FrameType frameType;

    public Glasses() {
    }

    public Glasses(Long id, String brand, String color, Double diopter, String layer, Integer orderDate, FrameType frameType) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.diopter = diopter;
        this.layer = layer;
        this.orderDate = orderDate;
        this.frameType = frameType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getDiopter() {
        return diopter;
    }

    public void setDiopter(Double diopter) {
        this.diopter = diopter;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public Integer getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Integer orderDate) {
        this.orderDate = orderDate;
    }

    public FrameType getFrameType() {
        return frameType;
    }

    public void setFrameType(FrameType frameType) {
        this.frameType = frameType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glasses glasses = (Glasses) o;
        return Objects.equals(id, glasses.id) && Objects.equals(brand, glasses.brand) && Objects.equals(color, glasses.color) && Objects.equals(diopter, glasses.diopter) && Objects.equals(layer, glasses.layer) && Objects.equals(orderDate, glasses.orderDate) && frameType == glasses.frameType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, color, diopter, layer, orderDate, frameType);
    }

    @Override
    public String toString() {
        return "Glasses{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", diopter=" + diopter +
                ", layer='" + layer + '\'' +
                ", orderDate=" + orderDate +
                ", frameType=" + frameType +
                '}';
    }
}
