package com.scalab.proyectofinal.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "telefonos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Telefonos{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "numero")
    private int numero;
    @Column(name = "cod_ciudad")
    private int cod_ciudad;
    @Column(name = "cod_pais")
    private int cod_pais;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Telefonos{");
        sb.append("id=").append(id);
        sb.append(", numero=").append(numero);
        sb.append(", cod_ciudad=").append(cod_ciudad);
        sb.append(", cod_pais=").append(cod_pais);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefonos telefonos = (Telefonos) o;
        return numero == telefonos.numero
                && cod_ciudad == telefonos.cod_ciudad
                && cod_pais == telefonos.cod_pais
                && Objects.equals(id, telefonos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, cod_ciudad, cod_pais);
    }
}
