package pe.edu.I202224460.examen_final.response;

public class DeleteCarResponse extends PadreResponse<Boolean> {
    public DeleteCarResponse(String code, String message, Boolean success) {
        super(code, message, success);
    }
}
