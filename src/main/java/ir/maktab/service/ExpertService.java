package ir.maktab.service;

import ir.maktab.entity.Customer;
import ir.maktab.entity.Expert;
import ir.maktab.repository.CustomerRepository;
import ir.maktab.repository.ExpertRepository;

public class ExpertService {

    private final ExpertRepository expertRepository = ExpertRepository.getInstance();

    public void addExpert(Expert expert) {
        expertRepository.save(expert);
    }
}
