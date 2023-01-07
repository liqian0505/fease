package info.nemoworks.fease.repository.mysql;

import info.nemoworks.fease.repository.mysql.model.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractEntityRepository extends JpaRepository<ContractEntity, Long> {
}
