/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_mssc;
import javax.swing.*;
import java.awt.*;

import java.awt.event.WindowEvent;
import java.util.Random;

/**
 *
 * @author WARDA
 */
public class TP_02 extends JPanel {
    

      private final JFrame frame;

    private final int width, height;

    private boolean[][] cellules;

    private int round ;
    private int fps;

    public TP_02(int width, int height, int n)
    {
        this.width = width;
        this.height = height;

        cellules = new boolean[width][height];

        generateRandomCells(n);

        frame = new JFrame("Game Of Life");
        frame.setSize(480,240);
        frame.setUndecorated(true);
        frame.setResizable(false);
       

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.setBackground(Color.white);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("rule 30");
        frame.setResizable(false);
        //frame.add(new WolframCA(), BorderLayout.CENTER);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


         run();
    }

    private void generateRandomCells(int x)
    {
        Random random = new Random();

        while (x > 0)
        {
            int rx = random.nextInt(width);
            int ry = random.nextInt(height);

            if(cellules[rx][ry]) continue;

            cellules[rx][ry] = true;
            x--;
        }

    }

    private void run()
    {
        long nanoSecond = System.nanoTime();
        double tick = 1000000000.0 / 5.0;

        int tps = 0;

        long lastTime = System.currentTimeMillis();

        while(true)
        {
            if(System.nanoTime() - nanoSecond > tick)
            {
                nanoSecond+=tick;
                tps++;
                update();
            }
            else
            {
                frame.repaint();
            }

            if(System.currentTimeMillis() - lastTime >= 1000)
            {
                lastTime = System.currentTimeMillis();
              //  System.out.println(tps+" TPS - "+fps+" FPS");
                tps = 0;
                fps = 0;

                System.gc();
            }
        }
    }

    private void update()
    {
        boolean[][] newCells = new boolean[width][height];

        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                int count = 0;

                for(int xo = -1; xo < 2; xo++)
                {
                    for(int yo = -1; yo < 2; yo++)
                    {
                        if(xo == 0 && yo == 0) continue;
                        int nx = x + xo;
                        int ny = y + yo;
                        count += (nx >= 0 && ny > 0 && nx < width && ny < height && cellules[nx][ny]) ? 1 : 0;
                    }
                }

                newCells[x][y] = cellules[x][y] ? (count == 1 || count == 2) : count == 3;
            }
        }

        cellules = newCells;
        round++;
    }

    protected void paintComponent(Graphics g)
    {
        fps++;

        int xOffset = 800 / width;
        int yOffset = 500 / height;

        g.setColor(Color.RED);

        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                if(cellules[x][y])
                    g.fillRect(x * xOffset, y * yOffset, xOffset, yOffset);
            }
        }

        g.setColor(Color.RED);
        g.setFont(new Font("arial", Font.PLAIN, 15));
        g.drawString(""+round, 20, 20);

    }

    public static void main(String... args)
    {

        new TP_02(200, 150, 5000);
    }

   
       
}