package part1;

import java.util.Objects;

public class Episode {
    private final String title;
    private final int runtimeSec;

    public Episode(String title, int runtimeSec) {
        this.title = title;
        this.runtimeSec = runtimeSec;
    }

    public String getTitle() {
        return title;
    }

    public int getRuntimeSec() {
        return runtimeSec;
    }

    @Override
    public String toString() {
        return String.format("%s (%d sec)", title, runtimeSec);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Episode)) return false;
        Episode episode = (Episode) o;
        return runtimeSec == episode.runtimeSec && title.equals(episode.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, runtimeSec);
    }
}