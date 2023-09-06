package br.com.lucasbdourado.jobsapi.service;

import br.com.lucasbdourado.jobsapi.dao.IJobDAO;
import br.com.lucasbdourado.jobsapi.dao.JobDAO;
import br.com.lucasbdourado.jobsapi.domain.Job;

import java.sql.SQLException;
import java.util.List;

public class JobService implements IJobService{

    private final IJobDAO jobDAO;

    public JobService(){
        this.jobDAO = new JobDAO();
    }

    /**
     * @return List of Jobs
     * @throws Exception
     */
    @Override
    public List<Job> getAllJobs() throws Exception {
        try{
            return jobDAO.getAll();
        } catch (Exception e){
            throw e;
        }
    }

    /**
     * @param job 
     * @return Job
     * @throws SQLException
     */
    @Override
    public Job create(Job job) throws SQLException {
        try{
            Job createdJob = jobDAO.create(job);

            if(createdJob == null){
                throw new SQLException("Não foi possivel criar o anúncio da vaga");
            }

            return createdJob;
        } catch (SQLException sqlException){
            throw sqlException;
        }
    }

    /**
     * @param id 
     * @return Job
     * @throws SQLException
     */
    @Override
    public Job findById(Long id) throws SQLException {
        try{
            return jobDAO.findById(id);
        } catch (SQLException sqlException){
            throw sqlException;
        }
    }

    /**
     * @param id 
     * @param job
     * @return
     * @throws SQLException
     */
    @Override
    public Job update(Long id, Job job) throws SQLException {
        try{
            Job updateJob = jobDAO.findById(id);

            if(updateJob == null){
                return updateJob;
            }

            job.setId(updateJob.getId());

            return jobDAO.update(job);
        } catch (SQLException sqlException){
            throw sqlException;
        }
    }

    /**
     * 
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Job delete(Long id) throws SQLException {
        try{
            Job job = jobDAO.findById(id);

            if(job == null){
                return job;
            }

            return jobDAO.delete(job);
        } catch (SQLException sqlException){
            throw sqlException;
        }
    }
}
