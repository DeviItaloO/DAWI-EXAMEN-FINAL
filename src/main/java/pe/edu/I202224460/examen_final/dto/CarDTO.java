package pe.edu.I202224460.examen_final.dto;

public record CarDTO(
    Integer carId,
    String model,
    Integer year,
    Integer mileage,
    String color
) {
}
