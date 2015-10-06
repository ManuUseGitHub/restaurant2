package restaurant.models;
public abstract class Consommable implements IConsommable {
    private long id;
    private String nom;
    private float prix;
    
    public Consommable(){
    }
    public Consommable(long id,String nom,float prix){
        this.id = id;
        this.nom=nom;
        this.prix=prix;
    }
    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String getNom() {
        return nom;
    }
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public float getPrix() {
        return prix;
    }
    @Override
    public void setPrix(float prix) {
        this.prix = prix;
    }
}
