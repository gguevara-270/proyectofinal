package com.scalab.proyectofinal.enums;

public enum Msg {

    MSG_CREATE_USUARIO("Usuario Creado"),
    MSG_USUARIO_ACTIVO("Usuario ya se encuentra activo"),
    MSG_USUARIO_ACTIVO_OK("Usuario fue activado"),
    MSG_USUARIO_NO_ACTUALIZADO("No se puedo actualizar el usuario"),
    MSG_USUARIO_NO_EXISTE_EN_BD("Usuario No se encuentra en BD"),
    MSG_USUARIO_ACTUALIZADO("Usuario fue actualizado"),
    MSG_USUARIO_ELIMINADO("Usuario fue eliminado"),
    MSG_MAIL_YA_REGISTRADO("El mail ya fue registrado");

    private String mensaje;
    Msg(String mensaje){
        this.mensaje = mensaje;
    }
    public String getMensaje() {return mensaje;}
}
