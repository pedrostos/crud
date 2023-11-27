package nube.crudiphone.controllers;

import nube.crudiphone.iphone.*;
import nube.crudiphone.iphone.DadosIphone;
import nube.crudiphone.iphone.Iphone;
import nube.crudiphone.iphone.IphoneRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class IphoneController {

    @Autowired
    private IphoneRepositorio repositorio;

    @PostMapping
    @Transactional
    public void post(@RequestBody DadosIphone dados){
        repositorio.save(new Iphone(dados));
    }

    @GetMapping
    public List<Iphone> lista() {
        return repositorio.findAll();
    }

    @PutMapping
    @Transactional
    public void atualiza(@RequestBody DadosIphoneAtt dados){
        var iphone = repositorio.getReferenceById(dados.id());
        iphone.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleta(@PathVariable Long id){
        repositorio.deleteById(id);
    }
}
