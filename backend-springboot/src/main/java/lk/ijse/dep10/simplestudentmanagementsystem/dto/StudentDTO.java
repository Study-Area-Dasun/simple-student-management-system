package lk.ijse.dep10.simplestudentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private int id;

    private String name;

    private String address;

    public StudentDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
