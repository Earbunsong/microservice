package co.song.organizationservice.mapper;

import co.song.organizationservice.dto.OrganizationDto;
import co.song.organizationservice.entity.Organization;

public class OrganizationMapper {
    public static  OrganizationDto mapToOrganizationDto(Organization organization){
        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreateDate()
        );

        return organizationDto;
    }
    public static  Organization mapToOrganization(OrganizationDto organizationDto){
        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreateDate()
        );

        return organization;
    }
}
