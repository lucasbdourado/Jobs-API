package br.com.lucasbdourado.jobsapi.dao;

import br.com.lucasbdourado.jobsapi.domain.Job;

import java.sql.SQLException;
import java.util.List;

public interface IJobDAO {

    List<Job> getAll() throws SQLException;

    Job create(Job job) throws SQLException;

    Job findById(Long id) throws SQLException;

    Job update(Job job) throws SQLException;

    Job delete(Job job) throws SQLException;
}
