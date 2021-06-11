package org.emp.gl.core.launcher;


import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gui.Labyrinthe;
//import org.emp.gl.rebot.Rebot;
import org.emp.gl.rebot.Rebot;
import org.emp.gl.rebotinterface.RebotAbstract;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerChangeProvider;
import org.emp.gl.timer.service.impl.withdelegation.TimerChangeProviderImplWithDelegation;
import org.emp.gl.environment.Environment;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String args[]) throws InterruptedException {


        Environment env = new Environment();
        int matrice[][] =
                {
                {0,1,1,0,1,0,0,1,1,0},
                {0,0,0,0,0,1,0,0,1,0},
                {0,1,1,1,0,0,0,0,0,1},
                {0,1,0,0,0,1,1,0,0,1},
                {1,1,1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,1,0,0},
                {0,1,0,0,0,1,0,0,1,0},
                {0,0,0,0,0,1,0,1,0,1},
                {0,1,0,0,1,0,0,1,1,0},
                {0,1,0,0,1,0,0,1,1,0}
        };
        //matrice = env.createMatrice(matrice);


        Lookup.getInstance().register(RebotAbstract.class, new Rebot(0,0,"down",matrice));
        Lookup.getInstance().register(TimerChangeListener.class, new Labyrinthe());
        Lookup.getInstance().register(TimerChangeProvider.class, new TimerChangeProviderImplWithDelegation());

        TimerChangeProvider tcpimpl = Lookup.getInstance().getService(TimerChangeProvider.class);
        TimerChangeListener labyrinthe = Lookup.getInstance().getService(TimerChangeListener.class);
        tcpimpl.addTimeChangeListener(labyrinthe);


        //c'est pour tester sans interface graphique GUI dans le TimerChangeListener aussi
        /*
        sleep(1500);
        labyrinthe.down();
        sleep(1500);
        labyrinthe.right();
        sleep(1500);
        labyrinthe.up();
        */






    }

}
