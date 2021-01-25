package com.company.controller;

import com.company.dto.ErroDTO;
import com.company.dto.FuncionarioDTO;
import com.company.dto.ListaFuncionarioDTO;
import com.company.service.FuncionariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class FuncionariosController {
    @RequestMapping(value = "/funcionarios", // caminho url para testes
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    //metodo para mostrar lista de funcionarios
    public ResponseEntity<Object> getFuncionarios() {
        try {
            //DTO acede ao servico FuncionariosService e chama o metodo getFuncionarios()
            ListaFuncionarioDTO listaFuncionarioDTO = FuncionariosService.getFuncionarios();
            if (listaFuncionarioDTO != null) {
                return new ResponseEntity<>(listaFuncionarioDTO, HttpStatus.OK);
            } else {
                //se a lista dos func estiver vazia retorna NO_CONTENT no pedido http
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }



    @RequestMapping(value = "/funcionarios/{id}", //{} --> path variable
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    //Metodo para mostrar funcionario especifico
    public ResponseEntity<Object> getFuncionario(@PathVariable("id") int nr
                                                            //int nr é o correspondente à pathVariable "id"
                                                                    ) {
        try {
            //DTO acede ao servico e chama o metodo para aceder ao funcionario pedido
            FuncionarioDTO funcionarioDTO = FuncionariosService.getFuncionario(nr);
            if (funcionarioDTO != null) {
                return new ResponseEntity<>(funcionarioDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }


    @RequestMapping(value = "/funcionarios",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
            //e um POST, tem de passar a informacao que quer postar, neste caso do funcionario
    public ResponseEntity<Object> addFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        try {
            FuncionariosService.addFuncionario(funcionarioDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }


    @RequestMapping(value = "/funcionarios/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateFuncionario(@PathVariable("id") int nr, @RequestBody FuncionarioDTO
            funcionarioDTO) {
        try {
            FuncionariosService.updateFuncionario(nr, funcionarioDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }


    //posso dar o nome que quiser a pathvariable, o importante e fazer a ligacao entre ela e ao q corresponde
    @RequestMapping(value = "/funcionarios/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeFuncionario(@PathVariable("id") int nr) {
        try {
            FuncionariosService.removeFuncionario(nr);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}