import java.util.Objects;

public class Jogo{
    private String id;
    private String nome;
    private int teamates;

    public Jogo(){
        this.id = new String();
        this.nome = new String();
        this.teamates = 1;
    }

    public Jogo(String id,String nome, int teamates) throws Exception {
        if (teamates >= 1 && id.charAt(0)=='J')
        {
            this.id = id;
            this.nome = nome;
            this.teamates = teamates;
        }
        else{
            throw new Exception("Impossivel criar jogo");
        }
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return teamates == jogo.teamates && Objects.equals(nome, jogo.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, teamates);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTeamates() {
        return teamates;
    }

    public void setTeamates(int teamates) {
        this.teamates = teamates;
    }

    public Jogo clone(){
        Jogo jogo = new Jogo();
        try {
            jogo = new Jogo(this.id, this.nome, this.teamates);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jogo;
    }
}
