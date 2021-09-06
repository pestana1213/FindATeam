import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String id;
    private String nome;
    private String pass;
    private String desc;
    private boolean online;
    private double reputacao;
    private Jogo procura;

    public Player(){
        this.id = new String();
        this.nome = new String();
        this.pass = new String();
        this.desc = new String();
        this.online = true;
        this.reputacao = 0.0;
        this.procura = new Jogo();
    }

    public Player(String id,String nome,String pass, String desc){
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.pass = pass;
        this.online = true;
        this.reputacao = 0.0;
        this.procura = new Jogo();
    }

    public Player(String id,String nome, String pass, String desc, Jogo procura){
        this.id = id;
        this.nome = nome;
        this.pass = pass;
        this.desc = desc;
        this.online = true;
        this.reputacao = 0.0;
        this.procura = procura.clone();
    }

    public Player(String id,String nome, String pass, String desc, double rep, Jogo procura){
        this.id = id;
        this.nome = nome;
        this.pass = pass;
        this.desc = desc;
        this.reputacao = 0.0;
        this.online = true;
        this.reputacao = rep;
        this.procura = procura.clone();
    }

    public Player(String id,String nome, String pass, String desc, double rep){
        this.id = id;
        this.nome = nome;
        this.pass = pass;
        this.desc = desc;
        this.reputacao = 0.0;
        this.online = true;
        this.reputacao = rep;
        this.procura = new Jogo();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void setReputacao(double reputacao) {
        this.reputacao = reputacao;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Jogo getProcura() {
        return procura;
    }

    public void setProcura(Jogo procura) {
        this.procura = procura;
    }

    public String getDesc() {
        return desc;
    }

    public double getReputacao() {
        return reputacao;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Player clone(){
        return new Player(this.id,this.nome,this.pass,this.desc,this.reputacao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return online == player.online && Double.compare(player.reputacao, reputacao) == 0 && Objects.equals(id, player.id) && Objects.equals(nome, player.nome) && Objects.equals(pass, player.pass) && Objects.equals(desc, player.desc) && Objects.equals(procura, player.procura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, pass, desc, online, reputacao, procura);
    }
}
