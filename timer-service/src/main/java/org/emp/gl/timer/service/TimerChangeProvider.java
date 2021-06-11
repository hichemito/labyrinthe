package org.emp.gl.timer.service;

public interface TimerChangeProvider {


    public void addTimeChangeListener(TimerChangeListener pl);

    public void removeTimeChangeListener(TimerChangeListener pl);
}
