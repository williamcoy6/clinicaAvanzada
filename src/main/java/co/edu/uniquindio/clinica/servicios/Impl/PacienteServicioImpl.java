package co.edu.uniquindio.clinica.servicios.Impl;

import co.edu.uniquindio.clinica.Repositorios.UsuarioRepo;
import co.edu.uniquindio.clinica.dto.admin.DetalleUsuarioDTO;
import co.edu.uniquindio.clinica.modelo.Usuario;

public class PacienteServicioImpl {
    @Override
    public int crearUsuario(DetalleUsuarioDTO user) throws Exception {
        Usuario buscado = UsuarioRepo.buscarUsuario(user.getCorreo());
        if (buscado!= null){
            throw new Exception("El correo "+user.getCorreo()+" ya existe!");
        }
        Usuario usuario= convertiraUsuario(user);
        usuario.setUsuario(Rol.CLIENTE);
        return usuarioRepo.save(usuario).getCodigo();
    }

    @Override
    public int actualizarUsuario(int codigoUsuario, UsuarioDTO user) throws Exception{
//        validarUsuario(codigoUsuario);
//        Optional<Usuario> buscado = usuarioRepo.findBy(codigoUsuario);
//        Usuario usuario = buscado.get(); //quiere decir que existe y lo asigna

        validarExiste(codigoUsuario);

        Usuario usuario = convertiraUsuario(user);
        usuario.setCodigo(codigoUsuario);

        return usuarioRepo.save(usuario).getCodigo();
    }

    @Override
    public int eliminarUsuario(int codigoUsuario) throws Exception{
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }
}
