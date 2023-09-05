package br.com.lucasbdourado.jobsapi.service;

import br.com.lucasbdourado.jobsapi.dao.IJobDAO;
import br.com.lucasbdourado.jobsapi.dao.JobDAO;
import br.com.lucasbdourado.jobsapi.domain.Job;

import java.util.List;

public class JobService implements IJobService{

    private final IJobDAO jobDAO;

    public JobService(){
        this.jobDAO = new JobDAO();
    }

    @Override
    public List<Job> getAllJobs() throws Exception {
        try{
            return jobDAO.getAll();
        } catch (Exception e){
            throw e;
        }
    }
}
