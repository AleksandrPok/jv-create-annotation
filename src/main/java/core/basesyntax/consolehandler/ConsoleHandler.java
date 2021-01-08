package core.basesyntax.consolehandler;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String SPLITTER = " ";
    private static final int BET_VALUE_INDEX = 0;
    private static final int BET_RISK_INDEX = 1;
    private final BetDao betDao = new BetDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        addBet(scanner);
        addUser(scanner);
    }

    private void addBet(Scanner scanner) {
        System.out.println("Write your bet and risk\nWrite 'q' to exit");
        while (true) {
            String command = scanner.nextLine();
            Bet bet = null;
            try {
                String[] betData = command.split(SPLITTER);
                int value = Integer.parseInt(betData[BET_VALUE_INDEX]);
                double risk = Double.parseDouble(betData[BET_RISK_INDEX]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please, write a valid data ");
                continue;
            }
            if (bet != null) {
                betDao.add(bet);
                System.out.println("Your " + bet);
            }
            if (command.equalsIgnoreCase("q")); {
                return;
            }
        }
    }

    private void addUser(Scanner scanner) {
        System.out.println("Write your name\nWrite 'q' to exit");
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("q")) {
                return;
            }
            if (name.isEmpty()) {
                System.out.println("Please, write a valid data ");
                continue;
            }
            userDao.add(new User(name));
            return;
        }
    }
}
