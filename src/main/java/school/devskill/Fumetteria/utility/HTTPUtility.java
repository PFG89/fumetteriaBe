package school.devskill.Fumetteria.utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HTTPUtility {
    public static final String CREATE = "/create";
    public static final String GETALL = "/items"; //per list DTO
    public static final String GET = "/get"; //per DTO
    public static final String DELETE = "/delete/{id}";
    public static final String UPDATE = "/update/{id}";
}
