package pe.edu.I202224460.examen_final.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PadreResponse<T> {
    private String code;
    private String message;
    private T entity;
}
