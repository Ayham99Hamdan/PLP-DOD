/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public enum UnitType {
    /*Type	Name	MaxHealth	Armor	AttackDamge	AttackRange	AttackFrequency (attack per second)	Size (Radius)	MovementSpeed (square per second)	CanTarget	UnitPrice*/
  

    TeslaTank(Type.Tank, "TeslaTank", 1000, 0.5, 300, 250, 0.60, 20, 30,new Type[]{Type.Tank,Type.Solider}, 50),
    Sniper(Type.Solider, "Sniper",250,0.10, 75, 700, 0.4, 3, 10, new Type[]{Type.Solider}, 5),
    MirageTank(Type.Tank,"MirageTank", 750, 0.10, 1000, 10, 1, 15, 60, new Type[]{Type.Tank,Type.Solider, Type.Structure}, 70),
    Infantry(Type.Solider, "Infantry", 250, 0.20, 50, 50, 1.5, 3, 10, new Type[]{Type.Solider}, 3),
    GrizzlyTank(Type.Solider, "GrizzlyTank", 1000, 0.40, 250, 250, 0.60, 20, 30, new Type[]{Type.Tank,Type.Solider, Type.Structure}, 50),
    NavySEAL(Type.Solider, "NavySEAL", 400, 0.20, 60, 50, 2, 3, 20, new Type[]{Type.Tank,Type.Solider}, 10),
    TankDestroyer(Type.Tank, "TankDestroyer", 1000, 0.50, 400, 150, 0.60, 20, 20, new Type[]{Type.Tank}, 50),
    PrismTank(Type.Tank, "PrismTank", 1000, 0.35, 300, 150, 0.60, 20, 20, new Type[]{Type.Tank,Type.Solider, Type.Structure}, 60),
    Pillbox(Type.Structure, "Pillbox", 4000, 0.70, 100, 200, 0.70, 40, 0, new Type[]{Type.Solider}, 150),
    PrismTower(Type.Structure, "PrismTower", 4000, 0.70, 100, 200, 0.50, 30, 0, new Type[]{Type.Tank,Type.Solider}, 150),
    GrandCannon(Type.Structure, "GrandCannon", 6500, 0.30, 150, 400, 0.90, 40, 0, new Type[]{Type.Tank,Type.Solider}, 200),
    MainBase(Type.Structure, "MainBase", 10000, 0, 0,0 , 0 ,50, 0, null, 0),
    BlackEagle(Type.Airplane, "BlackEagle", 1500, 0, 400, 30, 0 , 0, 100, new Type[]{Type.Structure}, 75),
    PatriotMissileSystem(Type.Structure, "PatriotMissileSystem", 2500, 0.20, 50, 400, 0.90, 40, 0, new Type[]{Type.Airplane}, 175)
    ;
    
    private Type type;
    private String name;
    private double maxHealth;
    private double armor;
    private double attackDamage;
    private double attackrange;
    private double attackFrequency;
    private int size;
    private double movementSpeed;
    private Type[] canTarget;
    private int unitPrice;

    private UnitType(Type type, String name, double maxHealth, double armor, double attackDamage, double attackrange, double attackFrequency, int size, double movementSpeed, Type[] canTarget, int price) {
        this.type = type;
        this.name = name;
        this.maxHealth = maxHealth;
        this.armor = armor;
        this.attackDamage = attackDamage;
        this.attackrange = attackrange;
        this.attackFrequency = attackFrequency;
        this.size = size;
        this.movementSpeed = movementSpeed;
        this.canTarget = canTarget;
        this.unitPrice = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public double getAttackrange() {
        return attackrange;
    }

    public void setAttackrange(double attackrange) {
        this.attackrange = attackrange;
    }

    public double getAttackFrequency() {
        return attackFrequency;
    }

    public void setAttackFrequency(double attackFrequency) {
        this.attackFrequency = attackFrequency;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Type[] getCanTarget() {
        return canTarget;
    }

    public void setCanTarget(Type[] canTarget) {
        this.canTarget = canTarget;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    
    
    
    }
