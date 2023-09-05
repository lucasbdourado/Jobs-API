package br.com.lucasbdourado.jobsapi.resource;

import br.com.lucasbdourado.jobsapi.domain.Job;
import br.com.lucasbdourado.jobsapi.service.IJobService;
import br.com.lucasbdourado.jobsapi.service.JobService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/jobs")
public class JobResource {

    private final IJobService jobService;

    public JobResource(){
        this.jobService = new JobService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobs() {
        try{
            List<Job> jobs = jobService.getAllJobs();

            System.out.println(jobs);

            return Response.status(Response.Status.OK).entity(jobs).build();
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
