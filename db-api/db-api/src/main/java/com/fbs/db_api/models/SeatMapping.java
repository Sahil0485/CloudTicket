package com.fbs.db_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "seatmapping")
public class SeatMapping {

    String className;
    String range;
    int basePrice;
    int windowPrice;
    int totalWindow;
}
