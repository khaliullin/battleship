package classes;

import javafx.scene.control.Label;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by 1 on 21.12.2016.
 */
public class TimeCounter extends Thread {
    Date time;
    Label lblTime;

    public TimeCounter(Date time, Label lblTime) {
        this.time = time;
        this.lblTime = lblTime;
    }

    @Override
    public void run() {
        lblTime.setText(String.valueOf(time.getTime() - 1));
    }
}
