package co.song.organizationservice.repo;

import co.song.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String organizationCode);
}
