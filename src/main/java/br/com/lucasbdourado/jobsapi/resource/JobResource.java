package br.com.lucasbdourado.jobsapi.resource;

import br.com.lucasbdourado.jobsapi.domain.Job;
import br.com.lucasbdourado.jobsapi.service.IJobService;
import br.com.lucasbdourado.jobsapi.service.JobService;
import org.glassfish.jersey.server.ContainerException;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/jobs")
public class JobResource {

    private final IJobService jobService;

    public JobResource(){
        this.jobService = new JobService();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobs() {
        try{
            List<Job> jobs = jobService.getAllJobs();

            return Response.status(Response.Status.OK).entity(jobs).build();
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJob(Job job) {
        try{
            Job createdJob = jobService.create(job);

            return Response.status(Response.Status.CREATED).entity(createdJob).build();
        } catch (SQLException | ContainerException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@QueryParam("id") Long id) {
        try{
            Job job = jobService.findById(id);

            if(job == null){

                return Response.status(Response.Status.NOT_FOUND).entity("Não foi possível encontrar um anúnucio com o ID especificado").build();
            }

            return Response.status(Response.Status.OK).entity(job).build();
        } catch (SQLException | ContainerException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@QueryParam("id") Long id, Job job){
        try{
            Job updatedJob = jobService.update(id, job);

            if(updatedJob == null){
                return Response.status(Response.Status.NOT_FOUND).entity("Não foi possível encontrar um anúnucio com o ID especificado").build();
            }

            return Response.status(Response.Status.CREATED).entity(updatedJob).build();
        } catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@QueryParam("id") Long id){
        try{
            Job deletedJob = jobService.delete(id);

            if(deletedJob == null){
                return Response.status(Response.Status.NOT_FOUND).entity("Não foi possível encontrar um anúnucio com o ID especificado").build();
            }

            return Response.status(Response.Status.OK).entity(deletedJob).build();
        } catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
