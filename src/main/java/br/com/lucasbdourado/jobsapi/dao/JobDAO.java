package br.com.lucasbdourado.jobsapi.dao;

import br.com.lucasbdourado.jobsapi.domain.Job;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAO implements IJobDAO{


    @Override
    public List<Job> getAll() throws SQLException {
        try{
            List<Job> jobs = new ArrayList<>();

            jobs.add(new Job(1L,"Desenvolvedor Full-Stack Java - Junior"));
            jobs.add(new Job(2L,"Desenvolvedor Full-Stack Java - Pleno"));
            jobs.add(new Job(3L,"Desenvolvedor Full-Stack Java - Sênior"));

            jobs.add(new Job(4L,"Desenvolvedor Full-Stack PHP - Sênior"));
            jobs.add(new Job(5L,"Desenvolvedor Full-Stack PHP - Pleno"));

            if(jobs.isEmpty()){
                throw new SQLException("Erro ao conectar com o banco de dados");
            }

            return jobs;

        } catch (SQLException e){
            throw e;
        }
    }
}
