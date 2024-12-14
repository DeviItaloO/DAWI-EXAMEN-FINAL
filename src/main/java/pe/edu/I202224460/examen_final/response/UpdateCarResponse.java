package pe.edu.I202224460.examen_final.response;

public class UpdateCarResponse extends PadreResponse<Boolean> {
    public UpdateCarResponse(String code, String message, Boolean success) {
        super(code, message, success);
    }
}
