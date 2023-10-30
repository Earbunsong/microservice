package co.song.employeeservice.serviceimpl;

import co.song.employeeservice.dto.ApiRespone;
import co.song.employeeservice.dto.DepartmentDto;
import co.song.employeeservice.dto.EmployeeDto;
import co.song.employeeservice.dto.OrganizationDto;
import co.song.employeeservice.entity.Employee;
import co.song.employeeservice.mapper.EmployeeMapper;
import co.song.employeeservice.repo.EmployeeRepo;
import co.song.employeeservice.service.ApiClient;
import co.song.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
//    private final RestTemplate restTemplate;
   private WebClient webClient;
    private ApiClient apiClient;
   @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

       Employee saveDEmployee = employeeRepo.save(employee);

       EmployeeDto saveDEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return saveDEmployeeDto;
    }

    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
//    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiRespone getEmployeeById(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).get();

//       ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/depatments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);

//       DepartmentDto departmentDto = responseEntity.getBody();

       DepartmentDto departmentDto1 = webClient.get()
                .uri("http://localhost:8080/api/depatments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();


//        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();


        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setEmployee(employeeDto);
        apiRespone.setDepartment(departmentDto1);
        apiRespone.setOrganization(organizationDto);

        return apiRespone;
    }
    public ApiRespone getDefaultDepartment(Long employeeId, Exception exception){
        Employee employee = employeeRepo.findById(employeeId).get();

        DepartmentDto departmentDto = new DepartmentDto();
//        departmentDto.setId(employee.getId());
        departmentDto.setDepartmentName("S&P Department");
        departmentDto.setDepartmentCode("ST10");
        departmentDto.setDepartmentDescription("SETEC Universitsity");


        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setEmployee(employeeDto);
        apiRespone.setDepartment(departmentDto);
        return apiRespone;
    }
}
