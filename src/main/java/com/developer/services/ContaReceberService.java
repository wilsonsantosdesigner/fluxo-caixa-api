package com.developer.services;

import com.developer.data.models.ContaReceber;
import com.developer.repository.ContaReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaReceberService {

    @Autowired
    private ContaReceberRepository cbRepository;

    public ContaReceber create(ContaReceber cb){
        return cbRepository.save(cb);
    }

    public ContaReceber findById(Long id){
        return cbRepository.findById(id).get();
    }

    public List<ContaReceber> findAll(){
        return cbRepository.findAll();
    }

    public ContaReceber findByDescricao(String descricao){
        return cbRepository.findByDescricao(descricao);
    }

    public ContaReceber update(ContaReceber cb){
        return cbRepository.save(cb);
    }

    public void delete(Long id){
        cbRepository.deleteById(id);
    }
}
