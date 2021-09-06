import java.util.ArrayList;
import java.util.stream.Collectors;

public class FazTudo {
    private ArrayList<Player> players;
    private ArrayList<Jogo> jogos;

    public FazTudo(){
        this.players = new ArrayList<>();
        this.jogos = new ArrayList<>();
    }

    public FazTudo(ArrayList<Player> players, ArrayList<Jogo> jogos) {
        this.players = players.stream().collect(Collectors.toCollection(ArrayList::new));
        this.jogos = jogos.stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Player> getPlayers() {
        return this.players.stream().map(Player::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players.stream().map(Player::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Jogo> getJogos() {
        return this.jogos.stream().map(Jogo::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos.stream().map(Jogo::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public void addPlayer(Player novo) throws Exception {
        if(!players.contains(novo)){
            this.players.add(novo);
        }
        else{
            throw new Exception("Jogador ja existente");
        }
    }

    public void addJogo(Jogo novo) throws Exception{
        if(!jogos.contains(novo)){
            this.jogos.add(novo);
        }
        else{
            throw new Exception("Jogo ja existente");
        }
    }

    public ArrayList<Player> finPartner(Player me, Jogo jogo, int numero) {
        ArrayList<Player> ret = new ArrayList<>();
        int faltam = numero;
        me.setOnline(true);

        for (Player p : this.players) {
            if(!p.equals(me) && p.isOnline() && p.getProcura().equals(jogo) && faltam != 0){
                ret.add(p.clone());
                faltam--;
            }
        }

        return ret;
    }

    public boolean login(String id, String pass){
        for (Player p : this.players){
            if (p.getId().equals(id)){
                if(p.getPass().equals(pass)) return true;
             }
        }
        return false;
    }

}
