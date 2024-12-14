package pe.edu.I202224460.examen_final.response;

public class CreateCarResponse extends PadreResponse<Boolean> {
    public CreateCarResponse(String code, String message, Boolean success) {
        super(code, message, success);
    }
}
