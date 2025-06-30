package net.bingomc.spring_lobby_2025.quest.duck.animation;

import net.bingomc.spring_lobby_2025.quest.duck.Offset;

public class WaveAnimation extends BaseDuckAnimation {

    private final double strenght;
    private final double frequency;

    public WaveAnimation(Moveable part, double strenght, double frequency) {
        super(part);
        this.strenght = strenght;
        this.frequency = frequency;
    }

    public WaveAnimation(Moveable part) {
        this(part, 1, 1);
    }

    @Override
    public void animationTick() {
        Offset offset = part.getAnimationOffset();
        offset.y = (Math.sin((this.tick*frequency) / 5d) / 20d) * strenght;
        part.setAnimationOffset(offset);
    }
}
