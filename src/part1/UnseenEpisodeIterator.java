package part1;

import java.util.HashSet;
import java.util.Set;

public class UnseenEpisodeIterator implements EpisodeIterator {
    private final EpisodeIterator inner;
    private final Set<String> seenTitles;
    private Episode nextEp;

    public UnseenEpisodeIterator(EpisodeIterator inner, Set<String> seenTitles) {
        this.inner = inner;
        this.seenTitles = new HashSet<>(seenTitles);
        advance();
    }

    private void advance() {
        nextEp = null;
        while (inner.hasNext()) {
            Episode e = inner.next();
            if (!seenTitles.contains(e.getTitle())) {
                nextEp = e;
                return;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextEp != null;
    }

    @Override
    public Episode next() {
        Episode result = nextEp;
        seenTitles.add(result.getTitle());
        advance();
        return result;
    }
}