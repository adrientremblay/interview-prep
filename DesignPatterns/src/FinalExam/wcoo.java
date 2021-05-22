package FinalExam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

interface ICounter {
    void reset();
    int getCount();
    void process(char c);
}

interface IComputer {
    void init(FileInputStream inputStream);
    void reset();
}

public class wcoo {

    public static void main(String args[]) throws IOException {
        if ( args.length < 1 ) {
            System.out.println("Usage: wc file(s)" );
            System.exit(1);
        }

        ICounter fileCounter = new Composite(
                new LineLeaf(),
                new WordLeaf(),
                new CharLeaf()
        );
        IComputer computer = new Computer(fileCounter);

        for (int n = 0; n < args.length; ++n) {
            File srcFile = new File(args[n]);
            if (!srcFile.canRead()) {
                System.out.println("wc: Can't open file '" + args[n] + "'");
                continue;
            }
            FileInputStream fs = new FileInputStream(srcFile);

            System.out.print(args[n] + ": ");
            computer.init(fs);
            computer.reset();
        }

        // print total result
        System.out.println("**Total: " + LineLeaf.totalCount + " lines, " + WordLeaf.totalCount + " words, " + CharLeaf.totalCount + " chars");
    }
}

class Composite implements ICounter {
    ICounter[] children;

    public Composite(ICounter... children) {
        this.children = children;
    }

    @Override
    public void reset() {
        int lines = 0;
        int words = 0;
        int chars = 0;

        for (ICounter child : children) {
            if (child instanceof CharLeaf) {
                chars = child.getCount();
            } else if (child instanceof WordLeaf) {
                words = child.getCount();
            } else if (child instanceof LineLeaf) {
                lines = child.getCount();
            }
            child.reset();
        }

        // print file results
        System.out.println(lines + " lines, " + words + " words, " + chars + " chars");
    }

    @Override
    public int getCount() {
        // Method unused in program
        int sum = 0;

        for (ICounter counter: children) {
            sum += counter.getCount();
        }

        return sum;
    }

    @Override
    public void process(char c) {
        for (ICounter counter: children) {
            counter.process(c);
        }
    }
}

abstract class Leaf implements ICounter {
    protected int count = 0;

    @Override
    public void reset() {
        count = 0;
    }

    @Override
    public int getCount() {
        return count;
    }
}

class LineLeaf extends Leaf {
    public static int totalCount = 0;

    @Override
    public void reset() {
        totalCount += count;
        super.reset();
    }

    @Override
    public void process(char c) {
        if (c == '\n')
            count++;
    }
}

class WordLeaf extends Leaf {
    public static int totalCount = 0;
    private boolean inWord = false;

    @Override
    public void reset() {
        totalCount += count;
        super.reset();
    }

    @Override
    public void process(char c) {
        if (! (c == ' ' || c == '\t' )) {
            if ( !inWord ) {
                inWord = true;
                count++;
            }
        } else {
            inWord = false;
        }
    }
}

class CharLeaf extends Leaf {
    public static int totalCount = 0;

    @Override
    public void reset() {
        totalCount += count;
        super.reset();
    }

    @Override
    public void process(char c) {
        count++;
    }
}

/**
 * run through composite tree and process character by character
 */
class Computer implements IComputer {
    public ICounter counter;
    private static final int EOF = -1;

    public Computer(ICounter counter) {
        this.counter = counter;
    }

    @Override
    public void init(FileInputStream inputStream) {
        int c;
        try {
            while ((c = inputStream.read()) != EOF)
                counter.process((char)c);
        } catch (IOException e) {
            System.out.println("Computer.init(): IOException - abort wcoo");
            System.exit(1);
        }

    }

    @Override
    public void reset() {
        counter.reset();
    }

}