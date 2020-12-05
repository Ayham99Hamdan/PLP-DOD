
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class DoDGameManager implements UnitDestroyObserver {

    private static DoDGameManager instance = null;

    private Grid grid;
    private Unit mainBase;
    private int remainingAttackerUnit;
    private double remainingTime;
    private ArrayList<Team> teams;
    private UnitFactory unitFactory;
    private GameState status;

    private DoDGameManager() {

        grid = Grid.getInstance();
        teams = new ArrayList();
        DeffenderTeam Deffender = DeffenderTeam.getInstance();
        AttackerTeam Attacker = AttackerTeam.getInstance();
        teams.add(Deffender);
        teams.add(Attacker);
        unitFactory = new UnitFactory();

        mainBase = unitFactory.createUnit(UnitType.MainBase);
        mainBase.setPosition(new UnitPosition());
        mainBase.getPosition().setCenterX(600);
        mainBase.getPosition().setCenterY(600);
        mainBase.getPosition().setRadius(UnitType.MainBase.getSize());
        mainBase.setOwner(Deffender.DeffenderPlayerForMainBase());
        mainBase.setUnitType(UnitType.MainBase);
        mainBase.setMovement(DeffenderMovement.getInstance());
        grid.addUnit(mainBase);

    }

    public static DoDGameManager getInstance() {

        if (instance == null) {

            instance = new DoDGameManager();

        }
        return instance;

    }

    @Override
    public void onUnitDestroy(Unit unit) {

        if (unit.getOwner().teamId == 2) {

            remainingAttackerUnit--;
            System.out.print("Fras");

        }

        grid.removeUnit(unit);

    }

    public void gameInit() {

        for (Team team : teams) {

            team.getTeamReady();

        }
        grid.start();
        status = GameState.Runnig;
        gameLoop();
    }

    public Unit getMainBase() {
        return mainBase;
    }

    public void setMainBase(Unit mainBase) {
        this.mainBase = mainBase;
    }

    public void BayUnit(Player player, int X, int Y, UnitType unitType) {

        if (player.coins >= unitType.getUnitPrice()) {
            Unit unit = unitFactory.createUnit(unitType);
            player.coins = player.coins - unitType.getUnitPrice();
            unit.setPosition(new UnitPosition());
            unit.getPosition().setCenterX(X);
            unit.getPosition().setCenterY(Y);
            unit.getPosition().setRadius(unitType.getSize());
            
            unit.setOwner(player);

            unit.setUnitType(unitType);

            unit.setCanAttack(unitType.getCanTarget());

            if (player.teamId == 1) {

                unit.setMovement(DeffenderMovement.getInstance());

            } else {

                unit.setMovement(AttackerMovement.getInstance());
                remainingAttackerUnit++;
                System.out.println("Attacker");
            }

            grid.addUnit(unit);
        } else {

            System.out.println("You don't have enough coins");

        }
    }

    public void gameLoop() {

        while (status.equals(GameState.Runnig)) {

            if (mainBase.getProperties().get(0).getPropertyValue() <= 0) {

                status = GameState.AttackerWon;
                System.out.print("Attackers Win");
                grid.end();
                break;

            } else if (remainingAttackerUnit == 0 /*|| remainingTime == 0*/) {

                status = GameState.DeffenderWon;
                System.out.print("Deffenders Win");
                grid.end();
                break;

            }

        }

    }

}
