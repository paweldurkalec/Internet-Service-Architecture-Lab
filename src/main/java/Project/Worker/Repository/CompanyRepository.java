package Project.Worker.Repository;

import Project.DataStorage.DataStorage;
import Project.Repository.Repository;
import Project.Worker.Entity.Company;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class CompanyRepository implements Repository<Company, String> {
    private DataStorage data_storage;

    @Autowired
    public CompanyRepository(DataStorage s){
        this.data_storage = s;
    }

    @Override
    public Optional<Company> find(String name) {
        return data_storage.companies.stream().filter(company -> company.name.equals(name)).findFirst();
    }

    @Override
    public HashSet<Company> findAll() {
        return data_storage.companies;
    }

    @Override
    public void create(Company c) {
        data_storage.companies.add(c);
    }

    @Override
    public void delete(Company c) {data_storage.companies.remove(c);}


}
