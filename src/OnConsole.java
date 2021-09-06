import java.util.Scanner;

public class OnConsole {

    private static FazTudo tudo;

    public static void Menu() throws Exception {
        System.out.println("1) Login");
        System.out.println("\n2) Registar");
        System.out.println("\n0) Sair");
        int opcao;
        Scanner scan = new Scanner(System.in);
        opcao = scan.nextInt();

        switch (opcao){
            case 1 :
                login();
            case 2 :
                registar();
            case 3 :
                System.exit(0);
            default:
                System.out.println("\nOpcao desconhecida");
                Menu();
                break;
        }
    }

    public static void login() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEmail: ");
        String id = scan.nextLine();
        int encontra = 0;
        for (Player p : tudo.getPlayers()){
            if (p.getId().equals(id)) {
                encontra = 1;
                break;
            }
        }
        if(encontra==0){
            System.out.println("\nEmail nao registado :(\n1)Tentar de novo\n2)Registar");
            int op = scan.nextInt();
            switch (op){
                case 1 :
                    login();
                case 2 :
                    registar();
                default:
                    System.out.println("\nOpcao desconhecida");
                    Menu();
                    break;
            }
        }
        else{
            System.out.println("\nPassword");
            String pass = scan.nextLine();
            for(Player y : tudo.getPlayers()){
                if(y.getId().equals(id)){
                    if (y.getPass().equals(pass)) {
                        //Menu login
                    }
                    else{
                        System.out.println("\nLogin invalido :(\n1)Tentar de novo\n2)Registar");
                        int op2 = scan.nextInt();
                        switch (op2){
                            case 1 :
                                login();
                            case 2 :
                                registar();
                            default:
                                System.out.println("\nOpcao desconhecida");
                                Menu();
                                break;
                        }
                    }
                }
            }
        }
    }

    public static void registar() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nIntroduza o email do user");
        String id = scan.nextLine();
        int aux = 1;
        for(Player p : tudo.getPlayers()){
            if(p.getId().equals(id)){
                System.out.println("\nEmail ja registado\n1)Login\n2)Registar");
                aux = 0;
                int op = scan.nextInt();
                switch (op){
                    case 1 :
                        login();
                    case 2 :
                        registar();
                    default:
                        System.out.println("\nOpcao desconhecida");
                        Menu();
                        break;
                }
            }
        }
        if(aux==1){
            System.out.println("\nNome: ");
            String nome = scan.nextLine();
            System.out.println("\nPassword: ");
            String pass = scan.nextLine();
            System.out.println("\nDescricao da conta: ");
            String desc = scan.nextLine();
            System.out.println("\nNome do jogo para encontrar equipa: ");
            //Fazer tostring para mostrar todos os jogos registados!
            String jogo = scan.nextLine();
            Jogo jo = new Jogo();
            if (tudo.getJogos().stream().noneMatch(h -> h.getNome().equals(jogo))) {
                System.out.println("\nJogo desconhecido");
            }
            for(Jogo j : tudo.getJogos()){
                if(j.getNome().equals(jogo)){
                    jo = j.clone(); 
                }
            }

            Player novo = new Player(id,nome,pass,desc,0,jo);
            tudo.addPlayer(novo);
        }
    }

    public static void main(String[] args) throws Exception {
        tudo = new FazTudo();
        Menu();
    }
}
