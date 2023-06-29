package com.scalab.proyectofinal.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false)
    private String nombre;
    @Column(name = "correo")
    private String mail;
    @Column(nullable = false)
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Telefonos> telefonos;
    private Date created;
    private Date modified;
    @Column(name = "isactive")
    private String isactive;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id)
                && Objects.equals(nombre, usuario.nombre)
                && Objects.equals(mail, usuario.mail)
                && Objects.equals(password, usuario.password)
                && Objects.equals(telefonos, usuario.telefonos)
                && Objects.equals(created, usuario.created)
                && Objects.equals(modified, usuario.modified)
                && Objects.equals(isactive, usuario.isactive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, mail, password, telefonos, created, modified, isactive);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", correo='").append(mail).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", telefonos=").append(telefonos);
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append(", isactive='").append(isactive).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
