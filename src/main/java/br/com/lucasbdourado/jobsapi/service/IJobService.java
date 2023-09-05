package br.com.lucasbdourado.jobsapi.service;

import br.com.lucasbdourado.jobsapi.domain.Job;

import java.util.List;

public interface IJobService {

    List<Job> getAllJobs() throws Exception;
}
