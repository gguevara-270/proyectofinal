package com.scalab.proyectofinal.model.dto;

import com.scalab.proyectofinal.enums.Msg;
import com.scalab.proyectofinal.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private UUID id;
    private Usuario usuario;
    private int status;
    private String message;

    public static UsuarioResponse mapToDto(Usuario respList) {
        UsuarioResponse resp = new UsuarioResponse();
        resp.setUsuario(respList);
        resp.setMessage(Msg.MSG_CREATE_USUARIO.getMensaje());
        return resp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsuarioResponse{");
        sb.append("id=").append(id);
        sb.append(", usuario=").append(usuario);
        sb.append(", status=").append(status);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioResponse that = (UsuarioResponse) o;
        return status == that.status
                && Objects.equals(id, that.id)
                && Objects.equals(usuario, that.usuario)
                && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, status, message);
    }

    public static final class Builder {
        private UUID id;
        private Usuario usuario;
        private int status;
        private String message;

        public Builder() {
        }

        public static Builder anUsuarioResponse() {return new Builder();}

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder usuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public UsuarioResponse build() {
            UsuarioResponse usuarioResponse = new UsuarioResponse();
            usuarioResponse.setId(id);
            usuarioResponse.setUsuario(usuario);
            usuarioResponse.setStatus(status);
            usuarioResponse.setMessage(message);
            return usuarioResponse;
        }
    }



}
