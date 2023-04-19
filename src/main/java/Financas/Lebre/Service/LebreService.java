package Financas.Lebre.Service;

import Financas.Lebre.Model.Ativos;
import Financas.Lebre.Repository.LebreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LebreService {

    @Autowired
    private LebreRepository lebreRepository;

    public Ativos cadastrarAtivos(Ativos ativos){

        Double result;
        if(ativos.getTempInvestimento()>=0.1||ativos.getTempInvestimento()<=0.6){
        }



        return(Ativos) this.lebreRepository.save(ativos);

    }

    public List<Ativos>findAll(){
        return lebreRepository.findAll();
    }

    public Ativos save(Ativos ativos){
        return lebreRepository.save(ativos);
    }


    public boolean existsBynomeAtivo(String nomeAtivo){
        return lebreRepository.existsBynomeAtivo(nomeAtivo);
    }

    public Optional<Ativos> findById(Integer id){
        return lebreRepository.findById(id);
    }


    public void deleteById(Integer id){
        lebreRepository.deleteById(id);
    }
}
