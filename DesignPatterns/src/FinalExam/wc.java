// wc.java - A Java version of the word count command.

import java.io.*;

public class wc {
    private static final int      EOF = -1;
    private static       boolean  isSpace(int c) { return c == ' ' || c == '\t'; }

    public static void main(String args[]) throws IOException {
        int totalLines = 0, totalWords = 0, totalChars = 0;

        if ( args.length < 1 ) {
            System.out.println("Usage: wc file(s)" );
            System.exit(1);
        }

        for (int n = 0; n < args.length; ++n) {
            File     srcFile;
            int      c, nChars, nLines, nWords;
            boolean  inWord = false;

            srcFile = new File(args[n]);
            if ( !srcFile.canRead() ) {
                System.out.println("wc: Can't open file '" + args[n] + "'");
                continue;
            }

            FileInputStream fs = new FileInputStream(srcFile);
            nChars = nLines = nWords = 0;

            while ( (c = fs.read()) != EOF ) {
                if (c == '\n') ++nLines;

                if ( !isSpace(c) ) {
                    if ( !inWord ) {
                        inWord = true;
                        ++nWords;
                    }
                } else {
                    inWord = false;
                }
                ++nChars;
            }
            System.out.println(args[n]+": "+nLines+" lines, "+nWords+" words, "+nChars+" chars");
            totalLines += nLines;
            totalWords += nWords;
            totalChars += nChars;
        }
        if ( args.length > 1 ) {
            System.out.println("**Total: "+totalLines+" lines, "+totalWords+" words, "+totalChars+" chars");
        }
    }
}
