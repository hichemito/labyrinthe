package org.emp.gl.timer.service.impl.withdelegation;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerChangeProvider;

import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerChangeProviderImplWithDelegation extends TimerTask implements TimerChangeProvider {

    final static String SECONDE_PROP = "seconde" ;

    public TimerChangeProviderImplWithDelegation() {
        Timer timer = new Timer();

        LocalTime localTime = LocalTime.now();
        timer.scheduleAtFixedRate(this, 1000, 1000);
    }

    @Override
    public void run() {
        timeChanged();
        System.out.println("Time Changed");
    }

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
        pcs.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        pcs.removePropertyChangeListener(pl);
    }


    private void timeChanged() {
        pcs.firePropertyChange(this.SECONDE_PROP, null, null);
    }


}
