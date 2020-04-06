package br.pro.hashi.ensino.desagil.aps.model;

public class OrGate extends Gate {

    private final NandGate nandA;
    private final NandGate nandB;
    private final NandGate nandC;

    public OrGate() {
        super("OR", 2);

        nandA = new NandGate();
        nandB = new NandGate();
        nandC = new NandGate();

    }

    @Override
    public boolean read() {
        return nandC.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {

    }
}
