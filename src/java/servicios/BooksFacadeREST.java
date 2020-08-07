/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import modelo.Books;

/**
 *
 * @author dell
 */
@Stateless
@Path("modelo.books")
public class BooksFacadeREST extends AbstractFacade<Books> {

    @PersistenceContext(unitName = "WebPracticaPU")
    private EntityManager em;

    public BooksFacadeREST() {
        super(Books.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Books entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Books entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Books find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Books> findAll() {
        return super.findAll();
    }

    @POST
    @Path("Hola")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Message() {
        return "Hola Mundo";
    }

    @GET
    @Path("Hola nombre")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String HolaNombre(@QueryParam("nombre") String nam) {
        return "Bienvenido:" + nam;
    }

    @GET
    @Path("Suma Numeros")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Resultado(@QueryParam("num1") int num1, @QueryParam("num2") int num2) {
        int result = num1 + num2;
        return "El resultado es:" + result;

    }

    @POST
    @Path("Multiplicacion")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String result(@FormParam("num1") int num1, @FormParam("num2") int num2) {
        int result = num1 * num2;
        return "El resultadoi es:" + result;
    }

    @GET
    @Path("numero Mayor")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String mayor(@QueryParam("num1") int num1, @QueryParam("num2") int num2) {
        if (num1 > num2) {
            return num1 + "El mayor es num1:";
        } else {
            return num2 + "El mayor numero es num2:";
        }

    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Books> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
