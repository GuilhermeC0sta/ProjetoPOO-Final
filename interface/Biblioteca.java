import java.util.*;

public class Biblioteca { // ADICIONAR ou REMOVER livros do acervo;
    private ArrayList<conta> contas = new ArrayList<>(); // tava public, coloquei private
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<audiobook> audiobook = new ArrayList<>();
    private ArrayList<utensilios> utensilios = new ArrayList<>();

    private ArrayList<Integer> id_user = new ArrayList<>();
    private ArrayList<Integer> id_userAudio = new ArrayList<>();
    private ArrayList<Integer> isbn_locado = new ArrayList<>();
    private ArrayList<Integer> audio_locado = new ArrayList<>();

    private ArrayList<Integer> id_devolvido = new ArrayList<>();
    private ArrayList<Integer> isbn_devolvido = new ArrayList<>();
    private ArrayList<Integer> id_multa = new ArrayList<>();
    private ArrayList<Integer> id_multapaga = new ArrayList<>();

    public String genero, tamanho, nome, email, senha, cor, marca, plan, titulo, autor, controle, dev, nome_b, email_b,
            senha_b, log = "n", BIO;
    int duracao, id_audio, escolha;
    private boolean logado;

    int k = 0, index_user = 0, op = 0, id = 1, isbn, qnt_disp, isbnlocar, isbndevolver, j, i, slots;

    Scanner sc = new Scanner(System.in);

    public Biblioteca() {
        this.contas = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.id_user = new ArrayList<>();
        this.isbn_locado = new ArrayList<>();
        this.id_devolvido = new ArrayList<>();
        this.isbn_devolvido = new ArrayList<>();
        this.id_multa = new ArrayList<>();
        this.id_multapaga = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.audiobook = new ArrayList<>();
        this.audio_locado = new ArrayList<>();
        this.id_userAudio = new ArrayList<>();

        nome_b = "biblioteca";
        email_b = "biblioteca123@gmail.com";
        senha_b = "admin";
        contas.add(new premium(email_b, senha_b, nome_b, 0));
        livros.add(new Livro("Harry Potter", "JK", 7, 55, "Fantasia"));
        contas.get(0).defPlano("Administrador");
        utensilios.add(new postit("postit", "verde", 10));
        utensilios.add(new apoio_livros("apoiolivros", 20, 12));
        utensilios.add(new marca_texto("marcatexto", "azul", "pequeno", 11));
    }

    public String login() {
        System.out.println("Digite o email:");
        email = sc.next();
        System.out.println("Digite a senha:");
        senha = sc.next();
        for (i = 0; i < contas.size(); i++) {
            if (contas.get(i).getEmail().equals(email) && contas.get(i).getSenha().equals(senha)) {
                index_user = i;
                System.out.println("Login realizado com sucesso!");
                return "logado";
            }
        }

        System.out.println("Essa conta não existe ou você errou o email/senha");
        return "erro";
    }

    public void cadastrar_usuario() {
        System.out.println("Digite seu plano:");
        plan = sc.nextLine();

        if (plan.equalsIgnoreCase("comum")) {
            System.out.println("Digite seu nome:");
            nome = sc.nextLine();

            System.out.println("Digite o email:");
            email = sc.nextLine();

            System.out.println("Digite a senha:");
            senha = sc.nextLine();

            contas.get(index_user).defPlano(plan);

            System.out.println("Usuário " + nome + " cadastrado!");

            contas.add(new comum(email, senha, nome, id));
            id += 1;
        } else if (plan.equalsIgnoreCase("premium")) {
            System.out.println("Digite seu nome:");
            nome = sc.nextLine();

            System.out.println("Digite o email:");
            email = sc.nextLine();

            System.out.println("Digite a senha:");
            senha = sc.nextLine();

            contas.get(index_user).defPlano(plan);

            System.out.println("Usuário " + nome + " cadastrado!");

            contas.add(new premium(email, senha, nome, id));
            id += 1;
        } else {
            System.out.println("Plano inválido! Digite novamente.");
        }
    }

    public void editar_perfil() {
        if (contas.get(index_user).getPlano().equalsIgnoreCase("comum")) {
            System.out.println("Digite o novo nome:");
            sc.nextLine();
            nome = sc.nextLine();
            System.out.println("Digite o novo email:");
            email = sc.nextLine();
            System.out.println("Digite uma BIO para você com até 50 caracteres (caso não desejar digite 00):");
            BIO = sc.nextLine();
            if (BIO.length() > 50) {
                System.out.println("Você excedeu o número de caracteres");
            } else if (BIO == "00") {
            } else {
                contas.get(index_user).defBios(BIO);
            }
            contas.set(index_user, new comum(email, contas.get(index_user).getSenha(), nome, id));
            System.out.println("Nome e email alterados com sucesso!");
        } else if (contas.get(index_user).getPlano().equalsIgnoreCase("premium")) {
            System.out.println("Digite o novo nome:");
            sc.nextLine();
            nome = sc.nextLine();
            System.out.println("Digite o novo email:");
            email = sc.nextLine();
            System.out.println("Digite uma BIO para você com até 200 caracteres (caso não desejar digite 00):");
            BIO = sc.nextLine();
            if (BIO.length() > 200) {
                System.out.println("Você excedeu o número de caracteres");
            } else if (BIO == "00") {
            } else {
                contas.get(index_user).defBios(BIO);
            }
            contas.set(index_user, new premium(email, contas.get(index_user).getSenha(), nome, id));
            System.out.println("Nome e email alterados com sucesso!");
        } else if (contas.get(index_user).getPlano().equalsIgnoreCase("administrador")) {
            System.out.println("Digite o novo nome:");
            sc.nextLine();
            nome = sc.nextLine();
            System.out.println("Digite o novo email:");
            email = sc.nextLine();
            contas.set(index_user, new admin(email, contas.get(index_user).getSenha(), nome, id));
            System.out.println("Nome e email alterados com sucesso!");
        } else {
            System.out.println("Plano Inválido, digite novamente!");
        }
    }

    public void logout() {
        if (logado) {
            logado = false;
            System.out.println("Logout realizado com sucesso!");
        } else {
            System.out.println("Nenhum usuário logado!");
        }
    }

    public void mostrar_livros() {
        for (int i = 0; i < livros.size(); i++) {
            System.out.printf(
                    "Titulo: " + livros.get(i).getTitulo() + " - " + "Autor: " + livros.get(i).getAutor()
                            + " - "
                            + " Código ISBN: " + livros.get(i).getIsbn() + " - "
                            + " Quantidade disponível: "
                            + livros.get(i).getQnt_disp() + " Genero: " + livros.get(i).getGenero() + "\n");
        }
    }

    public void listar_usuarios() {
        if (index_user == 0) {
            for (int i = 0; i < contas.size(); i++) {
                System.out.println("Nome: " + contas.get(i).getNome() + " - " + "Email: " + contas.get(i).getEmail());
            }
        } else {
            System.out.println("Somente adminstradores podem usar esta função");
        }
    }

    public void add_livro() {
        if (index_user == 0) {
            System.out.println("Digite o titulo:");
            titulo = sc.nextLine();

            System.out.println("Digite o autor:");

            autor = sc.nextLine();

            System.out.println("Digite o codigo ISBN:");
            isbn = sc.nextInt();

            System.out.println("Digite o gênero:");
            sc.nextLine();
            genero = sc.nextLine();

            System.out.println("Digite a quantidade disponíveis:");
            qnt_disp = sc.nextInt();

            livros.add(new Livro(titulo, autor, isbn, qnt_disp, genero));
        } else {
            System.out.println("Somente adminstradores podem usar esta função");
        }
    }

    public void locar_livro() {
        if (contas.get(index_user).getPlano().equalsIgnoreCase("administrador")) {
            System.out.println("Administradores não podem executar esta funcionalidade!");
            return;
        } else if (contas.get(index_user).getPlano().equalsIgnoreCase("comum")) {
            if (id_user.size() == 1) {
                System.out.println(
                        "Você não pode locar mais livros, você atingiu seu limite de 1 livro locado simultaneamente!");
                return;
            }
        } else {
            if (id_user.size() == 15) {
                System.out.println(
                        "Você não pode locar mais livros, você atingiu seu limite de 15 livros locados simultaneamente!");
                return;
            }
        }
        System.out.println("Digite o código ISBN do livro que deseja locar: ");
        isbnlocar = sc.nextInt();
        for (k = 0; k < livros.size(); k++) {
            if (isbnlocar == livros.get(k).getIsbn()) {
                if (livros.get(k).getQnt_disp() == 0) {
                    System.out.println("Livro indisponível, tente novamente em outro momento.");
                    break;
                } else {
                    livros.set(k, new Livro(livros.get(k).getTitulo(), livros.get(k).getAutor(), isbnlocar,
                            livros.get(k).getQnt_disp() - 1, livros.get(k).getGenero()));

                    livros.get(k).locar();
                    id_user.add(index_user);
                    isbn_locado.add(isbnlocar);
                    break;
                }
            }
        }
    }

    public void remover_livro() {
        if (contas.get(index_user).getPlano().equalsIgnoreCase("administrador")) {
            System.out.println("Digite o código ISBN do livro que deseja remover do acervo: ");
            isbnlocar = sc.nextInt();
            for (k = 0; k < livros.size(); k++) {
                if (isbnlocar == livros.get(k).getIsbn()) {
                    livros.remove(k);
                }
            }
        } else {
            System.out.println("Somente adminstradores podem usar esta função");
        }
    }

    public void devolver_livro() {
        if (contas.get(index_user).getPlano().equalsIgnoreCase("administrador")) {
            System.out.println("Administradores não podem executar esta funcionalidade!");
            return;
        }
        if (id_user.size() == 0) {
            System.out.println("*NÃO HÁ LIVRO LOCADOS*");
            // break;
        } else {
            System.out.println("Livros locados: ");
        }
        for (k = 0; k < id_user.size(); k++) {
            if (id_user.get(k) == index_user) {
                System.out.println(isbn_locado.get(k));
            }
        }
        System.out.println("Escolha o livro que deseja devolver de acordo com o ISBN: ");
        isbndevolver = sc.nextInt();
        for (j = 0; j < id_user.size(); j++) {
            if (id_user.get(j) == index_user) {
                if (isbn_locado.get(j) == isbndevolver) {
                    id_devolvido.add(j, index_user);
                    isbn_devolvido.add(j, isbndevolver);
                    id_user.remove(j);
                    isbn_locado.remove(j);
                    System.out.println("Livro " + isbndevolver + " devolvido! A Libraric agradece!\n");
                    for (k = 0; k < livros.size(); k++) {
                        if (isbndevolver == livros.get(k).getIsbn()) {
                            livros.set(k,
                                    new Livro(livros.get(k).getTitulo(), livros.get(k).getAutor(), isbndevolver,
                                            livros.get(k).getQnt_disp() + 1, livros.get(k).getGenero()));
                            break;
                        }
                    }
                    break;
                }
            }
            if (j == id_user.size() - 1) {
                System.out.println("Este livro não foi locado por você.");
            }
        }
    }

    public void livros_locados() {
        if (contas.get(index_user).getPlano().equalsIgnoreCase("administrador")) {
            System.out.println("Administradores não podem executar esta funcionalidade!");
            return;
        }
        if (id_user.size() == 0) {
            System.out.println("*NÃO HÁ LIVRO LOCADOS*");
            // break;
        } else {
            System.out.println("Livros locados: ");

            for (k = 0; k < id_user.size(); k++) {
                if (id_user.get(k) == index_user) {
                    System.out.println(isbn_locado.get(k));
                }
            }
        }

        if (id_user.size() == 0) {
            System.out.println("*NÃO HÁ AUDIOS LOCADOS*");
            // break;
        } else {
            System.out.println("\n");
            System.out.println("Audiobooks locados: ");

            for (k = 0; k < id_userAudio.size(); k++) {
                if (id_userAudio.get(k) == index_user) {
                    System.out.println(audio_locado.get(k));
                }
            }
        }
    }

    public void livros_devolvidos() {
        if (contas.get(index_user).getPlano().equalsIgnoreCase("administrador")) {
            for (j = 0; j < id_devolvido.size(); j++) {
                System.out.println("O usuario de id " + id_devolvido.get(j) + " devolveu o livro "
                        + isbn_devolvido.get(j));
                System.out.println("Se este livro foi devolvido digite S, caso contrario, digite N");
                sc.nextLine();
                dev = sc.nextLine();
                if (dev.equalsIgnoreCase("S")) {
                    id_devolvido.remove(j);
                    isbn_devolvido.remove(j);
                } else if (dev.equalsIgnoreCase("N")) {
                    System.out.println(
                            "Aplicar multa? digite S para aplicar multa caso tenha passado o prazo, digite N, caso nao tenha passado o prazo");
                    String multinha = sc.nextLine();
                    if (multinha.equalsIgnoreCase("S")) {
                        System.out.println("MULTA APLICADA!");
                        id_multa.add(id_devolvido.get(j));
                    } else if (multinha.equalsIgnoreCase("N")) {
                        System.out.println("MULTA NÃO APLICADA!");
                    }
                }
            }
        } else {
            System.out.println("Somente adminstradores podem usar esta função");
        }
    }

    public void verificar_multas() {
        for (j = 0; j < id_multa.size(); j++) {
            if (id_multa.get(j) == index_user) {
                System.out.println(
                        "Você possui uma multa não paga! Realize o pagamento dentro do prazo ou então será aplicado juros à multa!");
                System.out.println(
                        "Deseja pagá-la agora? se SIM digite S, caso contrário, digite outra N");
                sc.nextLine();
                String resp = sc.nextLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Dirija-se para o caixa para realizar o pagamento!");
                    id_multapaga.add(index_user);
                } else if (resp.equalsIgnoreCase("N")) {
                    System.out.println(
                            "Realize o pagamento dentro do prazo ou então será aplicado juros à multa!");
                    break;
                }
            }
        }
    }

    public void multas_pagas() {
        if (index_user == 0) {
            for (j = 0; j < id_multapaga.size(); j++) {
                System.out.println(
                        "O usuário de id " + id_multapaga.get(j) + " pagou a multa, confirma?");
                sc.nextLine();
                String resposta = sc.nextLine();
                if (resposta.equalsIgnoreCase("S")) {
                    System.out.println("Confirmado que o usuário de id " + id_multapaga.get(j)
                            + " pagou a multa!");
                    id_multapaga.remove(j);
                    id_devolvido.remove(j);
                    id_multa.remove(j);
                }
            }
        } else {
            System.out.println("Somente adminstradores podem usar esta função");
        }
    }

    public void add_audiobook() {

        if (contas.get(k).getId() == 0) {
            System.out.println("Digite o titulo:");
            titulo = sc.next();

            System.out.println("Digite o autor:");
            autor = sc.next();

            System.out.println("Digite a duracao");
            duracao = sc.nextInt();

            System.out.println("Digite a quantidade:");
            qnt_disp = sc.nextInt();

            System.out.println("Digite o gênero:");
            sc.nextLine();
            genero = sc.nextLine();

            System.out.println("Digite o código:");
            id_audio = sc.nextInt();

            audiobook.add(new audiobook(titulo, autor, duracao, qnt_disp, genero, id_audio));
        } else {
            System.out.println("Somente adminstradores podem usar esta função");
        }
    }

    public void locar_audio() {
        if (contas.get(index_user).getPlano().equalsIgnoreCase("administrador")) {
            System.out.println("Administradores não podem executar esta funcionalidade!");
            return;
        } else if (contas.get(index_user).getPlano().equalsIgnoreCase("comum")) {
            if (audiobook.size() == 1) {
                System.out.println(
                        "Você não pode locar mais livros, você atingiu seu limite de 1 livro locado simultaneamente!");
                return;
            }
        } else {
            if (audiobook.size() == 15) {
                System.out.println(
                        "Você não pode locar mais livros, você atingiu seu limite de 15 livros locados simultaneamente!");
                return;
            }
        }
        System.out.println("Digite o código do audiobook: ");
        id_audio = sc.nextInt();
        for (k = 0; k < audiobook.size(); k++) {
            if (id_audio == audiobook.get(k).getAudio()) {
                if (audiobook.get(k).getQnt_disp() == 0) {
                    System.out.println("Livro indisponível, tente novamente em outro momento.");
                    break;
                } else {
                    audiobook.set(k,
                            new audiobook(audiobook.get(k).getTitulo(), audiobook.get(k).getAutor(),
                                    audiobook.get(k).getDuracao(),
                                    audiobook.get(k).getQnt_disp() - 1, audiobook.get(k).getGenero(), id_audio));

                    audiobook.get(k).locar();
                    id_userAudio.add(index_user);
                    audio_locado.add(id_audio);
                    break;
                }
            }
        }
    }

    public void mostrar_audios() {
        if (contas.get(index_user).getPlano().equalsIgnoreCase("administrador")) {
            System.out.println("Administradores não podem executar esta funcionalidade!");
            return;
        }
        for (int i = 0; i < audiobook.size(); i++) {
            System.out.printf(
                    "Titulo: " + audiobook.get(i).getTitulo() + " - " + "Autor: " + audiobook.get(i).getAutor()
                            + " - "
                            + " Código do áudio: " + audiobook.get(i).getAudio() + " - "
                            + " Quantidade disponível: "
                            + audiobook.get(i).getQnt_disp() + " Genero: " + audiobook.get(i).getGenero() + "\n");
        }
    }

    public void remover_audios() {
        if (contas.get(index_user).getPlano().equalsIgnoreCase("administrador")) {
            System.out.println("Administradores não podem executar esta funcionalidade!");
            return;
        }
        if (index_user == 0) {
            System.out.println("Digite o código do audio que deseja remover: ");
            id_audio = sc.nextInt();
            for (k = 0; k < audiobook.size(); k++) {
                if (id_audio == audiobook.get(k).getAudio()) {
                    audiobook.remove(k);
                }
            }
        } else {
            System.out.println("Somente adminstradores podem usar esta função");
        }
    }

    // porta-livros, suporte de livros - cor
    public void add_utensilios() {
        if (contas.get(index_user).getPlano().equals("administrador")) {// index_user == 0 ele funciona
            System.out.println("Informe o código do utensílio que deseja adicionar");
            System.out.println("[1] - Postit\n[2] - Marca texto\n[3] - Apoio de livros");
            escolha = sc.nextInt();

            if (escolha == 1) {
                System.out.println("Informe a marca");
                marca = sc.next();
                System.out.println("Informe a cor");
                cor = sc.next();
                System.out.println("Informe a quantidade");
                qnt_disp = sc.nextInt();

                utensilios.add(new postit(marca, cor, qnt_disp));
            } else if (escolha == 2) {

                System.out.println("Informe a marca");
                marca = sc.next();
                System.out.println("Informe a cor");
                cor = sc.next();
                System.out.println("Informe o tamanho");
                tamanho = sc.next();
                System.out.println("Informe a quantidade");
                qnt_disp = sc.nextInt();

                utensilios.add(new marca_texto(marca, cor, tamanho, qnt_disp));
            } else if (escolha == 3) {
                System.out.println("Informe a marca");
                marca = sc.next();
                System.out.println("Informe a quantidade de slots");
                slots = sc.nextInt();
                System.out.println("Informe a quantidade");
                qnt_disp = sc.nextInt();

                utensilios.add(new apoio_livros(marca, slots, qnt_disp));
            }

        } else {
            System.out.println("Somente administradores podem usar esta função");
        }
    }

    public void ver_utensilios() {

        System.out.println("Postit's: ");
        for (i = 0; i < utensilios.size(); i++) {
            System.out.println("Marca: " + utensilios.get(i).getMarca() + "\nCor: " + utensilios.get(i).getCor()
                    + "\nQuantidade: " + utensilios.get(i).getQuantidade());
        }
        System.out.println("\n");

        System.out.println("Marca textos: ");
        for (i = 0; i < utensilios.size(); i++) {
            System.out.println("Marca: " + utensilios.get(i).getMarca() + "\nCor: " + utensilios.get(i).getCor()
                    + "\nTamanho:" + utensilios.get(i).getTam() + "\nQuantidade: "
                    + utensilios.get(i).getQuantidade());
        }
        System.out.println("\n");

        System.out.println("Apoio de livros: ");
        for (i = 0; i < utensilios.size(); i++) {
            System.out.println("Marca: " + utensilios.get(i).getMarca() + "\nSlots: " + utensilios.get(i).getSlots()
                    + "\nQuantidade: " + utensilios.get(i).getQuantidade());
        }
    }

}
