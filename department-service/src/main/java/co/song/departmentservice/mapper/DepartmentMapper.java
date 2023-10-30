package co.song.departmentservice.mapper;

import co.song.departmentservice.dto.DepartmentDto;
import co.song.departmentservice.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
              department.getId(),
              department.getDepartmentName(),
              department.getDepartmentDescription(),
              department.getDepartmentCode()
        );
        return departmentDto;
    }
    public static  Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
               departmentDto.getId(),
               departmentDto.getDepartmentDescription(),
               departmentDto.getDepartmentCode(),
               departmentDto.getDepartmentName()
        );
        return department;
    }
}
