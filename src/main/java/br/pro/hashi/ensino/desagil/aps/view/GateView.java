package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Switch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class GateView extends FixedPanel implements ActionListener, MouseListener {

    private final Gate gate;

    private final JCheckBox inBox1;
    private final JCheckBox inBox2;
    private final JCheckBox outBox;

    public GateView(Gate gate) {
        super(122, 122);

        this.gate = gate;

        int h = 2;

        inBox1 = new JCheckBox();
        inBox2 = new JCheckBox();
        outBox = new JCheckBox();

        JLabel inLabel = new JLabel("Entrada:");
        JLabel outLabel = new JLabel("Saida:");

        add(inLabel, 8, h, 75, 25);
        add(inBox1, 8, h+20, 75, 25);
        add(outLabel, 8, h+62, 75, 25);
        add(outBox, 8, h+82, 75, 25);


        outBox.setEnabled(false);
        inBox1.addActionListener(this);


        if (gate.getInputSize() > 1) {
            add(inBox2, 8, h+40, 75, 25);
            inBox2.addActionListener(this);

        }



        addMouseListener(this);

        update();
    }

    private void update() {
        System.out.println("updatou");

        Switch in1 = new Switch();

        if (inBox1.isSelected()) {in1.turnOn();};

        gate.connect(0,in1);

        if (gate.getInputSize() > 1) {
            Switch in2 = new Switch();
            if (inBox2.isSelected()) {in2.turnOn();};
            gate.connect(1,in2);
        }


        System.out.println(gate.read());

        //outBox.setEnabled(true);
        if (gate.read()) {
            outBox.setSelected(true);
        }
        else {
            outBox.setSelected(false);
        }
        //outBox.setEnabled(false);

    }


    @Override
    public void actionPerformed(ActionEvent event) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        // Não precisamos de uma reação específica à ação de pressionar
        // um botão do mouse, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.

    }

    @Override
    public void mousePressed(MouseEvent event) {
        // Não precisamos de uma reação específica à ação de pressionar
        // um botão do mouse, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // Não precisamos de uma reação específica à ação de soltar
        // um botão do mouse, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // Não precisamos de uma reação específica à ação do mouse
        // entrar no painel, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void mouseExited(MouseEvent event) {
        // Não precisamos de uma reação específica à ação do mouse
        // sair do painel, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }
}
