package alumno;

import modelo.AlumnoModelo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("alumno")
@Produces(value = {MediaType.APPLICATION_JSON})
public class AlumnoServicio {


    @GET
    @Path("/detalleAlumno")
    public AlumnoModelo buscaAlumno(@QueryParam("id") Integer id) {
        return getAlumno(id);
    }

    @GET
    public List<AlumnoModelo> buscaAlumnoList(){

        List<AlumnoModelo> alumnoModeloList = creaAlumnoModeloList();

        return alumnoModeloList;
    }

    @POST
    @Path("/agrega")
    public void agregar(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido, @QueryParam("id") Integer id){
        AlumnoModelo alumnoModelo = new AlumnoModelo(nombre,apellido,id);
        insertAlumno(alumnoModelo);
    }

    @PUT
    @Path("/edita")
    public void actualiza(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido, @QueryParam("id") Integer id){
        setAlumnoList(nombre, apellido, id);
    }

    @DELETE
    @Path("/elimina")
    public void elimina(@QueryParam("id") Integer id){
        deleteAlumno(id);
    }


    public List<AlumnoModelo> creaAlumnoModeloList(){
        List<AlumnoModelo> alumnoModeloList = new ArrayList<>();
        AlumnoModelo juan = new AlumnoModelo("Juan", "Lopez", 1);
        AlumnoModelo mauricio = new AlumnoModelo("Mauricio", "Garcia", 2);
        AlumnoModelo guillermo = new AlumnoModelo("Guillermo", "Cuahuey", 3);
        AlumnoModelo antonio = new AlumnoModelo("Antonio", "Balerdi", 4);

        alumnoModeloList.add(juan);
        alumnoModeloList.add(mauricio);
        alumnoModeloList.add(guillermo);
        alumnoModeloList.add(antonio);
        System.out.println(alumnoModeloList.toString());
        return alumnoModeloList;
    }

    public List<AlumnoModelo> getAlumnoModeloList(){
        List<AlumnoModelo> alumnoModeloList = creaAlumnoModeloList();
        System.out.println(alumnoModeloList.toString());
        return alumnoModeloList;
    }

    public void setAlumnoList(String nombre, String apellido, Integer id){
        List<AlumnoModelo> alumnoModeloList = creaAlumnoModeloList();
        AlumnoModelo alumnoModelo = new AlumnoModelo(nombre, apellido, id);
        for (AlumnoModelo alumnoModelo1 : alumnoModeloList){
            if (alumnoModelo1.getId().equals(id)){
                int i = alumnoModeloList.indexOf(alumnoModelo1);
                alumnoModeloList.get(i).setNombre(alumnoModelo.getNombre());
                alumnoModeloList.get(i).setApellido(alumnoModelo.getApellido());
            }
        }
        System.out.println(alumnoModeloList.toString());
    }

    public void deleteAlumno(Integer id){
        List<AlumnoModelo> alumnoModeloList = creaAlumnoModeloList();
        alumnoModeloList.removeIf(alumnoModelo -> alumnoModelo.getId().equals(id));
        System.out.println(alumnoModeloList.toString());
    }

    public void insertAlumno(AlumnoModelo alumnoModelo){
        List<AlumnoModelo> alumnoModeloList = creaAlumnoModeloList();
        alumnoModeloList.add(alumnoModelo);
        System.out.println(alumnoModeloList.toString());
    }

    public AlumnoModelo getAlumno(Integer id){
        List<AlumnoModelo> alumnoModeloList = creaAlumnoModeloList();
        AlumnoModelo alumnoModelo = new AlumnoModelo();
        for (int i = 0; i < alumnoModeloList.size(); i++) {
            if(alumnoModeloList.get(i).getId().equals(id)){
                alumnoModelo = alumnoModeloList.get(i);
                break;
            }
        }
        System.out.println(alumnoModeloList.toString());
        return alumnoModelo;
    }
}