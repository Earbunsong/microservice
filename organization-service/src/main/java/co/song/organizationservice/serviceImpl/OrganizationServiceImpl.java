package co.song.organizationservice.serviceImpl;

import co.song.organizationservice.dto.OrganizationDto;
import co.song.organizationservice.entity.Organization;
import co.song.organizationservice.mapper.OrganizationMapper;
import co.song.organizationservice.repo.OrganizationRepo;
import co.song.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepo organizationRepo;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        //Covert OrganizationDto to Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepo.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepo.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
