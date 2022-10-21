package Project.Worker.Repository;

import Project.Repository.Repository;
import Project.Worker.Entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface CompanyRepository extends JpaRepository<Company, String> {


}
