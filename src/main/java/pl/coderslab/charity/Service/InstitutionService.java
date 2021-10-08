package pl.coderslab.charity.Service;

import org.springframework.context.annotation.Configuration;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Configuration
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> institutionList(){
        List<Institution> all = institutionRepository.findAll();
        return all;

    }
}
