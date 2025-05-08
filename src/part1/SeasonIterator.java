package part1;

import java.util.Iterator;
import java.util.List;

public class SeasonIterator implements EpisodeIterator, Iterator<Episode> {
    private final List<Episode> episodes;
    private int index;

    public SeasonIterator(Season season) {
        this.episodes = season.getEpisodes();
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(index++);
    }
}