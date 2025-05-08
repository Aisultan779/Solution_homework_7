package part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffled;
    private int index;

    public ShuffleSeasonIterator(Season season) {
        this.shuffled = new ArrayList<>(season.getEpisodes());
        Collections.shuffle(shuffled, new Random(42));
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < shuffled.size();
    }

    @Override
    public Episode next() {
        return shuffled.get(index++);
    }
}