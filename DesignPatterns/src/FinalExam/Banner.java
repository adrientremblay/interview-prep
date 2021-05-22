package FinalExam;

interface IBanner {
    String getBanner();
}

abstract class AbstractBanner implements IBanner {
    public String getBanner() {
        return getProgramNameAndVersion() + getCopyrightNotice() + getWrittenBy();
    }

    abstract String getProgramNameAndVersion();
    abstract String getCopyrightNotice();
    abstract String getWrittenBy();
}

class Banner extends AbstractBanner {
    String programName;
    String programVersion;
    String copyrightDate;
    String copyrightNotice;

    public Banner(String programName, String programVersion, String copyrightDate, String copyrightNotice) {
        this.programName = programName;
        this.programVersion = programVersion;
        this.copyrightDate = copyrightDate;
        this.copyrightNotice = copyrightNotice;
    }

    @Override
    String getProgramNameAndVersion() {
        return programName + " Version " + programVersion + "\n";
    }

    @Override
    String getCopyrightNotice() {
        return "(c) " + copyrightDate + " " + copyrightNotice + ". All rights reserved.\n";
    }

    @Override
    String getWrittenBy() {
        return "";
    }
}

class CompanyBanner extends Banner {
    private String authorName;

    public CompanyBanner(String programName, String programVersion, String copyrightDate, String copyrightNotice, String authorName) {
        super(programName, programVersion, copyrightDate, copyrightNotice);
        this.authorName = authorName;
    }

    @Override
    String getWrittenBy() {
        return "Written by " + authorName;
    }
}

class TestBanner {
    public static void main(String args[]) {
        IBanner msBanner = new Banner(
                "Microsoft Windows", "10.0.17134.471",
                "2018", "Microsoft Corporation"
        );
        IBanner mdecWCOOBanner = new Banner(
                "WordCount OO", "1.2",
                "2003-2020", "Michel de Champlain"
        );
        IBanner dmcBanner = new CompanyBanner(
                "Digital Mars Compiler", "8.42n",
                "2000-2004", "Digital Mars",
                "Walter Bright"
        );
        System.out.println(msBanner.getBanner());
        System.out.println(mdecWCOOBanner.getBanner());
        System.out.println(dmcBanner.getBanner());
    }
}

