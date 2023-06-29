package com.scalab.proyectofinal.service.impl;

import com.scalab.proyectofinal.enums.Msg;
import com.scalab.proyectofinal.model.dto.UsuarioRequest;
import com.scalab.proyectofinal.model.dto.UsuarioResponse;
import com.scalab.proyectofinal.model.entity.Usuario;
import com.scalab.proyectofinal.model.repository.UsuarioRepository;
import com.scalab.proyectofinal.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUsuarioService {

    private final static String INACTIVO = "INACTIVO";
    private final static String ACTIVO = "ACTIVO";
    UsuarioRepository usuarioRepository;

    public UserServiceImpl(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository;}

    /**
     * Metodo para insertar usuarios nuevo en BD con validacion de correo.
     * @param request
     * @return
     */
    @Override
    public UsuarioResponse insertUsuario(UsuarioRequest request){
            if (!usuarioRepository.existsByMail(request.getCorreo())) {
                Date fechaCreate = new Date();
                Usuario usuario = UsuarioRequest.mapToEntity(request);
                usuario.setCreated(fechaCreate);
                usuario.setIsactive(INACTIVO);

                Usuario creado = (usuarioRepository.save(usuario));
                return new UsuarioResponse.Builder()
                        .usuario(creado)
                        .status(HttpStatus.CREATED.value())
                        .message(Msg.MSG_CREATE_USUARIO.getMensaje())
                        .build();
            }
        return new UsuarioResponse.Builder()
                .status(HttpStatus.CONFLICT.value())
                .message(Msg.MSG_MAIL_YA_REGISTRADO.getMensaje())
                .build();
    }

    @Override
    public UsuarioResponse updateUsuario(UUID id, UsuarioRequest request) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            Date fechaUpdate = new Date();
            Usuario usuariobd = usuario.get();

            usuariobd.setNombre(request.getNombre());
            usuariobd.setPassword(request.getPassword());
            usuariobd.setModified(fechaUpdate);
            usuariobd.setTelefonos(request.getTelefonos());

            usuarioRepository.save(usuariobd);

            return new UsuarioResponse.Builder()
                    .id(id)
                    .usuario(usuariobd)
                    .status(HttpStatus.OK.value())
                    .message(Msg.MSG_USUARIO_ACTUALIZADO.getMensaje())
                    .build();
       }
        return new UsuarioResponse.Builder()
                .id(id)
                .status(HttpStatus.CONFLICT.value())
                .message(Msg.MSG_USUARIO_NO_EXISTE_EN_BD.getMensaje())
                .build();
    }

    @Override
    public UsuarioResponse activaUsuario(UUID id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Date fechaupdate = new Date();
        if (usuario.isPresent()){
            Usuario usuarioActiv = usuario.get();
            if (!usuarioActiv.getIsactive().equalsIgnoreCase(ACTIVO)){
                usuarioActiv.setIsactive(ACTIVO);
                usuarioActiv.setModified(fechaupdate);
                usuarioRepository.save(usuarioActiv);

                return new UsuarioResponse.Builder()
                        .id(id)
                        .usuario(usuarioActiv)
                        .status(HttpStatus.OK.value())
                        .message(Msg.MSG_USUARIO_ACTIVO_OK.getMensaje())
                        .build();
            }
            return new UsuarioResponse.Builder()
                    .id(id)
                    .status(HttpStatus.CONFLICT.value())
                    .message(Msg.MSG_USUARIO_ACTIVO.getMensaje())
                    .build();
        }
        return new UsuarioResponse.Builder()
                .id(id)
                .status(HttpStatus.NOT_FOUND.value())
                .message(Msg.MSG_USUARIO_NO_EXISTE_EN_BD.getMensaje())
                .build();
    }


    /**
     * Motodo que lista todos los Usuarios de la BD.
     * @return
     */
    @Override
    public List<Usuario> getUsers() {
        List<Usuario> userList = usuarioRepository.findAll();
        return userList;
    }

    @Override
    public UsuarioResponse getUserById(UUID id) {
        Optional<Usuario> usuariobyId = usuarioRepository.findById(id);
        if(!usuariobyId.isEmpty()){
            Usuario usuario = usuariobyId.get();
            return new UsuarioResponse.Builder()
                    .id(id)
                    .usuario(usuario)
                    .status(HttpStatus.OK.value())
                    .message(HttpStatus.OK.name())
                    .build();
        }
        return new UsuarioResponse.Builder()
                .id(id)
                .status(HttpStatus.NOT_FOUND.value())
                .message(Msg.MSG_USUARIO_NO_EXISTE_EN_BD.getMensaje())
                .build();
    }

    @Override
    public UsuarioResponse deleteUsuario(UUID id) {
        Optional<Usuario> usuarioDelete = usuarioRepository.findById(id);
        if (usuarioDelete.isPresent()){
            usuarioRepository.deleteById(id);

            return new UsuarioResponse.Builder()
                    .id(id)
                    .status(HttpStatus.OK.value())
                    .message(Msg.MSG_USUARIO_ELIMINADO.getMensaje())
                    .build();
        }
        return new UsuarioResponse.Builder()
                .id(id)
                .status(HttpStatus.NOT_FOUND.value())
                .message(Msg.MSG_USUARIO_NO_EXISTE_EN_BD.getMensaje())
                .build();
    }
}
