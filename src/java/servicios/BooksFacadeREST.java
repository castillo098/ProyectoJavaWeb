/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    @Path("SumaNumeros")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Resultado(@QueryParam("num1") int num1, @QueryParam("num2") int num2) {
        int result = num1 + num2;
        return "El resultado es:" + result;
    }

    @POST
    @Path("SumaNumeros")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Resultado1(@QueryParam("num1") int n1, @QueryParam("num2") int n2) {
        int result = n1 + n2;
        return "El resultado es:" + result;
    }

    @POST
    @Path("Multiplicacion")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String result(@FormParam("num1") int num1, @FormParam("num2") int num2) {
        int result = num1 * num2;
        return "El resultado es:" + result;
    }

    @POST
    @Path("Division")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String result1(@FormParam("num1") int num1, @FormParam("num2") int num2) {
        int resultado1 = num1 / num2;
        return "El resultado es:" + resultado1;
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

    @POST
    @Path("numeroMayor")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String mayor1(@FormParam("a") int a1, @FormParam("b") int b1) {
        if (a1 > b1) {
            return a1 + "El numero mayor es a1: ";
        } else {
            return b1 + "El numero mayor es b1: ";
        }
    }

    //OBTENER DE LA BASE DE DATOS
    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Crear(@FormParam("book_id") int book_id, @FormParam("tittle") String tittle,
            @FormParam("description") String descripcion, @FormParam("author") String author, @FormParam("publisher_id") int publisher_id,
            @FormParam("price") String price, @FormParam("copies") int copies) {

        Books b = new Books(book_id, tittle, descripcion, author, publisher_id, price, copies);
        /*if (book_id.() == 2) {
            super.create(b);
            return "El objeto se inserto con éxito";
        } else {
            return "El objeto no se inserto con éxito";
        }*/
        return "El objeto se inserto con éxito";
    }

    @POST
    @Path("readLibros")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Books> LeerLibros(@FormParam("author") String author) {
        TypedQuery consulte = getEntityManager().createQuery("SELECT b FROM Books b WHERE b.author = :author", Books.class);
        consulte.setParameter("author", author);
        return consulte.getResultList();

    }

    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Editar(@FormParam("book_id") int book_id, @FormParam("tittle") String tittle,
            @FormParam("description") String description, @FormParam("author") String author, @FormParam("publisher_id") int publisher_id,
            @FormParam("price") String price, @FormParam("copies") int copies) {

        Books b = super.find(book_id);
        b.setAuthor(author);
        b.setDescription(description);
        b.setCopies(copies);
        b.setPrice(price);
        b.setPublisherId(publisher_id);
        b.setTittle(tittle);
        super.edit(b);
        return "datos editados";
    }

    @POST
    @Path("delete")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Eliminar(@FormParam("book_id") int book_id) {
        Books b = super.find(book_id);
        if (b == null) {
            return ("Datos no eliminados");
        } else {
            super.remove(b);
            return ("Datos eliminados");
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
