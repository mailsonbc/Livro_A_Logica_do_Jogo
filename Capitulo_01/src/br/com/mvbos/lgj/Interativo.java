package br.com.mvbos.lgj;

import java.awt.*;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Interativo extends JFrame {
    private JPanel tela;
    private int px;
    private int py;
    private boolean jogando = true;

    private final int FPS = 100 /20; //50

    public void inicia() {
        long prxAtualizacao = 0;
        while (jogando) {
            if (System.currentTimeMillis() >= prxAtualizacao) {
                tela.repaint();
                prxAtualizacao = System.currentTimeMillis() + FPS;
            }
        }
    }

    public Interativo() {
        super.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                }

            @Override
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                switch (tecla) {
                    case KeyEvent.VK_ESCAPE:
                        jogando = false;
                        dispose();
                        break;
                    case KeyEvent.VK_UP:
                        py = py - 3;
                        break;
                    case KeyEvent.VK_DOWN:
                        py = py + 3;
                        break;
                    case  KeyEvent.VK_LEFT:
                        px = px - 3;
                        break;
                    case  KeyEvent.VK_RIGHT:
                        px = px + 3;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

                int x = tela.getWidth() / 2 - 20 + px;
                int y = tela.getHeight() / 2 - 20 + py;

                g.setColor(Color.BLUE);
                g.fillRect(x, y, 40, 40);
                g.drawString("Agora estou em " + x + "x" + y, 5, 10);
            }
        };

        getContentPane().add(tela);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }
}
