package co.song.employeeservice.service;

import co.song.employeeservice.dto.ApiRespone;
import co.song.employeeservice.dto.EmployeeDto;


public interface EmployeeService {
   EmployeeDto saveEmployee(EmployeeDto employeeDto);

   ApiRespone getEmployeeById(Long employeeId);
}
