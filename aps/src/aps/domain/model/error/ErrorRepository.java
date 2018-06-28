package aps.domain.model.error;

public interface ErrorRepository {
    
    public Error findByBaseUrl(String baseUrl);

    public void add(Error Error);

    public void delete(Error Error);

    public void update(Error Error);

}
