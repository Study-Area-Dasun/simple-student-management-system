package lk.ijse.dep10.simplestudentmanagementsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course implements SuperEntity{
    private String id;
    private String description;
    private String duration;
}
