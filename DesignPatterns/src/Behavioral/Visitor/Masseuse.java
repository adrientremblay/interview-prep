package Behavioral.Visitor;

interface Person {
    void accept(PersonVisitor personVisitor);
}

class StressedPerson implements Person {

    @Override
    public void accept(PersonVisitor personVisitor) {
        personVisitor.visit(this);
    }
}

class AthletePerson implements Person {

    @Override
    public void accept(PersonVisitor personVisitor) {
        personVisitor.visit(this);
    }
}

interface PersonVisitor {
    void visit(StressedPerson person);
    void visit(AthletePerson person);
}

class Masseuse implements PersonVisitor {
    @Override
    public void visit(StressedPerson person) {
        System.out.println("Giving this stressed person a 'footrub'!");
    }

    @Override
    public void visit(AthletePerson person) {
        System.out.println("Giving this athlete person cryo therapy!");
    }
}

class Client {
    public static void main(String[] args) {
        Masseuse sandra = new Masseuse();
        Person[] people = {new AthletePerson(), new StressedPerson(), new AthletePerson()};
        for (Person p : people) {
            p.accept(sandra);
        }
    }
}
