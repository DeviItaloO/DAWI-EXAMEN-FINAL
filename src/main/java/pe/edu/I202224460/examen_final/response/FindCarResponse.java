package pe.edu.I202224460.examen_final.response;

import pe.edu.I202224460.examen_final.dto.CarDetailDTO;

public class FindCarResponse extends PadreResponse<CarDetailDTO>{
    public FindCarResponse(String code, String message, CarDetailDTO car) {
        super(code, message, car);
    }
}
