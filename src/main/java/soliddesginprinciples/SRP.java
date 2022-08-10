package soliddesginprinciples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
//        return "solid_desgin_principles.Journal " + "entries: " + entries + " count: " + count;
        return String.join(System.lineSeparator(), entries);
    }

    public void save(String filename) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }

}

class Persistence {
    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }
}

public class SRP {
    public static void main(String[] args) throws Exception {
        Journal journal = new Journal();
        journal.addEntry("Hello");
        journal.addEntry("World");
        System.out.println(journal);

        Persistence persistence = new Persistence();
        String filename = "d:\\temp\\journal.txt";
        persistence.saveToFile(journal, filename, true);

        Runtime.getRuntime().exec("notepad.exe " + filename);
    }
}
