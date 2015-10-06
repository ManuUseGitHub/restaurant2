package restaurant.models;

public interface IConsommable {

    long getId();

    void setId(long id);
    
    String getNom();

    void setNom(String nom);
    
    float getPrix();

    void setPrix(float prix);
    
}
