import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Game {
    Node startNode;

    public Game(Node startNode) {
        this.startNode = startNode;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Node currentNode = startNode;

        while (currentNode != null) {
            System.out.println(currentNode.getDescription());

            if (currentNode.getChoices().isEmpty()) {
                System.out.println("Deseja jogar novamente (y/n)?");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    currentNode = startNode;
                } else {
                    System.out.println("Fim do jogo.");
                    break;
                }
            } else {
                System.out.println("\nEscolha uma das seguintes opções:");
                int i = 1;
                for (String choice : currentNode.getChoices().keySet()) {
                    System.out.println(i + ". " + choice);
                    i++;
                }

                int choiceIndex = -1;
                while (true) {
                    try {
                        System.out.print("\nDigite sua escolha (número): \n");
                        choiceIndex = scanner.nextInt();
                        scanner.nextLine();  // Consumir nova linha

                        if (choiceIndex < 1 || choiceIndex > currentNode.getChoices().size()) {
                            System.out.println("Escolha inválida. Tente novamente.");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, digite um número.");
                        scanner.nextLine();  // Consumir entrada inválida
                    }
                }

                String selectedChoice = (String) currentNode.getChoices().keySet().toArray()[choiceIndex - 1];
                currentNode = currentNode.getChoices().get(selectedChoice);
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // Criar os nós da história
        Node start = new Node("Você é Paulinho e acabou de fraturar o braço. Seu objetivo é levar Paulinho em segurança até o Hospital. Você está a 20km do local de destino.\n" +
                              "\nVocê vai para a garagem pegar o carro e ir dirigindo para o hospital 'a' ou ligar para emergência e pedir ajuda e ficar esperando 'b'.");
        
        Node a = new Node("Você vai para a garagem pegar o carro e ir dirigindo para o hospital.\n" +
                          "Liga o carro o mais rápido possível 'c' ou verifica o carro antes de sair 'd'.");
        
        Node b = new Node("Você ligou para emergência e está esperando ajuda. Paulinho está perdendo muito sangue e você não consegue esperar. Ele morreu.\n "
        		+ "");
        
        Node c = new Node("Você ligou o carro sem verificar, o carro estava engatado a marcha e você bateu a cabeça, desmaiou e morreu porque perdeu muito sangue. Deseja jogar novamente 'y' ou encerrar 'n'?");
        
        Node d = new Node("Você verificou o carro e sai da garagem. Você sai o mais rápido possível da garagem 'e' ou sai com cautela para não bater em ninguém na saída 'f'.");
        
        Node e = new Node("Você saiu sem bater em ninguém, está chegando no semáforo. \n"
        		+ "Você vai esperar ficar verde 'g' ou vai furar o semáforo 'h'.");
        
        Node f = new Node("Você saiu com cautela e olhou para ambos os lados, na sua frente surge um cachorro entrando na frente do carro.\n "
        		+ "Você freia o carro imediatamente 'i' ou passa por cima do cachorro 'j'.");
        
        Node g = new Node("Você esperou o semáforo ficar verde e continuou seu caminho. \n"
        		+ " ");
        
        Node h = new Node("Você furou o sinal e conseguiu passar em segurança. Na sua frente surge um buraco. \n"
        		+ "Você passa por cima do buraco 'k' ou desvia para não se machucar mais 'l'.");
        
        Node i = new Node("Você parou e esperou o dono do cachorro retirá-lo da estrada e continuou o seu caminho, porém o carro não tem combustível suficiente para continuar a jornada. O carro para e você espera demais e acaba morrendo.\n "
        		+ "");
        
        Node j = new Node("Você passou por cima do cachorro e seguiu até o primeiro semáforo, que estava aberto. Porém, surge um buraco na sua frente.\n"
        		+ " Você passa por cima do buraco 'k' ou desvia para não se machucar mais 'l'.");
        
        Node k = new Node("Você passou por cima do buraco, sentiu dor, mas continuou seu caminho. Na sua frente tem um cruzamento e tem um caminhão vindo.\n "
        		+ "Você para e deixa o caminhão passar 'l' ou acelera mais ainda e tenta ultrapassar o caminhão 'm'.");
        
        Node l = new Node("Você deixou o caminhão passar e seguiu seu caminho em segurança. Você está chegando no hospital e tem que encontrar um lugar para estacionar. \n"
        		+ "Você escolhe o lugar correto 'n' ou vai parar na frente e entrar correndo 'o'.");
        
        Node m = new Node("Você não esperou o caminhão, acelerou e acabou morrendo atropelado pelo caminhão.");
        
        Node n = new Node("Você escolheu o lugar correto, porém perdeu muito sangue, não conseguiu levantar do carro e morreu parado.");
        
        Node o = new Node("Você entrou correndo, conseguiu encontrar duas atendentes. \n"
        		+ "Você quer falar com Ricarda 'p' ou Luciana 'q'.");
        
        Node p = new Node("Você falou com a Ricarda. Ela te encaminhou automaticamente para o atendimento. Parabéns! Conseguiram te ajudar, você sobreviveu.");
        
        Node q = new Node("Você falou com Luciana que te obrigou a preencher uma ficha enorme, fazendo você perder tempo e morrer de hemorragia no atendimento.");

        // Adicionar escolhas aos nós
        start.addChoice("a", a);
        start.addChoice("b", b);

        a.addChoice("c", c);
        a.addChoice("d", d);

        d.addChoice("e", e);
        d.addChoice("f", f);

        e.addChoice("g", g);
        e.addChoice("h", h);

        f.addChoice("i", i);
        f.addChoice("j", j);

        g.addChoice("k", k);
        g.addChoice("l", l);

        h.addChoice("k", k);
        h.addChoice("l", l);

        j.addChoice("k", k);
        j.addChoice("l", l);

        k.addChoice("l", l);
        k.addChoice("m", m);

        l.addChoice("n", n);
        l.addChoice("o", o);

        o.addChoice("p", p);
        o.addChoice("q", q);

        // Iniciar o jogo
        Game game = new Game(start);
        game.play();
    }
}