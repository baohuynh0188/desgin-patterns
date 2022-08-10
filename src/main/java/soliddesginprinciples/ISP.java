package soliddesginprinciples;

class Document {

}

interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

class MultiFunctionPrinter implements Machine {

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}


class JustAPrinter implements Printer {

    @Override
    public void print(Document d) {

    }
}

class Photocopier implements Printer, Scanner {

    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface MultiFunctionDevice extends Printer, Scanner {

}

class MultiFunctionMachine implements MultiFunctionDevice {

    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

public class ISP {
    public static void main(String[] args) {

    }
}
