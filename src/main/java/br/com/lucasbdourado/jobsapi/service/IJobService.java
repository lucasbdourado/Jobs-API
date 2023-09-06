package br.com.lucasbdourado.jobsapi.service;

import br.com.lucasbdourado.jobsapi.domain.Job;

import java.sql.SQLException;
import java.util.List;

public interface IJobService {

    List<Job> getAllJobs() throws Exception;

    Job create(Job job) throws SQLException;

    Job findById(Long id) throws SQLException;

    Job update(Long id, Job job) throws SQLException;

    Job delete(Long id) throws SQLException;
}
