package br.com.lucasbdourado.jobsapi.dao;

import br.com.lucasbdourado.jobsapi.domain.Job;

import java.sql.SQLException;
import java.util.List;

public interface IJobDAO {

    List<Job> getAll() throws SQLException;
}
