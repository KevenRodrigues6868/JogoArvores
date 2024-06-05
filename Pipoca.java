import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Pipoca {
    Node startNode;

    public Pipoca(Node startNode) {
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
        Node start = new Node("Ana quer preparar pipoca. Vamos ajudá-la a tomar as decisões corretas.\n" +
                              "Ana pega uma panela e coloca óleo 'a' ou usa manteiga 'b'.");

        Node a = new Node("Ana coloca óleo na panela. Ela coloca milho imediatamente 'c' ou espera o óleo esquentar 'd'.");

        Node b = new Node("Ana usa manteiga. Ela coloca milho imediatamente 'e' ou espera a manteiga derreter 'f'.");

        Node c = new Node("Ana colocou milho imediatamente e a pipoca queimou. Ela precisa ir ao hospital. Deseja jogar novamente 'y' ou encerrar 'n'?");

        Node d = new Node("Ana espera o óleo esquentar e então coloca o milho. Ela cobre a panela com a tampa 'g' ou deixa a panela descoberta 'h'.");

        Node e = new Node("Ana colocou milho imediatamente na manteiga e a pipoca queimou. Ela precisa ir ao hospital. Deseja jogar novamente 'y' ou encerrar 'n'?");

        Node f = new Node("Ana espera a manteiga derreter e então coloca o milho. Ela cobre a panela com a tampa 'g' ou deixa a panela descoberta 'h'.");

        Node g = new Node("Ana cobre a panela. Ela agita a panela constantemente 'i' ou deixa a panela parada 'j'.");

        Node h = new Node("A pipoca começa a pular para fora da panela, e ela se queima tentando controlar a situação. Ela precisa ir ao hospital. Deseja jogar novamente 'y' ou encerrar 'n'?");

        Node i = new Node("Ana agita a panela constantemente e a pipoca fica perfeita. Ela adiciona sal 'k' ou açúcar 'l'.");

        Node j = new Node("Ana deixou a panela parada e a pipoca queimou. Ela precisa ir ao hospital. Deseja jogar novamente 'y' ou encerrar 'n'?");

        Node k = new Node("A pipoca salgada está deliciosa. Parabéns, Ana preparou a pipoca com sucesso!");

        Node l = new Node("A pipoca caramelizada está deliciosa. Parabéns, Ana preparou a pipoca com sucesso!");

        // Adicionar escolhas aos nós
        start.addChoice("a", a);
        start.addChoice("b", b);

        a.addChoice("c", c);
        a.addChoice("d", d);

        b.addChoice("e", e);
        b.addChoice("f", f);

        d.addChoice("g", g);
        d.addChoice("h", h);

        f.addChoice("g", g);
        f.addChoice("h", h);

        g.addChoice("i", i);
        g.addChoice("j", j);

        i.addChoice("k", k);
        i.addChoice("l", l);

        // Iniciar o jogo
        Pipoca game = new Pipoca(start);
        game.play();
    }
}