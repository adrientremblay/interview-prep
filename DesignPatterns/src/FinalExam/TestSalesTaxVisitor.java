package FinalExam;

interface Visitor {
    void visit(GSTProvince gstProvince);
    void visit(GSTPSTProvince gstpstProvince);
}

interface Visitable {
    void accept(Visitor visitor);
}

class SalesTaxVisitor implements Visitor {

    @Override
    public void visit(GSTProvince gstProvince) {
        float total = TestSalesTaxVisitor.SALE_PRICE * (1 + gstProvince.canadaRate) ;
        System.out.println("In " + gstProvince.code + " has a total cost of $" +String.format("%.3f", total));
    }

    @Override
    public void visit(GSTPSTProvince gstpstProvince) {
        float total = TestSalesTaxVisitor.SALE_PRICE * (1 + gstpstProvince.provincialRate + gstpstProvince.canadaRate);
        System.out.println("In " + gstpstProvince.code + " has a total cost of $" +String.format("%.3f", total));
    }
}

class Province implements Visitable {
    String code;
    float canadaRate;
    float provincialRate;

    public Province(String code, float canadaRate, float provincialRate) {
        this.code = code;
        this.canadaRate = canadaRate;
        this.provincialRate = provincialRate;
    }

    @Override
    public void accept(Visitor visitor) {
        // DO NOTHING
    }
}

class GSTProvince extends Province {

    public GSTProvince(String code, float canadaRate, float provincialRate) {
        super(code, canadaRate, provincialRate);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}


class GSTPSTProvince extends Province {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public GSTPSTProvince(String code, float canadaRate, float provincialRate) {
        super(code, canadaRate, provincialRate);
    }
}

public class TestSalesTaxVisitor {
    public static final float SALE_PRICE = 100.0f;

    public static void main(String args[]) {
        SalesTaxVisitor salesTaxVisitor = new SalesTaxVisitor();
        Province[] provinces = {
            new GSTProvince("AB", 0.05f, 0),
            new GSTPSTProvince("BC", 0.05f, 0.07f),
            new GSTPSTProvince("ON", 0.05f, 0.08f),
            new GSTPSTProvince("QC", 0.05f, 0.0975f)
        };

        System.out.println("A sale of $" + SALE_PRICE);
        for (Province province : provinces) {
            province.accept(salesTaxVisitor);
        }
    }
}
