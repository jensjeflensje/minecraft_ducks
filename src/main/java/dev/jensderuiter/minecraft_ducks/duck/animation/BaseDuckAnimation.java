package net.bingomc.spring_lobby_2025.quest.duck.animation;

public abstract class BaseDuckAnimation implements DuckAnimation {

    protected Moveable part;
    protected int tick;

    public BaseDuckAnimation(Moveable part) {
        this.part = part;
        this.tick = 0;
    }

    public void tick() {
        this.tick++;
        this.animationTick();
    }


}
