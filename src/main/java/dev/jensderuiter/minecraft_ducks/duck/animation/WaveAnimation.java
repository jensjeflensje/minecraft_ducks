package dev.jensderuiter.minecraft_ducks.duck.animation;

import dev.jensderuiter.minecraft_ducks.duck.Offset;


/**
 * Animation that makes the Duck wave on the y-axis as if it's in waving water.
 */
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
