package com.scalab.proyectofinal.model.dto;

import com.scalab.proyectofinal.model.entity.Telefonos;
import com.scalab.proyectofinal.model.entity.Usuario;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    private String nombre;
    @Email(message = "Formato email no valido")
    private String correo;

    private String password;

    List<Telefonos> telefonos;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsuarioRequest{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", correo='").append(correo).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", telefonos=").append(telefonos);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRequest that = (UsuarioRequest) o;
        return Objects.equals(nombre, that.nombre)
                && Objects.equals(correo, that.correo)
                && Objects.equals(password, that.password)
                && Objects.equals(telefonos, that.telefonos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, correo, password, telefonos);
    }

    public static Usuario mapToEntity(UsuarioRequest request){
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setPassword(request.getPassword());
        usuario.setMail(request.getCorreo());
        usuario.setTelefonos(request.getTelefonos());
        return usuario;
    }

}
