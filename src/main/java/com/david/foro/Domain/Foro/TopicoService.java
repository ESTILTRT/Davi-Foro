package com.david.foro.Domain.Foro;

import com.david.foro.Domain.Curso.CursoRepository;
import com.david.foro.Domain.Foro.DTOs.DatosDetalleTopico;
import com.david.foro.Domain.Foro.DTOs.DatosModificarTopico;
import com.david.foro.Domain.Foro.DTOs.DatosRegistroTopicos;
import com.david.foro.Domain.Foro.ReglasDeNegocio.Reglas;
import com.david.foro.Domain.Usuario.UsuariosRepository;
import com.david.foro.Infra.Errors.Excepciones.ReglasException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private List<Reglas> reglas;

    public DatosDetalleTopico registrarTopicos(DatosRegistroTopicos datos) {
        reglas.forEach(r -> r.validar(datos));
        var autor = usuariosRepository.getReferenceById(datos.usuario());
        var curso = cursoRepository.getReferenceById(datos.curso());
        Topico topico = new Topico(datos, autor, curso);
        repository.save(topico);
        return new DatosDetalleTopico(topico);
    }

    public Page<DatosDetalleTopico> listadoTopicos(Pageable paginacion, String nombreCurso) {
        Page<DatosDetalleTopico> detallesTopico;
        if (nombreCurso != null){
            detallesTopico = repository.findByCursoContainsIgnoreCase(nombreCurso, paginacion)
                    .map(DatosDetalleTopico::new);
        }
        else {
            detallesTopico = repository.findAll(paginacion).map(DatosDetalleTopico::new);
        }
        return detallesTopico;
    }

    public DatosDetalleTopico mostrarTopico(Long id) {
        boolean exiteTopico = repository.existsById(id);
        if(!exiteTopico){
            throw new ReglasException("El topico introducido no existe...");
        }
        Topico topico = repository.getReferenceById(id);
        return new DatosDetalleTopico(topico);
    }

    public DatosDetalleTopico modificarTopico(Long id, DatosModificarTopico datos) {
        if(!repository.existsById(id)){
            throw new ReglasException("El topico introducido no existe...");
        }
        Topico modificado = repository.getReferenceById(id);
        modificado.modificarTopico(datos);

        return new DatosDetalleTopico(modificado);
    }

    public void eliminarTopico(Long id) {
        if(!repository.existsById(id)){
            throw new ReglasException("El topico introducido no existe...");
        }
        repository.deleteById(id);
    }
}
