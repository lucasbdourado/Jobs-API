package br.com.lucasbdourado.jobsapi.domain;

public class Job {

    private Long id;

    private String name;

    public Job(){}

    public Job(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
