package com.BusinessIntranet.BusinessIntranet.CalendarEvent;

import javax.persistence.*;

@Entity
public class CalendarEventColor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,unique = true)
    private Long id;
    private String colorName;
    private String primaryColor; // HEX code
    private String secondaryColor; // HEX code

    public CalendarEventColor() {
    }

    public CalendarEventColor(String colorName, String primaryColor, String secondaryColor) {
        this.colorName = colorName;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public Long getId() {
        return id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }
}
