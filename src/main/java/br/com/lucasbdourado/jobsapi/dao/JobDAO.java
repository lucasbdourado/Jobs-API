package br.com.lucasbdourado.jobsapi.dao;

import br.com.lucasbdourado.jobsapi.dao.jdbc.ConnectionFactory;
import br.com.lucasbdourado.jobsapi.domain.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO implements IJobDAO{


    @Override
    public List<Job> getAll() throws SQLException {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet;

        List<Job> jobs = new ArrayList<>();

        try{
            connection = ConnectionFactory.getConnection();

            String query = "SELECT * FROM jobs";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Job job = new Job();

                job.setId(resultSet.getLong("id"));
                job.setName(resultSet.getString("name"));

                jobs.add(job);
            }

            return jobs;

        } catch (SQLException e){
            throw e;
        } finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    /**
     * @param job 
     * @return
     * @throws SQLException
     */
    @Override
    public Job create(Job job) throws SQLException {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();

            String query = "INSERT INTO jobs (name, description) VALUES (?, ?)";

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, job.getName());
            preparedStatement.setString(2, job.getDescription());

            int rowsAffected  = preparedStatement.executeUpdate();

            if(rowsAffected == 0) throw new SQLException("Erro: A criação do jogo falhou, tente novamente mais tarde.");

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Long jobId = generatedKeys.getLong(1);
                    job.setId(jobId);
                } else {
                    throw new SQLException("Erro: A criação falhou, não foi possível obter o ID gerado.");
                }
            }
        } catch (SQLException e) {

            throw e;
        } finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }

        return job;
    }

    /**
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Job findById(Long id) throws SQLException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet;

        try {
            connection = ConnectionFactory.getConnection();

            String query = "SELECT * FROM jobs WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Job job = new Job();

                job.setId(resultSet.getLong("id"));
                job.setName(resultSet.getString("name"));

                return job;
            }

        } catch (SQLException sqlException){
            throw new SQLException(sqlException.getMessage());
        } finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }

        return null;
    }

    /**
     * @param job 
     * @return
     * @throws SQLException
     */
    @Override
    public Job update(Job job) throws SQLException {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();

            String query = "UPDATE jobs SET name = ?, description = ? WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, job.getName());
            preparedStatement.setString(2, job.getDescription());
            preparedStatement.setLong(3, job.getId());

            int rowsAffected  = preparedStatement.executeUpdate();

            if(rowsAffected == 0) throw new SQLException("Erro: A atualização do anuncio de emprego falhou, tente novamente mais tarde.");

            return job;
        } catch (SQLException e) {

            throw e;
        } finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    /**
     * 
     * @param job
     * @return
     * @throws SQLException
     */
    @Override
    public Job delete(Job job) throws SQLException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();

            String query = "DELETE FROM jobs WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, job.getId());

            int rowsAffected  = preparedStatement.executeUpdate();

            if(rowsAffected == 0) throw new SQLException("Erro: A deleção do anuncio de emprego falhou, tente novamente mais tarde.");

            return job;
        } catch (SQLException e) {

            throw e;
        } finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }
}
