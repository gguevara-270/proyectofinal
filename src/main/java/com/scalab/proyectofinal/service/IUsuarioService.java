package com.scalab.proyectofinal.service;

import com.scalab.proyectofinal.model.dto.UsuarioRequest;
import com.scalab.proyectofinal.model.dto.UsuarioResponse;
import com.scalab.proyectofinal.model.entity.Usuario;

import java.util.List;
import java.util.UUID;

public interface IUsuarioService {

    UsuarioResponse insertUsuario(UsuarioRequest request);
    UsuarioResponse updateUsuario(UUID id, UsuarioRequest request);
    UsuarioResponse activaUsuario(UUID id);
    List<Usuario> getUsers();

    UsuarioResponse getUserById(UUID id);

    UsuarioResponse deleteUsuario(UUID id);
}
