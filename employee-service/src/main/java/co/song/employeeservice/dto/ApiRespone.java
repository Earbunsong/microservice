package co.song.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiRespone {
    private EmployeeDto employee;
    private DepartmentDto department;
    private OrganizationDto organization;
}
