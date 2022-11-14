package Project.Company.Repository;

import Project.Company.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CompanyRepository extends JpaRepository<Company, String> {


}
