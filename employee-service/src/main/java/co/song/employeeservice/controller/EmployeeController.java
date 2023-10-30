package co.song.employeeservice.controller;

import co.song.employeeservice.dto.ApiRespone;
import co.song.employeeservice.dto.EmployeeDto;
import co.song.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    // build Save Employee REST controller
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiRespone> getEmployee(@PathVariable("id") Long employeeId){
        ApiRespone apiRespone = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiRespone, HttpStatus.OK);
    }
}
