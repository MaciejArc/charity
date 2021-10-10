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

    public Institution addNewInstitution(Institution institution){
        return institutionRepository.save(institution);

    }
    public Institution findInstitutionById(Long id){
        return institutionRepository.findById(id).get();
    }

    public void deteteInstitution(Institution institution){
        institutionRepository.delete(institution);
    }
}
