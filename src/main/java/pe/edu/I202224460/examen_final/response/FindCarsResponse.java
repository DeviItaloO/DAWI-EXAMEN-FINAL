package pe.edu.I202224460.examen_final.response;

import pe.edu.I202224460.examen_final.dto.CarDTO;

import java.util.List;

public class FindCarsResponse extends PadreResponse<List<CarDTO>> {
    public FindCarsResponse( String code, String message, List<CarDTO> cars) {
        super(code, message, cars);
    }
}
