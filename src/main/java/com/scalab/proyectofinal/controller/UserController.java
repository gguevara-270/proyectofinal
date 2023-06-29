package com.scalab.proyectofinal.controller;

import com.scalab.proyectofinal.model.dto.UsuarioRequest;
import com.scalab.proyectofinal.model.dto.UsuarioResponse;
import com.scalab.proyectofinal.model.entity.Usuario;
import com.scalab.proyectofinal.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/usuario")
public class UserController {

    IUsuarioService usuarioService;

    public UserController(IUsuarioService usuarioService) {this.usuarioService = usuarioService;}


    /**
     * Metodo Inserta usuarios con estado Inactivo
     * @param request
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> insertUsuario(@RequestBody UsuarioRequest request){

            UsuarioResponse response = usuarioService.insertUsuario(request);
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));

    }

    /**
     * Listamos todos los Usuarios insertos en BD.
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Usuario>> getUsers() {
        List<Usuario> usuarioList = usuarioService.getUsers();
        if (usuarioList.size() > 0) {
            return new ResponseEntity<>(usuarioList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Listamos todos los Usuarios insertos en BD.
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getUserById(@PathVariable("id") UUID id) {
        UsuarioResponse usuario = usuarioService.getUserById(id);
        return new ResponseEntity<>(usuario, HttpStatusCode.valueOf(usuario.getStatus()));
    }


    /**
     * Metodo Actualizar usuario con estado Inactivo
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> updateUsuario(@PathVariable("id") UUID id, @RequestBody UsuarioRequest request){

        UsuarioResponse response = usuarioService.updateUsuario(id, request);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));

    }

    /**
     * Metodo Actualizar usuario con estado Inactivo
     * @param id
     * @return
     */
    @RequestMapping(value = "/activausuario/{id}", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> activaUsuario(@PathVariable("id") UUID id){

        UsuarioResponse response = usuarioService.activaUsuario(id);
        return new ResponseEntity<>(response,  HttpStatusCode.valueOf(response.getStatus()));

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") UUID id){

        UsuarioResponse response = usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));

    }

}
