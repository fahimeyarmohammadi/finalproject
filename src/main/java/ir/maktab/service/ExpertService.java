package ir.maktab.service;

import ir.maktab.entity.Expert;
import ir.maktab.repository.ExpertRepository;

public class ExpertService {

    private final ExpertRepository expertRepository = ExpertRepository.getInstance();

    public void addExpert(Expert expert) {
        expertRepository.save(expert);
    }

    public void updateCustomer(Expert expert) {
        expertRepository.update(expert);
    }
}
