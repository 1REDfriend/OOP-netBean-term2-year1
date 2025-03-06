/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

public class MyClock extends JLabel implements Runnable, MouseListener {
    private int seconds = 0;
    private boolean running = true;
    
    public MyClock() {
        setText("00:00:00");
        addMouseListener(this);
    }
    
    @Override
    public void run() {
        while (true) {
            if (running) {
                int hour = seconds / 3600;
                int min = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format("%02d:%02d:%02d", hour, min, sec);
                setText(time);

                seconds++;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        running = !running;
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}