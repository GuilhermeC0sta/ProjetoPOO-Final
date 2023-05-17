import java.util.*;

public class Libraric {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int op = 0, bookoption = 0;
        String login = "n", controle, menu = "n";

        Scanner sc = new Scanner(System.in);

        while (op != -1) {

            while (menu != "s") {
                System.out.println("Você possui login ? S/N");
                controle = sc.next();

                if (controle.equalsIgnoreCase("S")) {
                    while (!login.equals("logado")) {
                        login = biblioteca.login();
                    }
                    menu = "s";
                } else {
                    biblioteca.cadastrar_usuario();
                }
            }

            while (menu == "s") {
                System.out.println("[1] para editar perfil");
                System.out.println("[2] (ADMIN) para adicionar um livro ou um audiobook");
                System.out.println("[3] para locar um livro ou um audiobook");
                System.out.println("[4] mostrar livros disponíveis ou audiosbook's disponíveis");
                System.out.println("[5] (ADMIN) para remover um livro ou um audiobook");
                System.out.println("[6] para devolver um livro do acervo");
                System.out.println("[7] para verificar os livros locados");
                System.out.println("[8] (ADMIN) para ver quais livros foram devolvidos");
                System.out.println("[9] verificar se você possui multas pendentes");
                System.out.println("[10] (ADMIN) confirmar pagamento de multas pelos usuários");
                System.out.println("[11] (ADMIN) para verificar todas as contas cadastradas no Libraric");
                System.out.println("[16] para deslogar do Libraric");
                System.out.println("[17] para encerrar o programa");
                op = sc.nextInt();
                switch (op) {

                    case 1:
                        biblioteca.editar_perfil();
                        break;

                    case 2:
                        System.out.println("Para adicionar um livro digite 1; audiobook digite 2; utensilio digite 3");
                        bookoption = sc.nextInt();
                        if (bookoption == 1) {
                            biblioteca.add_livro();
                        } else if (bookoption == 2) {
                            biblioteca.add_audiobook();
                        } else if (bookoption == 3) {
                            biblioteca.add_utensilios();
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        biblioteca.add_livro();
                        break;

                    case 3:
                        System.out.println("Para locar um livro digite 1, para locar um audiobook digite 2");
                        bookoption = sc.nextInt();
                        if (bookoption == 1) {
                            biblioteca.locar_livro();
                        } else if (bookoption == 2) {
                            biblioteca.locar_audio();
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        break;

                    case 4:
                        System.out.println(
                                "Para mostrar os livros disponíveis digite 1; audiobooks digite 2; utensilios digite 3");
                        bookoption = sc.nextInt();
                        if (bookoption == 1) {
                            biblioteca.mostrar_livros();
                        } else if (bookoption == 2) {
                            biblioteca.mostrar_audios();
                        } else if (bookoption == 3) {
                            biblioteca.ver_utensilios();
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        break;

                    case 5:
                        System.out.println(
                                "Para remover um livro digite 1; para remover um audiobook digite 2");
                        bookoption = sc.nextInt();
                        if (bookoption == 1) {
                            biblioteca.remover_livro();
                        } else if (bookoption == 2) {
                            biblioteca.remover_audios();
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        break;

                    case 6:
                        biblioteca.devolver_livro();
                        break;

                    case 7:
                        biblioteca.livros_locados();
                        break;

                    case 8:
                        biblioteca.livros_devolvidos();
                        break;

                    case 9:
                        biblioteca.verificar_multas();
                        break;

                    case 10:
                        biblioteca.multas_pagas();
                        break;

                    case 11:
                        biblioteca.listar_usuarios();
                        break;

                    case 12:
                        System.out.print("Deslogado\n");
                        menu = "n";
                        login = "deslogado";
                        break;

                    case 13:
                        op = -1;
                        menu = "n";
                        break;
                }
            }

        }
        sc.close();
    }
}