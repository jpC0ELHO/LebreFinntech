package Financas.Lebre.Controller;

import Financas.Lebre.DTO.AtivosDTO;
import Financas.Lebre.Model.Ativos;
import Financas.Lebre.Service.LebreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/ativos")
public class LebreController {

    @Autowired
    private LebreService lebreService;

    @GetMapping()
    public List<Ativos>getAllAtivos(){
        return lebreService.findAll();
    }


    @PostMapping
    public ResponseEntity<Object>saveAtivo(@RequestBody AtivosDTO ativosdto){
        if(lebreService.existsBynomeAtivo(ativosdto.getNomeAtivo())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("ATIVO already existing");
        }

    var ativos= new Ativos();
        BeanUtils.copyProperties(ativosdto,ativos);
        ativos.setData(LocalDate.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(lebreService.save(ativos));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object>getAtivo(@PathVariable(value = "id") Integer id){
        Optional<Ativos>ativosOptional=lebreService.findById(id);
       if(ativosOptional.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ATIVO NOT FOUND");
       }else{

           return ResponseEntity.status(HttpStatus.OK).body(ativosOptional.get());
       }

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object>deleteAtivo(@PathVariable(value = "id") Integer id){
        Optional<Ativos>ativosOptional=lebreService.findById(id);
       if(ativosOptional.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ATIVO NOT FOUND");
       }else{

           lebreService.deleteById(id);
           return ResponseEntity.status(HttpStatus.OK).body("ATIVO DELETED SUCCESSFULLY");
       }

    } @PutMapping(value = "/{id}")
    public ResponseEntity<Object>updateAtivo(@PathVariable(value = "id") Integer id, @RequestBody AtivosDTO ativosDTO){
        Optional<Ativos>ativosOptional=lebreService.findById(id);
       if(ativosOptional.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ATIVO NOT FOUND");
       }else{
           var ativos=new Ativos();
           ativos.setNomeAtivo(ativosDTO.getNomeAtivo());
           ativos.setValorAtivo(ativosDTO.getValorAtivo());
           ativos.setPerdaValorAtivo(ativosDTO.getPerdaValorAtivo());
           ativos.setTempInvestimento(ativosDTO.getTempInvestimento());
           return ResponseEntity.status(HttpStatus.CREATED).body(lebreService.save(ativos));
       }

    }
}
