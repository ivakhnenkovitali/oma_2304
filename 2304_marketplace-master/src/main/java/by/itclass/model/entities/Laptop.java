package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Laptop {
    int id;
    String vendor;
    String model;
    String cpu;
    int memorySize;
    double price;
}
