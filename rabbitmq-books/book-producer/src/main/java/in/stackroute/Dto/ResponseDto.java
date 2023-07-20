package in.stackroute.Dto;

import java.io.Serializable;
import java.util.List;

public record ResponseDto(String name, List<String>bookList) implements Serializable {
}
